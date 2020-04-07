<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Log In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="javascript:void(null);" method="post" id="form" name="test" onsubmit="send()">
        	<div class="form-group row">
    			<label for="inputLogin" class="col-sm-2 col-form-label">Login</label>
    				<div class="col-sm-10">
     					 <input name="login" type="text" class="form-control">
   				    </div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
    				<div class="col-sm-10">
     					 <input name="password" type="password" class="form-control">
    				</div>
  			</div>
			<br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="LOG IN"></div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="window.location.href ='/signup.do';">Sign up</button>
        <!--<a href='/signup.do'>Sign up</a></div>-->
      </div>
    </div>
  </div>
</div>