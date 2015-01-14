$.fn.flash = function(e, t, n) {
	if ($.isFunction(e)) {
		n = e;
		e = 0
	}
	if ($.isFunction(t)) {
		n = t;
		t = 0
	}
	var i = 2 * (e || 3), s = 0, a = this.is(":visible"), f = this.flashTimer, r = this;
	f && window.clearInterval(f);
	f = window.setInterval(function() {
		r.css("visibility", s % 2 ? "visible" : "hidden");
		s++;
		if (s >= i) {
			window.clearInterval(f);
			r.flashTimer = 0;
			$.isFunction(n) && n.call(r)
		}
	}, t || 200);
	this.flashTimer = f;
	return this
};
!function(e, t, n, i, s) {
	"use strict";
	t
			.extend(
					e,
					{
						getTotalNum : function(e, t, i, s) {
							var a = 0, f = 0, r, o, l, c, h = [], u, g = {
								d : {},
								t : {}
							}, d = {
								d : [],
								t : []
							};
							for (c = 0; c < s.length; c++) {
								g["d"][s[c]] = [];
								g["t"][s[c]] = []
							}
							if (e.length) {
								for (o in t) {
									if ("length" == o)
										continue;
									r = 0;
									for (l in t[o]["sp"]) {
										if (t[o].isDan)
											g.d[l].push(t[o]["sp"][l].length);
										else
											g.t[l].push(t[o]["sp"][l].length);
										r += t[o]["sp"][l].length
									}
									d[t[o].isDan ? "d" : "t"].push(r)
								}
								for (c = 0; c < e.length; c++) {
									u = i[e[c]];
									if (u)
										h = h.concat(u)
								}
								f = n.c2(d.t, d.d, h);
								if (s.length > 1) {
									for (o in g.t)
										if (g.t[o].length > 0)
											a += n.c2(g.t[o], g.d[o], h)
								} else
									a = f
							}
							return [ f, a ]
						},
						getMaxMethod : function(e, t) {
							t = t || n.gameEn;
							var i = {}, s, a, f, r = 0;
							for (a in e) {
								if ("length" == a)
									continue;
								s = e[a]["sp"] || e[a];
								for (f in s)
									if (!i[f])
										i[f] = true
							}
							if (i["sfc"])
								r = 4;
							else
								r = 8;
							if (e.length < r)
								r = e.length;
							return r
						},
						getMinMethod : function(t) {
							var n = 2, t, i, s, a = e.jcGameManage, f, r = a
									.getBetPool(), o = a.getBetArea();
							t = t || a.getPlayType();
							switch (t) {
							case "mixall4dg":
							case "sf4dg":
							case "rfsf4dg":
							case "dxf4dg":
							case "sfc4dg":
							case "sfc":
								n = 1;
								break;
							default:
								if (e.config.isSupportDg) {
									i = r.get();
									s = o.getGameInfo();
									for ( var l in i)
										if ("length" != l) {
											f = i[l]["sp"];
											for ( var c in f)
												if (!(s[l] && s[l].dgStatus[c]))
													return n
										}
									n = 1
								}
							}
							return n
						},
						formatGameInfo : function(e, t) {
							var n = [], i, s, a, f, r, o, l, c, h = {
								sf : -1,
								rfsf : -1,
								sfc : -2,
								dxf : -1
							};
							for (s in e) {
								if ("length" == s)
									continue;
								r = {};
								for (o in e[s].sp) {
									l = e[s].sp[o];
									c = {};
									if (l) {
										for ( var f in l)
											if ("length" != f) {
												i = t[o][f];
												c[String(i[2]).slice(h[o])] = l[f]
											}
										r[o] = c
									}
								}
								n.push({
									matchCode : s,
									matchnumcn : e[s].matchnumcn,
									score : e[s].score,
									isDan : e[s].isDan,
									sp : r
								})
							}
							return n
						},
						formatGameInfo4Detail : function(e, t, n) {
							var i = [], s, a, f, r, o, l, c;
							l = this.betArea;
							for ( var h in t) {
								if ("length" == h)
									continue;
								o = e[h];
								r = [];
								for (a in t[h].sp) {
									f = t[h].sp[a];
									if (f)
										for ( var u in f)
											if ("length" != u) {
												c = n[a][u];
												r.push([ c[2], f[u] ])
											}
								}
								i.push({
									matchCode : h,
									startTime : e.startTime,
									hostName : t[h].hostName,
									guestName : t[h].guestName,
									rq : t[h].score,
									isDan : t[h].isDan,
									sp : r
								})
							}
							return i
						},
						dan : function(e, t) {
							var n = t.cache.selectMethod, i = t.cache.currentMethod, s = t.config.methodType, a, f = e
									.get(), r = {}, o = {}, l, c, h = 0;
							if ("m_1" == t.cache.currentType) {
								for ( var u in f) {
									if ("length" == u)
										continue;
									if (f[u].isDan) {
										h += 1;
										r[u] = false
									} else
										r[u] = true
								}
								for (var g = 0; g < n.length; g++) {
									a = s[n[g]];
									a = a[0];
									if (!l || l > a)
										l = a
								}
								for (var g = 0; g < i.length; g++) {
									a = s[i[g]];
									a = a[0];
									if (!c || c < a)
										c = a
								}
								if (l)
									if (l == f.length)
										e.setDisableDan(true);
									else if (l - 1 == h)
										e.setDisableDan(r);
									else
										e.setDisableDan(false);
								else if (h === c - 1)
									e.setDisableDan(r);
								else if (h >= c)
									e.setDan(false);
								else
									e.setDisableDan(false);
								h = 0;
								for ( var u in f) {
									if ("length" == u)
										continue;
									if (f[u].isDan)
										h += 1
								}
								if (0 == h)
									t.setDisabledMethod(false);
								else {
									for (var g = 0; g < i.length; g++) {
										a = s[i[g]];
										if (h < a)
											o[i[g]] = false;
										else
											o[i[g]] = true
									}
									t.setDisabledMethod(o)
								}
							} else if ("m_n" == t.cache.currentType)
								e.setDisableDan(true)
						},
						createForm : function(e, n, i, s) {
							var a = [ "<form method='", i || "post",
									"' action='", e, "' target='",
									s || "_blank", "'>" ], f, r;
							if (n)
								for (f in n)
									a.push("<input type='hidden' name='" + f
											+ "' value='" + n[f] + "'/>");
							r = t(a.join("") + "</form>").appendTo(
									document.body);
							r.submit();
							r.remove()
						}
					})
}(Core, jQuery, Game, window);