$(document).ready(function(){
	$('.modal').modal();
	
	var date = new Date();
	date.setYear(date.getYear()-25);	
	$('#petDOBinput').pickadate({
		selectYears: true,
		selectMonths: true,
		min: date,
		max: true,
		format: 'mmm d, yyyy',
	});
	
	$('#petDOBinput').change(function(){
		$('#petDOB').val($('#petDOBinput').val());
	});
	
	$('#datatable').dataTable({
	    "oLanguage": {
	        "sStripClasses": "",
	        "sSearch": "",
	        "sSearchPlaceholder": "Enter Keywords Here",
	        "sInfo": "_START_ -_END_ of _TOTAL_",
	        "sLengthMenu": '<span>Rows per page:</span><select class="browser-default">' +
	          '<option value="10">10</option>' +
	          '<option value="20">20</option>' +
	          '<option value="30">30</option>' +
	          '<option value="40">40</option>' +
	          '<option value="50">50</option>' +
	          '<option value="-1">All</option>' +
	          '</select></div>'
	      }
	    });

});
