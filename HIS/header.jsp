<nav class="navbar navbar-inverse"> 
  <div class="container-fluid">
    <div class="navbar-header ">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      
      	<a class="navbar-brand" href="#">WebSiteName</a>
      	<!-- Button trigger modal -->
  		
  		<%
  			String id=null;
  			if(session.getAttribute("isAdmin") == null)
  			{
	      		id =(String)session.getAttribute("id");
	      		
	      		if(id==null || id.isEmpty())       	  		
			  		out.write("<a  class='navbar-brand' href='#' data-toggle='modal' data-target='#myModal'>Login/Signup");
			
				else{
					out.write("<a class='navbar-brand' href='userDetail.jsp'>"+session.getAttribute("name"));
	      			out.write("<a class=\"btn btn-default\" href=\"Logout.jsp\">LogOut</a>");
				}
  			}
  			else
  			{
  				out.write("<a class='navbar-brand' href='userDetail.jsp'>Admin");
      			out.write("<a class=\"btn btn-default\" href=\"Logout.jsp\">LogOut</a>");
  			}
		%>
		</a>
      	
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Contact Us</a></li> 
      </ul>
      
    </div>
  </div>
</nav>