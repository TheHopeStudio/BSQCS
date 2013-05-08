<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- common properties difine -->
<%@include file="/WEB-INF/pages/common/commonProperties.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header id="top">
	<div class="wrapper">
		<!-- Title/Logo - can use text instead of image -->
		<div id="title"><img src="${ctx}/img/logo.png" alt="Administry" /><!--<span>Administry</span> demo--></div>
		<!-- Top navigation -->
		<div id="topnav">
			你好 ！<b>${sessionScope.login_user.username }</b>
			<span>|</span> <a href="${ctx }/user/logout.do">注销</a><br />
		</div>
		<!-- End of Top navigation -->
		<!-- Main navigation -->
		<nav id="menu">
			<ul class="sf-menu">
			
				<c:if test="${sessionScope.login_user.type eq '2' }">
<!-- 					显示管理员菜单 -->
					<c:set scope="request" var="menus" value="${applicationScope.managerMenus }" />
				</c:if>
				
				<c:if test="${sessionScope.login_user.type eq '1' }">
<!-- 					显示学生菜单 -->
					<c:set scope="request" var="menus" value="${applicationScope.studentMenus }" />
				</c:if>
			
				<c:if test="${sessionScope.login_user.type eq '0' }">
<!-- 					显示教师菜单 -->
					<c:set scope="request" var="menus" value="${applicationScope.teacherMenus }" />
				</c:if>
				
				<c:forEach items="${requestScope.menus }" var="menu">
						<c:choose>
							<c:when test="${not empty menu.subMenus }">
								<c:if test="${fn:contains(requestScope.uri,menu.uri) }">
									<li class="current">
								</c:if>
								<c:if test="${not fn:contains(requestScope.uri,menu.uri) }">
									<li>
								</c:if>
									<a href="javascript:void(0);">${menu.title }</a>
									<ul>
									<c:forEach items="${menu.subMenus }" var="subMenu">
										<li>
											<a href="${ctx }${subMenu.uri }">${subMenu.title }</a>
										</li>
									</c:forEach>
									</ul>
								</li>
							</c:when>
							<c:otherwise>
									<c:if test="${fn:contains(requestScope.uri,menu.uri) }">
										<li class="current"><a href="${ctx }${menu.uri }">${menu.title }</a></li>
									</c:if>
									<c:if test="${not fn:contains(requestScope.uri,menu.uri) }">
										<li><a href="${ctx }${menu.uri }">${menu.title }</a></li>
									</c:if>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</ul>
		</nav>
		<!-- End of Main navigation -->
	</div>
</header>