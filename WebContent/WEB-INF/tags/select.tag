<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="HTML Id" %>
<%@ attribute name="enumClass" type="java.lang.String" description="Enum Class" %>
<%@ attribute name="beans" type="java.util.Collection" description="Bean List" %>
<%@ attribute name="value" type="java.lang.String" description="HTML Value" %>
<%@ attribute name="styleClass" type="java.lang.String" description="HTML Class" %>
<%@ attribute name="style" type="java.lang.String" description="CSS Style" %>
<%@ attribute name="required" type="java.lang.Boolean" description="Is field required?" %>
<%@ attribute name="readonly" type="java.lang.Boolean" description="Is field enabled?" %>

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

<select id="${id}" name="${id}" ${htmlClass} ${htmlStyle} ${htmlRequired} ${htmlReadonly} >
	<option value="" selected="selected">Selecione</option>

	<c:choose>
		<c:when test="${not empty enumClass}">
			<c:set var="options" value="${f:getEnumValues(enumClass)}"/>
		
			<c:forEach items="${options}" var="option">
				<c:choose>
					<c:when test="${option.value eq value}">
						<option value="${option.value}" selected="selected">${option.toString()}</option>
					</c:when>
					<c:otherwise>
						<option value="${option.value}">${option.toString()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:when test="${not empty beans}">
			<c:forEach items="${beans}" var="bean">
				<c:choose>
					<c:when test="${bean.id eq value}">
						<option value="${bean.id}" selected="selected">${bean.toUserString()}</option>
					</c:when>
					<c:otherwise>
						<option value="${bean.id}">${bean.toUserString()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
	</c:choose>
</select>