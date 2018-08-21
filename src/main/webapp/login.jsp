<%--
  Created by IntelliJ IDEA.
  User: amosdavis
  Date: 8/20/18
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login Page</title>
        <jsp:include page="partials/header.jsp">
            <jsp:param name="title" value="Login please"/>
        </jsp:include>
    </head>
    <body>

        <form method="POST" action="login.jsp">

            <label for="username">Username</label>
            <input id="username" name="username" type="text">
            <br>

            <label for="password">Password</label>
            <input id="password" name="password" type="password">
            <br>

            <button>submit</button>
        </form>

        <%
        if (request.getMethod().equalsIgnoreCase("post")) {
            String userName = request.getParameter("username");
            String pass = request.getParameter("password");

            if (userName.equals("admin") && pass.equals("password")) {
                response.sendRedirect("/profile.jsp");
            }
        }
        %>





    </body>
</html>
