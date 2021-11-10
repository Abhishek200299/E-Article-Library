<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wildlife Articles</title>
</head>
<body>
<h1>List of Articles under Wildlife Category</h1>
<c:forEach items="${titleList}" var="title">
	<li><a href="http://localhost:8080/"+${title}><c:out value="${title}"/></a></li>
</c:forEach>
</body>
</html>