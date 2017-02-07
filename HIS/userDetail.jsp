<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.his.constants.PageConstant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="externalJsAndCSS.jsp" %>

<title>Edit User Details</title>
</head>
<body>

							<!-- header section start -->							
							<%@include file="header.jsp" %>
<%
	 id=(String)session.getAttribute("id");
	if(id==null || id.isEmpty())
	{
		response.sendRedirect(PageConstant.HOMEPAGE);
	}
		
	
%>
							<!-- header section end -->
						
							
							<!-- content section start -->
<div class="container">
  <div class="jumbotron">
  	
  		<%
  			String s_msg=(String)request.getAttribute("success_message");
  			if(s_msg==null || s_msg.isEmpty()){
  				
  			}else{
  				out.write("<div class=\"alert alert-success\" role=\"alert\">"+s_msg+"</div>");

  			}
  			String err_msg=(String)request.getAttribute("error_msg");
  			if(err_msg==null || err_msg.isEmpty()){
  				
  			}else{
  				out.write("<div class=\"alert alert-danger\" role=\"alert\">"+err_msg+"</div>");
  			}
  		%>
  	
  	
    <form role="form" method="post" action="UserDetailsServlet">						
		<div class="form-group">
    		<label for="firstName">First Name:</label>
    		<input type="text" class="form-control" id="firstName" name = "firstName">
  		</div>
  		<div class="form-group">
    		<label for="lastName">Last Name:</label>
    		<input type="text" class="form-control" id="lastName" name = "lastName">
  		</div>
  		<div class="form-group">
    		<label for="email">Email address:</label>
    		<input type="email" class="form-control" id="email" name = "email">
		</div>
  		<div class="form-group">
   			<label for="pwd">Password:</label>
    		<input type="password" class="form-control" id="pwd" name = "password">
  		</div>
  		<div class="form-group">
    		<label for="phonenumber">Phone Number:</label>
    		<input type="text" class="form-control" id="phonenumber" name = "phonenumber">
  		</div>
  		<div class="form-group">
      		<label for="inputPassword">Disabled 1</label>
      		<input class="form-control" id="disabledInput" type="text" value = "disabled 1"  disabled>
    	</div>
    	<div class="form-group">
      		<label for="inputPassword">Disabled 2</label>
      		<input class="form-control" id="disabledInput" type="text" value = "disabled 2"  disabled>
    	</div>
  		<button type="submit" class="btn btn-default" action = "#">Update</button>
	</form>  
	</div>     
</div>
							
							<!-- content section end -->
							
							
							<!-- footer section start -->							
							<%@include file="footer.jsp" %>						
							<!-- footer section end -->

</body>
</html>