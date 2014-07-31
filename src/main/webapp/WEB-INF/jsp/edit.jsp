<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit student</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin-top:10%;width:50%;margin-left:25%;margin-right:auto%;">
	<h1>Edit student with PESEL:"${pesel}"</h1>
	
	<form:form modelAttribute="editStudent" method="POST"
		action="editStudent">
		<div>
			<h2>Personal Info</h2>
			<p>First Name</p>
			<form:input path="vorName" class="form-control"/>
			<p>Last Name</p>
			<form:input path="lastname" class="form-control"/>
		</div>
		<div>
			<h2>Adress</h2>
			<p>Street</p>
			<form:input path="homeAdress.street" class="form-control"/>
			<p>Possesion number</p>
			<form:input path="homeAdress.posesionNumber"  class="form-control"/>
			<p>Flat number</p>
			<form:input path="homeAdress.flatNumber" class="form-control"/>
		</div>
		<div>
			<h2>Divisions</h2>
			<form:select path="division.name" class="form-control">
				<c:forEach items="${divisions}" var="division">
					<form:option value="${division.value.name}" />
				</c:forEach>
			</form:select>
		</div>
		<form:hidden path="pesel" value="${pesel}"/>
		<form:button type="submit" class="btn btn-primary">Edit</form:button>
	</form:form>
	<form action="homePage">
		<input type="submit" value="Back to home" class="btn btn-primary"/>
	</form>
</div>
</body>
</html>
