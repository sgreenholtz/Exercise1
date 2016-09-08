<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class=".table-bordered">
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userid}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
