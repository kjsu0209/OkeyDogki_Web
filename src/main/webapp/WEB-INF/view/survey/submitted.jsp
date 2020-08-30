<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>계산 결과</title>
</head>
<body>
    <p>응답 내용:</p>
    <ul>
        <c:forEach var="response" 
                   items="${ansData.responses}" varStatus="status">
        <li>${status.index + 1}번 문항: ${response}</li>
        </c:forEach>
    </ul>
    <p>강아지 이름: ${ansData.responses[0]}</p>
    <p>강아지 나이: ${ansData.responses[1]}</p>
    <p>강아지 몸무게: ${ansData.responses[2]}kg</p>
     <p>하루 권장 급여량:${amount}g</p>
       <p><a href="<c:url value='/main'/>">[첫 화면 이동]</a></p>
       <p><a href="<c:url value='/survey'/>">[다시하기]</a></p>
   
</body>
</html>