<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="./commons/_head.jspf" %>

</head>

<body>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>Login</h1>


  <form action="/form.jsp" method ="get">
  
  <label id="icon" for="userId"><i class="icon-user"></i></label>
  <input type="text" name="userId" id="userId" placeholder="Id" required/>    
  <label id="icon" for="email"><i class="icon-envelope "></i></label>
  <input type="text" name="email" id="email" placeholder="E-mail" required/>
  <label id="icon" for="Password"><i class="icon-shield"></i></label>
  <input type="password" name="password" id="password" placeholder="Password" required/>
  
  <input type="submit" class="button" value="Submit"></input>
  </form>
</div>

</body> 
</html>