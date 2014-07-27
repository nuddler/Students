Students
========
* https://console.cloudbees.com/
* http://students.lowca93.eu.cloudbees.net/
* http://www.mkyong.com/tutorials/spring-security-tutorials/
* http://www.javablog.eu/java/implementacja-uwierzytelniania-w-spring-security/
* http://docs.spring.io/spring-security/site/docs/3.0.x/reference/ns-config.html

TOMCAT
=====
conf contex.xml
< Resource url="jdbc:mysql://localhost:3306/dupa" driverClassName="com.mysql.jdbc.Driver" password="root" username="root" maxWaitMillis="10000" maxIdle="30" maxTotal="100" type="javax.sql.DataSource" auth="Container" name="jdbc/TestDB"/ >

Przydatne linki
==============
* http://www.regexr.com/
* http://www.mkyong.com/
* http://www.mkyong.com/spring-mvc/spring-3-mvc-and-jsr303-valid-example/

IMPORTANT MOZILLA
=========

* FireBug, xpath, WEBLOCATOR
* ROBOTFRAMEWORK


CREATE TABLE `students2` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VOR_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `PESEL` varchar(45) NOT NULL,
  `HOME_ADRESS_street` varchar(45) NOT NULL,
  `HOME_ADRESS_FLAT` varchar(45) DEFAULT NULL,
  `HOME_ADRESS_HOME` varchar(45) NOT NULL,
  `DIVISION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PESEL_UNIQUE` (`PESEL`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
