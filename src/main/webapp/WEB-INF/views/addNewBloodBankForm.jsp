<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
     <style type="text/css">
                input{
                    text-align: center;
                }
     </style>
    </head>
    <body>
        <h3>Welcome, Enter The New Blood Bank Details</h3>
        <form:form action = "addNewBloodBankSubmit" method = "POST" modelAttribute="BloodBank">
             <table>
                <tr>
                    <td><form:label path="bankName">Bank Name : </form:label></td>
                    <td><form:input path="bankName"/></td>
                </tr>
                <tr>
                    <td><form:label path="bankAddress">Bank Address : </form:label></td>
                    <td><form:input path="bankAddress"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupAPosUnit">A Positive : </form:label></td>
                    <td><form:input path="groupAPosUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupBPosUnit">B Positive : </form:label></td>
                    <td><form:input path="groupBPosUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupOPosUnit">O Positive : </form:label></td>
                    <td><form:input path="groupOPosUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupABPosUnit">AB Positive : </form:label></td>
                    <td><form:input path="groupABPosUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupANegUnit">A Negative : </form:label></td>
                    <td><form:input path="groupANegUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupBNegUnit">B Negative : </form:label></td>
                    <td><form:input path="groupBNegUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupONegUnit">O Negative : </form:label></td>
                    <td><form:input path="groupONegUnit"/></td>
                </tr>
                <tr>
                    <td><form:label path="groupABNegUnit">AB Negative : </form:label></td>
                    <td><form:input path="groupABNegUnit"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>