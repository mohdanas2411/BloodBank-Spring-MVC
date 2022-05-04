<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Blood Bank List</title>
</head>
<body>

   <h3>Welcome! ${name}</h3>
   <h2  style="align-content: flex-end;"><a href="adminLogout">LogOut</a></h2>
   <br>
   <h3>List of Blood Banks</h3>

   <table border="2" width="80%" cellpadding="2">
      <tr><th>Id</th><th>Name</th><th>Address</th><th>View</th><th>Update</th><th>Delete</th></tr>
      <c:forEach var = "bankList" items = "${list}">
         <tr style="text-align: center">
            <td>${bankList.bankId}</td>
            <td>${bankList.bankName}</td>
            <td>${bankList.bankAddress}</td>
            <td><a href="bloodBankDetailes/${bankList.bankId}">View</a></td>
            <td><a href="bloodBankUpdate/${bankList.bankId}">Update</a></td>
            <td><a href="bloodBankDelete/${bankList.bankId}">Delete</a></td>
         </tr>
         </c:forEach>
   </table>
<br>
   <a href="addNewBloodBankForm">Add New Blood Bank</a>
</body>
</html>