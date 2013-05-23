<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Vamos implementar algo legal?</title>
		<link href="${contextPath}/assets/css/style.css" rel="stylesheet"/>
	</head>
	<body>
	    <div class="container-narrow">
			<div class="masthead">
				<ul class="nav nav-pills pull-right">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<h3 class="muted">Projeto</h3>
			</div>

			<div class="jumbotron">
				<h1>Projeto dahora!</h1>
				<p class="lead">Um texto muito foda que vai te convencer que esse site é muito foda.</p>
				<a class="btn btn-large btn-success" href="#">Um botão que faz algo</a>
	    	</div>
			
			<hr />
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Idade</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty pessoas}">
						<c:forEach var="pessoa" items="${pessoas}">
		    				<tr>
    							<td>${pessoa.id}</td>
    							<td>${pessoa.name}</td>
    							<td>${pessoa.age}</td>
    						</tr>
						</c:forEach>
					</c:if>
	    		</tbody>
	    	</table>
	    	
			<hr/>
		
			<div class="footer">
				<p>&copy; Cópiraitis</p>
			</div>
	    </div>

		<script type="text/javascript" src="${contextPath}/assets/js/jquery-1.9.1.min.js"></script>	
		<script type="text/javascript" src="${contextPath}/assets/js/bootstrap.min.js"></script>	
	</body>
</html>