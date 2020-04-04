<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse mx-auto" id="navbarSupportedContent">
    <ul class="navbar-nav  text-right">
      <li class="nav-item active">
        <a class="nav-link" href="#">Catalog<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <c:choose>
          <c:when test="${empty login}">
            <li> <a href="<c:url value="/login.do"/>">Login</a></li> 
          </c:when>
          <c:otherwise>
            <li> <a href="<c:url value="/privateroom.do"/>">${login.getLogin()}</a></li>
          </c:otherwise>
        </c:choose>
      </li>
    </ul>
  </div>
</nav>
</body>
</html>
