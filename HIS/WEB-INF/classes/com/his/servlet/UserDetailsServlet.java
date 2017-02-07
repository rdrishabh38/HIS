package com.his.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.his.BL.UserDetailsValidation;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.UserUpdateBean;

/**
 * Servlet implementation class UserDetailsServlet
 */
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost method invoked");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");

		UserUpdateBean uub = new UserUpdateBean(firstName, lastName, password,
				email, phonenumber);
		uub.setCustomer_id((String) request.getSession().getAttribute("id"));

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("userDetail.jsp");

		try {
			UserDetailsValidation.validate(uub);

			request.setAttribute("success_message",
					"details have been saved successfully");

		} catch (HISBusinessException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());

		} catch (HISApplicationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
		} finally {
			dispatcher.forward(request, response);
		}

	}
}
