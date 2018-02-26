<%@page import="cn.itlaobing.model.AutoModel"%>
<%@page import="cn.itlaobing.service.AutoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑车辆</title>
</head>
<body>
<%
//1:后期要修改的车辆的主键
int id = Integer.parseInt(request.getParameter("id"));
//2:到数据库中查询要修改的车辆的原始信息，将这些信息显示在表单中，用户在表单中修改车辆信息
AutoService service = new AutoService();
AutoModel model = service.findById(id);
//3:用户修改完后，点击更新按钮，更新数据

%>
<form action="doeditauto.jsp" method="post">
<input type="hidden" name="id" value="<%=model.getId() %>">
车辆类型<input type="text" name="autotype" value="<%=model.getAutotype() %>" /><br />
排量<input type="text" name="pailiang" value="<%=model.getPailiang() %>"/><br />
价格<input type="text" name="price" value="<%=model.getPrice() %>"/><br />
<input type="submit" value="更新" /><br />
</form>

</body>
</html>