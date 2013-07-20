<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="when" required="true" type="java.lang.Boolean" description="When test" %>
<%@ attribute name="then" type="java.lang.String" description="Then String" %>
<%@ attribute name="otherwise" type="java.lang.String" description="Otherwise String" %>

<c:choose>
	<c:when test="${when}">
		${then}
	</c:when>
	<c:otherwise>
		${otherwise}
	</c:otherwise>
</c:choose>
