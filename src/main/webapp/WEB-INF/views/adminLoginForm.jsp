<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Info page</title>
    </head>
    <body>
        <h2>WELCOME!</h2>
        <form action ="adminValidate" method="POST">
        	<label>Email</label>
        	<input type="email" name="email" placeholder="Admin Email">
        	<br>
        	<label>Password</label>
        	<input type="text" name="password" placeholder="Password">
        	<br><input type="submit" name="Submit">
        </form>
    </body>
</html>