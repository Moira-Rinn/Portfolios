<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<title>${userName}'s Book</title>

<t:html>
	<t:nav/>
	<t:sidebarLeft/>
	<t:sidebarRight/>
	<t:footer/>
	<div class="container">
	<h1>Your Book...</h1>
		<c:choose>
<%--******************************************** ADD BOOKS FORM ********************************************--%>
			<c:when test="${id ==  null}">
				<form:form class="column" action="/apartments/create" method="POST" modelAttribute="newApartment">
				<h4>Add a Book</h4>
					<div class="column">
				        <form:errors class="error" path="title"/>
				        <form:input path="title" placeholder="Title"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="link"/>
				        <form:input path="link" placeholder="Link"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="size"/>
				        <form:input path="size" placeholder="SqFt?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="price"/>
				        <form:input path="price" placeholder="Monthly Rent?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="dateAvail"/>
				        <form:input path="dateAvail" placeholder="Date Available"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="datePosted"/>
				        <form:input path="datePosted" placeholder="Today's Date?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="location"/>
				        <form:input path="location" placeholder="Address"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="pets"/>
				        <form:input path="pets" placeholder="Pets Allowed?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="bed"/>
				        <form:input path="bed" placeholder="# of Beds?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="bath"/>
				        <form:input path="bath" placeholder="# of Bathrooms?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="contact"/>
				        <form:input path="contact" placeholder="Contact Information"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="accessibility"/>
				        <form:input path="accessibility" placeholder="Accessibility?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="utilities"/>
				        <form:input path="utilities" placeholder="Utilities Included"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="description"/>
				        <form:textarea class="" path="description" placeholder="Thoughts"/>
				    </div>
				    <form:input type="hidden" value="${userId}" path="poster"/>
				    <input class="btn" type="submit" value="Submit"/>
				</form:form>
			</c:when>
<%--******************************************** EDIT BOOKS FORM ********************************************--%>
			<c:otherwise>
				<form:form class="column" action="/apartments/update/${id}" method="PUT" modelAttribute="updateApartment">
				<h4>Edit a Book</h4>
				<div class="column">
				        <form:errors class="error" path="title"/>
				        <form:input path="title" value="${title}" placeholder="Title"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="link"/>
				        <form:input path="link" value="${link}" placeholder="Link"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="size"/>
				        <form:input path="size" value="${size}" placeholder="SqFt?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="price"/>
				        <form:input path="price" value="${price}" placeholder="Monthly Rent?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="dateAvail"/>
				        <form:input path="dateAvail" value="${dateAvail}" placeholder="Date Available"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="datePosted"/>
				        <form:input path="datePosted" value="${datePosted}" placeholder="Today's Date?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="location"/>
				        <form:input path="location" value="${location}" placeholder="Address"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="pets"/>
				        <form:input path="pets" value="${pets}" placeholder="Pets Allowed?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="bed"/>
				        <form:input path="bed" value="${bed}" placeholder="# of Beds?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="bath"/>
				        <form:input path="bath" value="${bath}" placeholder="# of Bathrooms?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="contact"/>
				        <form:input path="contact" value="${contact}" placeholder="Contact Information"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="accessibility"/>
				        <form:input path="accessibility" value="${accessibility}" placeholder="Accessibility?"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="utilities"/>
				        <form:input path="utilities" value="${utilities}" placeholder="Utilities Included"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="description"/>
				        <form:textarea class="" path="description" value="${description}" placeholder="Thoughts"/>
				    </div>
				    <form:input type="hidden" value="${userId}" path="poster"/>
				    <input class="btn" type="submit" value="Submit"/>
				</form:form>
			</c:otherwise>
			
		</c:choose>
	</div> 
</t:html>
