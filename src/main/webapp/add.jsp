<html>
<body>

<form action="addstudent" method="POST">
<h5>Personal Info</h5>
First Name: <input type="text" name="vorName">
<br />
Last Name: <input type="text" name="lastName" />
<br>
PESEL: <input type="text" name="pesel">
<br />
<h5>Adress</h5>
Street: <input type="text" name="street" />
<br />
Possesion number: <input type="text" name="posesionNumber" />
<br>
Flat number: <input type="text" name="flatNumber" />
<br>
<h5>Division</h5><input type="text" name="divisionName" />
<br />
<input type="submit" value="Submit" />
</form>

<%-- <%
request.setAttribute("vorname", request.getParameter("vorname"));
request.setAttribute("lastName", request.getParameter("lastName"));
request.setAttribute("pesel", request.getParameter("pesel"));
request.setAttribute("posesionNumber", request.getParameter("posesionNumber"));
request.setAttribute("flatNumber", request.getParameter("flatNumber"));
request.setAttribute("divisionName", request.getParameter("divisionName"));
%> --%>
</body>
</html>