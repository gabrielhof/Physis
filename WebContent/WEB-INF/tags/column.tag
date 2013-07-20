<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="property" required="true" type="java.util.String" description="Value" %>

<c:set var="htmlId" value="${empty id ? \"\" : \"id='${id}'\"}"></c:set>

<td ${htmlId}>${bean.property}</td>