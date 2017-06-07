var current_customer_id = "";
var picker = "";

$(document).ready(function(){
	$('#settingsModal').modal();
	$('#customerDetailsModal').modal();
	$('#newCustomerModal').modal({
		complete: function() { cancelUpdate(); } 
	});
	$('select').material_select();
	
	var date = new Date();
	date.setYear(date.getYear()-25);	
	var dp = $('#petDOBinput').pickadate({
		selectYears: true,
		selectMonths: true,
		min: date,
		max: true,
		format: 'mmm d, yyyy',
	});
	picker = dp.pickadate("picker");
	
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


function openSettings(customer_id){	
	$('#settingsModal').modal('open');
	current_customer_id = customer_id;
}

function viewCustomer(){
	request = $.ajax({
		url : "/customer/findcustomer",
		data : {"id" : current_customer_id},
		type : "get",
		success: function(data){
			populateDetails(data);			
			$('#settingsModal').modal('close');
			$('#customerDetailsModal').modal('open');
		}
	});
}

function populateForm(customer){
	for (var key in customer) {
		$('#' + key).val(customer[key]);
	}
	
	picker.set('select', customer.petDOB);
	
	$('select').material_select('destroy');
	$('#service option[value="' + customer.service + '"]').prop('selected', true);
	$('select').material_select();
	Materialize.updateTextFields();
}


function populateDetails(c){
	var d = $('#detailsPane');
	d.empty();
	
	var arr = {"Name": (c.firstName + " " + c.lastName),
			"Email" : c.email,
			"Phone Number" : c.phone,
			"Address" : (c.addressOne + " " + c.addressTwo),
			"City/State" : (c.city + ", " + c.state + " " + c.zip),
			"Other Notes" : c.notes};
	
	for (var key in arr) {
		d.append('<li class="collection-item"><div class="row">'+
      '<div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i> ' + key + '</div>'+
      '<div class="col s7 grey-text text-darken-4 right-align">' + arr[key] + '</div>'+
	 '</div></li>');
	}	
}



/*---------------------------
----BOTTOM MODAL ACTIONS-----
---------------------------*/
function deactivateCustomer(){
	location.href="/customer/deactivatecustomer?id=" + current_customer_id;
}

function cancelUpdate(){
	location.href="/customer/getcustomers";
}

function customerGraduated(){
	location.href="/customer/customergraduated?id=" + current_customer_id;
}

function downloadBarcode(customer_id){
	location.href="/customer/downloadbarcode?id=" + current_customer_id;
}

function editCustomer(){
	request = $.ajax({
		url : "/customer/findcustomer",
		data : {"id" : current_customer_id},
		type : "get",
		success: function(data){
			$('#updateCancelButton').removeClass('hide');
			$('#saveOrUpdateButton').val('Update');
			$('#id').val(current_customer_id);
			populateForm(data);			
			$('#settingsModal').modal('close');
			$('#newCustomerModal').modal('open');
		}
	});
}