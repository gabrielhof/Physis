<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Equipamentos</h1>

<f:button label="Novo Exercício" controller="exercise" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="person-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Equipamento</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty exercises}">
			<c:forEach var="exercise" items="${exercises}">
				<tr>
					<td>${exercise.id}</td>
					<td>${exercise.name}</td>
					<td>${exercise.description}</td>
					<td>
						<f:case when="${empty exercise.equipment})" then="N/A" otherwise="${exercise.equipment.toUserString()}" />
					</td>
					
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="exercise" action="edit" parameters="id=${exercise.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="exercise" action="delete" parameters="id=${exercise.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>