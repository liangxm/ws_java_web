!function(a, t, e, i, n) {
	"use strict";
	var g = a.isSupportTouch ? "tap" : "click", s = t.common, o = t.helper;
	a.extend(t, {
		config : {},
		cache : {
			matchList : null
		},
		quickInit : function() {
			var e;
			if (t.pageConfigInit) {
				e = t.pageConfigInit();
				a.extend(this.config, e.config);
				this.gameConfig = e.gameConfig;
				a.extend(this.cache, e.eleConfig);
				a.extend(s.cache, e.eleConfig)
			}
			this.initGameManage();
			s.init();
			this.initBetTimes();
			return this
		},
		myInit : function() {
			return this
		},
		initBetTimes : function() {
			var a = this;
			this.betTime = e.createCom("COMS.JC.iNumber", {
				wrap : "#betTimes",
				max : +a.config.maxBetTimes || 5e5
			});
			this.betTime.onChange(function(a) {
				t.helper.updateGameInfo()
			});
			return this
		},
		initGameManage : function() {
			var a = Class.Game.COMS.JC.JCGameManage.create({
				gameConfig : t.gameConfig
			});
			t.jcGameManage = a;
			delete this.initGameManage;
			return this
		},
		loadData : function(i) {
			var n = this.cache, g = this.config, s = this.config.gameUrl;
			o.changeLoadingStatus(3);
			this.get(s, i, function(s, c) {
				var h;
				if (s) {
					o.changeLoadingStatus(2);
					a.sendMsg("loadData", 3);
					n.loadDataStatus = 3
				}
				try {
					c = JSON.parse(c) || t.parseJSON(c);
					if (!c) {
						o.changeLoadingStatus(1);
						n.loadDataStatus = 1;
						n.matchList = [];
						g.isSupportDg = h.isSupportDg;
						return
					}
					h = o.explainData(c, t.gameConfig.allGameTypes);
					n.matchList = h.listData || [];
					g.isSupportDg = h.isSupportDg;
					n.betDate = i.betDate;
					e.config = e.config || {};
					e.config.gameEn = c.gameEn;
					e.config.gameId = c.gameId;
					if (!n.matchList.length) {
						o.changeLoadingStatus(1);
						n.loadDataStatus = 1;
						a.sendMsg("loadData", 1);
						return
					}
					o.changeLoadingStatus(0);
					n.loadDataStatus = 0;
					a.sendMsg("loadData", 0)
				} catch (r) {
					o.changeLoadingStatus(2);
					a.sendMsg("loadData", 2);
					n.loadDataStatus = 2
				}
			}, "@zqdcMixp");
			return this
		}
	})
}(jQuery, Core, Game, window);