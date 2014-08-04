<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript"
src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"/>"></script>
<script type="text/javascript"
src="<c:url value="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"/>"></script>
<script src="<c:url value="resource1/file.js"/>"></script>

</head>
<body>
<div style="margin-top:10%;width:50%;margin-left:25%;margin-right:auto%;">
	<form:form id="formularz" modelAttribute="newStudent" method="POST"
		action="addStudent" >
		<form:errors path="*" element="div" cssClass="alert alert-danger"/>
		<c:if test="${param.error}">
				<div class="alert alert-danger">
				<c:out value="Student exist!"/>
				</div>
		</c:if>
		<div>
			<h2>Personal Info</h2>
			<p>First Name</p>
			<form:input path="vorName" value="Imie" class="form-control"/>
			<p>Last Name</p>
			<form:input path="lastname" value="Nazwisko" class="form-control"/>
			<p>PESEL</p>
			<form:input path="pesel" value="12345678910" class="form-control"/>
		</div>
		<div>
			<h2>Adress</h2>
			<p>Street</p>
			<form:input path="homeAdress.street" value="ulica" class="form-control"/>
			<p>Possesion number</p>
			<form:input path="homeAdress.posesionNumber" value="Nr domu" class="form-control"/>
			<p>Flat number</p>
			<form:input path="homeAdress.flatNumber" value="Nr miszkania" class="form-control"/>
		</div>
		<div>
			<h2>Divisions</h2>
			<form:select path="division.name" class="form-control">
				<c:forEach items="${divisions}" var="division">
					<form:option value="${division.name}" />
				</c:forEach>
			</form:select>
		</div>
		<form:button type="submit" class="btn btn-primary">Add</form:button>
	</form:form>
	<form action="/Students">
		<input type="submit" value="Back to home" class="btn btn-primary"/>
	</form>
</div>
</body>
</html>

