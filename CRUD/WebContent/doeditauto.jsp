<%@page import="cn.itlaobing.service.AutoService"%>
<%@page import="cn.itlaobing.model.AutoModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1：设置中文编码
request.setCharacterEncoding("utf-8");

//2:获取数据,验证数据
int id = Integer.parseInt(request.getParameter("id"));
String autotype=request.getParameter("autotype");
String pailiang=request.getParameter("pailiang");
double price=Double.parseDouble(request.getParameter("price"));

//3:封装数据
AutoModel model =new AutoModel();
model.setAutotype(autotype);
model.setPailiang(pailiang);
model.setPrice(price);
model.setId(id);
//4:调用业务
AutoService service =new AutoService();
service.update(model);
//5:重定向
response.sendRedirect("findall.jsp");
%>