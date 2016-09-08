<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<form action="searchUser">
    <label>View all users</label>
    <input type="hidden" value="all" name="s"/>
    <input type="submit" value="Search" />
</form>
<form action="searchUser">
    <label>Search by first name</label>
    <input type="text" name="first" placeholder="First Name" />
    <input type="hidden" value="first" name="s"/>
    <input type="submit" value="Search" />
</form>
<form action="searchUser">
    <label>Search by last name</label>
    <input type="text" name="last" placeholder="Last Name" />
    <input type="hidden" value="last" name="s"/>
    <input type="submit" value="Search" />
</form>
</body>
</html>
