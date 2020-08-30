package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static int nextId = 0;

	private Map<String, Member> map = new HashMap<>();

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from okdog_db.user where EMAIL = ?", 
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("email"),
								rs.getString("user_pwd"),
								rs.getString("user_name"),
								rs.getString("user_city"),
								rs.getTimestamp("regdate").toLocalDateTime());
						member.setId(rs.getInt("user_id"));
						return member;
					}
					
				}, email);
		System.out.println(results.toString());
		if(results.size()>0)
			return results.get(0);
		else
			return null;
	}

	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement("insert into user (email, user_pwd, user_name, user_city, regdate) values (?, ?, ?, ?, ?)", new String[] {"id"} );
				//인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getCity());
				pstmt.setTimestamp(5, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
			
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.intValue());
	}

	public void update(Member member) {
		jdbcTemplate.update("update user set user_name=?, user_pwd=? where email=?", member.getName(), member.getPassword(), member.getEmail());
		
	}
	
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"select * from user",
				new MemberRowMapper());
		return results;
	}

	public int count1() {
		List<Integer> results = jdbcTemplate.query(
				"select count(*) from user",
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
						return rs.getInt(1);
					}
				});
		return results.get(0);
	}
	
	public int count() {
		//하나만 받기 때문에 mapping을 안해줘도 된다.
		Integer count = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
		return count;
	}
}