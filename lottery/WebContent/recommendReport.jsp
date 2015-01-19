<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>每日推荐-数据报表</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	  <link href="libs/custom/css/basic.css" rel="stylesheet">
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
   </head>
   <body>
   	  <div id="ceiling_banner"><span class="banner-text">专业化彩票分析网站（v1.0）</span></div>
      <div id="container" class="container-fluid"></div>
	  <div id="tab2">
			<table class="table table-bordered table-hover table-condensed">
			</table>
	  </div>
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="libs/jquery/jquery.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      <!-- high chart report -->
      <script type="text/javascript" src="libs/highcharts/highcharts.js"></script>
      <!-- custom report js -->
      <script type="text/javascript" src="libs/custom/js/recommendreport.js"></script>
   </body>
</html>