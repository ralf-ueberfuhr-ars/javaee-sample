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
	<h1><c:out value="${empty pageTitle ? 'Anzeige von Fahrzeugen' : pageTitle}"/></h1>
	<form action="merken" method="post">
	<ul>
		<c:forEach items="${fz}" var="f">
			<li>
				<c:if test="${!merkenFormDisabled}">
					<input type="checkbox" name="id" value="${f.id}">
				</c:if>
				<c:out value="${f.hersteller}, ${f.baujahr}"/>
			</li>
		</c:forEach>
	</ul>
	<c:if test="${!merkenFormDisabled}">
		<input type="submit" value="Markierte Fahrzeuge auf Merkliste setzen">
	</c:if>
	</form>
</body>
</html>