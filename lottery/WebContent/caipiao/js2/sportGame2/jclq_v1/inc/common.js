!function(e, t, i, a, s) {
	"use strict";
	var o, n = e.tools, r = e.helper;
	var c = {
		cache : {},
		init : function() {
			o = e.jcGameManage;
			c.initRuleClick().changeTime().changeDate().changeAnData()
					.initDgSupport().betTipsOpertion().initNews().changeGame()
					.gameChangeCon().checkStopGame().initScrollBar()
					.moveTitle().initAsideAutoHeight().initAsideAutoPosition()
					.initDisplayToolBar().payEvent().detailBounds();
			r.initRouter()
		},
		initScrollBar : function() {
			if (!(t.browser.msie && +t.browser.version < 7))
				c.betPoolScrollBar = n.initScrollBar(this.cache.scrollPoolPane);
			var e = t(".scrollDiv"), i, a = e.find("ul").attr("overflow",
					"hidden"), s = function() {
				if (i) {
					var t = a, s = t.height();
					s > 78 && (s = 78);
					e.css("height", s + 16);
					i.reinitialise();
					i.reinitialise()
				}
			};
			i = this.betMethodScrollBar = n.initScrollBar(e);
			o.onGameInit(function(t, a, o, n) {
				n.onTabChange(function(t) {
					"m_n" == t ? e.show() : e.hide();
					"m_n" == t && s()
				}).onMethodChange(function() {
					"m_n" == this.cache.currentType && i && s()
				})
			});
			return this
		},
		gameChangeCon : function() {
			var i = this.cache.main, a = this.cache.gameWrap, s = e.cache.changeDate, n, c = this.cache.stopGame, l = this.cache.changeGame, h = l
					.find(".ggwrap, .dgwrap"), f = this.cache.gameMenu
					.find("li"), u = this.cache.floatTitle;
			o
					.onBeforeGameChange(function() {
						u.addClass("hide");
						r.changeLoadingStatus(3);
						var e = this.getPlayType();
						if (e)
							i.removeClass(r.getClsByPlayType(e))
					})
					.onGameChange(
							function(a, o) {
								var n = o.getGameInfo(), g, m = e.cache.betDate, d, p = e.config.isSupportDg, v = e.cache.supportDg, y = !m;
								if (t.isEmptyObject(n))
									r.changeLoadingStatus(1);
								else
									r.changeLoadingStatus(0);
								d = o.getStopMatchSize();
								i.addClass(r.getClsByPlayType(a));
								u.addClass("hide").filter(
										"." + r.getClsByPlayType(a))
										.removeClass("hide");
								f.removeClass("active");
								h.hide();
								g = h.find('a[data-playtype="' + a + '"]');
								l.find(".imitateSelect").html(g.html()).attr(
										"href", g.attr("href"));
								s.find(".imitateSelect").html(m ? m : "当前日期")
										.attr("href", "#" + m);
								if (y)
									c.html('<i class="icoFx"></i>显示已截止(' + d
											+ ")");
								else
									c
											.html('<i class="icoFx icoFx_active"></i>显示已截止('
													+ d + ")");
								if (p && y)
									if (r.isDgByPlayType(a))
										v.addClass("hide").prev(".fgx")
												.addClass("hide");
									else
										v.removeClass("hide").prev(".fgx")
												.removeClass("hide");
								else
									v.addClass("hide").prev(".fgx").addClass(
											"hide");
								if (p)
									if (r.isDgByPlayType(a)) {
										f.eq(1).addClass("active");
										h.filter(".dgwrap").show()
									} else {
										f.eq(0).addClass("active");
										h.filter(".ggwrap").show()
									}
								else {
									f.eq(1).hide();
									f.eq(0).addClass("active");
									h.filter(".ggwrap").show()
								}
							});
			return this
		},
		moveTitle : function() {
			var e = this.cache, i, s = e.gameWrap, n = t("<div>"), c, l = t("#docBody"), h, f = e.floatTitle, u = null;
			f.after(n.css("display", "none"));
			t(a).scroll(
					function() {
						if (!u || !u.length)
							return;
						var e = t(a).scrollTop(), o = t.browser.msie
								&& +t.browser.version < 7;
						c = s.offset().top + s.eq(0).height()
								+ s.eq(1).height() - 30;
						if (e > i) {
							if (c < e)
								u.css({
									position : "absolute"
								});
							else
								u.css({
									position : o ? "absolute" : "fixed",
									top : o ? e - h : 0,
									zIndex : 888
								});
							n.css("display", "")
						} else {
							u.css({
								position : "relative",
								zIndex : 3,
								top : "auto"
							});
							n.css("display", "none")
						}
					});
			o.onGameInit(function(e) {
				u = f.filter("." + r.getClsByPlayType(e));
				i = u.offset().top;
				h = l.offset().top;
				n.css({
					height : u.height(),
					width : u.width()
				})
			});
			return this
		},
		checkStopGame : function() {
			var e = a.Game ? a.Game.config.gameEn : "";
			if (e)
				i.checkGamePause(e);
			return this
		},
		initAsideAutoPosition : function() {
			if (t.browser.msie && +t.browser.version < 7)
				return this;
			var e = this.cache, i = e.floatBox, s = e.floatTitle, n = t(".hotBlock"), c = t("#docFoot"), l = t("#docBody"), h = l
					.offset().top, f, u = false, g, m = t(a);
			g = function() {
				var e = m.scrollTop(), t = n.offset() || c.offset(), a;
				a = t.top - i.height() - 100;
				if (!a || a <= 0)
					return;
				if (m.height() < 616) {
					i.css({
						position : "relative",
						zIndex : 3,
						top : ""
					});
					return
				}
				if (e > f)
					if (a < e)
						if (a < f)
							i.css({
								position : "",
								zIndex : 1
							});
						else
							i.css({
								position : "absolute",
								top : a - h,
								zIndex : 665
							});
					else
						i.css({
							position : "fixed",
							zIndex : 665,
							top : 0
						});
				else
					i.css({
						position : "relative",
						zIndex : 3,
						top : ""
					})
			};
			o.onGameInit(function(e) {
				f = s.filter("." + r.getClsByPlayType(e)).offset().top;
				g()
			});
			this.reSetRightSidePosition = g;
			t(a).scroll(g);
			return this
		},
		initAsideAutoHeight : function() {
			if (t.browser.msie && +t.browser.version < 7)
				return this;
			var e = 138, i = this.cache, s = i.floatBox, o = i.poolStep2, n = i.poolStep3, r = i.scrollPoolPane, l = r
					.find("#selectGamePool"), h = this, f, u;
			r.css("overflow", "hidden");
			f = function() {
				var i = s.height(), c, f = t(a).height(), u = l.height(), g = n
						.height()
						+ o.height() + 67;
				c = f - g;
				c < e && (c = e);
				c > u && (c = u);
				r.css("height", c);
				h.betPoolScrollBar && h.betPoolScrollBar.reinitialise();
				h.reSetRightSidePosition && h.reSetRightSidePosition()
			};
			c.reSetRightSideHeight = f;
			t(a).resize(function() {
				u && clearTimeout(u);
				u = a.setTimeout(f, 100)
			});
			return this
		},
		initRuleClick : function() {
			t("#orderRule").click(function() {
				t(this).find(".icoFx").toggleClass("icoFx_active")
			});
			return this
		},
		changeTime : function() {
			var e = this, i = this.cache.changeTime;
			i.jSelect({
				method : "mouseover",
				hitCss : "showOption"
			}, function(e) {
				var i, a = e.option.hash.substr(1);
				if (o)
					i = o.getBetArea();
				if (i)
					i.eachGameInfo(function(e, i) {
						if (i.startTime && i.endTime)
							if ("1" == a)
								i.ele.find("span.gameTime i").html(
										t.formatTime(i.startTime, "MM-dd")
												+ "</br>"
												+ t.formatTime(i.startTime,
														"hh:mm"));
							else
								i.ele.find("span.gameTime i").html(
										t.formatTime(i.endTime, "MM-dd")
												+ "</br>"
												+ t.formatTime(i.endTime,
														"hh:mm"))
					})
			});
			return this
		},
		changeDate : function() {
			var e = this.cache.changeDate;
			e.jSelect({
				method : "click"
			}, function(e) {
				if (e.newVal) {
					var t = this.hash.substr(1);
					var i = r.getCurrentRouter(), a;
					i += "?betDate=" + t;
					a = o.getPlayType();
					History.pushState(null, r.getTitleByPlayType(a), i)
				}
			});
			return this
		},
		changeGame : function() {
			var t = this.cache.changeGame, i = this.cache.gameMenu;
			if (!t.length)
				return this;
			t.jSelect({
				method : "click"
			}, function(t) {
				var i = e.cache.betDate || "", a;
				if (t.newVal) {
					var s = t.option.getAttribute("data-playtype");
					if (s) {
						a = r.getPathByPlayType(s);
						if (i)
							a += "?betDate=" + i;
						History.pushState(null, r.getTitleByPlayType(s), a)
					}
				}
			});
			i.delegate("li[data-playtype]", "click", function(t) {
				var i = e.cache.betDate || "", a, s;
				t.preventDefault();
				var o = this.getAttribute("data-playtype");
				if (o) {
					if (r.isDgByPlayType(o))
						s = LS.get("jclqDefPlayType");
					else
						s = LS.get("jclqDefDgPlayType");
					if (s)
						o = s;
					a = r.getPathByPlayType(o);
					if (i)
						a += "?betDate=" + i;
					History.pushState(null, r.getTitleByPlayType(o), a)
				}
			});
			return this
		},
		changeAnData : function() {
			var e = this, i = this.cache.main, a = this.cache.changeBetPop;
			a.jSelect({
				method : "mouseover",
				hitCss : "showOption"
			}, function(e) {
				var a = e.option.hash.substr(1);
				t.each([ "onlyBidCounts", "onlyHotCounts" ], function(e, t) {
					if (e + 1 == a)
						i.addClass(t);
					else
						i.removeClass(t)
				})
			});
			return this
		},
		initDisplayToolBar : function() {
			var e = this.cache, i = e.stopGame, a = this, s = function() {
				var e = t(this).find(".icoFx"), a;
				e.toggleClass("icoFx_active");
				a = {
					isStop : i.find(".icoFx").hasClass("icoFx_active")
				};
				o.getBetArea().display(1, a)
			};
			i.click(s);
			return this
		},
		betTipsOpertion : function() {
			var e = this;
			this.cache.tzTips.delegate(".cuspText", "click", function() {
				var i = t(this), s = i.parents(".tzTips");
				if (!s.hasClass("closeData")) {
					s.addClass("closeData");
					e.reSetRightSidePosition && e.reSetRightSidePosition();
					i.html('显示<i class="cusp"></i>')
				} else {
					i.html('隐藏<i class="cusp"></i>');
					e.reSetRightSidePosition && e.reSetRightSidePosition();
					s.removeClass("closeData")
				}
				if (t.browser.msie && +t.browser.version < 7)
					t(a).triggerHandler("scroll")
			});
			return this
		},
		initNews : function() {
			var e;
			t(".eventTips").delegate("li", "mouseenter mouseleave",
					function(e) {
						if ("mouseover" == e.type)
							this.className = "hover";
						else
							this.className = ""
					}).mouseenter(function() {
				var i = t(this);
				e && a.clearTimeout(e);
				e = a.setTimeout(function() {
					i.addClass("eventTipsHover")
				}, 200)
			}).mouseleave(function() {
				var i = t(this);
				e && a.clearTimeout(e);
				i.removeClass("eventTipsHover")
			});
			return this
		},
		payEvent : function() {
			var a = this.cache, s, n = a.buy, c = a.groupBuy, l = e, h = a.totalMoney, f = function() {
				var e = o.getBetMethod(), t = o.getBetPool();
				var a = {
					stakeNumber : t.serialize(),
					gameExtra : e.serialize(),
					gameId : i.config.gameId,
					betTimes : l.betTime.get(),
					isSupportPassWay : "1"
				}, s = l.config.activityType;
				s && (a.activityType = s);
				return a
			};
			n.bind("click", function() {
				if (false !== l.baseCheck())
					r.payOrder(f(), 1);
				t(this).blur()
			});
			c.bind("click", function() {
				s = +h.html() || 0;
				if (!l.baseCheck())
					return;
				if (s < 8) {
					i.alert("发起合买时投注金额不能少于8元，再多选几注吧！");
					return
				}
				r.openGroupBuyDialog(s);
				t(this).blur()
			});
			return this
		},
		initParam : function() {
			var i = t.getPara(), a = e;
			if (i)
				try {
					if (i && i.gameStr)
						e.defaultGame(i.gameStr, i.gameExtra);
					var s;
					s = i.betTimes;
					if (!isNaN(s)) {
						s = Math.floor(s);
						if (s < 0)
							s = 0;
						if (s > 99999)
							s = 99999;
						a.betTime.set(s)
					}
					if (i.anchor) {
						var o = a.betArea.get(), n = o.gameInfo[i.anchor].ele, r = a.betArea.config;
						if (n) {
							a.scrollWhenNeed(n.offset().top - 60);
							n.addClass(r.hoverGame);
							a.betArea.cache.gameWrap.delegate(r.oneGameSelect,
									"mouseenter", function(e) {
										var i = t(this);
										if (i[0] != n[0])
											n.removeClass(r.hoverGame);
										else
											n.addClass(r.hoverGame)
									})
						}
					}
					if (i.autoPay && 1 == i.autoPay)
						a.cache.buy.trigger("click")
				} catch (c) {
				}
			return this
		},
		detailBounds : function() {
			var t = this, s = e;
			this.cache.openDetailBonus
					.click(function(n) {
						n.preventDefault();
						var r = s.config, c = t.cache, l = r.detailBoundUrl, h = o
								.getBetMethod(), f = i.config.gameId, u = o
								.getBetPool(), g = o.getBetArea(), m = u.config.teamData, d = {};
						if (!l)
							return;
						if (false !== s.baseCheck()) {
							if (+c.gameZhu.html() > 1e4) {
								i.alert("请选择10000注以下的查看");
								return this
							}
							d.betTimes = s.betTime.get();
							d.totalMoney = +c.totalMoney.html();
							d.selectMethod = h.get().selectMethod;
							d.stakeNumberStr = u.serialize();
							d.gameExtra = h.serialize();
							d.gameId = f;
							d.gameEn = i.config.gameEn;
							d.activityType = r.activityType;
							d.selectGameInfo = s.formatGameInfo4Detail(g
									.getGameInfo(), u.get(), m);
							e.bonusCalcData = d;
							a.open(l, "_blank")
						}
					});
			return this
		},
		initDgSupport : function() {
			var i = e.cache.supportDg, a = t(".main");
			i.click(function(e) {
				var t = i.find(".icoFx");
				if (t.hasClass("icoFx_active")) {
					t.removeClass("icoFx_active");
					a.removeClass("showDgTips")
				} else {
					t.addClass("icoFx_active");
					a.addClass("showDgTips")
				}
			});
			return this
		}
	};
	t
			.extend(
					e,
					{
						baseCheck : function() {
							var e = this.cache, a = this.getMinMethod(), s = o
									.getBetArea(), n = o.getBetPool(), c = n
									.get().length, l = o.getBetMethod(), h = e.gameZhu;
							if (!t("#orderRule i.icoFx").hasClass(
									"icoFx_active")) {
								i.alert("请先阅读并同意《委托投注规则》后才能继续");
								return false
							}
							if (!(c >= a)) {
								if (1 == a)
									r.messageTip("请在左侧列表选择投注比赛");
								else
									r.messageTip("请在左侧列表至少选择2场比赛");
								return false
							}
							if (!l.get().selectMethod.length) {
								r
										.messageTip('请选择过关方式&nbsp;&nbsp;<i inf="N串1，即将N场比赛串联成一注，猜对N场即可中奖" class="questionMark jtip"></i>');
								return false
							}
							if (!this.betTime.get()) {
								r.messageTip("方案倍数不正确");
								return false
							}
							return true
						}
					});
	e.common = e.common || {};
	c = t.extend(e.common, c);
	e.common = c
}(Core, jQuery, Game, window);