<header>
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">one</a></li>
		<li><a href="#!">two</a></li>
		<li class="divider"></li>
		<li><a href="#!">three</a></li>
	</ul>
	<nav class="nav-style">
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Haywood Admin</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="/customer/getcustomers">Customers</a></li>
				<li><a href="badges.html">Calendar</a></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><img height="50"/></li>
				<li><a href="/customer/getcustomers">Customers</a></li>
				<li><a href="badges.html">Calendar</a></li>
			</ul>
		</div>
	</nav>
	
	<script>
		$(document).ready(function(){
			$(".button-collapse").sideNav();
		});
	</script>
</header>