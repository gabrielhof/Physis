<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="Label" %>
<%@ attribute name="type" required="true" type="java.lang.String" description="HTML Field Type" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Class" %>
<%@ attribute name="style" type="java.lang.String" description="CSS Style" %>
<%@ attribute name="required" type="java.lang.Boolean" description="Is field required?" %>
<%@ attribute name="readonly" type="java.lang.Boolean" description="Is field enabled?" %>
<%@ attribute name="column" type="java.lang.Integer" description="Column Span" %>
<%@ attribute name="mask" type="java.lang.String" description="Mask" %>

<c:if test="${empty column}">
	<c:set var="column" value="4"/>
</c:if>


<div class="span${column} control-group">
	<label class="control-label" for="${id}">${label}:${not empty required and required ? "<span class='red'>*</span>" : ''}</label>
	<div class="controls">
		<f:input type="${type}" id="${id}" value="${value}" placeholder="${label}" styleClass="${styleClass}" style="${style}" required="${required}" readonly="${readonly}" mask="${mask}" />
	</div>
</div>