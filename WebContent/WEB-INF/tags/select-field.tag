<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="enumClass" required="true" type="java.lang.String" description="Enum Class" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="Label" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Class" %>
<%@ attribute name="style" type="java.lang.String" description="CSS Style" %>
<%@ attribute name="required" type="java.lang.Boolean" description="Is field required?" %>
<%@ attribute name="readonly" type="java.lang.Boolean" description="Is field enabled?" %>

<div class="control-group">
	<div class="span4">
		<label class="control-label" for="${id}">${label}:${not empty required and required ? "<span class='red'>*</span>" : ''}</label>
		<div class="controls">
			<f:select enumClass="${enumClass}" id="${id}" value="${value}" styleClass="${styleClass}" style="${style}" required="${required}" readonly="${readonly}" />
		</div>
	</div>
</div>