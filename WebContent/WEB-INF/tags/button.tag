<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="label" required="true" type="java.lang.String" description="Button Label" %>
<%@ attribute name="controller" type="java.lang.String" description="Controller Name" %>
<%@ attribute name="action" type="java.lang.String" description="Action Name" %>
<%@ attribute name="submit" type="java.lang.Boolean" description="Button Submit?" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Classes" %>
<%@ attribute name="style" type="java.lang.String" description="HTML Style" %>
<%@ attribute name="onclick" type="java.lang.String" description="javascript event" %>

<c:choose>
	<c:when test="${not empty styleClass}">
		<c:set var="htmlClass" value="class='${styleClass}'"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlClass" value="class='btn'"/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not empty style}">
		<c:set var="htmlStyle" value="style='${style}'"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlStyle" value=""/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not empty onclick}">
		<c:set var="onclickEvent" value="onclick=\"${onclick}\""/>
	</c:when>
	<c:otherwise>
		<c:set var="onclickEvent" value=""/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not empty submit and submit}">
		<button ${htmlClass} ${htmlStyle} ${onclickEvent} type="submit">${label}</button>
	</c:when>
	<c:otherwise>
		<a href="${appPath}/${controller}/${action}" ${htmlClass} ${htmlStyle} ${onclickEvent}>${label}</a>
	</c:otherwise>
</c:choose>