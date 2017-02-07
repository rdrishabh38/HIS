package com.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.his.BL.EditPolicyDetail;
import com.his.exceptions.HISApplicationException;
import com.his.exceptions.HISBusinessException;
import com.his.model.ViewPolicyBean;

/**
 * Servlet implementation class EditPolicyServlet
 */
public class EditPolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId=(String)request.getParameter("jspid");
		String pAmount=(String)request.getParameter("pAmount");
		String pDuration=(String)request.getParameter("pDuration");
		String pType=(String)request.getParameter("pType");
		
		ViewPolicyBean pb=new ViewPolicyBean();
		pb.setPolicy_id(Integer.parseInt(pId));
		pb.setPolicy_amount(Integer.parseInt(pAmount));
		pb.setPolicy_duration(Integer.parseInt(pDuration));
		pb.setPremium_type(pType);
		
		RequestDispatcher disp=request.getRequestDispatcher("ViewPolicy.jsp");
		
		
			try {
				EditPolicyDetail.validate(pb);
				
			} catch (HISApplicationException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", e.getMessage());
				
			} catch (HISBusinessException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", e.getMessage());
			}
			finally{
				request.setAttribute("success", "policy updated successfully");
				disp.forward(request, response);
			}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId=(String)request.getParameter("pid");
		String pAmount=(String)request.getParameter("pAmount");
		String pDuration=(String)request.getParameter("pDuration");
		String pType=(String)request.getParameter("pType");
		PrintWriter out=response.getWriter();
		ViewPolicyBean pb=new ViewPolicyBean();
		pb.setPolicy_id(Integer.parseInt(pId));
		pb.setPolicy_amount(Integer.parseInt(pAmount));
		pb.setPolicy_duration(Integer.parseInt(pDuration));
		pb.setPremium_type(pType);
		//System.out.println(pb);
		String msg=null;
		//RequestDispatcher disp=request.getRequestDispatcher("ViewPolicy.jsp");
		
		
			try {
				EditPolicyDetail.validate(pb);
				
			} catch (HISApplicationException e) {
				// TODO Auto-generated catch block
				//request.setAttribute("error", e.getMessage());
				msg=e.getMessage();
				
			} catch (HISBusinessException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", e.getMessage());
				msg=e.getMessage();
			}
			finally{
				//request.setAttribute("success", "policy updated successfully");
				//disp.forward(request, response);
				if(msg==null || msg.isEmpty() ){
					msg="Updat Successfull";
					out.write("<div id=\"updatemsg\" class=\"alert alert-success\" role=\"alert\">"+msg+"</div>");
				}
				else{
					out.write("<div id=\"updatemsg\" class=\"alert alert-danger\" role=\"alert\">"+msg+"</div>");
				}
					
				
				
			}
		
		
		
		
		
	}

}
