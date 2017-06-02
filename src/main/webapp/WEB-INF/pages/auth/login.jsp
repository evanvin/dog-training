<%@ include file="/WEB-INF/pages/common/header.jsp"%>

<main>
<br/><br/><br/><br/>
<div class="section">
	<center>
		<div class="row">
			<div class="col s4 offset-s4">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Login</span>
						<div class="row">
							<input type="hidden" id="loginError" value="${loginError}" />
							<input type="hidden" id="usernameError" value="${usernameError}" />
							<input type="hidden" id="passwordError" value="${passwordError}" />
							<form:form action="/auth/login" modelAttribute="loginForm"
								method="POST" class="col s12">
								<div class="row">
									<div class="input-field col s12">
										<form:input path="username"
											class="validate ${usernameErrorClass}" />
										<form:label path="username">Username</form:label>
									</div>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<form:password path="password"
											class="validate ${passwordErrorClass}" />
										<form:label path="password">Password</form:label>
									</div>
								</div>
								
								<div class="row">
									<div class="input-field col s12">
										<input type="submit"
											class="waves-effect waves-light btn btn-large cyan lighten-1"
											value="Log In" />
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</center>
</div>


<script type="text/javascript" src="/js/pages/login.js"></script>
</main>

</body>
</html>