<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:html>
	<header class="showcase">
		<t:nav/>
		<div class="content">
	
			<div class="intro">
				<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
				<div class="title">
					Welcome To <span>Portfolios</span>
				</div>
				<div class="text">
					Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae, vel.
				</div>
			</div>
		</div>  
	</header>
	
	<!-- Featured Portfolios -->
	<c:choose>
		<c:when test="${userId != null}">
			<section class="container center">	  
				<h1 class="center">Featured Portfolios:</h1>	
				<div class="grid-3">
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
						</a>  
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
					 <div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
						</a>  
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
					 <div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
						</a>  
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
					<div>
						<a href="#">
							<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
							<h3>SMCR Design</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
						</a>
					</div>
				</div>
			</section>
	</c:when>
		<c:otherwise>
			<section class="container center">	  
			<h1 class="center">Featured Portfolios:</h1>	
			<div class="grid-3">
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
					</a>  
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
				 <div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
					</a>  
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
				 <div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit...</p>
					</a>  
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
				<div>
					<a href="/login-reg">
						<img src="/css/fairyLogo.png" class="logo" alt="SMCR Design">
						<h3>SMCR Design</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, reiciendis!</p>
					</a>
				</div>
			</div>
		</section>
	</c:otherwise>
		</c:choose>
		
	<!-- Socials /login-reg-->  
	      
	<section class="center container">
		<h3>Socials:</h3>
		<div class="grid-2">
			<a href="#"><i class="fab fa-youtube fa-2x"></i><span>YouTube</span></a>
			<a href="#"><i class="fab fa-facebook fa-2x"></i><span>FaceBook</span></a>
			<a href="#"><i class="fab fa-twitter fa-2x"></i><span>Twitter</span></a>
			<a href="#"><i class="fab fa-instagram fa-2x"></i><span>Instagram</span></a>
		</div>
	</section>

	<t:footer/>

</t:html>