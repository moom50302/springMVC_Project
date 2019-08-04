<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<meta charset="UTF8">
<title>File Content</title>
</head>
<body>
	
	<h3>File Content Page</h3>
	<p>Here You Can Check Detail Contents or Data In This File.</p>
	
	<H4>${fileName}</H4>
	<div>
		<table id="dataTable"></table>
	</div>
	
	<script>
	
	window.onload = function(){
		setData("[[${fileName})]]");
	}
	
	function setData(fileName) {
			$.ajax({
				type : "GET",
				url : "fileContent",
				data : {
					file : fileName
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