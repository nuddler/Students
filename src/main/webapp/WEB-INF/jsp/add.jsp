<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
</head>
<body>

<form action="createstudent" method="POST">
<h2>Personal Info</h2>
First Name: <input type="text" name="vorName" value="dupa"/>
<br />
Last Name: <input type="text" name="lastName" />
<br>
PESEL: <input type="text" name="pesel"/>
<br />
<h2>Adress</h2>
Street: <input type="text" name="street" />
<br />
Possesion number: <input type="text" name="posesionNumber" />
<br>
Flat number: <input type="text" name="flatNumber" />
<br>
<h2>Division :</h2>
<c:forEach items="${divisions}" var="division">
<c:out value="${division.value.name}"></c:out>
</c:forEach></br>
<input type="text" name="divisionName" />
<br />

<input type="submit" value="Submit" />
</form>

</body>
</html>