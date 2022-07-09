<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<t:nav/>
	<div class="container">
		<h2>Books from everyone's shelves</h2>
        <div class="grid-container">
            <h4 class="item1">Title</h4>
            <h4 class="item2">Author</h4>
            <h4 class="item3">Posted By</h4>
            <h4 class="item4">Avg Stars</h4>
            <h4 class="item5">Actions</h4>
        </div>
        <c:forEach items="${books}" var="book">
	        <div class="grid-container hilite">
	            <div class="item10"><a class="btn" href="/books/details/${book.id}">${book.title}</a></div>
	            <div class="item20"><c:out value="${book.author}"/></div>
	            <div class="item30"><a href="/books/${book.poster.id}/profile"><c:out value="${book.poster.userName}"/></a></div>
	            <div class="item40"><c:out value="${book.getAvgStars()}"/></div>
	            <div class="item50">
		            <c:if test="${book.poster.id==userId}">
		            	<div class="wrapper">
							<a class="btn" href="/books/edit/${book.id}">Edit</a>
							<form  action="/books/delete/${book.id}" method="POST">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn" type="submit" value="Delete">
							</form>
						</div>
					</c:if>
				</div>
	        </div>
        </c:forEach>
	</div>
	<t:footer/>
	<t:sidebarLeft/>
	<t:sidebarRight/>
</t:html>
