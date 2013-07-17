<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="items" type="java.util.Collection" description="Data list" %>
<%@ attribute name="var" type="java.util.String" description="Items var name" %>

<table>
	<thead>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="${var}">
			<jsp:doBody />
		</c:forEach>
	</tbody>
</table>