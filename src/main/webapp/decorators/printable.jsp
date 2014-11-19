<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<html>
<head>
<title><decorator:title default="Welcome you!" /></title>
<decorator:head />
</head>

<body onload="window.print();">
	打印时间：
	<%=new java.util.Date()%>。
	<br />
	<hr noshade="noshade" size="1" />
	<br />
	<decorator:body />
</body>
</html>