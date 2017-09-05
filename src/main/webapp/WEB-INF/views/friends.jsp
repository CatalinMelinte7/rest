<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul{
list-style-type:none;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<ul>
		<c:forEach var="userList" items="${users}">
			<li id="username">Username: <c:out value="${userList.username}"/> </li>
			<li>Password: <c:out value="${userList.password}"/> </li>
			<li>Email: <c:out value="${userList.email}"/> </li>
			<input type="submit" id="follow" value="Follow"/>
			<br/>
		</c:forEach>
	</ul>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$('#follow').click( function() { 
		 var user = document.getElementById("username").value;
		 $.ajax({
		  url: 'http://localhost:8080/rest/follow',
		  type:'post',
		         dataType : 'json',
		         async : true,
		         data: JSON.stringify(user),
		         contentType: 'application/json; charset=utf-8',
		 		 success: function(data) 
		   		 {
		  		 location.reload();
		  		 },
		 		  failure: function(data){
		  		 }
		  }); 
		 });
	</script>
</html>