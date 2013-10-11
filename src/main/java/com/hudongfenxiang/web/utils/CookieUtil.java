package com.hudongfenxiang.web.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @FileName     :  CookieUtil.java
 * @Encoding     :  UTF-8
 * @Package      :  com.lezhai365.cms.model
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-8-13, 1:34:52
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *
 */
public class CookieUtil {

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookie = null;
        Cookie[] cookieArr = request.getCookies();
        if (cookieArr != null) {
            for (int i = 0; i < cookieArr.length; i++) {
                if (cookieArr[i].getName().equals(name)) {
                    cookie = cookieArr[i];
                    break;
                }
            }
        }
        return cookie;
    }

    public static String getCookieValue(HttpServletRequest request, String name) {
        String value = "";
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            value = cookie.getValue();
        }
        return value;
    }
}
