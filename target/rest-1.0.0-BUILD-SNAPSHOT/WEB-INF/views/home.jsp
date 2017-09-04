<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>
	Welcome home!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
