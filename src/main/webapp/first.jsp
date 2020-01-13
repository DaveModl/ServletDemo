<%--
  Created by IntelliJ IDEA.
  User: 65788
  Date: 2020/1/8
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%--01:page
<%@ page lanuage="" import="" pageEnocding="" contentType="" seesion="" errorPage="" extends=""%>
--%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<h3>aaaa</h3>
<hr>
<%--02:JSP局部代码块--%>
<%
    String str = "bbbb";
    int a = 4;
    if (a > 5){
%>
<b>ccccccccc</b>
<%
    }else {
%>
<%--02:JSP脚本段语句--%>
<b><%=str%></b>
<%
        test();  }
%>
<%--02:JSP全局代码块--%>
<%!
    int b = 5;
    public void test(){
        System.out.println("test");
    }
%>

<%--    03静态引入:相对路径，在转译时会把静态文件和当前文件转译在一起
且不能用java代码块声明同名变量--%>
<%@include file="static.jsp" %>
<%--03动态引入：会同时编译，不会合并文件，是调用关系--%>
<jsp:include page="active.jsp"/>
<%--04forward:一次请求，请求转发--%>
<jsp:forward page="forward.jsp"/>
<%--05九大内置对象,jsp转译成servlet自动生成的--%>
<%--1.pageContext 页面上下文对象 可取到其他八个对象，一个jsp只有一个,当前页面 ，当前页面的共享数据--%>
<%--2.request请求对象信息--%>
<%--3.response响应信息对象--%>
<%--4.out输出对象--%>
<%--5.application-- servLetContext，项目内，不同用户数据的的共享问题%>
<%--6.session 一个用户的不同请求的共享数据 一次会话--%>
<%--7.page-- 当前jsp,this%>
<%--8.exception-- 异常对象，isErrorPage = “true”%>
<%--9.config-- 配置信息对象 web.xml或者注解，初始化数据%>
<%--06jsp路径问题--%>
<%--/服务器根目录,使用绝对路径--%>

</body>
</html>
