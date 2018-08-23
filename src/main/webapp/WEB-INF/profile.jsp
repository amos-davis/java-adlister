<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <H1>Welcome, ${sessionScope.user}!</H1>
        <h1>You are now viewing your profile.</h1>
    </div>

</body>
</html>
