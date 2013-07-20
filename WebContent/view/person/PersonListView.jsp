<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1>Pessoas</h1>

<%-- <f:table items="${people}" headers="ID Nome" id="people-table"> --%>
<%-- 	<f:column property="id" /> --%>
<%-- 	<f:column property="name" /> --%>
<%-- </f:table> --%>

<table class="table table-hover table-bordered table-condensed table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty people}">
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>