/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudongfenxiang.controller;

import com.hudongfenxiang.utils.Global;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

/**
 *
 * @FileName     :  BaseController.java
 * @Encoding     :  UTF-8
 * @Package      :  com.hudongfenxiang.controller
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 12, 2013, 12:24:04 AM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
@Controller
public class BaseController {

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("text/html;charset=GBK");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        return response;
    }

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    public Boolean isAjaxRequest() {
        String xr = BaseController.getRequest().getHeader("x-requested-with");
        Boolean result = false;
        if (xr != null && !"".equals(xr) && xr.equals("XMLHttpRequest")) {
            result = true;
        }
        return result;
    }
    /**
     * 根据view name 获取站点主题某个视图 path + view name
     *
     * @param viewName
     * @return String 返回值: path + view name
     */
    public static String getThemeView(String viewName) {
        return Global.SITE_THEME_PATH + Global.SITE_THEME_NAME + "/" + viewName;
    }
    
    /**
     * 根据view name 获取站点后台某个页面视图
     *
     * @param viewName
     * @return String 返回值: path + view name
     */
    public static String getAdminView(String viewName) {
        return Global.ADMIN_THEME_PATH + viewName;
    }
    /**
     * <p>根据 动作和模块前缀,子模块前缀生成URI </p>
     *
     * <i>example for : ResourcePrefix/module_prefix/sub_module_prefix/action</i>
     *
     * @param action
     * @return String 返回模块完整的uri
     */
    public String getURI(String action) {
        return "";
    }

    /**
     * <p>根据动作返回 重定向uri</p>
     *
     * @param action
     * @return String
     */
    public String getRedirectURI(String action) {
        return "redirect:" + getURI(action);
    }
}
