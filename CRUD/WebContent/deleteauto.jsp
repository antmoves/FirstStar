<%@page import="cn.itlaobing.service.AutoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//获取要删除车辆的主键，从url获取
int id = Integer.parseInt(request.getParameter("id"));
//调用业务删除车辆
AutoService service =new AutoService();
int i=service.delete(id);
//重定向
response.sendRedirect("findall.jsp");
%>