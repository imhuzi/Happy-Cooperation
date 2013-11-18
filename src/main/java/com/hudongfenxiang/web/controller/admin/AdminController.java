/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.controller.admin;

import com.hudongfenxiang.utils.ResourceUtil;
import com.hudongfenxiang.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @FileName : AdminController.java
 * @Encoding : UTF-8
 * @Package : com.hudongfenxiang.controller.admin
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 12, 2013, 12:21:28 AM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
@Controller
@RequestMapping(ResourceUtil.ADMIN_URI_PREFIX)
public class AdminController extends BaseController {

    @RequestMapping(value = {"","/","/index"})
    public String index() {
        System.out.println("lllllllllllllllll");
        return ResourceUtil.getAdminView("index");
    }
}
