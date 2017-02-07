<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<%@include file="externalJsAndCSS.jsp" %>
</head>


<body>



							<!-- header section start -->
							
							<%@include file="header.jsp" %>

							<!-- header section end -->
						
							
							<!-- content section start -->

<div class="container-fluid" id="content">

<!-- Model start-->
<%@include file="model.jsp" %>
<!-- Model end -->

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="images/image1.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="images/image2.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="images/image3.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="images/image4.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
							<!-- content section end -->
							
							<!-- footer section start -->
							
							<%@include file="footer.jsp" %>								
							
							<!-- footer section end -->


</body>
</html>