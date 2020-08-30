<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>사료량 계산기</title>
</head>
<body>
    <h2>사료량 계산기</h2>
    <form method="post">
    <c:forEach var="q" items="${questions}" varStatus="status">
    <p>
        ${status.index + 1}. ${q.title}<br/>
        <c:if test="${q.choice}">
            <c:forEach var="option" items="${q.options}">
            <label><input type="radio" 
                           name="responses[${status.index}]" value="${option}">
                ${option}</label>
            </c:forEach>
        </c:if>
        <c:if test="${! q.choice }">
        <input type="text" name="responses[${status.index}]">
        </c:if>
    </p>
    </c:forEach>

    <input type="submit" value="전송">
    </form>
</body>
</html>