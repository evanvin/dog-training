<%@ include file="/WEB-INF/pages/common/header.jsp"%>
<%@ include file="/WEB-INF/pages/common/nav.jsp"%>

<main>
<div class="container">
	<div class="row">
		
	</div>

	<div class="row">
		<div id="admin" class="col s12">
			<div class="card material-table">
				<div class="table-header">
					<span class="table-title">Customers</span>
					<div class="actions">
						<a href="#newCustomerModal"
							class="modal-trigger waves-effect btn-flat nopadding"><i
							class="material-icons">person_add</i></a>
						<button type="button"
							class="search-toggle waves-effect btn-flat nopadding">
							<i class="material-icons">search</i>
						</button>
					</div>
				</div>
				<table id="datatable">
					<thead>
						<tr>
							<th>Name</th>
							<th>Pets Name</th>
							<th>Pet Description</th>
							<th>Pet DOB</th>
							<th>Owners Phone #</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td>${customer.firstName}&nbsp;${customer.lastName}</td>
								<td>${customer.petName}</td>
								<td>${customer.petDesc}</td>
								<td>${customer.petDOB}</td>
								<td>${customer.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="newCustomerModal" class="modal">
		<div class="modal-content">
			<h4>New Customer</h4>
			<div class="row">
				<form:form action="/customer/save" modelAttribute="customerForm"
					method="POST" class="col s12">
					<div class="row">
						<div class="input-field col s6">
							<form:input path="firstName" />
							<form:label path="firstName">First Name</form:label>
						</div>
						<div class="input-field col s6">
							<form:input path="lastName" />
							<form:label path="lastName">Last Name</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<form:input path="petName" />
							<form:label path="petName">Pet Name</form:label>
						</div>
						<div class="input-field col s6">
							<input type="date" id="petDOBinput" class="datepicker" /> <label
								for="petDOBinput">Pet Date of Birth</:label> <form:hidden
									path="petDOB" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="petDesc" />
							<form:label path="petDesc">Pet Description</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s4">
							<form:input path="email" />
							<form:label path="email">Email Address</form:label>
						</div>
						<div class="input-field col s4">
							<form:input path="phone" />
							<form:label path="phone">Phone Number</form:label>
						</div>
					</div>
					<div class="row"></div>
					<div class="row">
						<div class="input-field col s6">
							<form:input path="addressOne" />
							<form:label path="addressOne">Address Line 1</form:label>
						</div>
						<div class="input-field col s6">
							<form:input path="addressTwo" />
							<form:label path="addressTwo">Address Line 2</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s4">
							<form:input path="city" />
							<form:label path="city">City</form:label>
						</div>
						<div class="input-field col s4">
							<form:input path="state" />
							<form:label path="state">State</form:label>
						</div>
						<div class="input-field col s4">
							<form:input path="zip" />
							<form:label path="zip">Zip Code</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="notes" />
							<form:label path="notes">Other Notes</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="submit"
								class="right waves-effect waves-light btn btn-large cyan lighten-1"
								value="Save Customer" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</div>


<script type="text/javascript" src="/js/pages/customer.js"></script> </main>

<%@ include file="/WEB-INF/pages/common/footer.jsp"%>