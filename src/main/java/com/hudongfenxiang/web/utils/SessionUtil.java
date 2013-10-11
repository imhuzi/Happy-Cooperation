/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.utils;

import com.hudongfenxiang.utils.Global;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @FileName : SessionUtil.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.web.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  Sep 2, 2013, 1:18:36 AM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *   session 工具类
 */
public class SessionUtil {

    /**
     * 取session对象
     *
     * @return
     */
    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    public static Object getObjectFromSession(String key) {
        Object result = null;
        result = getSession().getAttribute(key);
        return result;
    }

    /**
     * 将obj 记录到session 中
     *
     * @param obj
     */
    public static void record(String key, Object obj) {

        HttpSession session = SessionUtil.getSession();
        HttpServletRequest request = RequestUtil.getRequest();
        if (key == null || "".equals(key)) {
            key = Global.SESSION_USER_KEY_PRIX;
        }
        //下次自动登陆
        String isRemenber = request.getParameter("remenber");
        int inactiveinterval = Global.DEFAULT_INACTIVEINTERVAL;
        if (!"".equals(isRemenber) && isRemenber != null) {
            inactiveinterval = Global.MAXINACTIVEINTERVAL;
        }
        session.setMaxInactiveInterval(inactiveinterval);
        session.setAttribute(key, obj);
    }
}
