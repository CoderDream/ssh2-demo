<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<html>
<head>
<decorator:head />
<title>程序员之家 - <decorator:title default="Welcome you!" /></title>
</head>
<body>
	<center>
		<h3>这是应用了装饰页面后的显示效果</h3>
		<strong><decorator:body /></strong>
	</center>
</body>
</html>