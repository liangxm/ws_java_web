!function(e, t, n, i, a) {
	"use strict";
	Class.Base.Event.extend("Game.COMS.JC.Attention", {
		config : {
			oneGameId : "matchcode",
			oneDayId : "gamedate",
			oneTitleSelect : "dt",
			oneDaySelect : "dl[gamedate]",
			gameWrapSelector : ".gameSelect",
			attentionGameWrapSelect : ".attentionInner",
			unAttentionGameWrapSelect : ".unAttention",
			attentionTitSelector : ".attentionTit",
			attentionMenuSelector : ".attentionMenu",
			attentionTitTmp : "我关注的赛事 ({0}场比赛)",
			saveAttentionURL : "/jc/jcquery_saveFollowedLeague.html",
			attentionSortFun : null,
			gameDateWrapTmp : "<dl {0}> <dt>{1}</dt></dl>",
			attentionListTplSelector : "#attentionList",
			gameId : ""
		},
		init : function(e, i) {
			var a, s, r = /(\S+)Selector$/, c = this;
			this.config = t.extend({}, this.config, e);
			this.cache = s = {};
			a = this.config;
			this.betArea = i;
			for ( var h in a)
				if ("string" == n.getType(h) && r.test(h))
					s[RegExp.$1] = t(a[h]);
			this.callSuper("onSave");
			t.each(l, function(e) {
				o[e] = t.proxy(l[e], c)
			});
			s.attentionGameWrap = s.gameWrap.find(a.attentionGameWrapSelect);
			s.unAttentionGameWrap = s.gameWrap
					.find(a.unAttentionGameWrapSelect);
			i.extend(p);
			f.call(this);
			A.call(this)
		},
		each : function(e, t) {
			if (e)
				for ( var n in e)
					if ("length" != n)
						if (false === t.call(this, n, e[n], e))
							return this
		}
	});
	var o = {}, s, l = {
		close : function() {
			var e = this.cache.attentionMenu;
			s && i.clearTimeout(s);
			s = i.setTimeout(function() {
				e.removeClass("showOption")
			}, 200)
		},
		open : function() {
			var e = this.cache.attentionMenu;
			s && i.clearTimeout(s);
			s = i.setTimeout(function() {
				e.addClass("showOption")
			}, 200)
		},
		isSaveChange : function(e) {
			var n = t(e.currentTarget);
			n.toggleClass("icoFx_active")
		},
		save : function() {
			var t = this.cache.attentionMenu, n = this;
			if (t.find(".isSave").hasClass("icoFx_active"))
				if (!e.easyNav.isLogin()) {
					e.easyNav.login2(function(e) {
						if (!e)
							c.call(n)
					});
					return
				} else
					c.call(n);
			o.close.call(this)
		},
		hoverLeague : function(e) {
			var n = t(e.currentTarget);
			if (!n.hasClass("select")) {
				if ("mouseover" == e.type)
					n.addClass("hover");
				else
					n.removeClass("hover");
				n.attr("title", "关注赛事将置顶显示")
			} else
				n.attr("title", "点击取消关注")
		},
		changeLeague : function(e) {
			var n = t(e.currentTarget), a = n.attr("leagueId"), o;
			if (a) {
				if (n.hasClass("select")) {
					n.removeClass("select").addClass("hover");
					o = false
				} else {
					n.addClass("select").removeClass("hover");
					if (!t.isIE678) {
						n.addClass("selectAnimation");
						i.setTimeout(function() {
							n.removeClass("selectAnimation")
						}, 300)
					}
					o = true
				}
				this.betArea.setAttentionStatus(a, o);
				h.call(this, a)
			}
		}
	}, f = function() {
		if (!this.config.saveAttentionURL || !this.cache.attentionMenu
				|| !this.cache.attentionMenu.length)
			return this;
		var e = this.config, i = this;
		r.call(this);
		this.betArea.onAddGame(function(e) {
			m.call(i, e);
			d.call(i)
		}).onBeforeDelGame(function(e) {
			var a, o, s, l, f, r = this.getOneGameInfo(e);
			if (r) {
				a = r.gameDate;
				if (!a)
					return this;
				this.eachAttentionGameInfo(function(t, i) {
					s = i[a];
					if (s && s.game && s.game.length) {
						l = n.indexOf(s.game, e);
						this.delOneAtDateMatch(t, a, e);
						if (l > -1) {
							if (0 === s.game.length) {
								if (s.title && s.title.length)
									s.title.remove();
								if (s.wrap && s.wrap.length)
									s.wrap.remove();
								this.delOneAtDateInfo(t, a)
							}
							return false
						}
					}
				});
				f = this.getOneAttentionMap(r.leagueId);
				if (f && f.size) {
					f.size -= 1;
					if (f.size <= 0)
						this.delOneAttentionMap(r.leagueId)
				}
			}
			if (t.isEmptyObject(this.getOneAtInfo("attention")))
				i.cache.attentionGameWrap.hide();
			d.call(i);
			return this
		});
		if (!t.isEmptyObject(this.betArea.getGameInfo()))
			this.betArea.eachGameInfo(function(e, t) {
				var n = t.ele.attr("isAttention");
				if ("undefined" !== typeof n) {
					n = "1" == n ? true : false;
					t.isAttention = n
				}
				m.call(i, e)
			});
		d.call(i)
	}, r = function() {
		var e = this.cache.attentionMenu;
		e.bind("mouseenter", o.open).bind("mouseleave", o.close).delegate(
				".makeSure", "click", o.save).delegate(".isSave", "click",
				o.isSaveChange).delegate("li", "mouseover mouseout",
				o.hoverLeague).delegate("li", "click", o.changeLeague);
		return this
	}, c = function() {
		var i = this.config, a = this.cache, o = this, s = [], l, f = a.attentionMenu
				.find("li[leagueid]");
		f.each(function() {
			var e = t(this), n = [ this.getAttribute("leagueid") ];
			if (e.hasClass("select"))
				n.push(1);
			else
				n.push(0);
			s.push(n.join(":"))
		});
		e.post(i.saveAttentionURL, {
			gameId : i.gameId,
			leagueIdArr : s.toString()
		}, function(e, t) {
			if (e)
				n.alert("对不起发生系统异常");
			else if (t == -2)
				easyNav.login();
			else if (100 == t) {
				o.trigger("onSave", o.betArea.getAttentionMap());
				n.alert("保存成功")
			} else if (/^(-1&)/.test(t))
				n.alert(t.split("&")[1])
		})
	}, h = function(e) {
		var i = this.config, o = this.cache, s, l, f, r, c = this.betArea, h = this, m = [], d, A = 0, p = c
				.getAttentionGameInfo();
		c.eachGameInfo(function(t, i) {
			if (i.isAttention !== a)
				if (i.leagueId == e) {
					s = i.ele;
					l = i.gameDate;
					m.push(l);
					if (i.isAttention) {
						if (!p["attention"] || !p["attention"][l])
							u.call(h, l, "attention");
						if (n.indexOf(p["attention"][l].game, t) < 0)
							g.call(h, t, l, "attention")
					} else {
						if (!p["unAttention"] || !p["unAttention"][l])
							u.call(h, l, "unAttention");
						if (n.indexOf(p["unAttention"][l].game, t) < 0)
							g.call(h, t, l, "unAttention")
					}
				}
		});
		d = [];
		c.eachAttentionGameInfo(function(e, t) {
			if ("other" !== e)
				this.each(t, function(t, a) {
					if (n.indexOf(m, t) > -1) {
						f = 0;
						for (var o = 0; o < a.game.length; o++)
							if (!this.getOneGameInfo(a.game[o]).isStop)
								f++;
						a.wrap.find(i.oneTitleSelect).find("span.matchSize")
								.html(f)
					}
					if (!a.game.length) {
						d.push(a.wrap);
						this.delOneAtDateInfo(e, t)
					} else if ("attention" == e)
						A += a.game.length
				})
		});
		o.attentionTit.html(t.format(i.attentionTitTmp, A));
		if (!A)
			o.attentionGameWrap.hide();
		else
			o.attentionGameWrap.show();
		for (r = 0; r < d.length; r++)
			if (d[r])
				d[r].remove();
		d = null;
		c.callEvent("onPosition", e);
		return this
	}, u = function(e, i) {
		var a = this.config, o = this.betArea, s = a.gameDateWrapTmp, l = o
				.getOneAtInfo(i), f = this.cache.attentionGameWrap, r = this.cache.unAttentionGameWrap, c, h, u, g, m = [], d = "attention" === i ? f
				: r;
		if ("attention" == i)
			h = o.getOneAtDateInfo("unAttention", e).wrap
					.find(a.oneTitleSelect).html();
		else
			h = o.getOneAtDateInfo("attention", e).wrap.find(a.oneTitleSelect)
					.html();
		c = t.format(s, [ a.oneDayId + "='" + e + "'", h ]);
		this.each(l, function(e) {
			m.push(e)
		});
		m.push(e);
		n.sortNum(m);
		u = n.indexOf(m, e);
		g = d.find(a.oneDaySelect);
		if (g.length)
			if (0 == u)
				g.eq(0).before(c);
			else
				g.eq(u - 1).after(c);
		else
			d.append(c);
		o.setAtDateInfo(i, e, {
			wrap : d.find(a.oneDaySelect).filter(
					"[" + a.oneDayId + '="' + e + '"]'),
			game : [],
			gameEle : []
		});
		return this
	}, g = function(e, i, a) {
		var o = this.betArea, s = o.getOneGameInfo(e), l = o.getOneAtDateInfo(
				a, i), f, r, c, h, u, g = this.config, m = l.game;
		m.push(e);
		if (g.attentionSortFun && t.isFunction(g.attentionSortFun)) {
			h = g.attentionSortFun.call(this.betArea, m.slice(0));
			if (h && h.length == m.length)
				m = h;
			else
				n.sortNum(m)
		} else
			n.sortNum(m);
		h = null;
		c = "attention" == a ? "unAttention" : "attention";
		h = o.getOneAtDateInfo(c, i).game;
		f = n.indexOf(h, e);
		if (f > -1) {
			h.splice(f, 1);
			r = [];
			t.each(h, function(e, t) {
				r.push(o.getOneGameInfo(t).ele)
			});
			o.setAtDateInfo(c, i, {
				gameEle : r,
				game : h
			})
		}
		if (1 == m.length) {
			l.wrap.append(s.ele);
			s.relationEle && l.wrap.append(s.relationEle)
		} else {
			f = n.indexOf(m, e);
			if (0 == f) {
				h = l.gameEle[0].eq(0);
				h.before(s.ele);
				s.relationEle && h.before(s.relationEle)
			} else {
				h = l.gameEle[f - 1];
				h = h.eq(h.length - 1);
				e = h.attr(this.config.oneGameId);
				u = o.getOneGameInfo(e);
				if (u.relationEle)
					h = u.relationEle.eq(u.relationEle.length - 1);
				s.relationEle && h.after(s.relationEle);
				h.after(s.ele)
			}
		}
		r = [];
		t.each(m, function(e, t) {
			r.push(o.getOneGameInfo(t).ele)
		});
		o.setAtDateInfo(a, i, {
			gameEle : r,
			game : m
		})
	}, m = function(e) {
		var t = this.betArea.getOneGameInfo(e), n, i, o, s, l = this.betArea
				.getAttentionGameInfo(), f = this.config;
		if (t && t.gameDate) {
			if (t.isAttention != a)
				if (!this.betArea.getOneAttentionMap(t.leagueId))
					this.betArea.setOneAttentionMap({
						id : t.leagueId,
						isAttention : t.isAttention,
						leagueName : t.leagueName,
						size : 1
					});
				else {
					s = this.betArea.getOneAttentionMap(t.leagueId);
					s.size += 1
				}
			this.betArea.setOneAttention;
			if (t.isAttention !== a)
				n = t.isAttention ? "attention" : "unAttention";
			else
				n = "other";
			if (l && l[n] && l[n][t.gameDate])
				this.betArea.setOneAtDateMatch(n, t.gameDate, e);
			else {
				o = t.wrap || t.ele.closest(f.oneDaySelect);
				this.betArea.setAtDateInfo(n, t.gameDate, {
					wrap : o,
					title : o.find(f.oneTitleSelect),
					game : [ e ],
					gameEle : [ t.ele ]
				})
			}
		}
	}, d = function() {
		var e = this.cache.attentionMenu.find(".gameSeleList ul"), n = this.cache.attentionListTpl
				.html();
		if (n)
			e.html(t.template(n, this.betArea.getAttentionMap() || {}));
		return this
	}, A = function() {
		var e = this.betArea;
		var t = this.cache.attentionMenu;
		e.onBeforeDestory(function() {
			t.unbind("mouseenter", o.open).unbind("mouseleave", close)
					.undelegate(".makeSure", "click", o.save).undelegate(
							".isSave", "click", o.isSaveChange).undelegate(
							"li", "mouseover mouseout", o.hoverLeague)
					.undelegate("li", "click", o.changeLeague);
			this.destoryAttentionView()
		})
	};
	var p = {
		getAttentionMap : function() {
			return this.cache.attentionMap
		},
		setOneAttentionMap : function(e) {
			var n = this.cache.attentionMap;
			if (!n)
				n = this.cache.attentionMap = {};
			if (e && e.id)
				n[e.id] = t.extend(n[e.id], e);
			return this
		},
		getOneAttentionMap : function(e) {
			var t = this.cache.attentionMap;
			if (t && t[e])
				return t[e]
		},
		delOneAttentionMap : function(e) {
			var t = this.cache.attentionMap;
			if (t && t[e])
				delete t[e];
			return this
		},
		getAttentionGameInfo : function() {
			return this.cache.attentionGameInfo
		},
		getOneAtInfo : function(e) {
			var t = this.getAttentionGameInfo();
			if (e && t[e])
				return t[e]
		},
		getOneAtDateInfo : function(e, t) {
			var n = this.getAttentionGameInfo();
			if (e && t && n[e] && n[e][t])
				return n[e][t]
		},
		eachAttentionGameInfo : function(e) {
			var t = this.getAttentionGameInfo();
			for ( var n in t)
				if (false === e.call(this, n, t[n], t))
					return
		},
		setAttentionStatus : function(e, t) {
			this.eachGameInfo(function(n, i) {
				if (i.isAttention !== a)
					if (i.leagueId == e)
						i.isAttention = t
			});
			if (this.cache.attentionMap && this.cache.attentionMap[e])
				this.cache.attentionMap[e].isAttention = t;
			return this
		},
		setAtDateInfo : function(e, n, i) {
			if (e && n) {
				var a = this.getAttentionGameInfo();
				if (!a)
					this.cache.attentionGameInfo = a = {};
				a[e] = a[e] || {};
				a[e][n] = t.extend(a[e][n], i)
			}
			return this
		},
		setOneAtDateMatch : function(e, t, i) {
			var a = this.getOneAtDateInfo(e, t), o, s;
			if (a && a.game && a.game.length) {
				o = n.indexOf(a.game, i);
				if (!(o > -1)) {
					s = this.getOneGameInfo(i);
					if (s) {
						a.game.push(i);
						a.gameEle.push(s.ele)
					}
				}
			}
			return this
		},
		delOneAtDateMatch : function(e, t, i) {
			var a = this.getOneAtDateInfo(e, t), o;
			if (a && a.game && a.game.length) {
				o = n.indexOf(a.game, i);
				if (o > -1) {
					a.game.splice(o, 1);
					a.gameEle.splice(o, 1)
				}
			}
			return this
		},
		delOneAtDateInfo : function(e, t) {
			var n = this.getAttentionGameInfo();
			if (e && t && n[e] && n[e][t])
				delete n[e][t];
			return this
		},
		destoryAttentionView : function() {
			var e = this.cache;
			if (e.attentionGameInfo)
				e.attentionGameInfo = null;
			this.attentionView.unbind("onSave")
		}
	}
}(Core, jQuery, Game, window);