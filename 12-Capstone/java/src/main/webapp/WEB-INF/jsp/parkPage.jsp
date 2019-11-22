<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:set value="${npgeek}" var="park" />

<div class="container">
	<div class="row">

		<div class="col">
			<br>
			<h2 align="center" margin-left="20px">
				<c:out value="${park.parkName}" />
			</h2>
			<br>
		</div>
		<div class="w-100"></div>

		<div align="center" class="col">
    <c:url var="parkpagelink" value="parkPage?parkcode=${ park.parkCode.toUpperCase() }"  />
 <c:set var="parkcode" value="${park.parkCode }" />
			<a href="${parkpagelink }"><img align="center" class="rounded"
				src="<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg"/>"
				class="img-fluid" alt="Responsive image" /></a> <br>


		</div>
		</div>
		<div class="row">

			<div align="center" class="col">

				<blockquote class="blockquote text-center">
  <p class="mb-0"><br><i>"<c:out value=" ${park.parkInspirationalQuote}" />"
						</i></p>
  <footer class="blockquote-footer"><cite title="Source Title">${park.parkInspirationalQuoteSource}</cite></footer>
</blockquote>

			</div>
		</div>
		<div class="w-100"></div>
			<div class="row">
		
		<div class="col">




			<table class="table table-striped">
				<thead>

				</thead>
				<tbody>
					<tr>
						<th scope="row">State</th>
						<td><c:out value="${park.parkState}" /></td>
					</tr>
					<tr>
						<th scope="row">Climate</th>
						<td><c:out value="${park.parkClimate}" /></td>
					</tr>
					<tr>
						<th scope="row">Park Acreage</th>
						<td><c:out value="${park.parkAcreage}" /></td>
					</tr>
					<tr>
						<th scope="row">Elevation (feet)</th>
						<td><c:out value="${park.parkElevation}" /></td>
					</tr>
					<tr>
						<th scope="row">Trail Distance (miles)</th>
						<td><c:out value="${park.parkTrailDistance}" /></td>
					</tr>
					<tr>
						<th scope="row">Founding Year</th>
						<td><c:out value="${park.parkYearFounded}" /></td>
					</tr>
					<tr>
						<th scope="row">Visitor Count</th>
						<td><c:out value="${park.parkVisitorCount}" /></td>
					</tr>
					<tr>
						<th scope="row">Number of Campsites</th>
						<td><c:out value="${park.numOfCampsites}" /></td>
					</tr>
					<tr>
						<th scope="row">Entry Fee</th>
						<td>$<c:out value="${park.entryFee}" /></td>
					</tr>
					<tr>
						<th scope="row">Number of Species</th>
						<td><c:out value="${park.numAnimalSpecies}" /></td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="col">

			<p>
				<c:out value="${park.parkDescription}" />
			</p>

		</div>
	</div>
</div>

<hr>

<div class="container">
	<div class="row">
		<div class="col">
			<h3>Weather Forecast</h3>
		</div>
	</div>

	<div class="row">
		<c:forEach items="${npgeek2}" var="weather">
			<div class="col">

				<img src="<c:url value="/img/weather/${weather.forecast}.png"/>"
					class="img-fluid" alt="Responsive image" /><br>

				<table class="table table-striped">

					<p></p>


					<thead>
						<tr>
							<th scope="col"> <c:out 
									value="${weather.dayOfTheWeek.toUpperCase()}" />									
									</th>

						</tr>
					</thead>
					<tbody>


						<c:choose>
							<c:when test="${sessionScope.type}">

								<tr>
									<th scope="row">Low</th>
									<td><c:out value="${weather.celsiusLowTemp}" />&#8451;</td>
								</tr>
								<tr>
									<th scope="row">High</th>
									<td><c:out value="${weather.celsiusHighTemp}" />&#8451;</td>
								</tr>

							</c:when>
							<c:otherwise>
								<tr>
									<th scope="row">Low</th>
									<td><c:out value="${weather.low}" />&#8457;</td>
								</tr>
								<tr>
									<th scope="row">High</th>
									<td><c:out value="${weather.high}" />&#8457;</td>
								</tr>
							</c:otherwise>
						</c:choose>
						
						<tr>
								
									<td colspan="2"><c:out value="${weather.weatherAdvice}" /></td>
								</tr>

					</tbody>
				</table>
			</div>
		</c:forEach>

	</div>
	<div class="row">
		<div class="col">
			<form action="parkPage" method="POST">
				<input type="radio" name="temp" value="${ false }"
					<c:out value="${ sessionScope.type ? '' : 'checked' }"/>>Fahrenheit
				<input type="radio" name="temp" value="${ true }"
					<c:out value="${ sessionScope.type ? 'checked' : '' }"/>>Celsius
				<input type="hidden" name="tempCode" value="${park.parkCode}">
				<input type="submit" value="Submit">
			</form>
		</div>

	</div>


</div>






<c:import url="/WEB-INF/jsp/common/footer.jsp" />