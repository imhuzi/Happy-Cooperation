/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.utils;

/**
 *
 * @FileName : Global.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.utils
 * @Link           : http://lezhai365.com
 * @Created on  : 2013-8-24,  17:50:32
 * @Author       : Hui.Wang [wanghui@lezhai365.com]
 * @Version    : 1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description
 *     放一些全局的公共变量,以后可能会写进配置文件里
 */
public class Global {

    //admin user session key
    public static final String SESSION_USER_KEY_PRIX = "LZ_SESSION_KEY";
    //会员
    public static final String SESSION_MEMBER_KEY_PRIX = "LZ_MSESSION_KEY";
    //user cookie key
    public static final String COOKIE_USER_KEY_PRIX = "LZ_COOKIE_KEY";
    //password secret key
    public static final String SECRET_KEY = "@#@I#UO@IKskdfjasldfj293042983askdf@#jasdf()hkjh~";
    //flash message key
    public static final String FLASH_MESSAGE_KEY = "FLASH_MESSAGE_KEY";
    //default session InactiveInterval 默认30分钟
    public static final int DEFAULT_INACTIVEINTERVAL = 1800;
    //MaxInactiveInterval (60*60*24*7) 最大值为7天
    public static final int MAXINACTIVEINTERVAL = 604800;
}
