/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudongfenxiang.service.impl;

import com.hudongfenxiang.service.IBaseService;
import org.springframework.stereotype.Service;

/**
 *
 * @FileName     :  BaseServiceImpl.java
 * @Encoding     :  UTF-8
 * @Package      :  com.lezhai365.service.impl
 * @Link         :  http://imhuzi.net
 * @Created on   :  Nov 16, 2013, 11:33:04 PM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
@Service
public class BaseService implements IBaseService{

    public int valid(String ModelName, String fieldName, String valueName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
