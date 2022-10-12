<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Login Details</h3>
        <form:form method="POST"
          action="/loginProcess" modelAttribute="credentials">
             <table>
                <tr>
                    <td><form:label path="emailId">Email ID</form:label></td>
                    <td><form:input path="emailId"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:password path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>