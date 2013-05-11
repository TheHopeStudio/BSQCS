<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<!-- datepicker -->
<link rel="stylesheet" href="${ctx}/css/datePicker.css" type="text/css" />

<style type="text/css">
/* located in demo.css and creates a little calendar icon
 * instead of a text link for "Choose date"
 */
a.dp-choose-date {
	float: left;
	width: 16px;
	height: 16px;
	padding: 0;
	margin: 5px 3px 0;
	display: block;
	text-indent: -2000px;
	overflow: hidden;
	background: url(${ctx}/img/calendar.png) no-repeat; 
}
a.dp-choose-date.dp-disabled {
	background-position: 0 -20px;
	cursor: default;
}
/* makes the input field shorter once the date picker code
 * has run (to allow space for the calendar icon
 */
input.dp-applied {
	width: 140px;
	float: left;
}
</style>

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
<!-- datepicker -->
<script type="text/javascript" src="${ctx}/js/date.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.datePicker.js"></script>
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
	Date.format = 'yyyy-mm-dd';
	$('.date-pick').datePicker();
	
	
	// validate signup form on keyup and submit
	var validator = $("#newChoosingTimeForm").validate({
		rules: {
			name: {
				required:true
			},
			startTime: {
				required:true
			},
			endTime:  {
				required:true
			}
		},
		messages: {
			name: {
				required:"请输入名称"
			},
			startTime: {
				required:"请选择开始时间"
			},
			endTime: {
				required:"请选择结束时间"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
	
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
			<h1>选题时间管理</h1>
			<!-- Quick search box -->
		</div>
	</div>
	<!-- End of Page title -->
	
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
				<!-- Left column/section -->
				<section class="column width6 first">
				
					<form id="newChoosingTimeForm" method="post" action="${ctx }/question/addChoosingTime.do">

						<fieldset>
							<legend>添加选题时间</legend>

							<p>
								<label class="required" for="firstname">名称:</label><br/>
								<input type="text" class="half" value="" name="name"/>
							</p>

							<p>
								<label class="required" for="lastname">开始时间:</label><br/>
								<input type="text" class="quarter date-pick dp-applied" value="" name="startTime"/><br/>
							</p>

							<p>
								<label class="required" for="username">结束时间:</label><br/>
								<input type="text" class="quarter date-pick dp-applied" value="" name="endTime"/><br/>
							</p>
							
							<p class="box"><input type="submit" class="btn btn-green" value="提 交"/> &nbsp; <input type="reset" class="btn" value="清 除"/></p>

						</fieldset>

					</form>
					
					<div class="clear">&nbsp;</div>
					<h3>选题时间列表</h3>
					
					<table class="display stylized" id="questionInfo">
						<thead>
							<tr>
								<th>名称</th>
								<th>开始时间</th>
								<th>结束时间</th>
<!-- 								<th>状态</th> -->
								<th>操作</th>
							</tr>
						</thead>
						<fmt:setLocale value="zh_CN"/> 
						<tbody>
							<c:forEach items="${choosingTimeList }" var="choosingTime">
								<tr class="gradeA">
									<td>${choosingTime.name }</td>
									<td><fmt:formatDate value="${choosingTime.startTime }" type="date"/></td>
									<td><fmt:formatDate value="${choosingTime.endTime }" type="date"/></td>
<!-- 									<td> -->
<%-- 										<c:if test="${choosingTime.state ea'1' }">有效</c:if> --%>
<%-- 										<c:if test="${choosingTime.state ea'0' }">无效</c:if> --%>
<!-- 									</td> -->
									<td>
										<a href="${ctx }/question/deleteChoosingTime.do?id=${choosingTime.id}">删除</a>
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