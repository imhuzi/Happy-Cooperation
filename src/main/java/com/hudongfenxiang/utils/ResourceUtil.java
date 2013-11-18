package com.hudongfenxiang.utils;

import com.hudongfenxiang.web.utils.RequestUtil;

/**
 *
 * @FileName : ResourceUtil.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.utils
 * @Link           : http://lezhai365.com
 * @Created on  : 2013-8-24,  22:59:39
 * @Author       : Hui.Wang [wanghui@lezhai365.com]
 * @Version    : 1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description
 *     一些资源变量，或者处理资源的一些工具方法
 */
public class ResourceUtil {
    //静态资源目录

    public static final String STATIC_RESOURCE_PATH = "/assets/";
    //后台管理资源
    public static final String ADMIN_PAGE_PATH = "/admin/";
    //后台管理ｕri前缀
    public static final String ADMIN_URI_PREFIX = "/admin";
    //站点相关资源常量====================
    //站点主题目录
    public static final String SITE_THEME_PATH = "/site";
    //站点主题名称
    public static final String SITE_THEME_NAME = "";
    //会员主页uri前缀
    public static final String MEMBER_URI_PREFIX = "/user";
    //文件上传URI前缀
    public static  final  String FILE_UPLOAD="/fileupload";

    /**
     * 根据view name 获取站点后台某个页面视图
     *
     * @param viewName
     * @return String 返回值: path + view name
     */
    public static String getAdminView(String viewName) {
        return ADMIN_PAGE_PATH + viewName;
    }

    /**
     * 根据view name 获取站点主题某个视图 path + view name
     *
     * @param viewName
     * @return String 返回值: path + view name
     */
    public static String getThemeView(String viewName) {
        return SITE_THEME_PATH + SITE_THEME_NAME + "/" + viewName;
    }

    /**
     * 站点主题的静态资源路径
     *
     * @return String
     */
    public static String getThemeAssetsPath() {
        return RequestUtil.getRequest().getContextPath() + SITE_THEME_PATH + SITE_THEME_NAME + "/assets/";
    }

    /**
     * 根据文件名字获取程序运行时的真是路径
     *
     * @param fileName
     * @return
     */
    public static String getRealFileName(String fileName) {
        String classPath = PropertyUtil.class.getResource("/").getFile();
        classPath = classPath.substring(1, classPath.length());
        fileName = classPath + fileName;
        return fileName;
    }
}
