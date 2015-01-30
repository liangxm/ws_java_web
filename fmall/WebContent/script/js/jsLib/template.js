/*  
	*@Description: 通用模板js
	*@Author:      Samuel Shen
	*@Update:      Samuel Shen(2012-9-24)  
*/
$(document).ready(function(){
	//nav切换
	$("#productDetail_nav li").click(function(){
		var indexNow = $(this).index();
		$("#productDetail_nav li:not(:eq("+indexNow+"))").removeClass("active");	
		$("#productDetail_nav li:eq("+indexNow+")").addClass("active");
		$(".mainTable:not(:eq("+indexNow+"))").hide();
		$(".mainTable:eq("+indexNow+")").show();
	});
});