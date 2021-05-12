<%@page import="entity.Item"%>
<%@page import="java.util.List"%>
<%@page import="util.ImageUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>FOOD RESTAURANT</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" />    
	<link href="css/templatemo-style.css" rel="stylesheet" />
	 
</head>
<!--

Simple House

https://templatemo.com/tm-539-simple-house

-->
<body> 

	<div class="container">
	<!-- Top box -->
		<!-- Logo & Site Name -->
		<div class="placeholder">
			<div class="parallax-window" data-parallax="scroll" data-image-src="img/simple-house-01.jpg">
				<div class="tm-header">
					<div class="row tm-header-inner">
						<div class="col-md-6 col-12">
							<img src="img/simple-house-logo.png" alt="Logo" class="tm-site-logo" /> 
							<div class="tm-site-text-box">
								<h1 class="tm-site-title">FOOD RESTAURANT</h1>
								<h6 class="tm-site-description">WHERE YOU ENJOY FOOD'S QUINTESSENTIAL</h6>	
							</div>
						</div>
						<nav class="col-md-6 col-12 tm-nav">
							<ul class="tm-nav-ul">
								<li class="tm-nav-li"><a href="index.html" class="tm-nav-link active">Home</a></li>
								<li class="tm-nav-li"><a href="about.html" class="tm-nav-link">About</a></li>
								<li class="tm-nav-li"><a href="contact.html" class="tm-nav-link">Contact</a></li>
							</ul>
						</nav>	
					</div>
				</div>
			</div>
		</div>

		<main>
	
 
			<header class="row tm-welcome-section">
				<h2 class="col-12 text-center tm-section-title">YOUR CART</h2>
				<p class="col-12 text-center"></p>
				</header>
				<c:if test = "${message != null }">			
       <p style="text-align:center; color:green"> <strong>Success!</strong><c:out value="${message}" /></p>
         <c:remove var="message" scope="session"/>
    </c:if>
					   <c:if test="${error != null}">
 <div class="alert alert-danger alert-dismissible fade show">
        <strong>Error!</strong><c:out value="${error}" />
        <c:remove var="error" scope="session"/>
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
 </c:if>
			 <c:if test="${items != null}">
			<div class="tm-paging-links">
				<nav>
					<ul>
					<li class="tm-paging-item"><a href="ViewHistoryOrderServlet" class="tm-paging-link">HISTORY</a></li>
					<li class="tm-paging-item"><a href="#" class="tm-paging-link">CONTINUE TO SHOPPING</a></li>
						<li class="tm-paging-item"><a href="DeleteCartServlet" class="tm-paging-link">REMOVE ALL</a></li>
						
					</ul>
				</nav>
			</div>

			<!-- Gallery -->
			<div class="row tm-gallery">
				<!-- gallery page 1 -->
				<div id="tm-gallery-page-pizza" class="tm-gallery-page">
				<c:forEach var = "item" items = "${items}">
					<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
						<figure>
							<img src="data:image/jpg;base64,${item.getImageBase()}" alt="Image" class="img-fluid tm-gallery-img" />
							<figcaption>
								<h4 class="tm-gallery-title">${item.name}</h4>
								<p class="tm-gallery-description">${item.description}</p>
								<p class="tm-gallery-price">Price: ${item.price} $</p>
								<p class="tm-gallery-price">Available: ${item.unit}</p>
								<p class="tm-paging-item-3"><a href="DeleteItemServlet?id=${item.id}" class="tm-paging-link">Remove</a></p>
							</figcaption>
						</figure>
					</article>
					</c:forEach>
				</div> <!-- gallery page 3 -->
			</div>
			<div class="tm-section tm-container-inner">
				<div class="row">
					<div class="col-md-6">
						<figure class="tm-description-figure">
							
						</figure>
					</div>
					
				</div>
				
			</div>				
				
					<div class="tm-paging-links">
				<nav>
					<ul>
					<li><p class = "tm-gallery-price">TOTAL: ${total}$</p></li>
					<li class="tm-paging-item"><a data-toggle="collapse" href="#GetCouponCode" role = "button" aria-expanded="false" aria-controls="GetCouponCode" class="tm-paging-link">GET COUPON CODE</a></li>
							<li class="tm-paging-item-2"><a href="MakePaymentServlet" class="tm-paging-link">MAKE PAYMENT</a></li>
						</ul>
						</nav>
					</div>
				
		</main>

		<footer class="tm-footer text-center">
			<p>Copyright &copy; 2020 Simple House 
            
            | Design: <a rel="nofollow" href="https://templatemo.com">TemplateMo</a></p>
		</footer>
	</div>
	 </c:if>
	<script src="js/jquery.min.js"></script>
	<script src="js/parallax.min.js"></script>
	<script>
		$(document).ready(function(){
			// Handle click on paging links
			$('.tm-paging-link').click(function(e){
				e.preventDefault();
				
				var page = $(this).text().toLowerCase();
				$('.tm-gallery-page').addClass('hidden');
				$('#tm-gallery-page-' + page).removeClass('hidden');
				$('.tm-paging-link').removeClass('active');
				$(this).addClass("active");
			});
		});
	</script>
</body>
</html>