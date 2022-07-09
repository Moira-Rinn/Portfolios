<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<title>${apartment.title}'s </title>

<t:html>
	<t:nav/>
	<t:sidebarLeft/>
	<t:sidebarRight/>

	<div class="container">
		<div class="column">
			<div class="wrapper">
				<h1 class="title"><c:out value="${apartment.title}"/></h1>
				<div class="column">
					<h5>Added by: <c:out value="${apartment.postedBy.userName}"/></h5>
					<p>Posted: <c:out value="${apartment.datePosted}"/></p>
				</div>
			</div>
			<c:if test="${apartment.poster.id==userId}">
				<div class="wrapper">
					<a class="btn" href="/apartments/edit/${apartment.id}">Edit</a>
					<form action="/apartments/delete/${apartment.id}" method="POST">
					    <input type="hidden" name="_method" value="delete">
					    <input class="btn" type="submit" value="Delete">
					</form>
				</div>
			</c:if>
		</div>
		<div class="column">
			<h4><c:out value="${apartment.poster.userName}"/>'s Thoughts:</h4>
			<p class="tBorder bBorder text"><c:out value="${apartment.description}"/></p>
		</div>
		<div class="column">
			<div class="feedWidth">
				<form:form class="feedWidth" action="/apartments/addPossible/${apartment.id}" method="POST" modelAttribute="newPossible">		        
				    <form:input type="hidden" value="${userId}" path="user"/>
				    <form:input type="hidden" value="${apartment.id}" path="apartment"/>
				    <input class="btn" type="submit" value="Star It!!">
				</form:form>
				<%-- 
				<h4>Users who starred this book:</h4>
				<div class="feedWidth">
					<c:forEach items="${book.stars}" var="star">
						<p class="bBorder">${star.readBy.userName} gave ${star.numStars} Stars</p>
						<p>${star.readBy.userName} thought... ${star.reply}</p>
						<c:if test="${star.readBy.id==userId}">
							<div class="wrapper">
								<a class="btn" href="#">Edit</a>
								<form action="/books/delete-star/${book.id}/${star.id}" method="POST">
								    <input type="hidden" name="_method" value="delete">
								    <input class="btn" type="submit" value="Delete">
								</form>
							</div>
						</c:if>
						<c:forEach items="${star.responses}" var="res">
							<p>${res.responseBy.userName} Replied... ${res.response}</p>
						</c:forEach>
						<div class="reply feedWidth">
							<form:form class="feedWidth" action="/books/addResponse/${star.id}" method="POST" modelAttribute="newResponse">
						        <form:errors class="error" path="response"/>
						        <form:textarea path="response" placeholder="Respond?"/>
						        
							    <form:input type="hidden" value="${userId}" path="responseBy"/>
							    <form:input type="hidden" value="${star.id}" path="replied"/>
							    <input class="btn" type="submit" value="Reply">
			
							</form:form>
						</div>
					</c:forEach>
				</div>--%>
		    </div>
	    </div>
	</div>
<t:footer/>
</t:html>