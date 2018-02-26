<%@page import="services.TblKnowledgeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//获取数据
String id = request.getParameter("id");

//删除知识业务
TblKnowledgeService service =new TblKnowledgeService();
int i = service.delete(Integer.parseInt(id));
if(i>0){
	response.sendRedirect(request.getContextPath()+"/list.jsp");
}else{
	response.sendRedirect(request.getContextPath()+"/edit.jsp?id="+id);
}
%>