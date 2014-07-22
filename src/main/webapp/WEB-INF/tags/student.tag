<%@ tag isELIgnored="false"%>
<%@ attribute name="student" required="true" type="amg.net.pl.model.Student"%>

    <jsp:text>${student.pesel}</jsp:text> | 
    <jsp:text>${student.vorName}</jsp:text> | 
    <jsp:text>${student.lastname}</jsp:text> | 
    <jsp:text>${student.homeAdress.street} ${student.homeAdress.posesionNumber} ${student.homeAdress.flatNumber}</jsp:text> | 
    <jsp:text>${student.divisions[0].name}</jsp:text> |

