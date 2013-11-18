/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.controller;

import com.hudongfenxiang.utils.ResourceUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

/**
 *
 * @FileName : BaseController.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.controller
 * @Link           : http://lezhai365.com
 * @Created on  : 2013-8-29,  13:29:32
 * @Author       : Hui.Wang [wanghui@lezhai365.com]
 * @Version    : 1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description
 *  鼻祖controller
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
        response.setHeader("Cache-Control", "no-cache");
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
     * <p>
     * 根据 动作和模块前缀,子模块前缀生成URI </p>
     *
     * <i>example for :
     * ResourcePrefix/module_prefix/sub_module_prefix/action</i>
     *
     * @param action
     * @return String 返回模块完整的uri
     */
    public String getURI(String action) {
        return "";
    }

    /**
     * <p>
     * 根据动作返回 重定向uri</p>
     *
     * @param action
     * @return String
     */
    public String getRedirectURI(String action) {
        return "redirect:" + getURI(action);
    }

    /**
     * <p>
     * 传入站点视图名称返回完整的视图路径</p>
     *
     * @param viewName
     * @return
     */
    public String getSiteView(String viewName) {
        return ResourceUtil.SITE_THEME_PATH + ResourceUtil.SITE_THEME_NAME + "/" + viewName;
    }

    /**
     * <p>
     * 传入后台视图名称返回完整的视图路径</p>
     *
     * @param viewName
     * @return
     */
    public String getAdminView(String viewName) {
        return ResourceUtil.ADMIN_PAGE_PATH + viewName;
    }

}
