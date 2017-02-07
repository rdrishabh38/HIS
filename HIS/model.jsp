<!-- Modal -->
<div class="modal fade custom-model" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content custom-model-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <form method="post" action="/HIS/welcome">
      	<div class="modal-body">			
			  <div class="form-group">
			    <label for="customerID">Customer ID</label>
			    <input type="text" class="form-control" name="customerID" id="customerID" placeholder="Customer ID">
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
			  </div>
			   <div class="checkbox">
				    <label>
				      <input type="checkbox" name="admin" id = "admin"> Admin
				    </label>
			  </div>
				  </div>
      	<div class="modal-footer" >  
	      	<div class="row">
	      		<div class="col-sm-6" style="text-align:left">
	      			<a class="btn btn-success" href="#">Register</a>
	      		</div>
		      	<div class="col-sm-6" >
			      	<input type="submit" class="btn btn-primary" value="login">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
		      	</div>
	      		
	      	</div>
      	</div>
      </form>
      
    </div>
  </div>
</div>
