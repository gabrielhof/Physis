<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="type" required="true" type="java.lang.String" description="HTML Field Type" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Class" %>
<%@ attribute name="style" type="java.lang.String" description="CSS Style" %>
<%@ attribute name="placeholder" type="java.lang.String" description="Field Placeholder" %>
<%@ attribute name="required" type="java.lang.Boolean" description="Is field required?" %>
<%@ attribute name="readonly" type="java.lang.Boolean" description="Is field enabled?" %>
<%@ attribute name="mask" type="java.lang.String" description="Mask" %>

<c:choose>
	<c:when test="${type eq 'date'}">
		<c:set var="styleClass" value="date ${styleClass}"/>
		<c:set var="type" value="text"/>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty styleClass}">
		<c:set var="htmlClass" value="class='${styleClass}'"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlClass" value=""/>
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
	<c:when test="${not empty required and required}">
		<c:set var="htmlRequired" value="required='required'"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlRequired" value=""/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not empty readonly and readonly}">
		<c:set var="htmlReadonly" value="readonly"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlReadonly" value=""/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not empty mask}">
		<c:set var="htmlMask" value="mask='${mask}'"/>
	</c:when>
	<c:otherwise>
		<c:set var="htmlMask" value=""/>
	</c:otherwise>
</c:choose>

<input type="${type}" id="${id}" name="${id}" value="${value}" placeholder="${placeholder}" ${htmlClass} ${htmlStyle} ${htmlRequired} ${htmlReadonly} ${htmlMask}/>
