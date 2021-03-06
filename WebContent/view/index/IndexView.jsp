<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!-- Begin Carousel -->
		<div id="index-carousel" class="carousel slide">
			<div class="carousel-inner">
				<div class="item active">
					<img src="${contextPath}/assets/img/carousel/slide-01.jpg" alt="" />
					<div class="container">
						<div class="carousel-caption">
							<p class="lead">Foque apenas no que é necessário</p>
							<h1>Alimentação e Treino</h1>
							<a class="btn btn-large btn-info" href="#">Saiba mais</a>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="${contextPath}/assets/img/carousel/slide-02.jpg" alt="">
					<div class="container">
						<div class="carousel-caption">
							<h1>Você já treinou hoje?</h1>
							<p class="lead">Não deixe seu treino para amanhã!</p>
							<a class="btn btn-large btn-danger" href="#">Entrar</a>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="${contextPath}/assets/img/carousel/slide-03.jpg" alt="">
					<div class="container">
						<div class="carousel-caption">
							<h1>Foco, força e dedicação.</h1>
							<p class="lead">Não se preocupe com o que não é necessário.</p>
<!-- 							<p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p> -->
							<a class="btn btn-large btn-info" href="#">Saiba mais</a>
						</div>
					</div>
				</div>
			</div>
		
			<a class="left carousel-control" href="#index-carousel" data-slide="prev">&lsaquo;</a>
			<a class="right carousel-control" href="#index-carousel" data-slide="next">&rsaquo;</a>
		</div>
		<!-- End Carousel -->

		<div class="container marketing">
			<div class="featurette">
				<img class="featurette-image pull-right" src="${contextPath}/assets/img/marketing/balance-food.png" />
				<h2 class="featurette-heading">Controle<span class="muted"> o que você realmente precisa </span>comer<span class="muted">.</span></h2>
				<p class="lead">Com o sistema de dieta, você poderá controlar todos os alimentos para obter as nutrientes necessários para alcançar seu objetivo.</p>
			</div>
			<hr class="featurette-divider">
			
			<div class="featurette">
				<img class="featurette-image pull-left" src="${contextPath}/assets/img/marketing/alteres-academia.png" />
				<h2 class="featurette-heading">Saiba<span class="muted"> o que você esta </span>fazendo<span class="muted">.</span></h2>
				<p class="lead">Com o sistema de treino, você saberá exatamente o que precisa fazer e porquê. Dessa maneira você confia no seu treino e em si mesmo. </p>
			</div>

			<hr class="featurette-divider">

			
			<jsp:include page="/template/footer.jsp"></jsp:include>
		</div>