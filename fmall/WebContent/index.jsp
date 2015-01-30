<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易投融</title>
<script type="text/javascript">
var time = 0;
var forward_url = "product/financing/manageFinancesProducts.jsp";
function forward_to(){
   document.location.href = forward_url;
}
</script>
</head>
<body onload="forward_to();">
	<h1>Hello World!</h1>
	<a href="product/financing/manageFinancesProducts.jsp">Go start</a>
</body>
</html>