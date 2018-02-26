<%@page import="services.TblKnowledgeService"%>
<%@page import="models.TblKnowledgeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//设置请求编码
request.setCharacterEncoding("utf-8");

//获取数据
String id =request.getParameter("id");
String title = request.getParameter("title");
String isPublish = request.getParameter("isPublish");
String[] fromNames = request.getParameterValues("fromName");
String typeId = request.getParameter("typeId");
String content = request.getParameter("content");

//构建知识来源
StringBuffer sb_fromName =new  StringBuffer();
for(int i=0;fromNames!=null && i<fromNames.length;i++){
	sb_fromName.append(fromNames[i]);
	sb_fromName.append("、");
}
String fromName = "";
if(sb_fromName.length()>0){
	fromName = sb_fromName.toString().substring(0,sb_fromName.toString().length()-1);
}

//数据验证（略）

//封装数据
TblKnowledgeModel model =new TblKnowledgeModel();
model.setId(Integer.parseInt(id));
model.setTitle(title);
model.setContent(content);
model.setIsPublish(Integer.parseInt( isPublish));
model.setFromName(fromName);
model.setTypeId(Integer.parseInt(typeId));

//修改知识业务
TblKnowledgeService service =new TblKnowledgeService();
int i = service.update(model);
if(i>0){
	response.sendRedirect(request.getContextPath()+"/list.jsp");
}else{
	response.sendRedirect(request.getContextPath()+"/add.jsp");
}
%>