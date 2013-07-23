<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>

<table class="table table-hover table-striped" id="${id}">
	<jsp:doBody />
</table>