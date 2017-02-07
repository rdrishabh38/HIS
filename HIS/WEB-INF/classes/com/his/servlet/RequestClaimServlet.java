package com.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.his.DAO.AdminViewPolicy;
import com.his.DAO.RequestClaimQuery;
import com.his.exceptions.HISApplicationException;
import com.his.model.ViewPolicyBean;

/**
 * Servlet implementation class requestClaimServlet
 */
public class RequestClaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestClaimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=(String) request.getSession().getAttribute("id");
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("requestClaim.jsp");
		
		List<ViewPolicyBean> vpl= new ArrayList<ViewPolicyBean>();
		
		try {
			vpl=RequestClaimQuery.getPolicies(id);
			request.setAttribute("policyList", vpl);
			
			dispatcher.forward(request, response);
		} catch (HISApplicationException e) {
			// TODO Auto-generated catch block
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ViewPolicyBean vpb=new ViewPolicyBean();
		String result="";
		if(request.getParameter("claimType") == null){
			String pid=request.getParameter("pid");
			try {
				vpb=RequestClaimQuery.getSinglePolicy(pid);
				result+=vpb.getPolicy_id()+"_"+vpb.getInsurance_name()+"_"+vpb.getPolicy_amount()+"_"+vpb.getPolicy_duration()+"_"+vpb.getPremium_type()+"_"+vpb.getDiscount()+"_"+vpb.getPremium_amount()+"_"+vpb.getPolicy_start_date()+"_"+vpb.getMaturity_date();
				out.write(result);
			} catch (HISApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			
				String cType = request.getParameter("claimType");
				String pid=request.getParameter("pid");
				
				RequestClaimQuery.putClaim(pid,cType);
				
		}
		
		
	}

}
