<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="./commons/_head.jspf"%>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
	rel="stylesheet">

</head>

<body>


	<%@ include file="./commons/_nav.jspf"%>
	<div class="container">
		<div class="testbox">
			<h1>Registration</h1>
			<form action="/user/signup" method="post">
			
			
<%
	Object errorMessage = request.getAttribute("errorMessage");
	if(errorMessage != null) {
	
%>
	 <div class = "control-group">
	 <label class = "error"><% out.println(errorMessage); %></label>
	 </div>

<%
	}
%>

				<label id="icon" for="userId"><i class="icon-user"></i></label> <input
					type="text" name="userId" id="userId" placeholder="Id" required />
				<label id="icon" for="email"><i class="icon-envelope "></i></label>
				<input type="text" name="email" id="email" placeholder="E-mail"
					required /> <label id="icon" for="Password"><i
					class="icon-shield"></i></label> <input type="password" name="password"
					id="password" placeholder="Password" required /> <input
					type="submit" class="button" value="Submit"></input>
			</form>

			<a href="/login.jsp">
				<h2>login은 이쪽으로</h2>
			</a>
		</div>
	</div>
	<%@ include file="./commons/_footer.jspf"%>
</body>
</html>