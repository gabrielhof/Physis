<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Pagamentos</h1>

<f:button label="Gera Boleto" controller="payment" action="generateSlipBank" styleClass="btn btn-primary pull-right"/>
<f:button label="Novo Pagamento" controller="payment" action="new" styleClass="btn btn-primary pull-right"/>

<f:table id="payment-table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Data de emissão</th>
			<th>Data de pagamento</th>
			<th>Valor</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty payments}">
			<c:forEach var="payment" items="${payments}">
				<tr>
					<td>${payment.id}</td>
					<td>${payment.issueDate}</td>
					<td>${payment.paymentDate}</td>
					<td>${payment.value}</td>
					<td>${payment.person.name}</td>
					<td>
						<f:icon-button icon="icon-pencil" title="Editar" controller="payment" action="edit" parameters="id=${payment.id}" />
					</td>
					<td>
						<f:icon-button icon="icon-trash" title="Remover" controller="payment" action="delete" parameters="id=${payment.id}" onclick="return confirmDialog(this, 'Term certeza que deseja excluir esse registro?', 'Deseja excluir?', true);"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</f:table>