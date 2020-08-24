<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h2>약관</h2>
	<p>사용자 이름, 주소, 이메일 정보가 본 사이트에 위탁됩니다. 위탁기간은 최대 1년이며 기간이 지나면 자동 삭제됩니다.</p>
	<form action="step2" method="post">
	<label>
		<input type="checkbox" name="agree" value="true"> 약관 동의
	</label>
	<input type="submit" value="다음 단계" />
	</form>
</body>
</html>