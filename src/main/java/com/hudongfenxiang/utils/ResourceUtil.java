package com.hudongfenxiang.utils;

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
