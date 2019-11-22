<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:url value="/css/site.css" var="cssHref" />
<link rel="stylesheet" href="${ cssHref }"/> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>National Parks</title>
<meta charset="ISO-8859-1">




	<img
				src="<c:url value="/img/logo.png"/>"
				class="img-fluid" alt="Responsive image"/>



</head>
<body>

  
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">National Parks</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
      <c:url var="home" value="/" />
        <a class="nav-link"  href="${home}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      <c:url var="survPage" value="surveyPage" />
        <a class="nav-link"  href="${survPage}">Survey</a>
      </li>
      <li class="nav-item">
      <c:url var="favPage" value="favoritePage" />
        <a class="nav-link"  href="${favPage}">Top Parks</a>
      </li>
    </ul>
  </div>
</nav>
  
 