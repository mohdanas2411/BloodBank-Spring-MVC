<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Info page</title>
    </head>
    <body>
        <h2>WELCOME! ${admin.adminName}</h2>
        <form:form action ="adminValidate" method="POST" modelAttribute="admin">
            <label>Enter Admin Email<label>
            <form:input path = "adminEmail"/>
        	<br>
        	<label>Enter Admin Password</label>
        	<form:input path="adminPassword" type="password"/>
        	<br><input type="submit" name="Submit">
        </form:form>
    </body>
</html>