<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log in</title>
</head>
<body>
	<s:form action="SignIn_input" validate="true">
		<s:textfield label="User Name" name="user.username" required="true"
			value="admin" />
		<s:password label="Password" name="user.password" required="true" />
		<s:iterator value="errors">
			<s:property />
		</s:iterator>
		<s:submit value="Login" />
	</s:form>
</body>
</html>