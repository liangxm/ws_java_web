!function(e, t, r, n) {
	"use strict";
	Class.Base.Event.extend("Game.COMS.JC.JCGameManage", {
		config : {
			isDestory : true
		},
		cache : {
			betAreas : null,
			currentBetArea : null,
			currentPlayType : null,
			betMethods : null,
			currentBetMethod : null,
			betPools : null,
			currentBetPool : null
		},
		init : function(t) {
			this.config = e.extend(t, this.config);
			this.cache = e.extend({}, this.cache);
			this.cache.betAreas = {};
			this.cache.betMethods = {};
			this.cache.betPools = {};
			this.callSuper("onGameChange onBeforeGameChange onGameInit");
			if (this.config.defaultGame)
				this.altGame(this.config.defaultGame)
		},
		altGame : function(e, t) {
			var r = this.cache;
			if (!e)
				return this;
			this.trigger("onBeforeGameChange");
			if (!this.config.defaultGame)
				this.config.defaultGame = e;
			this.loadGameControl(e, function(t, r, n) {
				var c = this.cache;
				c.currentBetArea = t;
				c.betAreas[e] = t;
				c.currentBetMethod = n;
				c.betMethods[e] = n;
				c.currentBetPool = r;
				c.betPools[e] = r;
				if (!this.config.isDestory) {
					c.currentBetArea.show();
					c.currentBetMethod.show();
					c.currentBetPool.show()
				}
				c.currentPlayType = e;
				this.trigger("onGameChange", e, t, r, n)
			})
		},
		loadGameControl : function(e, r) {
			var n = this.cache, c, o, i = this;
			if (n.loading)
				return this;
			if (!e)
				return this;
			o = this.config.gameConfig[e];
			if (!o)
				return this;
			c = o.path;
			if (!c)
				return;
			if (n.betAreas[e] && !this.config.isDestory) {
				n.currentBetArea.clear();
				n.currentBetArea.hide();
				n.currentBetMethod.hide();
				n.currentBetPool.hide();
				r.call(this, n.betAreas[e], n.betPools[e], n.betMethods[e])
			} else {
				if (n.currentBetArea)
					if (this.config.isDestory)
						this.destoryCurrentBet();
					else {
						n.currentBetArea.clear();
						n.currentBetArea.hide();
						n.currentBetMethod.hide();
						n.currentBetPool.hide()
					}
				n.loading = e;
				t.loadCdnJS(c, function() {
					return !!t.betModule
				}, function() {
					var c = t.betModule, h = c.init(o);
					if (h.betArea && h.betMethod && h.betPool) {
						r.call(i, h.betArea, h.betPool, h.betMethod);
						i.trigger("onGameInit", e, h.betArea, h.betPool,
								h.betMethod)
					}
					n.loading = null
				})
			}
		},
		getBetArea : function() {
			return this.cache.currentBetArea
		},
		getBetMethod : function() {
			return this.cache.currentBetMethod
		},
		getBetPool : function() {
			return this.cache.currentBetPool
		},
		getPlayType : function() {
			return this.cache.currentPlayType
		},
		destoryCurrentBet : function() {
			var e = this.getPlayType();
			if (e) {
				if (this.cache.currentBetArea) {
					this.cache.currentBetArea.destory();
					this.cache.currentBetArea = null;
					this.cache.betAreas[e] = null
				}
				if (this.cache.currentBetPool) {
					this.cache.currentBetPool.destory();
					this.cache.currentBetPool = null;
					this.cache.betPools[e] = null
				}
				if (this.cache.currentBetMethod) {
					this.cache.currentBetMethod.destory();
					this.cache.currentBetMethod = null;
					this.cache.betMethods[e] = null
				}
			}
		}
	})
}(jQuery, Core, Game, window);