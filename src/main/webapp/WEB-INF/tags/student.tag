<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

    <jsp:directive.tag pageEncoding="UTF-8"/> 

    <!-- The list of normal or fragment attributes can be specified here, e.g.: -->
    <jsp:directive.attribute name="student" type="amg.net.pl.model.Student"/>

    <!-- any content can be specified here e.g.: -->
    <jsp:text>${student.pesel}</jsp:text> | 
    <jsp:text>${student.vorName}</jsp:text> | 
    <jsp:text>${student.lastName}</jsp:text> | 
    <jsp:text>${student.address.street} ${student.address.posesionNumber} ${student.address.flatNumber}</jsp:text> | 
    <jsp:text>${student.divisions[0].name}</jsp:text> | 

</jsp:root>