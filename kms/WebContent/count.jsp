<%@page import="vo.TblTypeCountVO"%>
<%@page import="java.util.List"%>
<%@page import="services.TblKnowledgeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>知识详细内容</title>
<style>
body{ background-color:#EBEBEB; font-family:微软雅黑; font-size:13px;}
table{  border-radius:10px; background-color:white; }
td,th{ height:40px;}
th{ background-color: #ccc;}
</style>
</head>
<body>
<table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
   <caption>统计数据</caption>
    <tr>
      <th align="center">类别名称</th>
      <th align="center">数量</th>
    </tr>
    <%
    TblKnowledgeService service =new TblKnowledgeService();
    List<TblTypeCountVO> list = service.counted();
    if(list!=null && list.size()>0){
    	for(int i=0;i<list.size();i++){
    %>
    <tr>
      <td align="center"><%=list.get(i).getTypeName() %></td>
      <td align="center"><%=list.get(i).getCount() %></td>
    </tr>
    <%
    	}
    }
    %>
  </table>
</body>
</html>
