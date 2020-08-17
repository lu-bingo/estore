<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!--在浏览器上跳转到WEB-INF目录底下的index.jsp-->
   <!-- jsp:forward  服务器内部跳转-->
   <jsp:forward page="/toIndexServlet"></jsp:forward>
</body>
</html>