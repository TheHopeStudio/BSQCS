<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加一给新客户</title>
</head>
<body>
	<form action="newCustomer.do" method="post">
		<table>
			<tr>
				<td>企业名</td>
				<td><input name="enterprise.name" /></td>
			</tr>
			<tr>
				<td>企业地址</td>
				<td><input name="enterprise.address" /></td>
			</tr>
			<tr>
				<td>企业电话</td>
				<td><input name="enterprise.tel" /></td>
			</tr>
			
			<tr>
				<td>用户名</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					男:<input type="radio" value="1" name="gender" checked="checked"/>
					女:<input type="radio" value="0" name="gender"/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input name="mobile" /></td>
			</tr>
		</table>
		<input type="submit" value="提交" />
	</form>
</body>
</html>