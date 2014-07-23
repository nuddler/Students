<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
</head>
<body>
	<form:form modelAttribute="newStudent" method="POST"
		action="createstudent">
		<div>
			<h2>Personal Info</h2>
			<p>First Name</p>
			<form:input path="vorName" value="Imie" />
			<p>Last Name</p>
			<form:input path="lastname" value="Nazwisko" />
			<p>PESEL</p>
			<form:input path="pesel" value="12345678910" />
		</div>
		<div>
			<h2>Adress</h2>
			<p>Street</p>
			<form:input path="homeAdress.street" value="ulica" />
			<p>Possesion number</p>
			<form:input path="homeAdress.posesionNumber" value="Nr domu" />
			<p>Flat number</p>
			<form:input path="homeAdress.flatNumber" value="Nr miszkania" />
		</div>
		<div>
			<h2>Divisions</h2>
			<form:select path="division.name">
				<c:forEach items="${divisions}" var="division">
					<form:option value="${division.name}" />
				</c:forEach>
			</form:select>
		</div>
		<form:button type="submit">Add</form:button>
	</form:form>
</body>
</html>

