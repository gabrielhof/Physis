<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Alimentos</h1>

<f:button label="Novo Alimento" controller="food" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="person-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>% Prot.</th>
			<th>% Carb.</th>
			<th>% Gord.</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty foods}">
			<c:forEach var="food" items="${foods}">
				<tr>
					<td>${food.id}</td>
					<td>${food.name}</td>
					<td>${food.proteinPercentual} %</td>
					<td>${food.carbohydratePercentual} %</td>
					<td>${food.fatPercentual} %</td>
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="food" action="edit" parameters="id=${food.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="food" action="delete" parameters="id=${food.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>