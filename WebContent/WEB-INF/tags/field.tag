<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>
<%@ tag dynamic-attributes="dynattrs" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="type" required="true" type="java.lang.String" description="HTML Field Type" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="HTML Label" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Class" %>
<%@ attribute name="style" type="java.lang.String" description="CSS Style" %>
<%@ attribute name="required" type="java.lang.Boolean" description="Is field required?" %>
<%@ attribute name="readonly" type="java.lang.Boolean" description="Is field enabled?" %>
<%@ attribute name="mask" type="java.lang.String" description="Mask" %>

<div class="control-group">
	<div class="span4">
		<label class="control-label" for="${id}">${label}:${not empty required and required ? "<span class='red'>*</span>" : ''}</label>
		<div class="controls">
			<f:input id="${id}" type="${type}" value="${value}" placeholder="${label}" styleClass="${styleClass}" style="${style}" required="${required}" readonly="${readonly}" mask="${mask}"/>
		</div>
	</div>
</div>