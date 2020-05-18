<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Account</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/account-css.css">
<script>
	function send() {
      var orderForm   = $('#form').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/add_order.do"></c:url>',
                data: orderForm,
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
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="order.jsp"/>
<div class="container-block">
  <div class="block" class="align-self-stretch">
  	<div class="row">
  		<div class="col-6">
  			<div id="legend">
     			 <legend class="welcome">Welcome, ${login.getSurname()}</legend>
            </div>
  		</div>
  		<div class="col">
 <form action='<c:url value="/logout.do"/>' method="post"><input id="logout" class="btn btn-primary" type="submit" value="Exit"></form>
  		</div>
  	</div>
  	
    <c:choose>
    <c:when test="${Cart.getCount() eq 0 || empty Cart}">
       <h3 id="emptycart">Cart is empty</h3>
     </c:when>
    <c:otherwise>
    <h3 id="casth">Cart</h3>
    <div class="w-100 p-3" class="text-center">
    	 <table id="productsTable" class="table" border="1" cellpadding="10px">
       	<thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Feature</th>
       <th scope="col">Price, &euro;</th>
       <th scope="col">Quantity</th>
       <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="cart" items="${Cart.getItems()}" varStatus="status">
  	<tr>
  		<th scope="row">${status.index+1}</th>
      <td>${cart.getProduct().getId()}</td>
      <td>${cart.getProduct().getName()}</td>
      <td>${cart.getProduct().toString()}</td>
      <td>${cart.getTotalprice()}</td>
  		<td>${cart.getCount()}</td>
  		<td><a href="<c:url value="/remove_from_cart.do?position=${status.index}"/>">X</a></td>
  	</tr>
  	</c:forEach>
  </tbody>
</table>
    </div>
<div id="totalPrice"><p class="float-right"><strong>Total price: ${Cart.getTotalPrice()} euro.</strong></p></div>
<div class="col text-center"><div id="orderButton"><button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModalCenter">&nbsp;&nbsp;&nbsp;Order&nbsp;&nbsp;&nbsp;</button></div></div>
<div id="eraseCart"><a class="float-right" href="<c:url value="/erase_cart.do"/>"><strong>Erase cart</strong></a></div>
</c:otherwise>
</c:choose>
  </div>
</div>
</body>
</html>