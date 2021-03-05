<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>

</head>
<body>
	<h1>Add2</h1>
	<!-- target="zero" -->
	<form action="/todo/add" method="post">
		<div>
			<input type='text' name='title' value='${todoDTO.title }'>
		</div>

		<div>
			<button class='btn'>SAVE</button>
		</div>
	</form>
	<!-- 1. <iframe name='zero'></iframe> -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
		
	</script>

	<script>
		function showResult() {
			alert("showResult");
			self.location = "/todo/list";
		}

		$(document).ready(function() {
			$(".btn").on("click", function(e) {
				e.preventDefault();
				/* 1.  $('form').submit(); */
				const data = {title:$("input[name='title']".val(),complete:false)}
				console.log(data)
				$.post('/todo/add2',data,function(result){
					//console.log(result);
					alert(result);
				})
			})
		})
	</script>
</body>
</html>