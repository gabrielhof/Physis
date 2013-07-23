<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Pessoas</h1>

<f:button label="Nova Pessoa" controller="person" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="person-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Nascimento</th>
			<th>Email</th>
			<th>Telefone</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty people}">
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.id}</td>
					<td>${person.name} ${person.lastName}</td>
					<td><fmt:formatDate value="${person.bornDate}" pattern="dd/MM/yyyy"/></td>
					<td>${person.email}</td>
					<td>${person.phone}</td>
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="person" action="edit" parameters="id=${person.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Editar" controller="person" action="delete" parameters="id=${person.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>