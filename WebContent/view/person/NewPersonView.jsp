<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Nova Pessoa</h1>

<f:form controller="person" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:grid>
			<f:grid-field label="Nome" id="person.name" type="text" required="true"/>
			<f:grid-field label="Sobrenome" id="person.lastName" type="text" required="true"/>
		</f:grid>
		
		<f:field label="Nascimento" type="date" id="person.bornDate" required="true" styleClass="input-small"/>
		
		<f:grid>
			<f:grid-field label="RG" id="person.rg" type="text" required="true" styleClass="input-small" mask="9999999999"/>
			<f:grid-field label="CPF" id="person.cpf" type="text" required="true" styleClass="input-medium" mask="999.999.999-99"/>
		</f:grid>
	</f:fieldset>
	
	<f:fieldset title="Contato">
		<f:grid>
			<f:grid-field label="Email" type="email" id="person.email" />
			<f:grid-field label="Telefone" type="text" id="person.phone" styleClass="input-medium" mask="(99) 9999-9999" />
		</f:grid>	
	</f:fieldset>
	
	<f:fieldset title="Endereço">
		<f:field label="CEP" type="text" id="person.address.cep" required="true" styleClass="input-small" mask="99999-999"/>
		
		<f:grid>
			<f:grid-field label="Logradouro" type="text" id="person.address.address" required="true"/>
			<f:grid-field label="Bairro" type="text" id="person.address.district" required="true"/>
		</f:grid>
		
		<f:grid>
			<f:grid-field label="Número" type="text" id="person.address.number" required="true" styleClass="input-mini" mask="9?999"/>
			<f:grid-field label="Complemento" type="text" id="person.address.complement" styleClass="input-mini"/>
		</f:grid>
			
		<f:field label="Cidade" type="text" id="person.address.city" required="true" />
		
		<f:grid>
			<f:grid-select label="País" enumClass="br.feevale.physis.business.model.enums.Country" id="person.address.country" required="true" />
			<f:grid-select label="Estado" enumClass="br.feevale.physis.business.model.enums.State" id="person.address.state" required="true" />
		</f:grid>
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="person" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>