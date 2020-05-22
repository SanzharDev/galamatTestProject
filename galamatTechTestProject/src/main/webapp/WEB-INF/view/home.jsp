<%--
  Created by IntelliJ IDEA.
  User: sanzhar
  Date: 5/21/20
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome ${user.firstName}</h1>
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
        <br><br>
        First name: ${user.firstName}, Last name: ${user.lastName}, Email: ${user.email}
    </p>
    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

        <input type="submit" value="Logout" />

    </form:form>

</body>
</html>
