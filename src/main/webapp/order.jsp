<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Order</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table id="casttable" border="1" cellpadding="10px">
        <tr class="headers">
            <td>N</td>
            <td>id</td>
            <td>Name</td>
            <td>Price, &euro;</td>
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
      <p id="totalprice">Total price: ${Cart.getTotalPrice()} euro.</p>
        <form action="javascript:void(null);" method="post" id="form" name="test" onsubmit="send()">
        	<div class="form-group row">
    			<label for="inputLogin" class="col-sm-2 col-form-label">Address:</label>
    				<div class="col-sm-10">
     					 <input name="address" type="text" class="form-control">
   				    </div>
  			</div>
			<br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="ORDER"></div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
     </div>
    </div>
  </div>
</div>
</body>
</html>