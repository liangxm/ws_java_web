!function(t,e,i){var n=function(t,i,n){this.config=e.extend({},r,n||{});var o=1==t?this.init:this["init"+t];if(e.isFunction(o))o.call(this,i);else this.init2(i)},r={css:"",wraper:"<div class='jtipWraper'><i></i>{content}</div>",maxWidth:225},o=function(t){var n=0,r=function(t){var e=t.offsetParent(),i=e[0]?((e.css("zIndex")||"")+"").replace(/\D/g,""):"";if(i)n=Math.max(n,+(i||1));if(!e[0]||e[0]==document.body)return;r(e)};r(e(t));return n<=0?i:n+2};n.prototype={init:function(t){var i=this;e(t).bind({mouseenter:function(t){i.mouseenter(t,this)},mouseleave:function(t){i.mouseleave(t,this)}})},init2:function(t){var i=this;e(document).delegate(t,"mouseenter",function(t){i.mouseenter(t,this)}).delegate(t,"mouseleave",function(t){i.mouseleave(t,this)})},init3:function(t){var i=this;e(document).delegate(t,"click",function(t){i.mouseenter(t,this,true)}).delegate(t,"mouseleave",function(t){i.mouseleave(t,this)})},mouseenter:function(i,r,o){var u=this,s=e(r),a=s.attr("title");if(a)s.attr("inf",a).removeAttr("title");r.timer&&t.clearTimeout(r.timer);r.timer=t.setTimeout(function(){n.hide();u.showTipFor(r)},o?0:200)},mouseleave:function(e,i){i.timer&&t.clearTimeout(i.timer);i.timer=t.setTimeout(n.hide,200)},showTipFor:function(r){var u=e(r),s=u.attr("tip"),a=u.attr("title"),c=u.attr("inf"),f,h=this,d=this.config.wraper,m,l,p,v,g,w,T=0,x;if(a)u.attr("inf",a).removeAttr("title");f=s?e(s):a||c?e(d.replace(/{content}/g,a||c)).appendTo(document.body):[null];if(!f[0])return;if(!f[0].id){f[0].id="tip"+ +new Date+parseInt(1e3*Math.random());u.attr("tip","#"+f[0].id)}p=f[0].autoCreate||!s;if(p)f[0].autoCreate=true;x=new Function("return {"+(u.attr("tipconf")||"").replace(/[\{\}]/g,"")+"}")();e.each(["maxWidth","css"],function(t,e){h.config[e]=x[e]||h.config[e]});this.config.css&&f.addClass(this.config.css);n.Current=r;if(!f[0].initTipEvent){f.appendTo(document.body).bind({mouseenter:function(){r.timer&&t.clearTimeout(r.timer)},mouseleave:function(){r.timer=t.setTimeout(n.hide,200)}});f[0].initTipEvent=true}f.removeAttr("style").show();if(f[0].autoCreate&&f.outerWidth()>this.config.maxWidth)f.width(this.config.maxWidth);m=u.offset();l={width:u.outerWidth(),height:u.outerHeight()};if(x.center)v=m.left+l.width/2-f.outerWidth()/2;else v=m.left+l.width/2-25;if(f[0].autoCreate){g=Math.max(e(t).width(),e(document.body).width())-f.outerWidth()+e(t).scrollLeft(),w=v;if(g<w){T=w-g;v=g}else if(w<0){T=-w;v=0}if(x.center)f.find("i").css("left",f.outerWidth()/2-f.find("i").width()/2);else f.find("i").css("left",19+T)}var W=(f.css("zIndex")+"").replace(/\D/g,""),y=p||!W?o(u):i;f.hide().css({left:v,top:m.top+l.height+10,position:"absolute",zIndex:y}).show();if(y)f.attr("autoIndex",y)}};n.hide=function(i){var r=n.Current,o;if(r){r.timer&&t.clearTimeout(r.timer);o=e(e(r).attr("tip"));if(!i||i&&o.attr("autoIndex")){o.hide();n.Current=null}}};e.fn.jtip=function(t){return this.each(function(){new n(1,this,t)})};var u={};e.jtip=function(t,e){if("string"!=typeof t)return this;if(u[t])return this;u[t]=1;var i={click:3}[(e||{}).method||""]||2;new n(i,t,e);return this};e.jtip.hide=function(){n.hide()};e(t).scroll(function(){n.hide(true)})}(window,jQuery);