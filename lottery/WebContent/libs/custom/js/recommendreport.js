$(function () {
	$.ajax({
		url : "recommendReport",
		type : "get",
		dataType : "json",
		success : function(result) {
			var json = result.data;
			
			// build the table
			var total = 0;
			$.each(json,function(entryIndex, entry){
				total += parseInt(entry['number']);
			});
			// build the table
			var html = "<tr><th>推测结果</th><th>数量</th><th>比率</th></tr>";
			$.each(json, function(entryIndex, entry) {
				var t1 = (parseInt(entry['number'])/total).toFixed(4);
				var t3 = parseInt(t1.slice(2,4));
				if(t1==1.0000){
					t3=100;
				}
				var t2 = t3+"."+t1.slice(4,6)+"%";
				html += "<tr>" +
						"<td>" + entry['location'] + "</td>" +
						"<td>" + entry['number'] + "</td>" +
						"<td>" + t2 + "</td>" +
						"</tr>";
			});
			html += "<tr>" +"<td><font color='red' size='5'>Total</font></td>" +"<td>"+ total + "</td>" +"<td></td>" + "</tr>";
			$("#tab2 table").html(html);
			// build pie Chart
			var arrayData = new Array();
			for ( var i = 0, l = json.length; i < l; i++) {
				arrayData[i] = new Array();
				for ( var key in json[i]) {
					if (key == 'location') {
						arrayData[i][0] = json[i][key];
					} else {
						arrayData[i][1] = parseInt(json[i][key]);
					}
				}
			}
			$('#container').highcharts({
				chart: {
					plotBackgroundColor: null,
					plotBorderWidth: null,
					plotShadow: false,
					margin: [ 50, 50, 30, 80]
				},
				title: {
					text: '每日推荐中奖率统计示意图'
				},
				tooltip: {
					pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				credits: {
					enabled: false
				},
				plotOptions: {
					pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						dataLabels: {
							enabled: true,
							color: '#000000',
							connectorColor: '#000000',
							format: '<b>{point.name}</b>: {point.percentage:.1f} %'
						}
					}
				},
				series: [{
					type: 'pie',
					name: '所占比率',
					data: arrayData
				}]
			});
		}
	});
});