<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<title>File Analysis</title>
</head>
<body>
	<h2>Try To Use Our New Service!</h2>
	
	<h3>File Upload</h3>
		You Can Upload Your File By This Page.<br/>
		<a href="uploadFile" target="_blank">Upload Page</a>
	<hr />
	
	<h3>File Selector</h3>
	<select id="fileSelector"></select> <a id="checkContent" href="checkContent" target="_blank">Check File Content</a>
	
	<hr />
	
	<div id="fileAnalysisSelector">
		<h3>This Is File Selector For Analysis.</h3>
	</div>
	
</body>
</html>