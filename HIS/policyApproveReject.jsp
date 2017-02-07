<%@page import="java.util.*"%>
<%@page import="com.his.model.ViewPolicyBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Reject Policy</title>
<%@include file="externalJsAndCSS.jsp" %>
</head>


<body>



							<!-- header section start -->							
							<%@include file="header.jsp" %>
							<!-- header section end -->
						
							
							
							
							<!-- content section start -->
<div style="height:10%; overflow:scroll;" >
<%
String error =(String) request.getAttribute("error_msg");
if (error==null||error.isEmpty())
{
	List<ViewPolicyBean> vpl = new ArrayList<ViewPolicyBean>();
	vpl =(List<ViewPolicyBean>) request.getAttribute("policylist");
	
%>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Amount</th>
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
		 for(ViewPolicyBean vpb : vpl)
		 {
		%>
			<tr>
				<td><%=vpb.getPolicy_id() %></td>
				<td><%=vpb.getInsurance_name() %></td>
				<td><%=vpb.getPolicy_amount() %></td>
				<td><%=vpb.getPremium_type() %></td>
				<td><%=vpb.getPolicy_start_date() %></td>
				<td><%=vpb.getDiscount() %></td>
				<td><%=vpb.getPremium_amount()%></td>
				<td><%=vpb.getMaturity_date()%></td>
				<td><button class="btn btn-primary getPolicyDetail" type="button" value="<%=vpb.getPolicy_id() %>">View</button></td>
			</tr>
			<%
		 		}
			%>
		</tbody>
	</table>
</div>
<%
}
else
{
	out.write(error);
}


%>
<div id="tableContents" style="margin-top:10px;">
	<div id="msg"></div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<table class="table table-hover table-bordered">
			  <tr>
			  	<th>Policy_Id</th>
			  	<td id="tPolicyId"></td>
			  </tr>
			  <tr>
			  	<th>Ins_Name</th>
			  	<td id="tInsName"></td>
			  </tr>
			  <tr>
			  	<th>Policy_Amount</th>
			  	<td id="tPolicyAmount"></td>
			  </tr>
			  <tr>
			  	<th>Policy_Duration</th>
			  	<td id="tPolicyDuration"></td>
			  </tr>
			  <tr>
			  	<th>Premium_type</th>
			  	<td id="tPremiumType"></td>
			  </tr>
			  <tr>
			  	<th>Discount</th>
			  	<td id="tDiscount"></td>
			  </tr>
			  <tr>
			  	<th>Premium_amount</th>
				<td id="tPremiumAmount"></td>
			  </tr>
			  <tr>
				<th>Policy_StarDate</th>
				<td id="tPolicyStartDate"></td>
			  </tr>
			  <tr>
				<th>Policy_Maturity Date</th>
				<td id="tPolicyMaturityDate"></td>
			  </tr>
			  <tr>
				<th>Status</th>
				<td id="tStatus"></td>
			  </tr>
			  <tr>
			  	<td>
			  		<button class="btn btn-success updatebutton" id="tApproveButton" type="button" disabled="disabled">Approve</button>
			  	</td>
			  	<td>
			  		<button class="btn btn-danger updatebutton" id="tRejectButton" type="button" disabled="disabled">Reject</button>
			  	</td>
			  </tr>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
							


							
							
							<!-- content section end -->
							
							
							
							
							
							<!-- footer section start -->							
							<%@include file="footer.jsp" %>							
							<!-- footer section end -->


</body>
</html>