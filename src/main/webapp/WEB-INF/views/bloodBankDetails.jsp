<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOC TYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blood Bank List</title>
    </head>
    <body>
        <h3>Blood Bank Details</h3>

        <table border="2" width="80%" cellpadding="2">
            <tr>
                <td>Bank Id</td>
                <td>${bloodBankObj.bankId}</td>
           </tr>
           <tr>
                <td>Bank Name</td>
                <td>${bloodBankObj.bankName}</td>
           </tr>
           <tr>
                <td>Bank Address</td>
                <td>${bloodBankObj.bankAddress}</td>
           </tr>
        </table>

        <table border="2" width="80%" cellpadding="2" style="text-align: center;">
        <tr><th>Blood Group Name</th><th>Number of Unit Available</th></tr>
            <tr>
                <td>A Positive</td>
                <td>${bloodBankObj.groupAPosUnit}</td>
            </tr>
            <tr>
                <td>B Positive</td>
                <td>${bloodBankObj.groupBPosUnit}</td>
            </tr>
            <tr>
                <td>O Positive</td>
                <td>${bloodBankObj.groupOPosUnit}</td>
            </tr>
            <tr>
                <td>AB Positive</td>
                <td>${bloodBankObj.groupABPosUnit}</td>
            </tr>
            <tr>
                <td>A Negitive</td>
                <td>${bloodBankObj.groupANegUnit}</td>
            </tr>
            <tr>
                <td>B Negitive</td>
                <td>${bloodBankObj.groupBNegUnit}</td>
            </tr>
            <tr>
                <td>O Negitive</td>
                <td>${bloodBankObj.groupONegUnit}</td>
            </tr>
            <tr>
                <td>AB Negitive</td>
                <td>${bloodBankObj.groupABNegUnit}</td>
            </tr>
        </table>
        <a href="/Blood_Bank/bankList">Go Back</a>

    </body>
</html>