<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<t:nav/>
	<div class="container2">
		<h1 class="title">Resource Network</h1>
	    <div class="wrapper">
	    	<div class="feedWidth">
				<h2>Register: </h2>
				<c:if test="${userId == null }">
				</c:if>
			    <form:form class="" method="POST" action="/registration" modelAttribute="user">
			      	<div class="column">
				        <form:errors class="error" path="userName"/>
				        <form:input class="input" path="userName" placeholder="User Name"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="fName"/>
				        <form:input class="input" path="fName" placeholder="First Name"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="lName"/>
				        <form:input class="input" path="lName" placeholder="Last Name"/>
				    </div>
				    <div class="column">
				        <form:errors class="error" path="email"/>
				        <form:input path="email" placeholder="Email"/>
				    </div>
				     <div class="column">
				        <form:errors class="error" path="isCreator"/>
				        <form:label path="isCreator" >Yes</form:label>
				        <form:radiobutton path="isCreator" value="true"/>
				        <form:label path="isCreator" >No</form:label>
				        <form:radiobutton path="isCreator" value="false"/>
				    </div>
			      	<div class="column">
			            <form:errors class="error" path="password"/>
			            <form:password path="password" placeholder="Password"/>
			        </div>
			         <div class="column">
			            <form:errors class="error" path="passwordConfirmation"/> 
			            <form:password path="passwordConfirmation" placeholder="Confirm Password"/>
			        </div>
			        <div>
			        	<input class="btn" type="submit" value="Register"/>
			        </div>
			    </form:form>
		    </div>
		    
	    	<div class="feedWidth">
				<h2>Login:</h2>
			    <form class="" method="POST" action="/login" >
				    <p class="error">
				    	<c:out value="${error}"/>
				    </p>
			        <div class="column">
			            <input type="text" id="email" name="email" placeholder="Email"/>
			        </div>
			        <div class="column">
			            <input type="password" id="password" name="password" placeholder="Password"/>
			        </div>
			        <div>
			       		<input class="btn" type="submit" value="Login!"/>
			        </div>
			    </form>
		   	</div>
	   	</div>
   	</div>
	<t:footer/>
</t:html>