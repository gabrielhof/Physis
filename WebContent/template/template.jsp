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
					
					<jsp:include page="menu.jsp" />
				</div>
			</div>
		</div>
	
		<jsp:include page="${viewFile}"></jsp:include>
		
		<script type="text/javascript" src="${contextPath}/assets/js/jquery-1.9.1.min.js"></script>	
		<script type="text/javascript" src="${contextPath}/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath}/assets/js/application/application.js"></script>
	</body>
</html>