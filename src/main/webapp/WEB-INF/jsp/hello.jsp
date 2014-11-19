<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
	Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello</title>
</head>
<body>
	Hello JSP
	<br>
	<s:if test="#session.user!=null">
		<h2>
			From Session: Hello
			<s:property value="#session.user.username" />
		</h2>
	</s:if>
	<br>
	<s:if test="#request.user!=null">
		<h2>
			From Request: Hello
			<s:property value="#session.user.username" />
		</h2>
	</s:if>
</body>
</html>