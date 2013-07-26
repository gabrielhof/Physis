<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty food.id}" then="Novo Alimento" otherwise="Editar Alimento"/></h1>

<f:form controller="food" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="food.id" type="hidden" value="${food.id}" />
		<f:field label="Nome" type="text" id="food.name" required="true" value="${food.name}"/>
	</f:fieldset>

	<f:fieldset title="Nutrientes">
		<f:grid>
			<f:grid-field label="% Proteína" required="true" type="decimal" id="food.proteinPercentual" value="${food.proteinPercentual}" />
			<f:grid-field label="% Carboidrato" required="true" type="decimal" id="food.carbohydratePercentual" value="${food.carbohydratePercentual}" />
		</f:grid>
		
		<f:field label="% Gordura" type="decimal" id="food.fatPercentual" required="true" value="${food.fatPercentual}"/>
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="food" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>