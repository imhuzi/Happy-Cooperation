/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.web.controller;

import com.hudongfenxiang.service.IBaseService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 *
 * @FileName : ValidateUniqueController.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.controller
 * @Link           : http://lezhai365.com
 * @Created on  : 2013-8-29,  12:29:50
 * @Author       : Hui.Wang [wanghui@lezhai365.com]
 * @Version    : 1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description
 *    用于ajax 验证某个表的某个字段唯一
 */
@Controller
@RequestMapping("/validate")
public class ValidateUniqueController extends BaseController {

    @Autowired
    IBaseService baseService;
    
    /**
     * ajax 验证表的某个字段是否唯一
     *
     * @return
     */
    @RequestMapping(value = "/unique", method = RequestMethod.GET)
    public @ResponseBody
    int getUserInJson() throws NoSuchRequestHandlingMethodException {
        HttpServletRequest request = BaseController.getRequest();
        //如果不是以ajax方式访问就抛异常
        if (!this.isAjaxRequest()) {
            throw new NoSuchRequestHandlingMethodException(request);
        }
        String ModelName = request.getParameter("t");
        String fieldName  = request.getParameter("k");
        String valueName = request.getParameter("v");

        return baseService.valid(ModelName, fieldName, valueName);
    }
}
