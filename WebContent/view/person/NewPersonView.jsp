<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/components.tld" prefix="f" %>

<h1>Nova Pessoa</h1>

<f:form controller="person" action="save" method="post">
	<f:fieldset title="Dados Gerais">
		<f:field id="name" label="Nome" type="text" />
	</f:fieldset>
</f:form>