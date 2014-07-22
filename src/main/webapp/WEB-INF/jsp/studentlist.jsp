<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="amg" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of students</title>
</head>
<body>
<amg:studentheader/><br>
<c:forEach items="${map}" var="elem">
<amg:student student="${elem.value}"></amg:student>
</c:forEach>
<form action="homePage">
<input type="submit" value="Back to home" />
</form>
</body>
</html>