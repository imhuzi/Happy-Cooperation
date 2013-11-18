/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.controller;

import com.hudongfenxiang.utils.ResourceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @FileName : SiteController.java
 * @Encoding : UTF-8
 * @Package : com.hudongfenxiang.controller
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 12, 2013, 12:21:14 AM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
@Controller
public class SiteController extends BaseController {
    
    @RequestMapping("/")
    public String index() {
        return ResourceUtil.getThemeView("index");
    }
}
