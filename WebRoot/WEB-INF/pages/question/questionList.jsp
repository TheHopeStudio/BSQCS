<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- common properties difine -->
<%@include file="/WEB-INF/pages/common/commonProperties.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Question Choosing System</title>
<meta name="description" content="Administry - Admin Template by www.865171.cn" />
<meta name="keywords" content="Admin,Template" />
<!-- Favicons --> 
<link rel="shortcut icon" type="image/png" href="${ctx}/img/favicons/favicon.png"/>
<link rel="icon" type="image/png" href="${ctx}/img/favicons/favicon.png"/>
<link rel="apple-touch-icon" href="${ctx}/img/favicons/apple.png" />
<!-- Main Stylesheet --> 
<link rel="stylesheet" href="${ctx}/css/style.css" type="text/css" />
<!-- Your Custom Stylesheet --> 
<link rel="stylesheet" href="${ctx}/css/custom.css" type="text/css" />
<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" src="${ctx}/js/swfobject.js"></script>
<!-- jQuery with plugins -->
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.min.js"></script>
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" src="${ctx}/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.ui.widget.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.ui.tabs.min.js"></script>
<!-- jQuery tooltips -->
<script type="text/javascript" src="${ctx}/js/jquery.tipTip.min.js"></script>
<!-- Superfish navigation -->
<script type="text/javascript" src="${ctx}/js/jquery.superfish.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.supersubs.min.js"></script>
<!-- jQuery form validation -->
<script type="text/javascript" src="${ctx}/js/jquery.validate_pack.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" src="${ctx}/js/jquery.nyroModal.pack.js"></script>
<!-- jQuery data tables -->
<script type="text/javascript" src="${ctx}/js/jquery.dataTables.min.js"></script>
<!-- Internet Explorer Fixes --> 
<!--[if IE]>
<link rel="stylesheet" type="text/css" media="all" href="${ctx}/css/ie.css"/>
<script src="${ctx}/js/html5.js"></script>
<![endif]-->
<!--Upgrade MSIE5.5-7 to be compatible with MSIE8: http://ie7-js.googlecode.com/svn/version/2.1(beta3)/IE8.js -->
<!--[if lt IE 8]>
<script src="${ctx}/js/IE8.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	/* datatable */
	$('#questionInfo').dataTable();
	
	/* expandable rows */
	Administry.expandableRows();
});

</script>
</head>
<body>
	<!-- Header -->
	<%@include file="/WEB-INF/pages/common/headder.jsp" %>
	<!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>我的题目</h1>
			<!-- Quick search box -->
		</div>
	</div>
	<!-- End of Page title -->
	
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
				<!-- Left column/section -->
				<section class="column width8 first">					
					<h3>题目列表</h3>
					
					<table class="display stylized" id="questionInfo">
						<thead>
							<tr>
								<th>标题</th>
								<th>选题说明</th>
								<th>题目正文</th>
								<th>审批状态</th>
								<th>是否已被选择</th>
								<th>学生ID</th>
								<th>学生名</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${questionList }" var="question">
								<tr class="gradeA">
									<td>${question.title }</td>
									<td>${question.remark }</td>
									<td>${question.content }</td>
									<td>
										<c:if test="${question.state eq '0' }">审批中</c:if>
										<c:if test="${question.state eq '1' }">通过</c:if>
										<c:if test="${question.state eq '2' }">未通过</c:if>
									</td>
									<td>
										<c:if test="${question.live }">否</c:if>
										<c:if test="${not question.live }">是</c:if>
									</td>
									<td>${question.student.id }</td>
									<td>${question.student.name }</td>
									<td>
										<c:if test="${question.state ne '1' }">
<!-- 										未通过状态能够修改和删除 -->
											<a href="${ctx }/question/deleteQuestion.do?id=${question.id}">删除</a>
											&nbsp;&nbsp;
											<a href="${ctx }/question/toUpdateQuestion.do?id=${question.id}">修改</a>
										</c:if>
										<c:if test="${question.state eq '1'}">
											<c:if test="${question.live }">
<!-- 											通过状态可以确认给某1个学生-->
												<a href="${ctx }/question/confirm.do?id=${question.id}">确认给学生</a>
												&nbsp;&nbsp;
											</c:if>
											<a href="${ctx }/question/showSelectionStudent.do?id=${question.id}">查看选题学生</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tfoot>
					</table>
					
					<div class="clear">&nbsp;</div>
					
				</section>
				<!-- End of Left column/section -->
				
		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	
	<!-- Page footer -->
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	<!-- End of Page footer -->

<!-- Admin template javascript load -->
<script type="text/javascript" src="${ctx}/js/administry.js"></script>
</body>
</html>