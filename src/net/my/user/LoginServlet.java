package net.my.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.my.db.Database;

@WebServlet("/foo")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		User user = Database.FindbyId(userId);
		
		if(user == null){
			//사용자가 존재하지 않는다는 것을 에러 메시지 전송 
		}
		
		if(password.equals(user.getPassword())){
			//로그인 처리  
		}
		
		// TODO Auto-generated method stub
	}
}
