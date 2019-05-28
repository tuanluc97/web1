<!DOCTYPE html>
<html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<h2>${title}</h2>
<fieldset>
    <legend>Login</legend>
    <form:form method="POST" action="handle-login" modelAttribute="user">
        User name: <form:input path="userName" />
        <br/>
        Password: <form:input path="password" />
        <input type="submit" value="Submit" />
    </form:form>
    <h4>${mess}</h4>
</fieldset>
</body>

</html>