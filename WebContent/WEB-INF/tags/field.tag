<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="type" required="true" type="java.lang.String" description="HTML Field Type" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="HTML Label" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>

<div class="control-group">
	<label class="control-label" for="${id}">${label}</label>
	<div class="controls">
		<input type="${type}" id="${id}" name="${id}" value="${value}" />
	</div>
</div>