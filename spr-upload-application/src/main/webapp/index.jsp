<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <h1>Welcome To Struts 2!</h1>

    <p><a href="<s:url action='hello'/>">Hello World</a></p>

    <p><a href="produce.action">Produce JSON</a></p>
    <p><a href="consume.html">Consume JSON</a></p>

    <s:form action="helloUser">
        <s:textfield name="userName" label="Your name" />
        <s:submit value="Submit" />
    </s:form>

    </body>

</html>
