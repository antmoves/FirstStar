<%@page import="java.awt.dnd.Autoscroll"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="cn.itlaobing.model.AutoModel"%>
<%@page import="java.util.List"%>
<%@page import="cn.itlaobing.service.AutoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有的车辆信息</title>
<style>
table{ background-color:#CCC;}
td{ background-color:#FFF; font-size:18px; font-family:微软雅黑;}
</style>
</head>
<body>
<%
//获取所有的车辆信息
AutoService service=new AutoService();
List<AutoModel> list = service.findAll();
//表格显示车辆信息

%>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
  <tr>
    <td height="30" align="center">序号</td>
    <td align="center">车牌号</td>
    <td align="center">类型</td>
    <td align="center">价格</td>
    <td align="center">编辑</td>
    <td align="center">删除</td>
    <td align="center">查看</td>
  </tr>
  <%
  if(list!=null && list.size()>0){
	  NumberFormat nf = NumberFormat.getCurrencyInstance();
	  for(int i=0;i<list.size();i++){
  %>
  <tr>
    <td height="30" align="center"><%=(i+1) %></td>
    <td align="center"><%=list.get(i).getAutono() %></td>
    <td align="center"><%=list.get(i).getAutotype() %></td>
    <td align="center"><%=nf.format(list.get(i).getPrice()) %></td>
    <td align="center"><a href="editauto.jsp?id=<%=list.get(i).getId()%>">编辑</a></td>
    <td align="center"><a href="deleteauto.jsp?id=<%=list.get(i).getId()%>" onClick="javascript:return confirm('A U Sure?')">删除</a></td>
    <td align="center"><a href="detailauto.jsp?id=<%=list.get(i).getId()%>">查看</a></td>
  </tr>
  <%
	  }
  }else{
  %>
  <tr>
    <td height="30" colspan="7" align="center">还没有车辆信息</td>
  </tr>
  <%} %>
</table>
</body>
</html>