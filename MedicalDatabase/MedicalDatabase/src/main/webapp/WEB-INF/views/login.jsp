<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
</head>
<body>
    <h1>Login to your Account</h1>
    
    	<div id="mySignin" class="modal styled hide fade" tabindex="-1"
					role="dialog" aria-labelledby="mySigninModalLabel"
					aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 id="mySigninModalLabel">
							Input Employee Data Below
						</h4>
					</div>
					<div class="modal-body">
						<form action="login" method="post" class="form-horizontal">
							<div class="control-group">
								<label class="control-label" for="email">Username</label>
								<div class="controls">
									<input type="text" id="email" name="email"
										placeholder="Username">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Password</label>
								<div class="controls">
									<input type="password" id="password" name="password"
										placeholder="Password">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn">Sign in</button>
									
								</div>
								<p class="aligncenter margintop20">
									Forgot password? <a href="#myReset" data-dismiss="modal"
										aria-hidden="true" data-toggle="modal">Reset</a>
								</p>
							</div>
						</form>
					</div>
				</div>
    					
</body>
</html>