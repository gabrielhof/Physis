<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="controller" required="true" type="java.lang.String" description="Controller" %>
<%@ attribute name="action" required="true" type="java.lang.String" description="Action" %>
<%@ attribute name="method" type="java.lang.String" description="HTTP Method" %>
<%@ attribute name="validation" type="java.lang.String" description="Validation Javascript Function" %>


<c:if test="${empty method}">
	<c:set var="method" value="GET" />
</c:if>

<c:set var="onsubmitHtml" value="" />
<c:if test="${not empty validation}">
	<c:set var="onsubmitHtml" value="onsubmit=\"return ${validation}(this);\" novalidate" />
</c:if>

<form class="default-form form-horizontal" method="${method}" action="${appPath}/${controller}/${action}" ${onsubmitHtml}>
	<jsp:doBody />
</form>