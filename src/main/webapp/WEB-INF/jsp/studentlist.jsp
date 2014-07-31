<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="amg" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of students</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin-top:10%;width:70%;margin-left:auto;margin-right:auto;">
	<table class="table">
	<thead>
		<tr>
			<amg:studentheader />
		</tr>
	</thead>
		<c:forEach items="${map}" var="elem">
			<tr>
				<amg:student student="${elem.value}" />
				<td>
					<form action="editjsp" method="POST">
						<input type="submit" value="Edit" class="btn btn-default"/> 
						<input type="hidden" name="pesel" value="${elem.value.pesel}" />
					</form>
					<form action="deleteStudent">
						<input type="submit" value="Delete" class="btn btn-default" /> 
						<input type="hidden" name="pesel" value="${elem.value.pesel}" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="homePage">
		<input type="submit" value="Back to home" class="btn btn-primary"/>
	</form>
</div>
</body>
</html>