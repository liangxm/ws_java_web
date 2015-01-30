/*  
 *@Description: 理财产品js
 *@Author:      listener
 *@Update:      listener(2013-10-22)  
 */
function submitFinancialQuery(pagenumber) {
	var basefinance = new Object();
	basefinance.currency = $("#main #product_currency").find(
			"li[class='active']").text();
	basefinance.incomeType = $("#main #product_gainType").find(
			"li[class='active']").text();
	basefinance.salesStatus = $("#main #product_saleStatus").find(
			"li[class='active']").text();
	basefinance.timeLimite = $("#main #product_timeLimite").find(
			"li[class='active']").text();
	basefinance.purchaseAmount = $("#main #product_purchaseAmount").find(
			"li[class='active']").text();
	basefinance.expectedBenefits = $("#main #product_expectedBenefits").find(
			"li[class='active']").text();
	basefinance.riskLevel = $("#main #product_riskLevel").find(
			"li[class='active']").text();
	basefinance.productType = $("#main #product_productType").find(
			"li[class='active']").text();
	basefinance.issueBank = $("#main #product_issueBank").find(
			"li[class='active']").text();
	basefinance.salesRegion = $("#main .product_city").attr("value");
	basefinance.pageNumber = pagenumber;
	var basePath = $('#wrapper #basePath').attr("value");
	var df1 = new DateFormat("yyyyMMdd");
	var df2 = new DateFormat("yyyy/MM/dd");
	$.ajax({
				type : "POST",
				contentType : "application/json",
				url : basePath + "/financial/json.do",
				processData : false,
				dataType : "json",
				data : JSON.stringify(basefinance),
				success : function(json) {
					$("#pager").pager({
						pagenumber : pagenumber,
						pagecount : json.pagecount,
						totalcount : json.totalcount,
						buttonClickCallback : PageClick
					});
					$('#main_content .content_list').find('li').remove();
					var html = "";
					for (position in json.data) {
						var keep;
						if (json.data[position].keepPrincipal == "1") {
							keep = '保本';
						} else {
							keep = '非保本';
						}
						html += "<li>";
						html += "<span class='contentList_name'><a href='/fmall/financial/get.do?financialId="
								+ json.data[position].financialId
								+ "'>"
								+ json.data[position].productName
								+ "</a></span>";
						html += "<span class='contentList_bank'>"
								+ json.data[position].bank + "</span>";
						html += "<span class='contentList_start'>"
								+ json.data[position].investmentsAmt
								+ "万</span>";
						html += "<span class='contentList_date'>起 :"
								+ df2.format(df1.parse(json.data[position].salesStartDate))
								+ "<br>止 :" + df2.format(df1.parse(json.data[position].salesEndDate))
								+ "</span>";
						html += "<span class='contentList_deadline'>"
								+ json.data[position].entrustManagePeriod
								+ "天</span>";
						html += "<span class='contentList_rate'>";
						html += json.data[position].incomeRate +"%";
						html += "</span>";
						html += "<div class='clearB'></div>";
						html += "</li>";
						$('#main_content .content_list').html("");
						$('#main_content .content_list').html(html);
					}
				},
				error : function() {
					alert("server request failure....");
				}
			});
}
PageClick = function(pageclickednumber) {
	submitFinancialQuery(pageclickednumber);
};
$(document).ready(
		function() {
			submitFinancialQuery(1);
			$("#main #product_currency li").click(
					function() {
						$("#main #product_currency").find("li[class='active']")
								.removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_gainType li").click(
					function() {
						$("#main #product_gainType").find("li[class='active']")
								.removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});

			$("#main #product_saleStatus li").click(
					function() {
						$("#main #product_saleStatus").find(
								"li[class='active']").removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_timeLimite li").click(
					function() {
						$("#main #product_timeLimite").find(
								"li[class='active']").removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_purchaseAmount li").click(
					function() {
						$("#main #product_purchaseAmount").find(
								"li[class='active']").removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});

			$("#main #product_expectedBenefits li").click(
					function() {
						$("#main #product_expectedBenefits").find(
								"li[class='active']").removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_riskLevel li").click(
					function() {
						$("#main #product_riskLevel")
								.find("li[class='active']").removeClass(
										"active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_productType li").click(
					function() {
						$("#main #product_productType").find(
								"li[class='active']").removeClass("active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main #product_issueBank li").click(
					function() {
						$("#main #product_issueBank")
								.find("li[class='active']").removeClass(
										"active");
						$(this).addClass("active");
						submitFinancialQuery(1);
					});
			$("#main .product_city").change(function() {
				submitFinancialQuery(1);
			});
		});

/**
 * JavaScript的DateFormat类
 * [File  ] date.js
 * [Author] cerdar
 * [Date  ] 2006-06-20
 * copy right cerdar
/**----------------------------------------------------------------*/
function DateFormat(pattern, formatSymbols)
{
    if(pattern == null || pattern == undefined)
    {
        pattern = "yyyy-MM-dd HH:mm:ss SSS";
    }

    if(formatSymbols == null || formatSymbols == undefined)
    {
        formatSymbols = "yMdHmsS";
    }

    this.pattern = pattern;
    this.formatSymbols = formatSymbols;
}

DateFormat.prototype.format = function(date)
{
    var time = getTime(date);
    // 标记存入数组
    var cs = this.formatSymbols.split("");
    // 格式存入数组
    var fs = this.pattern.split("");
    // 构造数组
    var ds = time.split("");

    // 标志年月日的结束下标
    var y = 3;
    var M = 6;
    var d = 9;
    var H = 12;
    var m = 15;
    var s = 18;
    var S = 22;

    // 逐位替换年月日时分秒和毫秒
    for(var i = fs.length - 1; i > -1; i--)
    {
        switch (fs[i])
        {
            case cs[0]:
            {
                fs[i] = ds[y--];
                break;
            }
            case cs[1]:
            {
                fs[i] = ds[M--];
                break;
            }
            case cs[2]:
            {
                fs[i] = ds[d--];
                break;
            }
            case cs[3]:
            {
                fs[i] = ds[H--];
                break;
            }
            case cs[4]:
            {
                fs[i] = ds[m--];
                break;
            }
            case cs[5]:
            {
                fs[i] = ds[s--];
                break;
            }
            case cs[6]:
            {
                fs[i] = ds[S--];
                break;
            }
        }
    }
    return fs.join("");
};

/**
 *@param datetime - String
 *
 *@return - Date
 */
DateFormat.prototype.parse = function(date)
{
    var y = "";
    var M = "";
    var d = "";
    var H = "";
    var m = "";
    var s = "";
    var S = "";

    // 标记存入数组
    var cs = this.formatSymbols.split("");

    // 格式存入数组
    var ds = this.pattern.split("");

    // date   = "2005-08-22 12:12:12 888";
    // format = "yyyy-MM-dd HH:mm:ss SSS";
    // sign   = "yMdHmsS";
    var size = Math.min(ds.length, date.length);

    for(var i=0; i<size; i++)
    {
        switch (ds[i])
        {
            case cs[0]:
            {
                y += date.charAt(i);
                break;
            }
            case cs[1]:
            {
                M += date.charAt(i);
                break;
            }
            case cs[2]:
            {
                d += date.charAt(i);
                break;
            }
            case cs[3]:
            {
                H += date.charAt(i);
                break;
            }
            case cs[4]:
            {
                m += date.charAt(i);
                break;
            }
            case cs[5]:
            {
                s += date.charAt(i);
                break;
            }
            case cs[6]:
            {
                S += date.charAt(i);
                break;
            }
        }
    }
    
    if(y.length < 1) y = 0; else y = parseInt(y);
    if(M.length < 1) M = 0; else M = parseInt(M);
    if(d.length < 1) d = 0; else d = parseInt(d);
    if(H.length < 1) H = 0; else H = parseInt(H);
    if(m.length < 1) m = 0; else m = parseInt(m);
    if(s.length < 1) s = 0; else s = parseInt(s);
    if(S.length < 1) S = 0; else S = parseInt(S);

    var d = new Date(y, M - 1, d, H, m, s, S);

    return d;
};

// 返回当前时间
function getTime(date)
{
    if(date == null)
    {
        date = new Date();
    }
    
    var y = date.getFullYear();
    var M = date.getMonth() + 1;
    var d = date.getDate();
    var h = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();
    var S = date.getTime()%1000;

    var html = y + "-";

    if(M < 10)
    {
        html += "0";
    }
    html += M + "-";

    if(d < 10)
    {
        html += "0";
    }
    html += d + " ";

    if(h < 10)
    {
        html += "0";
    }
    html += h + ":";

    if(m < 10)
    {
        html += "0";
    }
    html += m + ":";

    if(s < 10)
    {
        html += "0";
    }
    html += s;
    
    html += " ";

    if(S < 100)
    {
        html += "0";
    }

    if(S < 10)
    {
        html += "0";
    }

    html += S;

    return html;
}