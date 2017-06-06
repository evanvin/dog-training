var chips = null;
var customerChipMap = [];
var timeSelected = 0;
var dateSelected = new Date().getTime();


$(document).ready(function(){
	$('#newSessionModal').modal();
	$('.collapsible').collapsible();
	
	updateTime();
	var datepicker = $('#dateInput').pickadate({
		selectYears: true,
		selectMonths: true,
		min: new Date(),
		max: false,
		format: 'mmm d, yyyy',
		onSet: function(context){
			dateSelected = context.select;
			updateTime();
		}
	});
	var clockpicker = $('#timeInput').pickatime({
	    default: 'now',
	    twelvehour: true,
	    donetext: 'Done',
	    autoclose: true,
	    vibrate: true,
	    afterDone: function(e, t){
	    	timeSelected = timeToMilliseconds(t);
	    	updateTime();
	    }
	});
	
	
	request = $.ajax({
		url : "/calendar/getcustomersforchips",
		type : "get",
		success: function(data){
			var chipData = formatChipData(data);
			chips = $('#customerChips').material_chip({
				autocompleteOptions: {
					data: chipData,
					limit: Infinity,
				},
				placeholder: 'Enter a pet or owners name',
				secondaryPlaceholder: '+Pet'
			});
		}
	});	
	
});




$('#customerChips').on('chip.add', function(e, chip){
	if(!isPresent(customerChipMap, chip["tag"])){
		$('.chip').last().remove();
		$('#customerChips').material_chip('data').splice(-1,1);
	}
	updateCustomerList();
});

function updateTime(){
	$('#sessionTime').val(new Date(timeSelected+dateSelected));
}

function updateCustomerList(){
	$('#customerIds').val($('#customerChips').material_chip('data').map(function(a) {return getCustomerId(a.tag);}));
}

function timeToMilliseconds(time){
	var hours = parseInt(time.substr(0, 2));
    if(time.indexOf('AM') != -1 && hours == 12) {
        time = time.replace('12', '0');
    }
    if(time.indexOf('PM')  != -1 && hours < 12) {
        time = time.replace(hours, (hours + 12));
    }
    
    var x = time.replace(/(AM|PM)/, '').split(":");
    var res = (parseInt(x[0])*3600000) + (parseInt(x[1])*60000);
    
    return res;
}

function getCustomerId(value){
	var result = customerChipMap.filter(function( obj ) {
	  return obj.tag == value;
	});
	return result[0].id;
}

function isPresent(arr, tag){
	return $.map(arr, function(val) {
		return val.tag == tag ? 1 : null;
	}).length > 0;
}

function formatChipData(customers){
	var arr = {};
	for(let i = 0; i < customers.length; i++){
		arr[(customers[i].petName + " (" + customers[i].firstName + " " + customers[i].lastName + ")")] = null;
		customerChipMap.push({
			tag : (customers[i].petName + " (" + customers[i].firstName + " " + customers[i].lastName + ")"),
			id : customers[i].id
		})
	}
	return arr;
}