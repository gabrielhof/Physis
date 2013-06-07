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
		<div class="navbar navbar-fixed-top">
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
							<li class="active"><a href="#home">Home</a></li>
							<li class="disabled"><a href="#about">Saiba mais</a></li>
							<li class="disabled"><a href="#contact">Contato</a></li>
<!-- 							<li class="dropdown"> -->
<!-- 								<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a> -->
<!-- 								<ul class="dropdown-menu"> -->
<!-- 									<li><a href="#">Action</a></li> -->
<!-- 									<li><a href="#">Another action</a></li> -->
<!-- 									<li><a href="#">Something else here</a></li> -->
<!-- 									<li class="divider"></li> -->
<!-- 									<li class="nav-header">Nav header</li> -->
<!-- 									<li><a href="#">Separated link</a></li> -->
<!-- 									<li><a href="#">One more separated link</a></li> -->
<!-- 								</ul> -->
<!-- 							</li> -->
						</ul>
						
						<c:if test="${useLoginBar}">
							<form class="navbar-form pull-right" method="post" action="${appPath}/login/doLogin">
								<input id="username" name="username" class="input-medium" type="text" placeholder="Usu&aacute;rio" required="required" style="height: 16px;">
								<input id="password" name="password" class="input-medium" type="password" placeholder="Senha" required="required" style="height: 16px;">
								<button type="submit" class="btn btn-small btn-danger">Entrar</button>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	
		<jsp:include page="${viewFile}"></jsp:include>
		
		<script type="text/javascript" src="${contextPath}/assets/js/jquery-1.9.1.min.js"></script>	
		<script type="text/javascript" src="${contextPath}/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath}/assets/js/application/application.js"></script>
	</body>
</html>