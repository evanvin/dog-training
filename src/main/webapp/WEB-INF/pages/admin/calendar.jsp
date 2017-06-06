<%@ include file="/WEB-INF/pages/common/header.jsp"%>
<%@ include file="/WEB-INF/pages/common/nav.jsp"%>

<main>
<div class="container">
	<div class="row"></div>

	<div class="row">
		<div class="col s12">
			<jsp:useBean id="now" class="java.util.Date" />
			<c:forEach items="${trainingSessions}" var="session">
				<div class="row">
					<div class="col s12">
						<ul class="collapsible" data-collapsible="accordion">
							<c:set var="isOld" value="${session.sessionTime lt now}" />
							<li>
								<div
									class="collapsible-header <c:if test="${isOld}">red lighten-4</c:if> ">
									<span><i class="material-icons">pets</i> <c:if
											test="${isOld}"> This sessions attendance needs to be updated</c:if></span> <span
										class="right"><fmt:formatDate
											pattern="EEEE, MMM d @ h:mm a" value="${session.sessionTime}" />
									</span>
								</div>
								<div
									class="collapsible-body <c:if test="${isOld}">red lighten-5</c:if> <c:if test="${not isOld}">grey lighten-4</c:if> ">
									<div class="row">
										<div class="col s4">
											<ul class="collection with-header">
												<li class="collection-header"><h5>In Attendance</h5></li>
												<c:forEach items="${session.customers}" var="customer">
													<c:if test="${isOld}">
														<li class="collection-item"><input type="checkbox"
															id="${customer.id}" /> <label for="${customer.id}">${customer.petName}&nbsp;(${customer.firstName}&nbsp;${customer.lastName})</label>
														</li>
													</c:if>
													<c:if test="${not isOld}">
														<li class="collection-item">
															${customer.petName}&nbsp;(${customer.firstName}&nbsp;${customer.lastName})
														</li>
													</c:if>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>




	<div id="newSessionModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>New Training Session</h4>
			<div class="row">
				<div class="row">
					<br />
				</div>

				<form:form action="/calendar/savesession"
					modelAttribute="sessionForm" method="POST" class="col s12">
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">pets</i>
							<form:hidden path="customerIds" />
							<div id="customerChips" class="chips"></div>
						</div>
					</div>

					<div class="row">
						<br />
					</div>

					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">note_add</i>
							<form:input path="notes" />
							<form:label path="notes">Notes</form:label>
						</div>
					</div>

					<div class="row">
						<br />
					</div>

					<div class="row">
						<form:hidden path="sessionTime" />
						<div class="input-field col s4">
							<i class="material-icons prefix">date_range</i> <input
								type="date" id="dateInput" class="datepicker" /> <label
								for="dateInput">Date</label>
						</div>

						<div class="input-field col s4">
							<i class="material-icons prefix">schedule</i> <input type="time"
								id="timeInput" class="timepicker" /> <label for="timeInput">Time</label>
						</div>

						<div class="input-field col s4">
							<input type="submit"
								class="right waves-effect waves-light btn btn-large cyan lighten-1"
								value="Save Training Session" />
						</div>
					</div>


				</form:form>
			</div>
		</div>
	</div>

	<div class="fixed-action-btn" style="bottom: 100px; right: 24px;">
		<a href="#newSessionModal" class="btn-floating btn-large red"> <i
			class="material-icons">add</i>
		</a>
	</div>


</div>


<script type="text/javascript" src="/js/pages/calendar.js"></script> </main>

<%@ include file="/WEB-INF/pages/common/footer.jsp"%>