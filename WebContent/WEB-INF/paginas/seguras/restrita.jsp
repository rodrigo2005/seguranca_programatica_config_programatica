<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area restrira</title>
</head>
<body>
<h1>�rea restrita </h1>
<hr/>
<a href="/logout">Sair</a> |
<c:if test="${IS_ADMIN eq true}"> 
<a href="/admin">�rea admin</a> |
</c:if>
<a href="User">�rea User</a>
</body>
</html>