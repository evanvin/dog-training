<header>
	<nav class="nav-style">
		<div class="nav-wrapper">
			<a href="/home" class="brand-logo">Haywood Admin</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="/customer/getcustomers"><i class="material-icons left">people</i>Customers</a></li>
				<li><a href="/calendar/getcalendar"><i class="material-icons left">access_time</i>Calendar</a></li>
				<li><a href="/statistics/getstatistics"><i class="material-icons left">timeline</i>Statistics</a></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><img height="50"/></li>
				<li><a href="/customer/getcustomers"><i class="material-icons left">people</i>Customers</a></li>
				<li><a href="/calendar/getcalendar"><i class="material-icons left">access_time</i>Calendar</a></li>
				<li><a href="/statistics/getstatistics"><i class="material-icons left">timeline</i>Statistics</a></li>
			</ul>
		</div>
	</nav>
	
	<script>
		$(document).ready(function(){
			$(".button-collapse").sideNav();
		});
	</script>
</header>