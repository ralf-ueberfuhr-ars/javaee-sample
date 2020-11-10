<%@page import="de.ars.demo.entity.Fahrzeug"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrzeuge</title>
</head>
<body>
<ul>
<% Collection<Fahrzeug> fahrzeuge = (Collection<Fahrzeug>) request.getAttribute("fz"); 

	for(Fahrzeug f : fahrzeuge) {
		%><li><%=f.getHersteller() %>, <%=f.getBaujahr() %></li><%	
	}

 %>
</ul>
</body>
</html>