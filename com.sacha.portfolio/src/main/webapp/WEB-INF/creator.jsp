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
				<h2>Creator Information: </h2>
				<form class="" action="/creatorReg/${id}" method="POST">
			      	<div class="column">
				        <input class="input" id="address" name="address" placeholder="Address"/>
				    </div>
				    <div class="column">
				        <input class="input" id="phone" name="phone" placeholder="Phone #"/>
				    </div>
				    <div class="column">
				        <input class="input" id="projects" name="projects" placeholder="Projects"/>
				    </div>
				    <div class="column">
				        <input class="input" id="social" name="social" placeholder="social"/>
				    </div>
				     <div class="column">
				       <input class="input" id="homePage" name="homePage" placeholder="Home Page"/>
				    <c:out value="${userId}"/>
				    </div>
				    	<div class="column">
			            <input type="password" id="password" name="password" placeholder="Password"/>
			        </div>
			        </div>
				    	<div class="column">
			            <input type="hidden" id="passwordConfirmation" name="passwordConfirmation" value="Password"/>
			        </div>
			        <div>
			        <input type="hidden" value="${userId}" name="id"/>
			        	<input class="btn" type="submit" value="Register"/>
			        </div>
			    </form>
		    </div>
	   	</div>
   	</div>
	<t:footer/>
</t:html>