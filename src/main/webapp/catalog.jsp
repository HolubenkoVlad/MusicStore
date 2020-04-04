<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Catalog</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/catalog-css.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<ul id="catalogblock">
<c:forEach var="item" items="${product}">
<li id="list">
<div class="photoblock">
<img src="img/${item.getPhoto()}" width=30% height="196"/>
</div>
<p class="titleblock">${item.getName()}</p>
<c:choose>
      <c:when test="${empty login}">
        <a class="buttoncart" href="<c:url value="/login.do"/>"></a>
      </c:when>
      <c:otherwise>
        <a class="buttoncart" onclick="addToCart(${item.getId()})"></a>
      </c:otherwise>
</c:choose>
<p class="priceblock"><strong>${item.getPrice()} &euro;</strong> </p>
<p class="featureblock">${item.toString()}</p>
</li>
</c:forEach>
</ul>
</body>
</html>