<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!-- 무조건 /login이다 /customLogin이 아니다. -->
	<form action="/login" method="post">

		<input type='text' name='username'> 
		<input type='text' name='password'>
		<button>LOGIN</button>
		
		<input type='text' name="_csrf" value="${_csrf.token }">
		
	</form>

</body>
</html>