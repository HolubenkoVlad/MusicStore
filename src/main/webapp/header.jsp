<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
  <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
    <ul class="navbar-nav text-right">
      <li class="nav-item active">
        <a class="nav-link" href="/">Catalog<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
        <c:choose>
          <c:when test="${empty login}">
        <li class="nav-item"> <a data-toggle="modal" href="#exampleModalCenter" class="nav-link">Login</a></li> 
          </c:when>
          <c:otherwise>
        <li class="nav-item"> <a class="nav-link" href="/account.jsp">${login.get(0).getLogin()}</a></li>
          </c:otherwise>
        </c:choose>
    </ul>
  </div>
</nav>
</body>
</html>

