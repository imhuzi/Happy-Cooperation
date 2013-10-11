/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.utils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @FileName : RequestUtil.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.web.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  Sep 2, 2013, 1:18:59 AM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *   request 工具类
 *
 */
public class RequestUtil {

    /**
     * 判断一个请求是不是ajax请求
     *
     * @return Boolean
     */
    public Boolean isAjaxRequest() {
        String xr = RequestUtil.getRequest().getHeader("x-requested-with");
        Boolean result = false;
        if (xr != null && !"".equals(xr) && xr.equals("XMLHttpRequest")) {
            result = true;
        }
        return result;
    }

    /**
     * 取request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取用户浏览器信息
     * 
     * @return String 
     */
    public static String getUserAgent() {
        String result = "";
        result = getRequest().getHeader("User-Agent");
        return result;
    }

    /**
     * 获取客户端ip
     *
     * @return String ip
     */
    public static String getClientIP() {
        String ip = "";
        HttpServletRequest request = RequestUtil.getRequest();
        ip = request.getHeader("X-Real-IP");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
