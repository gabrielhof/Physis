<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="title" required="true" type="java.lang.String" description="Fieldset Legend" %>

<fieldset>
	<legend>${title}</legend>
	<jsp:doBody />
</fieldset>