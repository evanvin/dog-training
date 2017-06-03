<%@ include file="/WEB-INF/pages/common/header.jsp"%>
<%@ include file="/WEB-INF/pages/common/nav.jsp"%>

<main>
<div class="container">
	<div class="row">
		<input type="hidden" id="userName" value="${usersName}" />
	</div>
	<div class="row">
		<div class="col s6 offset-s3">
			<div class="card">
				<div class="card-content">
					<span class="card-title">New Customer</span>
					<div class="row">
						<form:form action="/customer/save" modelAttribute="customerForm"
								method="POST" class="col s12">
							<div class="row">
								<div class="input-field col s4">
									<form:input path="firstName" class="validate ${firstNameErrorClass}" />
									<form:label path="firstName">First Name</form:label>
								</div>
								<div class="input-field col s4">
									<form:input path="lastName" class="validate ${lastNameErrorClass}" />
									<form:label path="lastName">Last Name</form:label>
								</div>
								<div class="input-field col s4">
									<form:input path="petName" class="validate ${petNameErrorClass}" />
									<form:label path="petName">Pet Name</form:label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s4">
									<form:input path="email" class="validate ${emailErrorClass}" />
									<form:label path="email">Email Address</form:label>
								</div>
								<div class="input-field col s4">
									<form:input path="phone" class="validate ${phoneErrorClass}" />
									<form:label path="phone">Phone Number</form:label>
								</div>
							</div>
							<div class="row"></div>
							<div class="row">
								<div class="input-field col s6">
									<form:input path="addressOne" class="validate ${addressOneErrorClass}" />
									<form:label path="addressOne">Address Line 1</form:label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s6">
									<form:input path="addressTwo" class="validate ${addressTwoErrorClass}" />
									<form:label path="addressTwo">Address Line 2</form:label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s4">
									<form:input path="city" class="validate ${cityErrorClass}" />
									<form:label path="city">City</form:label>
								</div>
								<div class="input-field col s4">
									<form:input path="state" class="validate ${stateErrorClass}" />
									<form:label path="state">State</form:label>
								</div>
								<div class="input-field col s4">
									<form:input path="zip" class="validate ${zipErrorClass}" />
									<form:label path="zip">Zip Code</form:label>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<input type="submit"
											class="right waves-effect waves-light btn btn-large cyan lighten-1"
											value="Save Customer" />
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript" src="/js/pages/index.js"></script>
</main>

<%@ include file="/WEB-INF/pages/common/footer.jsp"%>