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
<!-- Colour Schemes
Default colour scheme is blue. Uncomment prefered stylesheet to use it.
<link rel="stylesheet" href="${ctx}/css/brown.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="${ctx}/css/gray.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="${ctx}/css/green.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${ctx}/css/pink.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="${ctx}/css/red.css" type="text/css" media="screen" />
-->
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
	$('#jobInfo').dataTable();
	
	// validate signup form on keyup and submit
	var validator = $("#addJob").validate({
		rules: {
			job: {
				required:true,
			},
			questionNum: {
				required:true,
				digits: true, 
			}
		},
		messages: {
			job: {
				required:"请输入职务名称",
			},
			questionNum: {
				required:"请输入职务可以出题的最大数量",
				digits:"出题数量必须是整数"
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
	
	
	// validate signup form on keyup and submit
	var validator = $("#updateJob").validate({
		rules: {
			job: {
				required:true,
			},
			questionNum: {
				required:true,
				digits: true, 
			}
		},
		messages: {
			job: {
				required:"请输入职务名称",
			},
			questionNum: {
				required:"请输入职务可以出题的最大数量",
				digits:"出题数量必须是整数"
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

function showModifyJob(id,job,questionNum){
	$('#jobId').val(id);
	$('#jobName').val(job);
	$('#jobQuestionNum').val(questionNum);
	
	$('#modifyJob').show('slow');
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
			<h1>职务维护</h1>
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
					<h3>添加职务</h3>
					<form id="addJob" method="post" action="${ctx }/teacherManager/addJob.do">
	
						<fieldset>
							<legend>职务信息</legend>
	
							<p>
								<label class="required" for="jobNo">职务名称:</label><br/>
								<input type="text" class="half" name="job"/>
							</p>
	
							<p>
								<label class="required" for="name">出题数量:</label><br/>
								<input type="text" class="half" name="questionNum"/>
							</p>
							
							<p class=""><input type="submit" class="btn btn-green big" value="新 增"/> &nbsp;&nbsp;&nbsp; <input type="reset" class="btn" value="清除"/></p>
	
						</fieldset>
	
					</form>
				</section>
				<!-- End of Left column/section -->
		
				<!-- Left column/section -->
				<section id="modifyJob" style="display:none;" class="column width6 first">					
					<h3>修改职务</h3>
					<form id="updateJob" method="post" action="${ctx }/teacherManager/updateJob.do">
	
						<fieldset>
							<legend>职务信息</legend>
							<input type="hidden" id="jobId" name="id" />
							<p>
								<label class="required" for="jobNo">职务名称:</label><br/>
								<input type="text" id="jobName" class="half" name="job"/>
							</p>
	
							<p>
								<label class="required" for="name">出题数量:</label><br/>
								<input type="text" id="jobQuestionNum" class="half" name="questionNum"/>
							</p>
							
							<p class=""><input type="submit" class="btn btn-green big" value="修 改"/> &nbsp;&nbsp;&nbsp; <input onclick="$('#modifyJob').hide('slow')" type="reset" class="btn" value="取 消"/></p>
	
						</fieldset>
	
					</form>
				</section>
				<!-- End of Left column/section -->
		
				<!-- Left column/section -->
				<section class="column width8 first">					
					
					<table class="display stylized" id="jobInfo">
						<thead>
							<tr>
								<th>id</th>
								<th>职务</th>
								<th>出题数量</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${jobList }" var="job">
								<tr class="gradeA">
									<td>${job.id }</td>
									<td>${job.job }</td>
									<td>${job.questionNum }</td>
									<td>
										<a href="${ctx }/teacherManager/deleteJob.do?id=${job.id}">删除</a>
										&nbsp;
										<a href="javascript:void(0);" onclick="showModifyJob('${job.id}','${job.job }','${job.questionNum }')">修改</a>
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