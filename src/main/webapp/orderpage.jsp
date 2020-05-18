<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/orderpage-css.css" rel="stylesheet" type="text/css" />
<title>Invoice</title>
</head>
<body>
<div class="mainblock">
	<h3 id="caption">${orderNumbers}</h3>
<table class="tab" border="1px solid black" cellpadding="10px">
<tr class="headers">
	<td>N</td>
    <td>id</td>
    <td>Name</td>
    <td>Price, euro</td>
    <td>Quantity</td>
</tr>
<c:forEach var="cart" items="${Cart.getItems()}" varStatus="status">
    <tr>
      <td>${status.index+1}</td>
    	<td>${cart.getProduct().getId()}</td>
      <td>${cart.getProduct().getName()}</td>
      <td>${cart.getTotalprice()}</td>
      <td>${cart.getCount()}</td>
    </tr>
</c:forEach>
</table>
<p id="totalprice">Total price: ${Cart.getTotalPrice()} euro</p>
<div class="orderinfo">
      <p> Surname: ${login.getSurname()}</p>
       <p>	Address: ${orderob.get(0).getAddress()}</p>
</div>   
<a href="<c:url value="/"/>">Back to catalog</a>
</div>
</body>
</html>