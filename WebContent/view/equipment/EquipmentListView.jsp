<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Equipamentos</h1>

<f:button label="Novo Equipamento" controller="equipment" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="person-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty equipments}">
			<c:forEach var="equipment" items="${equipments}">
				<tr>
					<td>${equipment.id}</td>
					<td>${equipment.name}</td>
					<td>${equipment.description}</td>
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="equipment" action="edit" parameters="id=${equipment.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="equipment" action="delete" parameters="id=${equipment.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>