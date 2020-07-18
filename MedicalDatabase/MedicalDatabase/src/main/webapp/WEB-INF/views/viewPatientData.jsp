<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Database</title>
</head>
<body>
    <h1>Search for Patients</h1>
    
    	<div id="mySignin" class="modal styled hide fade" tabindex="-1"
					role="dialog" aria-labelledby="mySearchModalLabel"
					aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 id="mySearchModalLabel">
							Input Patient Data Below
						</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" method="POST" action="viewPatientDataSucess">
							<div class="control-group">
								<label class="control-label" for="lname">Last Name</label>
								<div class="controls">
									<input type="text" id="lname" name="lname"
										placeholder="Last Name">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn">Search</button>
									
								</div>
								<p class="aligncenter margintop20">
									Cancel <a href="patientDatabase" data-dismiss="modal"
										aria-hidden="true" data-toggle="modal">Reset</a>
								</p>
							</div>
						</form>
					</div>
				</div>
    					
</body>
</html>