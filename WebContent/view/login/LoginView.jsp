<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<form class="form-login" method="post" action="${appPath}/login/doLogin">
	
		<c:if test="${invalidLogin}">
			<div class="alert alert-error">
				<h4>Aviso!</h4>
				<p>Usuário e/ou Senha inválidos.</p>
			</div>
		</c:if>
		
		<h3>Entrar no Physis</h3>
		
		<input type="text" id="usuario" name="username" placeholder="Usuário" class="input-block-level error" required="required">
		<input type="password" id="senha" name="password" placeholder="Senha" class="input-block-level error" required="required">
		
		<button type="submit" class="btn btn-danger">Entrar</button>
	</form>
</div>