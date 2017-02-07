package com.his.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.his.BL.ViewPolicyDetail;
import com.his.exceptions.HISApplicationException;
import com.his.model.ViewPolicyBean;

/**
 * Servlet implementation class ViewPolicyServlet
 */
public class ViewPolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewPolicyServlet() {
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

		String id = new String();
		id=(String) request.getSession().getAttribute("id");
		// System.out.println(id);
		List<ViewPolicyBean> pl = null;
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ViewPolicy.jsp");
		request.setAttribute("found", "true");
		try {
			pl = ViewPolicyDetail.allPolicies(id);
			//System.out.println(pl);
			request.setAttribute("policy_list", pl);

		} catch (HISApplicationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			request.setAttribute("error_msg",
					"server is down. please try later");
			dispatcher.forward(request, response);
		}

		dispatcher.forward(request, response);
		// System.out.println("dispatch success full");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
