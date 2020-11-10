<%@page import="de.ars.demo.entity.Fahrzeug"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrzeuge</title>
</head>
<body>
	<ul>
		<c:forEach items="${fz}" var="f">
			<li><c:out value="${f.hersteller}, ${f.baujahr}"/></li>
		</c:forEach>
	</ul>
</body>
</html>