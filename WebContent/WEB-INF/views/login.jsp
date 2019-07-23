<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Here is Login Page.</h1>
	
	<p> Welcome to IF Studio SpringMVC Practice Project.</p>
	<div>
		Please Login Your Own Account And Get Your Own Service.
		<form action="loginCheck" method="POST">
			<input type="text" name="account" placeholder="Account"/>
			<input type="password" name="password" placeholder="Password"/>
			<input type="submit" value="Send"/>
		</form>
	</div>
	${message}
</body>
</html>