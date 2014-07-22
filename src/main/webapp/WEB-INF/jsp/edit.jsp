<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit student</title>
</head>
<body>
	<h1>Edit student with PESEL:"${pesel}"</h1>
	<form action="editStudent" method="POST">
		<div>
			<h2>Personal Info</h2>
			First Name: <input type="text" name="vorName"
				value="${student.vorName}" /> <br /> Last Name: <input type="text"
				name="lastName" value="${student.lastname}" />
		</div>
		<br>
		<div>
			<h2>Adress</h2>
			Street: <input type="text" name="street"
				value="${student.homeAdress.street}" /> <br /> Possesion number: <input
				type="text" name="posesionNumber"
				value="${student.homeAdress.posesionNumber}" /> <br> Flat
			number: <input type="text" name="flatNumber"
				value="${student.homeAdress.flatNumber}" />
		</div>
		<br>
		<div>
			<h2>Division :</h2>
			<input list="divisions" name="divisionName"
				value="${student.divisions[0].name}">
			<datalist id="divisions">
				<c:forEach items="${divisions}" var="division">
					<option value="${division.value.name}">
				</c:forEach>
			</datalist>
		</div>
		<br /> <input type="submit" value="Edit" /> <input type="hidden"
			name="pesel" value="${pesel}" />
	</form>

</body>
</html>