<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new message</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
	Post a message!
	<hr/>
	<sf:form action="/rest/newmessage" method="POST" modelAttribute="newmessage">
		<input type="hidden" name="_method" value="POST" />
		<label>Type your message: </label>
		<sf:input path="txt" size="25" id="txt"/>
		<input name="commit" type="submit" value="Post Message"/>
	</sf:form>
</body>
</html>