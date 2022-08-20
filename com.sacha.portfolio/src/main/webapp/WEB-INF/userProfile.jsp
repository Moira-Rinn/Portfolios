<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<t:nav/>
	<t:sidebarLeft/>
	<t:sidebarRight/>
	<t:footer/>
		<div class="container">
			<h2><c:out value="${user.userName}"/>'s Profile</h2>
			<c:if test="${userId != user.id}">
			<form:form class="container2" action="/books/user/addContact/${user.id}" method="POST" modelAttribute="newContact">
				<form:input type="hidden" value="${userId}" path="connected"/>
				<form:input type="hidden" value="${user.id}" path="connectedUsers"/>
				<form:input type="hidden" value="${user.userName}" path="contactName"/>
				<input class="btn" type="submit" value="Connect"/>
			</form:form>
			</c:if>
			<h3>Contact:</h3>
			<p>${user.email}</p>
			<h3>Books ${user.userName} has added:</h3>
			<ul>
				<c:forEach items="${user.books}" var="book">
					<li><a href="/books/details/${book.id}">${book.title}</a></li>
				</c:forEach>
			</ul>
			<c:out value="${user.id}"/>
			<a class="btn" href="/books/user/${user.id}/contacts/">Contacts</a>
		</div>
</t:html>