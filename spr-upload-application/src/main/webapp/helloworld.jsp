<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/29
  Time: 22:34
  To change this template use File | Settings | File Templates.
  helloworld测试页面
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Hello World!</title>
</head>

<body>
<h2><s:property value="messageStore.message" /></h2>
</body>
</html>
