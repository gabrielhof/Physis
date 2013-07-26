<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Treinos</h1>

<f:button label="Novo Treino" controller="training" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="person-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty trainingList}">
			<c:forEach var="training" items="${trainingList}">
				<tr>
					<td>${training.id}</td>
					<td>${training.name}</td>
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="training" action="edit" parameters="id=${training.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="training" action="delete" parameters="id=${training.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>