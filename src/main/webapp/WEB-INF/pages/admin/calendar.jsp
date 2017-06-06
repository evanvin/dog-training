<%@ include file="/WEB-INF/pages/common/header.jsp"%>
<%@ include file="/WEB-INF/pages/common/nav.jsp"%>

<main>
<div class="container">
	<div class="row"></div>

	<div class="row">
		<div class="col s12">
		
			<c:forEach items="${trainingSessions}" var="session">
				<div class="row">
					<div class="col s12">
						<ul class="collapsible" data-collapsible="accordion">
						    <li>
						      <div class="collapsible-header"><i class="material-icons">pets</i> ${session.sessionTime}</div>
						      <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
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
							<i class="material-icons prefix">schedule</i> <input
								type="time" id="timeInput" class="timepicker" /> <label
								for="timeInput">Time</label> 
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
		<a href="#newSessionModal" class="btn-floating btn-large red"> <i class="material-icons">add</i>
		</a>
	</div>


</div>


<script type="text/javascript" src="/js/pages/calendar.js"></script> </main>

<%@ include file="/WEB-INF/pages/common/footer.jsp"%>