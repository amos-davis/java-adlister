<%--
  Created by IntelliJ IDEA.
  User: amosdavis
  Date: 8/21/18
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Show List of All Ads</title>
    </head>
    <body>
        <h1>Take a look at all of our ads...</h1>

        <c:forEach var="ad" items="${ads}">
            <div class="ad">
                <h2>${ad.title}</h2>
                <p>Description: "${ad.description}</p>
                <p>Id = ${ad.userId}</p>
            </div>
        </c:forEach>
    </body>
</html>
