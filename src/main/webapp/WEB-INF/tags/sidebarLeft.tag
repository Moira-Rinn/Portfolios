<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="sidebar sidebarLeft rBorder">
	<h3 class="bBorder">${userName}'s Stuff</h3>
	<ul>
		<li><a href="#">Favorites</a></li>
		<li><a href="#">Want to Read</a></li>
		<li><a href="#">Friend's Favs</a></li>
	</ul>	
	<h3 class="bBorder">Book Clubs</h3>
	<ul>
		<%-- <c:forEach items="" var="">--%>
			<li><a href="#">Link # 1</a></li>
			<li><a href="#">Link # 2</a></li>
			<li><a href="#">Link # 3</a></li>
			<li><a href="#">Link # 4</a></li>
			<li><a href="#">Link # 5</a></li>
			<li><a href="#">Link # 6</a></li>
			<li><a href="#">Link # 7</a></li>
			<li><a href="#">Link # 8</a></li>
			<li><a href="#">Link # 9</a></li>
			<li><a href="#">Link # 10</a></li>
		<%-- </c:forEach>--%>
	</ul>

	<h3 class="bBorder">Genres</h3>
	<ul>
		<li><a href="#">Non-Fiction</a></li>
		<li><a href="#">Fiction</a></li>
		<li><a href="#">Sci-Fi</a></li>
		<li><a href="#">Fantasy</a></li>
		<li><a href="#">Horror</a></li>
		<li><a href="#">Suspense</a></li>
		<li><a href="#">Mystery</a></li>
		<li><a href="#">Biography</a></li>
		<li><a href="#">History</a></li>
		<li><a href="#">Self Help</a></li>
		<li><a href="#">Children</a></li>
		<li><a href="#">Young Adult</a></li>
	</ul>

</nav>