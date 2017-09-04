<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
		Messages from user: ${username}
		<hr/>
		<c:forEach var="msg" items="${messages}">
			Message: <c:out value="${msg}"/>
			<br/>
		</c:forEach>
		Friends: <br/>
		<c:forEach var="friend" items="${friends}">
			<c:out value="${friend}" />
			<br/>
		</c:forEach>
		Friends messages: <br/>
		<c:forEach var="msg" items="${friendsMessages}">
			<c:out value="${msg}" />
			<br/>
		</c:forEach>
</body>
</html>