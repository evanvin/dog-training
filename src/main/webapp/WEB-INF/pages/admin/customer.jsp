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
								<td class="valign-wrapper"><i onclick="openSettings('${customer.id}');" class="clickable material-icons">settings</i>&nbsp;${customer.firstName}&nbsp;${customer.lastName}</td>
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

	<div id="newCustomerModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>New Customer</h4>
			<div class="row">
				<div class="row"><br/></div>
				
				<form:form action="/customer/saveorupdate" modelAttribute="customerForm"
					method="POST" class="col s12">
					<form:hidden path="id"/>
					<div class="row">
						<div class="col s12">
							<h5>Owner Information</h5>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s3">
							<i class="material-icons prefix">face</i>
							<form:input path="firstName" />
							<form:label path="firstName">First Name</form:label>
						</div>
						<div class="input-field col s3">
							<form:input path="lastName" />
							<form:label path="lastName">Last Name</form:label>
						</div>
						<div class="input-field col s3">
							<i class="tiny material-icons prefix">email</i>
							<form:input path="email" />
							<form:label path="email">Email Address</form:label>
						</div>
						<div class="input-field col s3">
							<i class="material-icons prefix">phone</i>
							<form:input path="phone" />
							<form:label path="phone">Phone Number</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s8">
							<i class="material-icons prefix">home</i>
							<form:input path="addressOne" />
							<form:label path="addressOne">Address Line 1</form:label>
						</div>
						<div class="input-field col s4">
							<form:input path="addressTwo" />
							<form:label path="addressTwo">Address Line 2</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s4">
							<i class="material-icons prefix">location_city</i>
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
					
					<div class="row"><br/></div>
					
					<div class="row">
						<div class="col s12">
							<h5>Pet Information</h5>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s4">
							<i class="material-icons prefix">pets</i>
							<form:input path="petName" />
							<form:label path="petName">Pet Name</form:label>
						</div>
						<div class="input-field col s4">
							<i class="material-icons prefix">date_range</i>
							<input type="date" id="petDOBinput" class="datepicker" /> <label
								for="petDOBinput">Pet Date of Birth</:label> <form:hidden
									path="petDOB" />
						</div>
						<div class="input-field col s4">
							<i class="material-icons prefix">shopping_cart</i>
							<form:select path="service">
								<form:option value="" disabled="true" selected="selected">Choose a Service</form:option>
							    <form:options items="${services}" />
							</form:select>
							<form:label path="service">Service</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">description</i>
							<form:input path="petDesc" />
							<form:label path="petDesc">Pet Description</form:label>
						</div>
					</div>
					
					<div class="row"><br/></div>
					
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">note_add</i>
							<form:input path="notes" />
							<form:label path="notes">Other Notes</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="submit" id="saveOrUpdateButton"
								class="right waves-effect waves-light btn btn-large cyan lighten-1"
								value="Save Customer" />
							<button type="button" id="updateCancelButton" onclick="cancelUpdate();"
								class="right hide waves-effect waves-light btn btn-large red lighten-1">Cancel</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	
	<div id="settingsModal" class="modal bottom-sheet">
    <div class="modal-content center-align">
    	<div class="row">
    		<div class="col s4">
    			<i onclick="" class="clickable large material-icons">clear</i>
    			<h4>Remove</h4>
    		</div>
    		<div class="col s4">
    			<i onclick="" class="clickable large material-icons">school</i>
    			<h4>Graduate</h4>
    		</div>
    		<div class="col s4">
    			<i onclick="editCustomer();" class="clickable large material-icons">create</i>
    			<h4>Edit</h4>
    		</div>
    	</div>
    </div>
  </div>


</div>


<script type="text/javascript" src="/js/pages/customer.js"></script> </main>

<%@ include file="/WEB-INF/pages/common/footer.jsp"%>