<%@page import="models.TblFromModel"%>
<%@page import="services.TblFromService"%>
<%@page import="models.TblTypeModel"%>
<%@page import="services.TblTypeService"%>
<%@page import="models.TblKnowledgeModel"%>
<%@page import="java.util.List"%>
<%@page import="services.TblKnowledgeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//获取要编辑知识条目实体
String id = request.getParameter("id");
TblKnowledgeService service =new TblKnowledgeService();
TblKnowledgeModel model = service.findById(Integer.parseInt(id));
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>编辑知识</title>
<style>
body{ background-color:#EBEBEB; font-family:微软雅黑; font-size:13px;}
table{ width:500px; border-radius:10px; background-color:white; }
td{ height:40px;}
</style>
</head>

<body>
<form name="form1" method="post" action="${pageContext.request.contextPath }/doedit.jsp">
  <input type="hidden" name="id" value="<%=model.getId()%>">
  <table width="600" border="0" cellspacing="0" cellpadding="0" align="center">
   <caption>编辑知识 </caption>
    <tr>
      <td width="100" align="right">知识标题：</td>
      <td><input type="text" name="title" id="title" value="<%=model.getTitle()%>"></td>
    </tr>
    <tr>
      <td align="right">是否发布： </td>
      <td><input type="radio" name="isPublish" id="radio" value="0" <% if(model.getIsPublish()==0){ %> checked="checked" <%} %>>
发布&nbsp;
<input type="radio" name="isPublish" id="radio" value="1" <% if(model.getIsPublish()!=0){ %> checked="checked" <%} %>>
停止</td>
    </tr>
    <tr>
      <td align="right">知识来源：</td>
      <td>
      <%
        //加载知识来源
        TblFromService fromService =new TblFromService();
        List<TblFromModel> fromModels = fromService.findAll();
        if(fromModels!=null && fromModels.size()>0){
        	for(int i = 0;i<fromModels.size();i++){
      %>
               <input name="fromName" type="checkbox" id="fromName" value="<%=fromModels.get(i).getFromName()%>" <% if(model.getFromName().contains(fromModels.get(i).getFromName())){ %> checked="checked" <%} %>><%=fromModels.get(i).getFromName()%>&nbsp;
      <%
        	}
        }
      %>
        
      </td>
    </tr>
    <tr>
      <td align="right">知识类别：</td>
      <td>
        <select name="typeId" id="typeId">
        <%
	    //加载知识类别
	    TblTypeService typeService =new TblTypeService();
	    List<TblTypeModel> typeModels = typeService.findAll();
	    if(typeModels!=null && typeModels.size()>0){
	    	for(int i = 0;i<typeModels.size();i++){
	    %>
	        <option value="<%=typeModels.get(i).getId()%>" <% if(model.getTypeId()==typeModels.get(i).getId()){ %> selected <%} %>><%=typeModels.get(i).getTypeName()%></option>
	    <%
	    	} 
	    }
	    %>
        </select>
      </td>
    </tr>
    <tr>
      <td align="right">知识内容：</td>
      <td><textarea name="content" cols="55" rows="5" id="content"><%=model.getContent()%></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="button" id="button" value="修改知识"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>
    