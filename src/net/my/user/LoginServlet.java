package net.my.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String password = request.getParameter("password");
		
		try {
			User.login(userId, password);
			session.setAttribute("userId", userId);
			response.sendRedirect("/");	
		} catch (UserNotFoundException e) {
			request.setAttribute("errorMessage", "존재하지 않는 사용자 입니다. 다시 로그인해주떼염");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} catch (PasswordMismatchException e) {
			request.setAttribute("errorMessage", "비밀번호가 틀립니당. 다시 로그인해줭 ㅋㄷ");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			
		}
		
	}
}
