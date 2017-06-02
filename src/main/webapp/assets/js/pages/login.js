$(document).ready(function(){
	Materialize.toast($('#loginError').val(), 4000, 'red lighten-2');
	Materialize.toast($('#usernameError').val(), 4000, 'red lighten-2');
	Materialize.toast($('#passwordError').val(), 4000, 'red lighten-2');
});