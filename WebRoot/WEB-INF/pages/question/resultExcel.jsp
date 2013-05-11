<%@ page contentType="application/vnd.ms-excel;charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition", "attachment;filename=选题结果.xls"); 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<table>
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
</body>
</html>