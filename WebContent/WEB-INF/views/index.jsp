<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Here is INDEX Page.</h1>
	
	<p> Welcome to IF Studio SpringMVC Practice Project.</p>
	<div>
		<p>Hi ${customerData.name} (${customerData.account}) Welcome Back.</p>
		<p>Let's See What You Can Do ?</p>
		<ul>
			<li><a href="checkTicket">Check My Own Ticket</a></li>
			<li><a href="updateCustomer">Update My Own Data</a></li>
			<li><a href="vipService">VIP Service (Only For Enterprise Customer)</a></li>
		</ul>
	</div>
	
	<div>
		<h2>Try Our New Service!</h2>
		<a href="fileAnalysis"><h3>File For Analysis</h3></a>
	</div>
</body>
</html>