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
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-block">
  <div class="block">
  	<div class="row">
  		<div class="col-6">
  			<div id="legend">
     			 <legend class="welcome">Welcome, ${login.get(0).getSurname()}</legend>
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
       <table id="casttable" border="1" cellpadding="10px">
<tr class="headers">
	<td>N</td>
    <td>id</td>
    <td>Name</td>
    <td>Feature</td>
    <td>Price, &euro;</td>
    <td>Quantity</td>
      <td></td>
</tr>
<c:forEach var="cart" items="${Cart.getItems()}" varStatus="status">
    <tr>
    	<td>${status.index+1}</td>
    	<td>${cart.getItem().getId()}</td>
  		<td>${cart.getItem().getName()}</td>
  		<td>${cart.getItem().getFeature()}</td>
  		<td>${cart.getTotalprice()}</td>
  		<!--<td><input size="2" id="quen" value="${cart.getCount()}" type="number" onchange="<c:url value="/ChangeQuentity?nomer=${status.index}&quentity=${cart.getCount()}"/>">.</td>-->
  		<td><a id="deleteitem" href="<c:url value="/remove_from_cart.do?position=${status.index}"/>"></a></td>
    </tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
  </div>
</div>
</body>
</html>