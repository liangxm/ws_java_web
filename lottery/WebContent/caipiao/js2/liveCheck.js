!function(e, i) {
	var t = function(i, t) {
		var n = function(n) {
			var a = this;
			e.setTimeout(function() {
				var e = i, r = new RegExp(e.source, [ "g",
						e.ignoreCase ? "i" : "", e.multiline ? "m" : "" ]
						.join("")), s = a.value, u = s.replace(r, "");
				if (s != u)
					a.value = u;
				t.call(a, n)
			}, 10)
		};
		return n
	}, n = function(i, t) {
		var n = function(n) {
			var a = n.charCode || n.keyCode;
			if (0 == a || n.ctrlKey || n.altKey || a < 32 || a > 34 && a < 41
					|| 0 == n.charCode && 46 == a)
				return true;
			if (String.fromCharCode(a).search(i) >= 0)
				return false;
			var r = this;
			e.setTimeout(function() {
				t.call(r, n)
			}, 10)
		};
		return n
	}, a = function(e) {
		var i = function() {
			var i = this.value, t = i.replace(/^0+/, ""), n = t || "0";
			if ((n != i || n != t) && i)
				this.value = +n || "";
			e && e.apply(this, arguments)
		};
		return i
	};
	i.fn
			.extend({
				disableIME : function() {
					return this.css("ime-mode", "disabled")
				},
				bindAutoCheck : function(e) {
					switch (e) {
					case 0:
						this.bindLiveCheck(/\D/g).disableIME();
						break;
					case 1:
					case 2:
						this
								.bindLiveCheck(
										/[^\d\.]/g,
										function(t) {
											var n = this.value, a = i
													.trim(n)
													.replace(/^0+([1-9])/, "$1")
													.replace(/^\./, "0.")
													.replace(
															[ /\.(\d?).*$/,
																	/\.(\d{0,2}).*$/ ][e - 1],
															".$1");
											if (n != a)
												this.value = a
										}).disableIME();
						break;
					case 3:
						this.bindLiveCheck(/\W/g).disableIME();
						break;
					case 4:
						this.bindLiveCheck(/[^A-Z0-9a-z.@_%+-]/g).disableIME()
								.blur(
										function(e) {
											/^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/
													.test(this.value)
													|| i(this).flash(
															function() {
																this.value = ""
															})
										});
						break;
					case 5:
						this.bindLiveCheck(/\D/g).disableIME().blur(
								function(e, t) {
									/^1\d{10}$/.test(this.value)
											|| i(this).flash(function() {
												this.value = ""
											})
								})
					}
					return this
				},
				bindLiveCheck : function(e, a) {
					var r = a || i.noop, s = t(e, r);
					return this.bind({
						keypress : n(e, r),
						keyup : s,
						drop : s,
						paste : s
					})
				},
				bindLiveCheck2 : function(e, a, r) {
					var s = r || i.noop, u = t(a, s);
					return this.delegate(e, "keypress", n(a, s)).delegate(e,
							"keyup", u).delegate(e, "drop", u).delegate(e,
							"paste", u)
				},
				bindNumberLiveCheck : function(e) {
					this.bindLiveCheck(/\D/g, a(e)).disableIME();
					return this
				},
				bindNumberLiveCheck2 : function(e, i) {
					this.bindLiveCheck2(e, /\D/g, a(i));
					this.find(e).disableIME();
					return this
				}
			})
}(window, jQuery);