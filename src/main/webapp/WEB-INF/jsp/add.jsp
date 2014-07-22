<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
</head>
<body>

	<form action="createstudent" method="POST">
		<div>
			<h2>Personal Info</h2>
			First Name: <input type="text" name="vorName" value="dupa" /> <br />
			Last Name: <input type="text" name="lastName" value="dupa" /> <br>
			PESEL: <input type="text" name="pesel" value="dupa" />
		</div>
		<br />
		<div>
			<h2>Adress</h2>
			Street: <input type="text" name="street" value="dupa" /> <br />
			Possesion number: <input type="text" name="posesionNumber"
				value="dupa" /> <br> Flat number: <input type="text"
				name="flatNumber" value="dupa" />
		</div>
		<br>
		<div>
			<h2>Division :</h2>
			<input list="divisions" name="divisionName">
			<datalist id="divisions">
				<c:forEach items="${divisions}" var="division">
					<option value="${division.value.name}">
				</c:forEach>
			</datalist>
		</div>
		<input type="submit" value="Submit" />
	</form>

</body>
</html>