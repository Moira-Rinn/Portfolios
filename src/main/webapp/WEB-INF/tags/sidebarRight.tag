<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="sidebar sidebarRight lBorder">

<h3>Recently Viewed</h3>
<ul>
	<%--> <c:forEach items="" var="">--%>
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
	<%--> </c:forEach>--%>
</ul>
<%--> 
Recent:
	list...
	
	ToDo: Need to store the book title and Id in session for the first ten books, then remove the oldest for each additional book added.
	if (list.size < 11)
	Session.addAttribute...
	else
	Session.removeAttribute(list[0])..
	Session.addAttribute... 
--%>
	


</nav>