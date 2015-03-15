package net.my.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.my.db.Database;

@WebServlet("/user/signup")
public class SaveUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(userId,password,email);
		
		try { // 우리 사용자가 아닌 분이 새로 왔을 때.
			//회원가입하는 부분
			User.signUp(user);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("/index.jsp");
		} catch(UserFoundException e) {
			// 이미 존재하는 분일 경우
			request.setAttribute("errorMessage", "이미 존재한다능. 다시 ID 써주떼욤");
			RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
			rd.forward(request, response);
		}
	}
}
