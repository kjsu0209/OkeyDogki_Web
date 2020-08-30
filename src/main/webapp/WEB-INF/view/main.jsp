<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
</head>
<body>
    <p>환영합니다.</p>
    <c:if test="${empty authInfo}">
       	   <p><a href="<c:url value="/login" />">[로그인]</a>
    	<p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
           <p><a href="<c:url value='/survey'/>">[사료 급여량 계산기]</a></p>
   	</c:if>
   	<c:if test="${! empty authInfo }">
   	   <p><a href="<c:url value="/logout" />">[로그아웃]</a>
   	<p><a href="<c:url value="/edit/changePassword" />">[비밀번호 변경]</a>
           <p><a href="<c:url value='/survey'/>">[사료 급여량 계산기]</a></p>
   	</c:if>
</body>
</html>