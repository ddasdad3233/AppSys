<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<fm:form method="post" modelAttribute="user">
		用户编码:<fm:input path="userCode" />
		用户名称:<fm:input path="userName" />
		用户密码:<fm:password path="userPassword" />
		<input type="submit" value="保存">
	</fm:form>
</body>
</html>
