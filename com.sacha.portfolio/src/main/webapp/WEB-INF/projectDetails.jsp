<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<t:nav/>
	
	<header>
		<div id="projBanner">
			<img src="./resources/static/imgs/${project.selectedImg}" alt=""/>
		</div>
	</header>
	
<!-- SUMMARY -->
	
	<section id="projSummary" >
		<div>
			<h2>Project Summary: <c:out value="${project.name}"/></h2>
			<p><c:out value="${project.version}"/></p>
			<p><c:out value="${project.language}"/></p>
			<p><c:out value="${project.dateCreated}"/></p>
			<p><c:out value="${project.dateModified}"/></p>
			<p><c:out value="${project.avgRating}"/></p>
			<p><c:out value="${project.createdBy}"/></p>
			<p><c:out value="${project.description}"/></p>		
		</div>
	</section>
		
<!-- IMAGE GALLERY -->

	<section id="projImageGallery">
		<div>
			<c:forEach items="${projects.images}" var="img">
				<c:out value="${img}"/>
			</c:forEach>		
		</div>
	</section>

<!-- COMMENTS -->
		
	<section id="projReplies">
		<div>
			<c:forEach items="replies" var="reply">
				<div>
					<h3><c:out value="${reply.postedBy}"/></h3>
					<p><c:out value="${reply.body}"/></p>
					<div id="replyFooter">
						<p><c:out value="${reply.dateCreated}"/></p>
						<p><c:out value="${reply.dateModified}"/></p>
						<p><a href="/reply/${proj.id}/${reply.id}" class="btn">Reply</a></p>
					</div>
				</div>
			</c:forEach>		
		</div>
	</section>
		
	<t:footer/>
</t:html>