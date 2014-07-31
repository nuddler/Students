<%@ tag isELIgnored="false"%>
<%@ attribute name="student" required="true" type="amg.net.pl.pojo.Student"%>

	 <td><jsp:text>${student.pesel}</jsp:text></td> 
     <td><jsp:text>${student.vorName}</jsp:text></td>
     <td><jsp:text>${student.lastname}</jsp:text></td>
     <td><jsp:text>${student.homeAdress.street}</jsp:text> </td>
     <td><jsp:text>${student.homeAdress.posesionNumber}</jsp:text> </td> 
     <td><jsp:text>${student.homeAdress.flatNumber}</jsp:text></td>  
     <td><jsp:text>${student.division.name}</jsp:text></td>