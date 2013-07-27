<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Avaliações</h1>

<f:button label="Nova Avaliação" controller="evaluation" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="evaluation-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Data</th>
			<th>Usuário</th>
			<th>Peso</th>
			<th>Altura</th>
			<th>% Massa Magra</th>
			<th>% Massa Gorda</th>
			<th>Treino</th>
			<th>Professor</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty evaluationList}">
			<c:forEach var="evaluation" items="${evaluationList}">
				<tr>
					<td>${evaluation.id}</td>
					<td><fmt:formatDate value="${evaluation.date}" pattern="dd/MM/yyyy"/></td>
					<td>${evaluation.user.toUserString()}</td>
					<td>${evaluation.weight}</td>
					<td>${evaluation.height}</td>
					<td>${evaluation.percentualLeanMass}</td>
					<td>${evaluation.percentualFatMass}</td>
					<td>${evaluation.professor.toUserString()}</td>
					<td>
						<f:case when="${empty evaluation.training})" then="N/A" otherwise="${evaluation.training.toUserString()}" />
					</td>
					
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="evaluation" action="edit" parameters="id=${evaluation.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="evaluation" action="delete" parameters="id=${evaluation.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>