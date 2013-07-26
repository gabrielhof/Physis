<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty payment.id}" then="Novo Pagamento" otherwise="Editar Pagamento"/></h1>

<f:form controller="payment" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="payment.id" type="hidden" value="${payment.id}" />
		<f:field label="Data de emissão" required="true" type="text" id="payment.issueDate" value="${payment.issueDate}"/>
		<f:field label="Valor R$" required="true" type="double" id="payment.value" value="${payment.value}" />
		<f:field label="Data de pagamento" required="false" type="date" id="payment.paymentDate" value="${payment.paymentDate}" />
		<f:field label="Pessoa" required="true" type="numeric" id="payment.person.id" value="${payment.person.id}" />	
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="payment" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>