<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加汽车信息</title>
</head>
<body>
<form action="doaddauto.jsp" method="post">
车牌号 <input type="text" name="autono" /><br />
车辆类型<input type="text" name="autotype" /><br />
 排量<input type="text" name="pailiang" /><br />
 价格 <input type="text" name="price" /><br />
<input type="submit" value="添加" /><br />
</form>
</body>
</html>