<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<t:nav/>
	<div class="container">
		<h2><c:out value="${user.fName}"/>'s Profile</h2>

		<h3>Contact:</h3>
		<p>${user.email}</p>
		<h3>${user.fName} ${user.lName}</h3>
	</div>
	<a class="btn" href="/creatorReg/${userId}">Register to be a creator!!!!!</a>
	<a class="btn" href="/">Home</a>
	<t:footer/>
</t:html>