<%@page import="vo.TblKnowledgeVO"%>
<%@page import="java.util.List"%>
<%@page import="services.TblKnowledgeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
TblKnowledgeService service =new TblKnowledgeService();
TblKnowledgeVO vo = service.findVOById(Integer.parseInt(id));
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>知识详细内容</title>
<style>
body{ background-color:#EBEBEB; font-family:微软雅黑; font-size:13px;}
table{ width:500px; border-radius:10px; background-color:white; }
td{ height:40px;}
</style>
</head>
<body>
<table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
   <caption>知识详细内容 </caption>
    <tr>
      <td width="100" align="right">知识标题：</td>
      <td><%=vo.getKnowledgeModel().getTitle() %></td>
    </tr>
    <tr>
      <td align="right">是否发布： </td>
      <td><%=vo.getKnowledgeModel().getIsPublish()==0?"发布":"停止"%></td>
    </tr>
    <tr>
      <td align="right">知识来源：</td>
      <td><%=vo.getKnowledgeModel().getFromName() %></td>
    </tr>
    <tr>
      <td align="right">知识类别：</td>
      <td><%=vo.getTypeModel().getTypeName() %></td>
    </tr>
    <tr>
      <td align="right">知识内容：</td>
      <td><%=vo.getKnowledgeModel().getContent() %></td>
    </tr>
  </table>
</body>
</html>


