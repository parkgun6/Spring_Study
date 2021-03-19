<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOME</h1>
	<form method="get" action="/sample/all">
		<button>GO TO ALL</button>
	</form>
	
	<form method="get" action="/sample/member">
		<button>GO TO MEMBER</button>
	</form>
	
	<form method="get" action="/sample/admin">
		<button>GO TO ADMIN</button>
	</form>
	
	<form method="post" action="/customLogout">
		<button>logout</button>
		<input type="hidden" name='_csrf' value='${_csrf.token }'>
	</form>
	
	<form method="get" action="/customLogin">

		<button>GO TO LOGIN</button>
	</form>
	

	
</body>
</html>