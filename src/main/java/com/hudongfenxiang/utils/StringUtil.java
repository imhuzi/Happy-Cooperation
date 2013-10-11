/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudongfenxiang.utils;

import java.util.regex.Pattern;

/**
 *
 * @FileName     :  StringUtil.java
 * @Encoding     :  UTF-8
 * @Package      :  com.hudongfenxiang.utils
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 11, 2013, 11:54:39 PM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
public class StringUtil {

	private static final Pattern TOPIC_PATTERN = Pattern.compile("#([^\\#|.]+)#");
	private static final Pattern AT_PATTERN = Pattern.compile("@[\\u4e00-\\u9fa5\\w\\-]+");

}
