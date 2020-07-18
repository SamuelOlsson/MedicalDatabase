<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Database</title>
</head>
<body>
    <h1>Insert The Patient Data</h1>
		<section id="content">
			<div class="container">
				<div class="row">
					<div class="span6">
						<h3 class="text-center">${msg}</h3>
						<form:form action="${action}" modelAttribute="patient" method="post"
							class="form-horizontal">
							<h3 class="text-center">
								<span class="text-success"> ${success}</span> <span
									class="text-error text-center">${error}</span>
							</h3>
							<div class="control-group">
								<label class="control-label" for="fname">First Name*</label>
								<div class="controls">
									<form:input path="fname" placeholder="First Name" />
									<div class="has-error">
										<form:errors path="fname" class="text-error" />
									</div>
								</div>

							</div>
							<div class="control-group">
								<label class="control-label" for="lname">Last Name*</label>
								<div class="controls">
									<form:input path="lname" placeholder="Last Name" />
									<div class="has-error">
										<form:errors path="lname" class="text-error" />
									</div>
								</div>

							</div>
							<div class="control-group">
								<label class="control-label" for="docEmail">Physician's Email*</label>
								<div class="controls">
									<form:input path="docEmail" placeholder="Physician's Email" />
									<div class="has-error">
										<form:errors path="docEmail" class="text-error" />
									</div>
								</div>

							</div>
							<div class="control-group">
								<label class="control-label" for="o2Level">02 Saturation Level*</label>
								<div class="controls">
									<form:input path="o2Level" placeholder="02 Saturation Level" />
									<div class="has-error">
										<form:errors path="o2Level" class="text-error" />
									</div>
								</div>

							</div>
								<div class="control-group">
								<label class="control-label" for="heartbeat">Heartbeat*</label>
								<div class="controls">
									<form:input path="heartbeat" placeholder="Heartbeat" />
									<div class="has-error">
										<form:errors path="heartbeat" class="text-error" />
									</div>
								</div>

							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" id="submit" class="btn btn-danger">Submit</button>
									<a href="login" class="btn btn-success">Cancel</a>

								</div>

							</div>
						</form:form>


					</div>
</body>
</html>