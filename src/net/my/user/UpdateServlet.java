package net.my.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.my.db.Database;

@WebServlet("/user/update")
public class UpdateServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello");
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User user = new User(userId, password, email);

		try {
			if (Database.checkUser(userId)) { 
				Database.modify(user);
				System.out.println(user);
				response.sendRedirect("/index.jsp");
			} else {
				// 우리 사용자가 아닌 분이 새로 왔을 때.
				// 회원가입하는 부분
			}
		} catch (InvalidAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
