<%@ tag isELIgnored="false"%>
<%@ attribute name="student" required="true" type="amg.net.pl.model.Student"%>

	 <td><jsp:text>${student.pesel}</jsp:text></td> 
     <td><jsp:text>${student.vorName}</jsp:text></td>
     <td><jsp:text>${student.lastname}</jsp:text></td>
     <td><jsp:text>${student.homeAdress.street} ${student.homeAdress.posesionNumber} ${student.homeAdress.flatNumber}</jsp:text></td>  
     <td><jsp:text>${student.divisions[0].name}</jsp:text></td>