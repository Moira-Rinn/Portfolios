<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	
	<header class="showcase">
	<t:nav/>
	    <div class="content">
	    
	      <div class="intro">
		      <img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
		      <div class="title">
		        Welcome To <span>S.M. C. R.  Design</span>
		      </div>
		      <div class="text">
		        Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae, vel.
		      </div>
	      </div>
	      
	   <!-- Services -->   
	      
		  <div class="container grid-3 center">
		  	
		  	<div>
		  		<a href="#">
		        	<i class="fas fa-face-smile fa-3x"></i>
		          	<h3>About Us</h3>
			        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
		          </a>  
		  	</div>
		        
		    <div>
		    	<a href="#">
			        <i class="fas fa-envelope fa-3x"></i>
			        <h3>Contact</h3>
			        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
		        </a>
		    </div>
		    <div>
		      	<a href="#">
		        	<i class="fas fa-keyboard fa-3x"></i>
		        	<h3>Projects</h3>
		        	<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
		        </a>
		    </div>
	      </div>

	    <!-- About -->  
	      
			<div class="center container">
			<h3>Socials:</h3>
				<div class="grid-2">
					<div>
						<div class="socials">
							
			      			<a href="#"><i class="fab fa-youtube fa-2x"></i></a>
		        		
			      			<a href="#"><i class="fab fa-facebook fa-2x"></i></a>
		        		
			      			<a href="#"><i class="fab fa-twitter fa-2x"></i></a>
		        		
			      			<a href="#"><i class="fab fa-instagram fa-2x"></i></a>
						</div>
		  			</div>
		  		</div>
			</div>
		</div>
	    <t:footer/>
	</header>



</t:html>