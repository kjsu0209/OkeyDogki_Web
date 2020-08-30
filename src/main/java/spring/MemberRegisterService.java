package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null)
			throw new DuplicateMemberException("duplicated email " + req.getEmail());
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), req.getCity(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
