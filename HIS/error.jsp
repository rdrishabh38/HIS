<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<%@include file="externalJsAndCSS.jsp" %>
</head>
<body>
<!-- header section start -->							
							<%@include file="header.jsp" %>
							<!-- header section end -->
						
							
						<!-- content section start -->
							<!-- Model start-->
							<%@include file="model.jsp" %>
							<!-- Model end -->
							<h1><%=request.getAttribute("errorMsg") %></h1>
						<!-- content section end -->
							
							
							<!-- footer section start -->							
							<%@include file="footer.jsp" %>						
							<!-- footer section end -->
</body>
</html>