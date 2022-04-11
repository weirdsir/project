<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Question</title>
</head>
<body>
<h2>Login App using HttpSession</h2>
<a href="login.html">Login</a>|
<a href="/logoutS">Logout</a>|
<a href="/profile">Profile</a>

<form action='/addquestion' method='post'>
    Question: <input type='text' name='question' value='' size=60>
    <input type='submit' name='submit' value='submit'>
</form>
</body>
</html>