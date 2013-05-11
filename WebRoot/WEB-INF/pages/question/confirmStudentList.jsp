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
	$('#studentInfo').dataTable();
	
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
			<h1>未确认选题的学生列表</h1>
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
					
					<table class="display stylized" id="studentInfo">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>学院</th>
								<th>专业</th>
								<th>大一</th>
								<th>大二</th>
								<th>大三</th>
								<th>大四</th>
								<th>总成绩</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${studentList }" var="student">
								<tr class="gradeA">
									<td>${student.studentNo }</td>
									<td>${student.name }</td>
									<td>
										<c:if test="${student.gender eq '0' }">女</c:if>
										<c:if test="${student.gender eq '1' }">男</c:if>
									</td>
									<td>${student.department }</td>
									<td>${student.major }</td>
									<td>${student.score1 }</td>
									<td>${student.score2 }</td>
									<td>${student.score3 }</td>
									<td>${student.score4 }</td>
									<td>${student.score1+student.score2+student.score3+student.score4 }</td>
									<td>
										<a href="${ctx }/question/confirmToStudent.do?id=${student.id}">确认给学生</a>
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