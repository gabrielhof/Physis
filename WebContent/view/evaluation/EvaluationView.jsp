<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty evaluation.id}" then="Nova Avaliação" otherwise="Editar Avaliação"/></h1>

<f:form controller="evaluation" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="evaluation.id" type="hidden" value="${evaluation.id}" />
	
		<f:grid>
			<f:grid-field label="Data" type="date" id="evaluation.date" required="true" value="${evaluation.date}" styleClass="input-small"/>
			<f:grid-select label="Usuário" beans="${users}" id="evaluation.user.id" value="${evaluation.user.id}"/>
		</f:grid>
		
		<f:grid>
			<f:grid-select label="Treino" beans="${training}" id="evaluation.training.id" value="${evaluation.training.id}"/>
			<f:grid-select label="Professor" beans="${professors}" id="evaluation.professor.id" value="${evaluation.professor.id}"/>
		</f:grid>
	</f:fieldset>
	
	<f:fieldset title="Detalhes">
		<f:grid>
			<f:grid-field label="Peso" type="decimal" id="evaluation.weight" required="true" value="${evaluation.weight}" styleClass="input-small"/>
			<f:grid-field label="Altura" type="numeric" id="evaluation.height" required="true" value="${evaluation.height}" styleClass="input-small"/>
		</f:grid>
		
		<f:grid>
			<f:grid-field label="% Massa Magra" type="decimal" id="evaluation.percentualLeanMass" required="true" value="${evaluation.percentualLeanMass}" styleClass="input-small"/>
			<f:grid-field label="% Massa Gorda" type="decimal" id="evaluation.percentualFatMass" required="true" value="${evaluation.percentualFatMass}" styleClass="input-small"/>
		</f:grid>
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="exercise" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>