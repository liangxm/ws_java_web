!function(e, n, o) {
	!function() {
		var e = /^(pinzhong|pzsem|sg|pzunion).*$/i.test(n
				.cookie("COOKIEYIMAFROM"))
				&& "2" != n.cookie("COOKIEYIMACPC");
		if (e) {
			var o = "null";
			var i = "null";
			var r = false;
			var t = false;
			var a = document.location.hostname
					.match(/(\w+\.(?:com|cn|net|org|cc)[^(?|\/)]*)(?:\/|$)/)[1];
			if ("" == document.referrer)
				r = true;
			else {
				o = document.referrer;
				var s = new RegExp("^(?:(?:https?|ftp):)/*(?:[^@]+@)?([^:/#]+)");
				var p = s.exec(document.referrer);
				if (p)
					if (p[1].indexOf(a) == -1)
						r = true;
				var c = new RegExp(".*fc=([^&]+).*");
				var u = c.exec(document.location);
				if (u) {
					i = u[1];
					r = true;
					t = true
				}
			}
			if (r) {
				var f = new Date;
				f.setDate(f.getDate() + 1);
				var C = "__pztm_lp=" + o + "|" + location.href
						+ ";path=/;domain=." + a + ";expires="
						+ f.toGMTString();
				document.cookie = C;
				if (t) {
					var d = "__pztm_fc=" + i + ";path=/;domain=." + a
							+ ";expires=" + f.toGMTString();
					document.cookie = d
				}
			}
		}
	}();
	if (/(pinzhong|pzsem|pzunion)/i.test(n.cookie("COOKIEYIMAFROM"))
			&& "2" == n.cookie("COOKIEYIMACPC"))
		e.loadCdnJS([ "js2/popularize/pinzhong.js" ]);
	if (/^sg.*$/i.test(n.cookie("COOKIEYIMAFROM"))
			&& "2" == n.cookie("COOKIEYIMACPC"))
		e.loadCdnJS("js2/popularize/pinzhong.js");
	var i = {};
	function r(r, t, a, s) {
		var p = /^(pinzhong|pzsem|sg|pzunion).*$/i.test(n
				.cookie("COOKIEYIMAFROM"))
				&& "2" == n.cookie("COOKIEYIMACPC") && r && t && !i[r];
		if (s || p)
			e.loadCdnJS("js2/popularize/pinzhong.js", function() {
				return !!o.pinzhong
			}, function() {
				var e = o.pinzhong;
				e.sendOrder(r, t);
				i[r] = true
			})
	}
	n.extend(e, {
		sendPopularizeOrder : function(o, i, t, a) {
			if (/^(pinzhong|pzsem|sg|pzunion).*$/i.test(n
					.cookie("COOKIEYIMAFROM")))
				r(o, i, t, a);
			var s = n.cookie("COOKIEYIMAFROM"), p = n.cookie("COOKIEYIMACPC");
			n.each(e.popularizeConfigs, function(n, r) {
				r.ORDER_CACHE = r.ORDER_CACHE || {};
				if (a || r.reg.test(s) && p && 2 === parseInt(p, 10) && o && i
						&& !r.ORDER_CACHE[o])
					e.loadCdnJS(r.js, function() {
						return !!r.sendOrder
					}, function() {
						r.sendOrder(o, i);
						r.ORDER_CACHE[o] = true
					})
			})
		},
		popularizeConfigs : {
			zyz : {
				reg : /^zyz.*$/i,
				js : "js2/popularize/zyz.js"
			},
			py : {
				reg : /^pydsp.*$/i,
				js : "js2/popularize/pinyou.js"
			},
			jx : {
				reg : /^mv.*$/i,
				js : "js2/popularize/juxiao.js"
			}
		}
	});
	var t = n.cookie("COOKIEYIMAFROM"), a = n.cookie("COOKIEYIMACPC");
	if (t) {
		if (a && 2 === parseInt(a, 10))
			n.each(e.popularizeConfigs, function(n, o) {
				if (o.reg.test(t))
					e.loadCdnJS(o.js, function() {
						return !!o.sendNew
					}, function() {
						o.sendNew()
					})
			});
		e.get("http://caipiao.163.com/activity/isSemUrl.html?pageUrl="
				+ encodeURIComponent(location.href), function(o, i) {
			if (!o)
				if (i) {
					n.each(e.popularizeConfigs, function(n, o) {
						if (o.reg.test(t))
							e.loadCdnJS(o.js, function() {
								return !!o.sendLanding
							}, function() {
								o.sendLanding()
							})
					});
					var r = i.split(",").slice(1), s = false;
					n.each(r, function(e, n) {
						if (n === t)
							s = true
					});
					if (s && 3 !== parseInt(a, 10))
						e.loadCdnJS(e.popularizeConfigs.jx.js, function() {
							return !!e.popularizeConfigs.jx.sendNew
						}, function() {
							e.popularizeConfigs.jx.sendNew()
						})
				}
		})
	}
}(Core, jQuery, window);