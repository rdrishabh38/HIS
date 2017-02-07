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

import sun.rmi.server.Dispatcher;

import com.his.BL.AdminApproveRejectPolicy;
import com.his.DAO.AdminViewPolicy;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.ViewPolicyBean;

/**
 * Servlet implementation class AdminViewPolicy
 */
public class AdminViewPolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewPolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("policyApproveReject.jsp");
		List<ViewPolicyBean> vpl = new ArrayList<ViewPolicyBean>(); 
		try {
			vpl = AdminViewPolicy.policies();
			request.setAttribute("policylist", vpl);
			
		} catch (HISApplicationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error_msg", "Server is down");
		}
		finally
		{
			disp.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid=request.getParameter("pid");
		String status=null;
		status=request.getParameter("status");
		
		ViewPolicyBean vpb=new ViewPolicyBean();
		PrintWriter out=response.getWriter();
		String result=""; 
		
		if(status == null){
			try {
				vpb=AdminViewPolicy.getSinglePolicy(pid);
				result+=vpb.getPolicy_id()+"_"+vpb.getInsurance_name()+"_"+vpb.getPolicy_amount()+"_"+vpb.getPolicy_duration()+"_"+vpb.getPremium_type()+"_"+vpb.getDiscount()+"_"+vpb.getPremium_amount()+"_"+vpb.getPolicy_start_date()+"_"+vpb.getMaturity_date()+"_"+vpb.getStatus();
				out.write(result);
				
			} catch (HISApplicationException e) {
				// TODO Auto-generated catch block
				out.write("server is down try later");
			}
		}
		else{
			
			if(status.equalsIgnoreCase("reject")){
				try {
					AdminApproveRejectPolicy.getPolicyStatus(pid);
					AdminViewPolicy.updatePolicyStatus(pid, "rejected");
					out.write("");
				} catch (HISApplicationException e) {
					// TODO Auto-generated catch block
					out.write(e.getMessage());
				} catch (HISBusinessException e) {
					// TODO Auto-generated catch block
					out.write(e.getMessage());
				}
			}
			else if(status.equalsIgnoreCase("approve")){
				try {
					AdminApproveRejectPolicy.getPolicyStatus(pid);
					AdminViewPolicy.updatePolicyStatus(pid, "approved");
					out.write("");
				} catch (HISApplicationException e) {
					// TODO Auto-generated catch block
					out.write(e.getMessage());
				} catch (HISBusinessException e) {
					// TODO Auto-generated catch block
					out.write(e.getMessage());
				}
			}
			else{
				out.write("unable to update policy status");
			}
			
		}
		
		
		
	}

}
