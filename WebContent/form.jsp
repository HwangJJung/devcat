<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.my.user.User" %>
<%@ page import="net.my.db.Database" %>

<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	User user = new User(userId,password,email);
	
	if (!Database.CheckUser(userId)) { // 우리 사용자가 아닌 분이 새로 왔을 때.
		//회원가입하는 부분
		Database.addUser(user);
		session.setAttribute("userId", userId);
		response.sendRedirect("index.jsp");
	} else {
		// 이미 존재하는 분일 경우
		// 이거를 로그인 요청이라고 가정하자.
		session.setAttribute("userId", userId);
		// request.setAttribute("errorMessage" , "존재하지 않는 사용자입니다. 다시로그인하시죠.");	
		response.sendRedirect("/mypage.jsp?userId="+userId);
	}
%>