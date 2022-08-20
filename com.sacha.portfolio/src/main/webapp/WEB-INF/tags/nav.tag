<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<c:choose>
			<c:when test="${userId != null}">
				<nav class="nav">
					<h3 class="title">Welcome to Portfolios, <c:out value="${userName}"/></h3>
					<div class="wrapper">
						<a href="/books">Home</a>
						<a href="/books/new">Profile</a>
						<a href="/logout">Logout</a>
					</div>
				</nav>
			</c:when>
			<c:otherwise>
				<nav class="nav">
					<h3 class="title">Welcome to Portfolios!</h3>
					<div class="wrapper">
						<a href="/login-reg">Login/Register</a>
					</div>
				</nav>
			</c:otherwise>
		</c:choose>

