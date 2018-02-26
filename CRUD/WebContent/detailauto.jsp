<%@page import="java.text.NumberFormat"%>
<%@page import="cn.itlaobing.model.AutoModel"%>
<%@page import="cn.itlaobing.service.AutoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆详细信息</title>
</head>
<body>
<%
//1:获取要显示的车辆信息
int id = Integer.parseInt(request.getParameter("id"));
AutoService service =new AutoService();
AutoModel model = service.findById(id);
//2：显示车辆信息
NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
车牌号:<%=model.getAutono() %><br />
类型:<%=model.getAutotype() %><br />
排量:<%=model.getPailiang() %><br />
价格:<%=nf.format(model.getPrice()) %><br />

</body>
</html>