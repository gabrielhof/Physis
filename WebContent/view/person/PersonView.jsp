<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty person.id}" then="Nova Pessoa" otherwise="Editar Pessoa"/></h1>

<f:form controller="person" action="save" method="post" validation="personFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="person.id" type="hidden" value="${person.id}" />
	
		<f:grid>
			<f:grid-field label="Nome" id="person.name" type="text" required="true" value="${person.name}" />
			<f:grid-field label="Sobrenome" id="person.lastName" type="text" required="true" value="${person.lastName}" />
		</f:grid>
		
		<f:field label="Nascimento" type="date" id="person.bornDate" required="true" styleClass="input-small" value="${person.bornDate}"/>
		
		<f:grid>
			<f:grid-field label="RG" id="person.rg" type="text" required="true" styleClass="input-small" mask="9999999999" value="${person.rg}"/>
			<f:grid-field label="CPF" id="person.cpf" type="text" required="true" styleClass="input-medium" mask="999.999.999-99" value="${person.cpf}"/>
		</f:grid>
	</f:fieldset>
	
	<f:fieldset title="Contato">
		<f:grid>
			<f:grid-field label="Email" type="email" id="person.email" value="${person.email}"/>
			<f:grid-field label="Telefone" type="text" id="person.phone" styleClass="input-medium" mask="(99) 9999-9999" value="${person.phone}" />
		</f:grid>	
	</f:fieldset>
	
	<f:fieldset title="Endereço">
		<f:input id="person.address.id" type="hidden" value="${person.address.id}" />
		<f:field label="CEP" type="text" id="person.address.cep" required="true" styleClass="input-small" mask="99999-999" value="${person.address.cep}"/>
		
		<f:grid>
			<f:grid-field label="Logradouro" type="text" id="person.address.address" required="true" value="${person.address.address}"/>
			<f:grid-field label="Bairro" type="text" id="person.address.district" required="true" value="${person.address.district}"/>
		</f:grid>
		
		<f:grid>
			<f:grid-field label="Número" type="text" id="person.address.number" required="true" styleClass="input-mini" mask="9?999" value="${person.address.number}"/>
			<f:grid-field label="Complemento" type="text" id="person.address.complement" styleClass="input-mini" value="${person.address.complement}"/>
		</f:grid>
			
		<f:field label="Cidade" type="text" id="person.address.city" required="true" value="${person.address.city}"/>
		
		<f:grid>
			<f:grid-select label="País" enumClass="br.feevale.physis.business.model.enums.Country" id="person.address.country" required="true" value="${person.address.country}"/>
			<f:grid-select label="Estado" enumClass="br.feevale.physis.business.model.enums.State" id="person.address.state" required="true" value="${person.address.state}"/>
		</f:grid>
	</f:fieldset>
	
	<f:fieldset title="Usuário">
		<f:input id="person.user.id" type="hidden" value="${person.user.id}" />
		<f:field id="person.user.username" type="text" label="Usuário" required="true" value="${person.user.username}"/>
		
		<f:grid>
			<f:grid-field id="person.user.password" type="password" label="Senha" required="${empty person.user.id}" />
			<f:grid-field id="passwordConfirmation" type="password" label="Confirmação" required="${empty person.user.id}" />
		</f:grid>
		
		<f:select-field enumClass="br.feevale.physis.business.model.enums.Role" id="person.user.role" label="Tipo" required="true" value="${person.user.role}" />
	</f:fieldset>
	
	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="person" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>

<f:script src="application/person/person-view.js" />