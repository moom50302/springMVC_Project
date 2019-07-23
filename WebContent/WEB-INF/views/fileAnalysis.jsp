<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>File Analysis</title>
</head>
<body>
	<h2>Try To Use Our New Service!</h2>
	<h3>FileAnalysis</h3>
	<input type="file" id="uploadFile" onchange="handleFiles(this.files)" />

	<hr/>
	<h3>File Content</h3>
	<h4 id="fileSetting"></h4>
	<div id="fileContent"></div>
	
	<script>
		const inputElement = document.getElementById("uploadFile");
		inputElement.addEventListener("change", handleFiles,null);
		function handleFiles(files) {
			const fileList = files; 
			const fileCount = files.length;
			const file = files[0];
			const fileName = file.name;
			$('#fileSetting').html("<p>File Name:"+fileName+"</p><p>Upload File Number:"+fileCount+"</p>");
			
			const reader = new FileReader()
			reader.onload = handleFileLoad;
			reader.readAsText(event.target.files[0])
		}
		
		function handleFileLoad(event){
			$('#fileContent').html(event.target.result);
		}
	</script>
</body>
</html>