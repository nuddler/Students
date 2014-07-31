<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="AMG" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student manager</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<center>
		<h1>Home page</h1>

		<div style="margin-top: 10%; width: 70%;">
				<form action="listStudents">
					<input type="submit" value="Go to student list"
						class="btn btn-primary" />
				</form>
				<form action="addStudent">
					<input type="submit" value="Go to student adding"
						class="btn btn-primary" />
				</form>
		</div>
	</center>
</body>
</html>