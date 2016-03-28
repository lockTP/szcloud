<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
	<head>
	<title>book</title>
	</head>
	<body>  
		<div>
		<h2>Add Book</h2>  
			<form method="post" action="<%=request.getContextPath() %>/book/add.do">  
			bookname:<input type="text" name="name" id="name">  
			author:<input type="text" name="author" id="author">  
			<input type="submit" value="Add">  
			</form> 
		</div>
	</body>  
</html>  