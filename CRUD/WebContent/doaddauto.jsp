<%@page import="cn.itlaobing.service.AutoService"%>
<%@page import="cn.itlaobing.model.AutoModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//1:设置请求编码
request.setCharacterEncoding("UTF-8");
//2:获取数据
String autono=request.getParameter("autono");
String autotype=request.getParameter("autotype");
String pailiang=request.getParameter("pailiang");
String price=request.getParameter("price");
double p = Double.parseDouble(price);
//3:数据验证
//不验证了
//4:封装数据
AutoModel model =new AutoModel();
model.setAutono(autono);
model.setAutotype(autotype);
model.setPailiang(pailiang);
model.setPrice(p);

//5:调用业务
AutoService service =new AutoService();
int i = service.save(model);

//6:重定向
if(i==-1){
	//车牌已存在继续返回添加车辆信息填写处
	response.sendRedirect("addauto.jsp");
	return;
}else if(i==0){
	//添加失败
	response.sendRedirect("addauto.jsp");
	return;
}else{
	//添加成功
	response.sendRedirect("findall.jsp");
}
%>
