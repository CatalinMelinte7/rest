<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<sf:form action="/rest/login" method="POST" modelAttribute="user">
		<input type="hidden" name="_method" value="POST" />
		<label>Username: </label>
		<sf:input path="username"  id="username"/>
		<label>Password: </label>
		<sf:input path="password" id="password"/>
		<input name="commit" type="submit" value="Login"/>
	</sf:form>
	<br/>
	${message}
</body>
</html>