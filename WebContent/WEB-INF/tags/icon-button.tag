<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="icon" required="true" type="java.lang.String" description="Icon Name" %>
<%@ attribute name="controller" type="java.lang.String" description="Controller Name" %>
<%@ attribute name="action" type="java.lang.String" description="Action Name" %>
<%@ attribute name="title" type="java.lang.String" description="Title" %>
<%@ attribute name="onclick" type="java.lang.String" description="javascript event" %>
<%@ attribute name="parameters" type="java.lang.String" description="javascript event" %>

<c:choose>
	<c:when test="${not empty onclick}">
		<c:set var="onclickEvent" value="onclick=\"${onclick}\""/>
	</c:when>
	<c:otherwise>
		<c:set var="onclickEvent" value=""/>
	</c:otherwise>
</c:choose>

<c:if test="${not empty parameters}">
	<c:set var="parameters" value="?${parameters}"/>
</c:if>

<a href="${appPath}/${controller}/${action}${parameters}" ${onclickEvent} title="${title}">
	<i class="${icon}"></i>
</a>