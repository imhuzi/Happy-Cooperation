/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
(function (f) {
	//验证配置
	var a = {
		errorRequired: "此项为必填项",
		errorTempl: '<span class="help-inline validate-error">{msg}</span>',
		successTempl: '<span class="help-inline validate-success">　</span>',
		optionTempl: '<span class="help-inline validate-option">{msg}</span>',
		callback: null,
		showSuccess: false
	},
	c = ".form-group", //
	b = ".validate-error",//
	success = ".validate-success",//
	e = ".validate-option",//
	//验证函数
	d = function (i, h, k, g, j) {
		if (!h || !i) {
			return
		}
            
		//远程验证列表
		this.asyncList = [];
		this.asyncEndHandle = null;
		//初始化
		this._init(i, h, k, g, j)
	};
	d.prototype = {
        
		/**
         * i为form或form外层，h为验证规则（rules），l错误提示(errorMsg)，g提示(optionMsg)，k配置选项(config)
         */
		_init: function (i, h, l, g, k) {
			var j;
			j = this.node = f(i);
			this.form = (j.prop("tagName").toLowerCase() === "form") ? j : j.find("form");
			this.config = f.extend(a, k);
			this.rules = h;
			this.errorMsg = l || {};
			this.optionMsg = g || {};
			j.data("validateForm", this);
			this._bindEvent()
		},
        
		/**
         * 绑定事件
         */
		_bindEvent: function () {
			//如果已经绑定过了就返回
			if (this.node.data("hasBindValidateEvent")) {
				return
			}
            
			//
			this.node.data("hasBindValidateEvent", true);
            
			//给form绑定submit事件
			this.form.submit(f.proxy(function (g) {
				this.validate();
				this._handleFormSubmit(g);
			}, this)).find("input, select, textarea").unbind(".validate").bind({
				"change.validate": f.proxy(function (g) {
					this._handleBlur(g)
				}, this),
				"blur.validate": f.proxy(function (g) {
					$(g.currentTarget).removeClass("focus");	
					this._handleBlur(g)
				}, this),
				"focus.validate": f.proxy(function (g) {
					$(g.currentTarget).addClass("focus");	
					this._handleFocus(g)
				}, this)
                
			});
            
			//绑定规则
			this._bindRules()
		},
        
		//绑定规则
		_bindRules: function () {
			var h = this.rules,
			g;
                
			//对规则进行循环 把每个验证规则字段存到相应的字段元素中
			for (g in h) {
				if (h.hasOwnProperty(g)) {
                    
					f(h[g].elems, this.form).each(function (k, m) {
						var j = f(m),
						l = j.data("validate-rules") || "";
						j.data("validate-rules", l + "," + g)
					})
				}
			}
		},
        
		//失去光标事件
		_handleBlur: function (n) {
			var h = f(n.target),
			o = h.parents(c),
			l, g, m, j, p = false,
			q = h.data("validate-rules");
			o.find(e).hide();
			if (!q) {
				return
			}
            
			/**
             * 对验证规则进行循环处理q:
             * {elems: '#title',
                isNull: function (el) {
                    return !$.trim(el.val());
                },
                tooLong: function (el) {
                    return $.trim(el.val()).replace(/[^\x00-\xff]/g, '豆瓣').length > 64;
                }}
             * 
             */
			q = q.split(",").slice(1);
			for (l = 0, m = q.length; l < m; l++) {
				g = this.rules[q[l]];
				//对每一个验证规则进行验证（校验规则，校验错误提示，当前对象）
				this.validate(g, this.errorMsg[q[l]], h)
			}
		},
        
		/**
         *  focus的时候，根据h的name显示提示
         */
		_handleFocus: function (h) {
			var g = h.target.getAttribute("name"),
			i;
			if (!g) {
				return
			}
            
			if (i = this.optionMsg[g.toLowerCase()]) {
				this.displayOptionMsg(f(h.target), i)
			}
		},
        
		/**
         * 
         */
		_handleFormSubmit: function (i) {
			var h, g, j = this;
			h = this.form.find(".has-error");
			if (h.length > 0) {
				i.preventDefault();
				f(j.form).trigger("hasError");
				return false;
			}
			g = this.form.find(".has-process");
			if (g.length > 0) {
				i.preventDefault();
				this.asyncEndHandle = function () {
					j.asyncEndHandle = null;
					j._handleFormSubmit(i);
				};
				return false;
			}
			if (j.config.callback) {
                  console.log(23423);
				j.config.callback(j.form);
			} else {
				j.form[0].submit();
			}
		},
        
		/**
         *  清空错误消息
         */
		clearErrorMsg: function (g) {
			var h = g.parents(c);
			h.find(b).hide()
		},
        
		/**
         *  显示错误提示（i当前elm,k提示信息）
         */
		displayError: function (i, k) {
			var j = i.parents(c),
			h = j.find(e),
			g = j.find(b);
			j.find(success).hide();
			h.hide();
			if (g.length === 0) {
				f(this.config.errorTempl.replace("{msg}", k)).appendTo(j).show();
				return
			}
			g.show().html(k);
			return
		},
		displaySuccess: function(i){
			var j = i.parents(c),
			h = j.find(e),
			g = j.find(success);
			//如果还在进行远程验证处理则返回
			if (j.hasClass("has-process")) {
				return;
			}
			j.addClass("has-success");
			h.hide();
			if (g.length === 0) {
				f(this.config.successTempl).appendTo(j).show();
				return
			}
			g.show();
			return
		},
		/**
         *  显示提示
         */
		displayOptionMsg: function (i, k) {
			if (!k) {
				return
			}
			//如果已经显示了error，return
			var j = i.parents(c),
			h = j.find(e),
			g = j.hasClass("error")||j.hasClass("success");
			if (g) {
				return
			}
            
			//没有则，根据模版显示错误提示
			if (h.length === 0) {
				f(this.config.optionTempl.replace("{msg}", k)).appendTo(j).show();
				return
			}
			h.show().html(k);
			return
		},
        
		/**
         * 远程验证
         */
		asyncValidate: function (i, h, g) {
			if (!i || !h) {
				return
			}
			var j = i.parent();
			if (j.hasClass("has-process")) {
				return
			}
			j.addClass("has-process");
			this.asyncList.push(f.getJSON(h, f.proxy(function (k) {
				var l = this.asyncList;
				g && g(k);
				j.removeClass("has-process");
				this.asyncList.pop();
				if (l.length === 0) {
					this.asyncEndHandle && this.asyncEndHandle()
				}
			}, this)));
			f("body").ajaxError(function (i,j,k) {
				alert("远程验证失败！\n请稍候重试或将此问题反馈给我们")
			})
		},
        
		/**
         * 规则（rules），错误信息(errors)，当前对象(this)
         */
		validate: function (m, l, h) {
			var i = this.errorMsg.errorRequired,
			/**
                 * v验证规则，x提示信息，t当前元素，w>this
                 */
			n = function (v, x, t, w) {
				var u = t.parents(c),
				q = false,
				s;
                    
				//如果是必填项
				if (v.isRequired && f.trim(t.val()) === "") {
					w.displayError(t, i || a.errorRequired);
					q = true;
					u.addClass("has-error").removeClass('field-null');
				} else {
                        
					//对自定义规则的验证函数进行循环
					for (s in v) {
						if (v.hasOwnProperty(s) && typeof v[s] === "function") {
                                
							//验证函数必须返回一个
							if (v[s](t, w)) {
								w.displayError(t, x[s]);
								u.addClass("has-error").removeClass('field-null');
								q = true;
								break
							}
						}
					}
					if (!q) {
						w.clearErrorMsg(t);
						u.removeClass("has-error")
						//是否显示验证成功标志
						w.config.showSuccess && w.displaySuccess(t);
					}
				}
			},
			g, p, o, j;
            
			if (!m) {
				p = this.rules;
				o = this.errorMsg;
				for (j in p) {
					if (p.hasOwnProperty(j)) {
						g = p[j];
						f(g.elems, this.form).each(f.proxy(function (k, q) {
							n(g, o[j], f(q), this)
						}, this))
					}
				}
			} else {
				n(m, l, h, this);
			}
		}
	};
    
	f.extend({
		validate: {
			isEmail: function (g) {
				return /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(g)
			},
			isUrl: function(g){
				return /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(g);
			},
			isPhone: function(g){
				var tel = /^\d{3,4}-?\d{7,8}$/;
				var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
				return mobile.test(g)||tel.test(g);
			}
		}
	});
    
	f.fn.validateForm = function (j, l, i, k) {
		var h = i,
		g = k;
		if (arguments.length === 3) {
			h = null;
			g = i
		}
		this.each(function () {
			new d(this, j, l, h, g)
		});
		return this
	}
})(jQuery);