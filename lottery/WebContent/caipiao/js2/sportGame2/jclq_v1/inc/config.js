!function(e, t, o, n, l) {
	"use strict";
	var i = {
		mainSelector : ".main",
		gameWrapSelector : ".gameSelect",
		gameNumberSelector : "#gameNumber",
		gameZhuSelector : "#gameZhu",
		totalMoneySelector : "#totalMoney",
		maxbonusSelector : "#maxbonus",
		floatBoxSelector : ".floatBox",
		buySelector : "#poolStep3 .ljtzBtn",
		groupBuySelector : "#poolStep3 .fqhmBtn",
		openDetailBonusSelector : "#openDetailBonus",
		changeDateSelector : "#changeDate",
		poolErrorTipsSelector : "#poolErrorTips",
		tipMarkSelector : "#tipMark",
		poolStep1Selector : "#poolStep1",
		poolStep2Selector : "#poolStep2",
		poolStep3Selector : "#poolStep3",
		floatTitleSelector : ".dataHead",
		changeTimeSelector : ".changeTime",
		changeBetPopSelector : ".changeBetPop",
		stopGameSelector : "#stopGame",
		gameMenuSelector : ".gameMenu",
		changeGameSelector : "#changeGame",
		tzTipsSelector : ".tzTips",
		scrollPoolPaneSelector : ".scrollMoni",
		supportDgSelector : "#supportDg",
		gameTypeTipsSelector : ".gameTypeTips",
		init : function() {
			var e = {}, n = /(\S+)Selector$/;
			for ( var l in this)
				if ("string" == o.getType(l) && n.test(l))
					e[RegExp.$1] = t(this[l]);
			delete this.init;
			return e
		}
	};
	var a = {
		gameUrl : "http://caipiao.163.com/order/preBet_jclqNewMixAllAjax.html",
		detailBoundUrl : "http://caipiao.163.com/hit/bonusCalc.html#from=bet",
		groupBuyUrl : "/bet/queryBetType_newgroupBuy.html"
	};
	var f = {
		"1_1" : [ 1 ],
		"2_1" : [ 2 ],
		"3_1" : [ 3 ],
		"4_1" : [ 4 ],
		"5_1" : [ 5 ],
		"6_1" : [ 6 ],
		"7_1" : [ 7 ],
		"8_1" : [ 8 ],
		"9_1" : [ 9 ],
		"10_1" : [ 10 ],
		"11_1" : [ 11 ],
		"12_1" : [ 12 ],
		"13_1" : [ 13 ],
		"14_1" : [ 14 ],
		"15_1" : [ 15 ],
		"2_3" : [ 2, 1 ],
		"3_3" : [ 2 ],
		"3_4" : [ 3, 2 ],
		"3_6" : [ 2, 1 ],
		"3_7" : [ 3, 2, 1 ],
		"4_4" : [ 3 ],
		"4_5" : [ 4, 3 ],
		"4_6" : [ 2 ],
		"4_10" : [ 2, 1 ],
		"4_11" : [ 4, 3, 2 ],
		"4_14" : [ 3, 2, 1 ],
		"4_15" : [ 4, 3, 2, 1 ],
		"5_5" : [ 4 ],
		"5_6" : [ 5, 4 ],
		"5_10" : [ 2 ],
		"5_15" : [ 2, 1 ],
		"5_16" : [ 5, 4, 3 ],
		"5_20" : [ 3, 2 ],
		"5_25" : [ 3, 2, 1 ],
		"5_26" : [ 5, 4, 3, 2 ],
		"5_30" : [ 4, 3, 2, 1 ],
		"5_31" : [ 5, 4, 3, 2, 1 ],
		"6_6" : [ 5 ],
		"6_7" : [ 5, 6 ],
		"6_15" : [ 2 ],
		"6_20" : [ 3 ],
		"6_21" : [ 2, 1 ],
		"6_22" : [ 6, 5, 4 ],
		"6_35" : [ 3, 2 ],
		"6_41" : [ 3, 2, 1 ],
		"6_42" : [ 6, 5, 4, 3 ],
		"6_50" : [ 4, 3, 2 ],
		"6_56" : [ 4, 3, 2, 1 ],
		"6_57" : [ 6, 5, 4, 3, 2 ],
		"6_62" : [ 5, 4, 3, 2, 1 ],
		"6_63" : [ 6, 5, 4, 3, 2, 1 ],
		"7_7" : [ 6 ],
		"7_8" : [ 7, 6 ],
		"7_21" : [ 5 ],
		"7_35" : [ 4 ],
		"7_120" : [ 7, 6, 5, 4, 3, 2 ],
		"7_127" : [ 7, 6, 5, 4, 3, 2, 1 ],
		"8_8" : [ 7 ],
		"8_9" : [ 8, 7 ],
		"8_28" : [ 6 ],
		"8_56" : [ 5 ],
		"8_70" : [ 4 ],
		"8_247" : [ 8, 7, 6, 5, 4, 3, 2 ],
		"8_255" : [ 8, 7, 6, 5, 4, 3, 2, 1 ]
	};
	var r = {
		m_1 : [ "1_1", "2_1", "3_1", "4_1", "5_1", "6_1", "7_1", "8_1" ],
		m_n : [ "3_3", "3_4", "4_4", "4_5", "4_6", "4_11", "5_5", "5_6",
				"5_10", "5_16", "5_20", "5_26", "6_6", "6_7", "6_15", "6_20",
				"6_22", "6_35", "6_42", "6_50", "6_57", "7_7", "7_8", "7_21",
				"7_35", "7_120", "8_8", "8_9", "8_28", "8_56", "8_70", "8_247" ]
	};
	var g = {
		sf : [ [ "blockFu", "主队负", "0" ], [ "blockWin", "主队胜", "3" ] ],
		rfsf : [ [ "blockFu", "让分主负", "1000" ], [ "blockWin", "让分主胜", "1003" ] ],
		sfc : [ [ "blockYel", "客胜1-5", "01" ], [ "blockYel", "客胜6-10", "02" ],
				[ "blockYel", "客胜11-15", "03" ],
				[ "blockYel", "客胜16-20", "04" ],
				[ "blockYel", "客胜21-25", "05" ], [ "blockYel", "客胜26+", "06" ],
				[ "blockYel", "主胜1-5", "31" ], [ "blockYel", "主胜6-10", "32" ],
				[ "blockYel", "主胜11-15", "33" ],
				[ "blockYel", "主胜16-20", "34" ],
				[ "blockYel", "主胜21-25", "35" ], [ "blockYel", "主胜26+", "36" ] ],
		dxf : [ [ "blockYel", "大分", "102" ], [ "blockYel", "小分", "101" ] ]
	};
	var c = {
		sf : {
			gameTypes : [ "sf" ],
			playType : "sf",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.sf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		rfsf : {
			gameTypes : [ "rfsf" ],
			playType : "rfsf",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.rfsf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		sfc : {
			gameTypes : [ "sfc" ],
			playType : "sfc",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.sfc .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		dxf : {
			gameTypes : [ "dxf" ],
			playType : "dxf",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.dxf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		mixall : {
			gameTypes : [ "sf", "rfsf", "sfc", "dxf" ],
			playType : "mixall",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.mixGg .attentionMenu"
				},
				betViewConfig : {
					moreOptionTplSelector : "#moreOptionTpl"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		mixall4dg : {
			gameTypes : [ "sf", "rfsf", "sfc", "dxf" ],
			playType : "mixall4dg",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.mixGg .attentionMenu"
				},
				betViewConfig : {
					moreOptionTplSelector : "#moreOptionTpl"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		sf4dg : {
			gameTypes : [ "sf" ],
			playType : "sf4dg",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.sf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		rfsf4dg : {
			gameTypes : [ "rfsf" ],
			playType : "rfsf4dg",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.rfsf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		sfc4dg : {
			gameTypes : [ "sfc" ],
			playType : "sfc4dg",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.sfc .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		dxf4dg : {
			gameTypes : [ "dxf" ],
			playType : "dxf4dg",
			betAreaConfig : {
				attentionViewConfig : {
					attentionMenuSelector : "dl.dxf .attentionMenu"
				}
			},
			betPoolConfig : {},
			betMethodConfig : {}
		},
		allGameTypes : [ "sf", "rfsf", "dxf", "sfc" ],
		init : function() {
			var e = [ "sf", "rfsf", "sfc", "dxf", "mixall", "mixall4dg",
					"sf4dg", "rfsf4dg", "sfc4dg", "dxf4dg" ];
			var o = [ '<tr matchcode="{matchCode}" class="gameTitle">', "<th>",
					'<a class="icoDel" href="javascript:;"></a>{matchnumcn}',
					"</th>", '<th class="tr">{guestName}</th>', "{VS}",
					'<th class="tl">{hostName}</th>', "{dan}", "</tr>",
					'<tr class="gameOption" matchCode={matchCode}>',
					"{option}", "</tr>" ].join("");
			for (var n = 0; n < e.length; n++) {
				this[e[n]].path = "js2/sportGame2/jclq_v1/all.js";
				t.extend(this[e[n]].betAreaConfig, {
					gameTypes : this[e[n]].gameTypes,
					playType : e[n]
				});
				t.extend(this[e[n]].betMethodConfig, {
					method : r,
					methodType : f
				});
				t.extend(this[e[n]].betPoolConfig, {
					gameTypes : this[e[n]].gameTypes,
					teamData : g,
					oneGameTmp : o
				})
			}
			delete this.init;
			return c
		}
	};
	e.pageConfigInit = function() {
		delete this.pageConfigInit;
		return {
			gameConfig : c.init(),
			config : a,
			eleConfig : i.init()
		}
	}
}(Core, jQuery, Game, window);