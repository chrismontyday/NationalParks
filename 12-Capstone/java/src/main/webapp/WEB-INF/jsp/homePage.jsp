<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<br>
<div class="container">
  <div class="row">
  
<c:forEach items="${ npgeek }" var="park">
    <div class="col">


  <div id="park">
  <br>
    <h4><c:out value="${park.parkName}"/></h4>
    
    <c:url var="parkpagelink" value="parkPage?parkcode=${ park.parkCode.toUpperCase() }"  />
    <c:set var="parkcode" value="${park.parkCode }" />
<a href="${parkpagelink }"><img class="rounded"  src="<c:url value="/img/parks/${park.parkCode}.jpg"/>" alt="parkPic"/></a>  
    <p><c:out value="${park.parkDescription}"/></p>
  </div>
    </div>
</c:forEach>
  </div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />