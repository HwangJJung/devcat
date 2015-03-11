<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.my.user.User" %>
<%@ page import="net.my.db.Database" %>

<%
	String name = request.getParameter("name");
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String email = request.getParameter("email");	
		
	User user = new User( userId, password, name, email);
	
	out.println(Database.show(userId).toString());
	
	if (!Database.CheckUser(userId)) {
		Database.addUser(user);
	} else {
		response.sendRedirect("/mypage.jsp");
	}
	
%>