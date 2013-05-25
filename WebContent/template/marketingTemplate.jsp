<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Physis</title>
	
		<link href="${contextPath}/assets/css/index.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					
					<a class="brand" href="${contextPath}">Physis</a>
					
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li class="nav-header">Nav header</li>
									<li><a href="#">Separated link</a></li>
									<li><a href="#">One more separated link</a></li>
								</ul>
							</li>
						</ul>
						
						<form class="navbar-form pull-right">
							<input class="input-medium" type="text" placeholder="Usu&aacute;rio" style="height: 16px;">
							<input class="input-medium" type="password" placeholder="Senha" style="height: 16px;">
							<button type="submit" class="btn btn-small btn-primary">Entrar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	
		<jsp:include page="${viewFile}"></jsp:include>
		
		<script type="text/javascript" src="${contextPath}/assets/js/jquery/jquery-1.9.1.min.js"></script>	
		<script type="text/javascript" src="${contextPath}/assets/js/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath}/assets/js/application/application.js"></script>
	</body>
</html>