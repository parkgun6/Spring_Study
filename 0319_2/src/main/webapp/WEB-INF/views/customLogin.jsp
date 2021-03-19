<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/login">
	<input type="text" name="username">
	<input type="text" name="password">
	<button>login</button>
	<input type="text" name='_csrf' value='${_csrf.token }'>
</form>

</body>
</html>