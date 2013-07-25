<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty exercise.id}" then="Novo Exercício" otherwise="Editar Exercício"/></h1>

<f:form controller="exercise" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="exercise.id" type="hidden" value="${exercise.id}" />
	
		<f:field label="Nome" type="text" id="exercise.name" required="true" value="${exercise.name}"/>
		<f:field label="Descrição" type="text" id="exercise.description" value="${exercise.description}"/>
		
		<f:select-field label="Equipamento" beans="${equipments}" id="exercise.equipment.id" value="${exercise.equipment.id}" />
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="person" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>