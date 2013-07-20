<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="items" required="true" type="java.util.Collection" description="Data list" %>
<%@ attribute name="headers" required="true" type="java.lang.String" description="Column Names" %>

<table class="table table-hover table-bordered table-condensed table-striped" id="${id}">
	<thead>
		<tr>
			<c:forEach items="${headers.split(\" \")}" var="head">
				<th>${head}</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty items}">
			<c:forEach var="bean" items="${items}">
				<jsp:doBody />
			</c:forEach>
		</c:if>
	</tbody>
</table>