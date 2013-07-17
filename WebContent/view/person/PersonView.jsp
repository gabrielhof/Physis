<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/components.tld" prefix="f" %>

<h1>Pessoas</h1>

<f:table items="${people}" var="person">
	<f:column value="${person.id}" header="ID"/>
	<f:column value="${person.name}" header="Nome"/>
	<f:column value="${person.age}" header="Idade"/>
</f:table>

<table class="table table-hover table-bordered table-condensed table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Idade</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty people}">
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.age}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>