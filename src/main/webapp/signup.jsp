<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sign up</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/signup-css.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		function regSender() {
      var regForm   = $('#regform').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/signup.do"></c:url>',
                data: regForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                    if (obj.status) {
                       window.location.href = '<c:url value="/'+obj.message+'.jsp"></c:url>';                     
                    } else {
                        alert(obj.message);
                    }
                }
            });
}
</script>
<script>
    function send() {
      var loginForm   = $('#form').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/login.do"></c:url>',
                data: loginForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                    if (obj.status) {
                        window.location.href = '/'+obj.message+'.do';                  
                    } else {
                        alert(obj.message);
                    }
                }
            });
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="signin.jsp"/>
<div class="container-block">
  <div class="block">
  	<form class="form-horizontal" action="javascript:void(null);" method="post" modelAttribute="regForm" id="regform" name="test" onsubmit="regSender()">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="form-group row">
      <label for="inputSurname" class="col-sm-2 col-form-label">Surname</label>
          <div class="col-sm-10">
           <input name="surname" type="text" id="surname" placeholder="" class="input-xlarge">
         </div>
    </div>
 <div class="form-group row">
      <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>    
          <div class="col-sm-10">
           <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
           <p class="help-block">Please provide your E-mail</p>
         </div>
      </div>
<div class="form-group row">
      <label for="inputLogin" class="col-sm-2 col-form-label">Login</label> 
           <div class="col-sm-10">
          <input name="login" type="text" id="login" placeholder="" class="input-xlarge">
        </div>
      </div>  
 <div class="form-group row">
      <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
           <div class="col-sm-10">
           <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
           <!--<p class="help-block">Password should be at least 4 characters</p>-->
         </div>
      </div>
 <div class="form-group row">
      <label for="inputPassword" class="col-sm-2 col-form-label">Password(Corfirm)</label>
           <div class="col-sm-10">
        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
      </div>
    <div class="control-group">
      <div class="controls">
        <br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="SIGN UP"></div>
      </div>
    </div>
  </fieldset>
</form>
  </div>
</div>
</body>
</html>