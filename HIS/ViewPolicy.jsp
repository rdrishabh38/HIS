<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List,com.his.model.ViewPolicyBean,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Policy</title>
<%@include file="externalJsAndCSS.jsp" %>
</head>


<body>



<!-- header section start -->							
<%@include file="header.jsp" %>
<!-- header section end -->




<!-- content section start -->
<div id="updatemsg"></div>
<table class="table table-hover table-bordered">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Amount</th>
			<th>Duration</th>
			<th>Type</th>
			<th>Start Date</th>
			<th>Discount</th>
			<th>Premium_Amount</th>
			<th>Maturity_Date</th>
			<th></th>
		</tr>
	</thead>
	<tbody>

<%

if(request.getAttribute("found")==null){
	response.sendRedirect("ViewPolicyServlet");	
	//RequestDispatcher disp=request.getRequestDispatcher("ViewPolicyServlet");
	//disp.forward(request,response);
}
if(request.getAttribute("error_msg")==null)
{
	List<ViewPolicyBean> pl=new ArrayList<ViewPolicyBean>();
	if(request.getAttribute("policy_list")!=null)
		pl=(ArrayList<ViewPolicyBean>)request.getAttribute("policy_list");		
		
	for(ViewPolicyBean pb:pl){
		%>
		
		<tr <%if(pb.getStatus().equalsIgnoreCase("pending"))
					out.write("class='active'");
				else if(pb.getStatus().equalsIgnoreCase("approved"))
					out.write("class='success'");
				else
					out.write("class='danger'");
			%>>
			
			<td><%=pb.getPolicy_id() %></td>
			<td><%=pb.getInsurance_name() %></td>
			<td>
				<%
				if(pb.getStatus().equalsIgnoreCase("pending"))
				{
			%>
					<input class="form-control pAmount" id="pAmount<%=pb.getPolicy_id()%>" type="text" value="<%=pb.getPolicy_amount()%>" name="pAmount">
			<%
				}
				else
				{
			%>
				<%=pb.getPolicy_amount() %>
			<%
				}
			%>
		    </td>
			<td>
				<%
				if(pb.getStatus().equalsIgnoreCase("pending"))
				{
				%>
						<input class="form-control pDuration" id="pDuration<%=pb.getPolicy_id()%>" type="text" value="<%=pb.getPolicy_duration()%>" name="pDuration">
				<%
					}
					else
					{
				%>
					<%=pb.getPolicy_duration() %>
				<%
					}
				%>
			</td>
			<td>
				<%
				if(pb.getStatus().equalsIgnoreCase("pending"))
				{
				%>
						<input class="form-control" id="pType<%=pb.getPolicy_id()%>" type="text" value="<%=pb.getPremium_type()%>" name="pType">
				<%
					}
					else
					{
				%>
					<%=pb.getPremium_type()%>
				<%
					}
				%>
			</td>
			<td><%=pb.getPolicy_start_date()%></td>
			<td><%=pb.getDiscount()%></td>
			<td><%=pb.getPremium_amount()%></td>
			<td><%=pb.getMaturity_date()%></td>
			<td>
			<%
				if(pb.getStatus().equalsIgnoreCase("pending"))
				{
			%>
				
					<button type="submit" class="btn btn-primary formSubmit" name="jspid" value="<%=pb.getPolicy_id()%>">Update</button>
				
			<%
				}
			%>
			</td>
			
		</tr>
		
<%
		
	}
}
else
{
	out.write((String)request.getAttribute("error_msg"));
	
}
%>
	</tbody>
</table>

<%
/*String s_msg=(String)request.getAttribute("success");
if(s_msg==null || s_msg.isEmpty()){
	 
}else{
	out.write("<div class=\"alert alert-success\" role=\"alert\">"+s_msg+"</div>");

}
String err_msg=(String)request.getAttribute("error");
if(err_msg==null || err_msg.isEmpty()){
	
}else{
	out.write("<div class=\"alert alert-danger\" role=\"alert\">"+err_msg+"</div>");
}*/		
%>
<!-- content section end -->





<!-- footer section start -->							
<%@include file="footer.jsp" %>							
<!-- footer section end -->


</body>
</html>