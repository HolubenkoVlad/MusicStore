<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Catalog</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="css/catalog-css.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
                        window.location.href = '<c:url value="/'+obj.message+'.jsp"></c:url>';                  
                    } else {
                        alert(obj.message);
                    }
                }
            });
}
	</script>
	<script>
		function addToCart(it_id, type_name){
			$.ajax({
            	type: "POST",
                url: '<c:url value="/add_to_cart.do"></c:url>',
                data: {
                    id:it_id,
                    type:type_name
                },
                success: function (msg){
                    alert("Product added to cart!");
                }
            });
}
	</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="signin.jsp"/>
<ul id="catalogblock">
<c:forEach var="item" items="${product}">
<li id="list">
<img src="img/${item.getPhoto()}" width=45% height="196" class="photoblock"/>
<h5 class="titleblock">${item.getName()}</h5>
<div class="row" id="marginTop">
	<div class="col-6">
      <p class="priceblock"><strong>${item.getPrice()} &euro;</strong> </p>
    </div>
    <div class="col">
      <c:choose>
      <c:when test="${empty login}">
        <button class="btn btn-primary"data-toggle="modal" data-target="#exampleModalCenter">Buy</button>
      </c:when>
      <c:otherwise>
        <button class="btn btn-primary" onclick="addToCart(${item.getId()},'${item.getInsType()}')">Buy</button>
      </c:otherwise>
</c:choose>
    </div>
</div>
<p class="featureblock">${item.toString()}</p>
</li>
</c:forEach>
</ul>
</body>
</html>