<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="nav-collapse collapse">
	<ul class="nav">
		<c:if test="${not empty menu}">
			<c:forEach items="${menu.menus}" var="parentMenu">
				<c:if test="${parentMenu.role.any || user.role eq parentMenu.role}">
					<c:choose>
						<c:when test="${empty parentMenu.menus}">
							<li><a href="${appPath}/${parentMenu.url}">${parentMenu.name}</a></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown">
								<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">${parentMenu.name} <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<c:forEach items="${parentMenu.menus}" var="childMenu">
										<c:if test="${childMenu.role.any || user.role eq childMenu.role}">
											<li><a href="${appPath}/${childMenu.url}">${childMenu.name}</a></li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
		</c:if>
	</ul>
</div>