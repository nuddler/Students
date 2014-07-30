<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form:form modelAttribute="newStudent" method="POST"
		action="addStudent">
		<form:errors path="*" element="div" />
		<div>
			<h2>Personal Info</h2>
			<p>First Name</p>
			<form:input path="vorName" value="Imie" />
			<form:errors path="vorName"></form:errors>
			<p>Last Name</p>
			<form:input path="lastname" value="Nazwisko" />
			<form:errors path="lastname" />
			<p>PESEL</p>
			<form:input path="pesel" value="12345678910" />
			<form:errors path="pesel"/>
			<c:if test="${param.error}">
				<c:out value="Student exist!"/>
			</c:if>
		</div>
		<div>
			<h2>Adress</h2>
			<p>Street</p>
			<form:input path="homeAdress.street" value="ulica" />
			<form:errors path="homeAdress.street"/>
			<p>Possesion number</p>
			<form:input path="homeAdress.posesionNumber" value="Nr domu" />
			<form:errors path="homeAdress.posesionNumber"/>
			<p>Flat number</p>
			<form:input path="homeAdress.flatNumber" value="Nr miszkania" />
			<form:errors path="homeAdress.flatNumber"/>
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

