/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;

/**
 *
 * @FileName : ImageUtile.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  Sep 12, 2013, 9:19:51 AM
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *   图片处理工具类
 * <h2>现有的几种图片生成方式:</h2>
 * <p>fix_width:限定宽度，高度自适应</p>
 * <p>fix_height:限定高度，宽度自适应</p>
 * <p>fix_max:限定最长边，短边自适应</p>
 * <p>fix_min:限定最短边，长边自适应</p>
 * <p>fix_width_or_height:限定宽度和高度</p>
 * <p>fix_scale:等比例缩小图片</p>
 *
 */
public class ImageUtil {

    public static String fileName = "E:/DSC01455.JPG";
    public static String newPath = "E:/DSC01455.JPG";

    /**
     * <p>限定宽度，高度自适应</p>
     *
     * @param width
     */
    public static Boolean fixWidth(Integer width) throws IOException, InterruptedException, IM4JavaException {
        Boolean flag = false;
//        try {
            IMOperation op = new IMOperation();
            op.addImage(fileName);
            op.crop(width);
            op.addImage("E:/DSC01455-fixwidth.JPG");
            ConvertCmd convert = new ConvertCmd();
            convert.run(op);
            flag = true;
//        } catch (IOException e) {
//            System.out.println("文件读取错误!");
//            flag = false;
//        } catch (InterruptedException e) {
//            flag = false;
//        } catch (IM4JavaException e) {
//            flag = false;
//        } finally {
//        }
//        return flag;
        return null;
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
    public static void fixMax(Integer max) {
    }

    /**
     * <p>限定最短边，长边自适应</p>
     *
     * @param min
     */
    public static void fixMin(Integer min) {
    }

    /**
     * <p>限定宽度和高度</p>
     *
     * @param width
     * @param Height
     */
    public static void fixWidthAndHeight(Integer width, Integer Height) {
    }

    /**
     * <p>等比例缩小图片</p>
     *
     * @param scale
     */
    public static void fixScale(Float scale) {
    }

    public static Integer getWidth() {
        Integer result = 0;
        return result;
    }

    public static Integer getHeight() {
        Integer result = 0;
        try {
            IMOperation op = new IMOperation();
            op.format("%w"); // 设置获取宽度参数
            op.addImage(1);
            IdentifyCmd identifyCmd = new IdentifyCmd(true);
            ArrayListOutputConsumer output = new ArrayListOutputConsumer();
            identifyCmd.setOutputConsumer(output);
            identifyCmd.run(op, fileName);
            ArrayList<String> cmdOutput = output.getOutput();
            assert cmdOutput.size() == 1;
            result = Integer.parseInt(cmdOutput.get(0));
        } catch (Exception e) {
            result = 0;
            System.out.println("运行指令出错!");
        }
        return result;
    }

    public static String getImageInfo() {
        String result = "";
        return result;
    }

    public static Integer getSize() {
        Integer result = 0;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
            result = inputStream.available();
            inputStream.close();
            inputStream = null;
        } catch (FileNotFoundException e) {
            result = 0;
            System.out.println("文件未找到!");
        } catch (IOException e) {
            result = 0;
            System.out.println("读取文件大小错误!");
        } finally {
            // 可能异常为关闭输入流,所以需要关闭输入流
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("关闭文件读入流异常");
                }
                inputStream = null;

            }
        }
        return result;
    }

    public static void main(String[] args) throws IM4JavaException, IOException, InterruptedException {
        System.out.println("lll:" + ResourceUtil.getRealFileName(""));;
        //fixwidth
        fixWidth(200);
    }
}
