<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="survey">
	<form:form modelAttribute="survey" action="surveyPage" method="POST">

		<div class="container" >
			<div class="row">
				<div class="col-">
					<h3>Please fill out the following survey:</h3>
					<br>
				</div>
			</div>
			<div class="row">
				<div class="col-sm" >
				
			<form:label path="parkCode">Park Name:</form:label>
				
				</div>
				<div class="col-sm">
					<form:select path="parkCode">
						<option value="CVNP">Cuyahoga Valley National Park</option>
						<option value="ENP">Everglades National Park</option>
						<option value="GCNP">Grand Canyon National Park</option>
						<option value="GNP">Glacier National Park</option>
						<option value="GSMNP">Great Smoky Mountains National Park</option>
						<option value="GTNP">Grand Teton National Park</option>
						<option value="MRNP">Mount Rainier National Park</option>
						<option value="RMNP">Rocky Mountain National Park</option>
						<option value="TNP">Yellowstone National Park</option>
						<option value="YNP2">Yosemite National Park</option>
					</form:select>
				
				</div>

			</div>
			<div class="row">
				<div class="col-sm">
					<form:label path="emailAddress">Email Address:</form:label>
				</div>
				<div class="col-sm">
					<form:input type="text" path="emailAddress"
						placeholder="Email Address" />
					<form:errors path="emailAddress" class="error" />
				</div>

			</div>
			<div class="row">
				<div class="col-sm">
					<form:label path="stateId">State of Residency:</form:label>

				</div>
				<div class="col-sm">
					<form:select path="stateId">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</form:select>
				</div>

			</div>
			<div class="row">
				<div class="col-sm">
					<form:label path="activityLevel">Rate This Park:</form:label>

				</div>
				<div class="col-sm">
					<form:select path="activityLevel">
						<option value="5">Greatest Place Ever!</option>
						<option value="4">Pretty Good</option>
						<option value="3">Average</option>
						<option value="2">Kinda Sucks</option>
						<option value="1">God Forsaken Hell Hole!</option>
					</form:select>
				</div>

			</div>
			<div class="row">
				<div class="col-sm">
<br>
					<input type="submit" value="Submit" />


				</div>

			</div>
		</div>
	</form:form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />