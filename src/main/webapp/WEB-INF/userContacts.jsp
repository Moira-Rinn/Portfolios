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
	<div class="container">
		<h1><c:out value="${user.userName}"/>'s Contacts</h1>
		<ul>
			<c:forEach items="${contacts}" var="contact">
				
				<c:out value="${contact.id}"/>
				<c:if test="${contact.connectedUsers.id != user.id}">
					<li><a href="/books/${contact.connectedUsers.id}/profile">${contact.contactName}</a></li>
					<c:if test="${user.id == userId}">
						<form  action="/books/user/delete-contact/${contact.id}" method="POST">
						    <input type="hidden" name="_method" value="delete">
						    <input class="btn" type="submit" value="Delete">
						</form>
					</c:if>
				</c:if>
			</c:forEach>				
			<c:forEach items="${user.user}" var="connection">
				<c:out value="${connection.connectedUsers.userName}"/>
				<c:out value="${connection.connectedUsers.id}"/>
			</c:forEach>
		</ul>
	</div>

</t:html>

<%-- 				<c:choose>
					<c:when test="${user.id == userId}">

							<li><a href="/books/${contact.user.id}/profile">${contact.user.userName}</a></li>
							<form  action="/books/user/delete-contact/${contact.id}" method="POST">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn" type="submit" value="Delete">
							</form>

					</c:when>

							<li><a href="/books/${contact.user.id}/profile">${contact.user.userName}</a></li>

					</c:otherwise>
				</c:choose>
<c:otherwise>--%>	