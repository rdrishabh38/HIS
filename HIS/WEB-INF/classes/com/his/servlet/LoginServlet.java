package com.his.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.his.BL.LoginValidation;
import com.his.DAO.LoginQuery;
import com.his.constants.PageConstant;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.CustomerLoginBean;

/**
 * Servlet implementation class LoginDemo
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("customerID");
		String pass = request.getParameter("password");
		RequestDispatcher disp = null;
		HttpSession session = request.getSession();
		if(request.getParameter("admin")== null)
		{
	
			CustomerLoginBean clb = new CustomerLoginBean(id, pass);
	
			LoginValidation lv = new LoginValidation(clb);
	
			try {
				lv.valid();
				LoginQuery.isVerified(clb);
				session.setAttribute("id", id);
				session.setAttribute("name", clb.getName());
				response.sendRedirect(PageConstant.WELCOME_PAGE);
			} catch (HISApplicationException e) {
				request.setAttribute("errorMsg",
						"The server is down please try after some time");
				disp = request.getRequestDispatcher(PageConstant.ERROR_PAGE);
				disp.forward(request, response);
	
			} catch (HISBusinessException e) {
				request.setAttribute("errorMsg", e.getMessage());
				disp = request.getRequestDispatcher(PageConstant.ERROR_PAGE);
				disp.forward(request, response);
	
			}
		}
		else
		{
			try {
				LoginValidation.adminLogin(id, pass);
				LoginQuery.adminLoginQuery(id, pass);
				response.sendRedirect(PageConstant.ADMIN_WELCOME_PAGE);
				session.setAttribute("isAdmin", "yes");
			} catch (HISApplicationException e) {
				request.setAttribute("errorMsg",
				"The server is down please try after some time");
				disp = request.getRequestDispatcher(PageConstant.ERROR_PAGE);
				disp.forward(request, response);

			} catch (HISBusinessException e) {
				request.setAttribute("errorMsg", e.getMessage());
				disp = request.getRequestDispatcher(PageConstant.ERROR_PAGE);
				disp.forward(request, response);
		
			}

		}
	}

}
