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

@WebServlet("/user/modify")
public class ModifyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("userId");
			User user = Database.modifyParsebyId(userId);
			
			String userEmail = user.getEmail();
			request.setAttribute("userId", userId);			
			request.setAttribute("userMail", userEmail);
			System.out.println(request.getAttribute("userMail"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
			rd.forward(request, response);
		} catch (InvalidAccessException e) {
//			request.setAttribute("errorMessage", "유효하지 않은 접근입니다.");
//			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
			response.sendRedirect("/");	
		}
	}
}
