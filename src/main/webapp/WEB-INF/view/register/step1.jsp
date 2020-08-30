<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="term" /></h2>
	<p>사용자 이름, 주소, 이메일 정보가 본 사이트에 위탁됩니다. 위탁기간은 최대 1년이며 기간이 지나면 자동 삭제됩니다.</p>
	<form action="step2" method="post">
	<label>
		<input type="checkbox" name="agree" value="true"> <spring:message code="term.agree" />
	</label>
	<input type="submit" value="<spring:message code="next.btn" />" />
	</form>
</body>
</html>