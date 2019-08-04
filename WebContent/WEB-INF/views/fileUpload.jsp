<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Upload Page</title>
</head>
<body>
	<form action="uploadFile" method="POST" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="Upload"/>
	</form>
	
	<p>${message}</p>
</body>
</html>