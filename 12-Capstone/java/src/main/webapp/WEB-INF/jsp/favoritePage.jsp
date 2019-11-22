<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<br>
<h3 align="center" >Top Parks Ranked</h3>
<br>

<c:set var="counter" value="1"/>

<div align="center" class="container">
<c:forEach items="${ npgeek }" var="park">
<c:url var="parkpagelink" value="parkPage?parkcode=${ park.parkCode.toUpperCase() }"  />
    <c:set var="parkcode" value="${park.parkCode }" />
  <div class="row">
    <div class="col">
<h4># <c:out value="${counter} "/><c:out value="${park.parkName}"/></h4>    
     
    </div>
  </div>
  <div class="row">
    <div class="col">
<a href="${parkpagelink }"><img  class="rounded" src="<c:url value="/img/parks/${park.parkCode}.jpg"/>" alt="parkPic"/> </a>  
     
    </div>
  </div>
<div class="row">
    <div class="col">
<p>Votes: <c:out value="${park.countOfSurveys}"/></p>
<br>
    </div>
  </div>
  <c:set var="counter" value="${counter+1}"/>
  <hr>
</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />