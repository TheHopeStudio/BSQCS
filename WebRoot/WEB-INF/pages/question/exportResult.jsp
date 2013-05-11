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
<!-- datepicker -->
<link rel="stylesheet" href="${ctx}/css/datePicker.css" type="text/css" />
<!-- datepicker -->
<script type="text/javascript" src="${ctx}/js/date.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.datePicker.js"></script>

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
	/* datePicker */
	Date.format = 'yyyy-mm-dd';
	$('.date-pick').datePicker({
			startDate: '1970-01-01',
			endDate: (new Date()).asString()
	});
	
	/* expandable rows */
	Administry.expandableRows();
});

function exportExcel(){
	var start = $('#startTime').val();
	var end = $('#endTime').val();
	var url = "${ctx}/question/exportResult.do";
	var param = {startTime:start,endTime:end};
	$.ajax({
		url:url,
		async:true,
		type:"post",
		data:param
	});
	
}

</script>
</head>
<body>
	<!-- Header -->
	<%@include file="/WEB-INF/pages/common/headder.jsp" %>
	<!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>查询选题结果</h1>
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

						<form id="chooseResultForm" method="post" action="${ctx }/question/queryResult.do">

						<fieldset>
							<legend>查询时间段</legend>

							<p>
								<label class="required" for="lastname">开始时间:</label><br/>
								<input type="text" id="startTime" class="quarter date-pick dp-applied" value="${startTime }" name="startTime"/><br/>
							</p>

							<p>
								<label class="required" for="username">结束时间:</label><br/>
								<input type="text" id="endTime" class="quarter date-pick dp-applied" value="${endTime }" name="endTime"/><br/>
							</p>
							
							<p class="box">
								<input type="submit" class="btn btn-green" value="查 询"/> 
								&nbsp; &nbsp; 
								<input type="button" class="btn btn-green" onclick="exportExcel();" value="导 出"/>
								&nbsp; &nbsp; 
								<input type="reset" class="btn" value="清 除"/>
							</p>

						</fieldset>
					</form>
					<div class="clear">&nbsp;</div>
				</section>
				<!-- End of Left column/section -->
		
				<!-- Left column/section -->
				<section class="column width8 first">					
					
					<table class="display stylized" id="questionInfo">
						<thead>
							<tr>
								<th>学生名</th>
								<th>联系电话</th>
								<th>标题</th>
								<th>选题说明</th>
								<th>题目正文</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${questionList }" var="question">
								<tr class="gradeA">
									<td>${question.student.name }</td>
									<td>${question.student.telphone }</td>
									<td>${question.title }</td>
									<td>${question.remark }</td>
									<td>${question.content }</td>
								</tr>
							</c:forEach>
						</tbody>
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