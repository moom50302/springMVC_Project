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
	<h3>FileAnalysis</h3>
	<input type="file" id="uploadFile" />
	<button id="analysisButton">Send To Analysis</button>
	<hr />
	<h3>File Content</h3>
	<h4 id="fileSetting"></h4>
	<div id="div_dataTable">
		<table id="dataTable"></table>
	</div>
	<script>
		const inputElement = document.getElementById("uploadFile");
		inputElement.addEventListener("change", handleFiles, null);

		function handleFiles(event) {
			const files = event.target.files;
			const fileList = files;
			const fileCount = files.length;
			const file = files[0];
			const fileName = files.name;
			$('#fileSetting').html(
					"<p>File Name:" + fileName + "</p><p>Upload File Number:"
							+ fileCount + "</p>");

			const reader = new FileReader()
			reader.onload = handleFileLoad;
			reader.readAsText(event.target.files[0])
		}

		var fileArray;

		function handleFileLoad(event) {
			var getContent = event.target.result;
			fileArray = getContent.split('\n');
			$('#analysisButton').click(checkCache);
		}

		function checkCache() {
			$.ajax({
				type : "GET",
				url : "cache",
				success : function(response) {
					window.alert('Check Cache:'+response.status);
					if (response.status)
						setData();
					else
						window.alert("checkCache success but not doing anything.");
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		
		function setData(dataArray) {
			$.ajax({
				type : "POST",
				url : "setData",
				data : {
					dataArray : fileArray
				},
				success : function(response) {
					var jsonString = response;
					var status = jsonString.status;
					var columnName = jsonString.columnName;
					var data = jsonString.data;
					
					if (status){
						$('#dataTable').DataTable({
						    data: data,
						    columns: columnName
						});
					}else
						window.alert("setData success but not doing anything.");
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	</script>
</body>
</html>