<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty equipment.id}" then="Novo Equipamento" otherwise="Editar Equipamento"/></h1>

<f:form controller="equipment" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="equipment.id" type="hidden" value="${equipment.id}" />
	
		<f:field label="Nome" type="text" id="equipment.name" required="true" value="${equipment.name}"/>
		<f:field label="Descrição" type="text" id="equipment.description" value="${equipment.description}"/>
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="equipment" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>