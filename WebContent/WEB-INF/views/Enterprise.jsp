<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/dashboard/dashboard.css" rel="stylesheet">
  	<!-- DataTable template -->
  	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
  
<title>EnterPrise Page</title>
</head>
<body>
	<h1>Enterprise Customer Page</h1>
	<p>Dear Our VIP Customer. You Can Do A Lot Of Things Here.</p>
	<p>Please Have A Great Time Yourself Here.</p>
	<div>
		What kind of things do you want to do ?
		<ul>
			<li><a href="servicePage/addTicket">Add New Ticket</a></li>
			<li><a href="servicePage/removeTicket">Remove Old Ticket</a></li>
			<li><a href="servicePage/editTicket">Edit Old Ticket</a></li>
		</ul>
	</div>
	<div>
		<table id="DataTable" class="display">
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
    <script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
	<!-- Graphs -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script>
	$(document).ready(function() {
        $('#DataTable').DataTable( {
        	dataSrc:"[[${dataSource}]]"
            ,columns: [
            	{data:"ticket_no"},
            	{data:"cid"},
            	{data:"store_no"},
            	{data:"ticket_date"},
            	{data:"final_price"}]
        });
    });
	</script>
</body>
</html>