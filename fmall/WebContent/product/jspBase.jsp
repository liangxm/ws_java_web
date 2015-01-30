<!-- COMMON TAGLIB -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- COMMON JAVA -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

<!-- COMMON CSS -->
<link rel="stylesheet" href="script/css/cssLib/reset.css"/>
<link rel="stylesheet" href="script/css/cssLib/global.css"/>
<link rel="stylesheet" href="script/css/cssLib/template.css"/>
<link rel="stylesheet" href="script/css/cssLib/component.css"/>

<!-- COMMON JS -->
<script src="script/js/jsLib/jquery-1.8.2.min.js"></script>
<script src="script/js/jsLib/global.js"></script>
<script src="script/js/jsLib/components.js"></script>
<script src="script/js/jsLib/template.js"></script>