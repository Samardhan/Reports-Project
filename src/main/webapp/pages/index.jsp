<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 align="center">Reports</h2>

	<form:form action="search"  modelAttribute="search"  method="post">
		<table>
			<tr>
				<td>Plan Name: </td>
				<td>
					<form:select path="planName">
						<form:option value="">select</form:option>
						<form:options items="${names}"/>
						
					</form:select>
				</td>
				<td>Plan Status: </td>
				<td>
					<form:select path="planStatus">
						<form:option value="">select</form:option>
						<form:options items="${status}"/>
					</form:select>
				</td>
				<td>Gender: </td>
				<td>
					<form:select path="Gender">
						<form:option value="">select</form:option>
						<form:options items="${gender}"/>
					</form:select>
				</td>
				</tr>
				
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date" /></td>
					
					<td>End Date:</td>
					<td><form:input path="endDate" type="date"/></td>
				</tr>
				</table>
				<tr>
					<form:button class="btn btn-secondary">Reset</form:button>
					<form:button class="btn btn-primary">Search</form:button>
				</tr>
			
		
	
	</form:form>
	<hr>
	
	<table class="table table-striped table-hover" >
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Gender</th>
					<th>PlanName</th>
					<th>PlanStatus</th>
					<th>StartDate</th>
					<th>EndDate</th>
					<th>BenifitAmt</th>
					<th>DeniedReason</th>
					<th>TerminatedDate</th>
					<th>TerminatedReason</th>
				</tr>				
			</thead>
			
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="in"> 
				<tr>
				<!-- <td>${plan.personId}</td> -->
					<td>${in.count}</td>
					<td>${plan.personName}</td>
					<td>${plan.gender}</td>
					<td>${plan.planName}</td>
					<td>${plan.planStatus}</td>
					<td>${plan.startDate}</td>
					<td>${plan.endDate}</td>
					<td>${plan.benifitAmt}</td>
					<td>${plan.deniedReason}</td>
					<td>${plan.terminatedDate}</td>
					<td>${plan.terminatedReason}</td>
					
				</tr>
				</c:forEach>
			</tbody>
	
	</table>
	
	
	<hr>
	Export : <a href="">PDF</a> <a href="">EXCEL</a>

</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>