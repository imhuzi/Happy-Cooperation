/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.utils;

/**
 *
 * @FileName : ImageProcess.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  Sep 12, 2013, 10:22:10 AM
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *  图片处理模型
 */
public class ImageProcess {

    private String path;

    /**
     * <p>限定宽度，高度自适应</p>
     *
     * @param width
     */
    public static void fixWidth(Integer width) {
    }

    /**
     * <p>限定高度，宽度自适应</p>
     *
     * @param height
     */
    public static void fixHeight(Integer height) {
    }

    /**
     * <p>限定最长边，短边自适应</p>
     *
     * @param max
     */
    public void fixMax(Integer max) {
    }

    /**
     * <p>限定最短边，长边自适应</p>
     *
     * @param min
     */
    public void fixMin(Integer min) {
    }

    /**
     * <p>限定宽度和高度</p>
     *
     * @param width
     * @param Height
     */
    public void fixWidthAndHeight(Integer width, Integer Height) {
    }

    /**
     * <p>等比例缩小图片</p>
     *
     * @param scale
     */
    public void fixScale(Float scale) {
    }

    public Integer getWidth() {
        Integer result = 0;
        return result;
    }

    public Integer getHeight() {
        Integer result = 0;
        return result;
    }

    public String getImageInfo() {
        String result = "";
        return result;
    }
}
