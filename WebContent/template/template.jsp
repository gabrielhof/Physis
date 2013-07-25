<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Physis</title>
	
		<link href="${contextPath}/assets/css/datepicker.css" rel="stylesheet"/>
		<link href="${contextPath}/assets/css/style.css" rel="stylesheet"/>
		
		<script type="text/javascript">
			var contextPath = "${contextPath}";
			var appPath = "${appPath}";
		</script>
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
					<div class="btn-group" style="float: right;">
						<a href="javascript:void(0);" class="btn btn-inverse dropdown-toggle" data-toggle="dropdown">${user.username} <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${appPath}/login/doLogoff" onclick="return confirmDialog(this, 'Ter certeza que deseja sair do sistema?', 'Deseja sair?');">Sair</a></li>
						</ul>
					</div>
					
					<jsp:include page="menu.jsp" />
				</div>
			</div>
		</div>
	
		<div class="container content">
			<div class="alert hide"></div>
			<jsp:include page="${viewFile}" />
		</div>
		
		<jsp:include page="footer.jsp" />
		
		<f:script src="jquery-1.9.1.min.js" />
		<f:script src="bootstrap.min.js" />
		<f:script src="jquery.numeric.js" />
		<f:script src="jquery.maskedinput.min.js" />
		<f:script src="bootstrap-datepicker.js" />
		<f:script src="locale/bootstrap-datepicker.pt-BR.js" />
		<f:script src="jquery.blockUI.js" />
		<f:script src="application/application.js" />
	</body>
</html>