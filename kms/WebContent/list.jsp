<%@page import="vo.TblKnowledgeVO"%>
<%@page import="java.util.List"%>
<%@page import="services.TblKnowledgeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");//编码统一
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>知识列表</title>
<style>
input{margin: 0;padding: 0;}
body{ font-family:微软雅黑; font-size:13px;}
table{ width:1000px; border-radius:10px; background-color:#ccc; }
td,th{ height:40px;}
td{background-color: #FFF;}
a{color: black;text-decoration: none;}
a:hover{color: red;}
</style>
</head>
<body>
<form action="list.jsp" method="get">
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="1" style="background-color:#FFF; ">
    <tbody>
    <tr>
      <td align="right"><a href="count.jsp">数据统计</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="add.jsp">添加知识</a>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="key" value="<%=request.getParameter("key")==null?"":new String( request.getParameter("key").getBytes("iso-8859-1"),"utf-8") %>" style="width: 500px; border:1px solid #999; height: 24px; line-height: 24px;" /></td>
      <td align="center" width="100"><input type="submit" value=" 搜 索 "  style="width:100px; height: 26px; border: 1px solid #999"/></td>
    </tr>
    </tbody>
</table>
</form>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="1">
  <caption>知识列表</caption>
    <thead>
    <tr>
      <th align="center" width="40">编号</th>
      <th align="center">标题</th>
      <th align="center" width="80">是否发布</th>
      <th align="center" width="150">知识来源</th>
      <th align="center" width="120">知识类别</th>
      <th align="center" width="150">创建日期</th>
      <th align="center" width="50">编辑</th>
      <th align="center" width="50">删除</th>
      <th align="center" width="50">详细</th>
    </tr>
    </thead>
    <tbody>
    <%
        //获取知识列表
        TblKnowledgeService service =new TblKnowledgeService();
        List<TblKnowledgeVO> list =null;
        if(request.getParameter("key")!=null && !request.getParameter("key").equals("")){
        	String key = new String(request.getParameter("key").getBytes("iso-8859-1"),"utf-8");
        	list = service.list(" and title like '%"+ key +"%'");        	
        }else{
        	list = service.list();
        }
        
        if(list!=null && list.size()>0){
    	    for(int i=0;i<list.size();i++){
    %>
	    <tr>
	      <td align="center"><%=(i+1) %></td>
	      <td align="left"><%=list.get(i).getKnowledgeModel().getTitle()%></td>
	      <td align="center"><%=list.get(i).getKnowledgeModel().getIsPublish()==0?"发布":"停止"%></td>
	      <td align="center"><%=list.get(i).getKnowledgeModel().getFromName()%></td>
	      <td align="center"><%=list.get(i).getTypeModel().getTypeName()%></td>
	      <td align="center"><%=list.get(i).getKnowledgeModel().getCreateDate()%></td>
	      <td align="center"><a href="edit.jsp?id=<%=list.get(i).getKnowledgeModel().getId()%>">编辑</a></td>
	      <td align="center"><a href="delete.jsp?id=<%=list.get(i).getKnowledgeModel().getId()%>" onclick="javascript:return confirm('确认删除吗？')">删除</a></td>
	      <td align="center"><a href="detail.jsp?id=<%=list.get(i).getKnowledgeModel().getId()%>">详细</a></td>
	    </tr>
    <%
         } 
     }
    %>
    </tbody>
    <tfoot>
    <tr>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
    </tr>
    </tfoot>
  </table>
</body>
</html>