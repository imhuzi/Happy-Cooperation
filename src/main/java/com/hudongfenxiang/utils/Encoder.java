package com.hudongfenxiang.utils;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *.
 *
 * @FileName : Encoder.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.cms.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-8-13, 5:31:27
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *         编码(加密)工具.
 */
public class Encoder {

    public Encoder() {
    }

    /**
     * 将字节数组转换成16进制字符串.
     * @param byteArr
     * @return 16进制字符串.
     */
    public static String byteArrayToHexString(byte[] byteArr) {
        StringBuffer hexString = new StringBuffer();
        String plainText;

        for (int i = 0; i < byteArr.length; i++) {
            plainText = Integer.toHexString(0xFF & byteArr[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    /**
     * MD5 编码.
     * @param byteArr
     * @return String
     */
    public static String MD5Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * SHA-1 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA1Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * SHA-256 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA256Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * SHA-512 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA512Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * 对称加密方法.
     *
     * @param byteSource 需要加密的数据
     * @return 经过加密的数据
     * @throws Exception
     */
    public static byte[] symmetricEncrypto(byte[] byteSource) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = Cipher.ENCRYPT_MODE;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            byte[] keyData = {9, 1, 3, 7, 2, 1, 2, 0};
            DESKeySpec keySpec = new DESKeySpec(keyData);
            Key key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            int position = 0;
            int length = byteSource.length;
            boolean more = true;
            while (more) {
                if (position + blockSize <= length) {
                    baos.write(cipher.update(byteSource, position, blockSize));
                    position += blockSize;
                } else {
                    more = false;
                }
            }
            if (position < length) {
                baos.write(cipher.doFinal(byteSource, position, length
                        - position));
            } else {
                baos.write(cipher.doFinal());
            }
            return baos.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            baos.close();
        }
    }

    public static String symmetricEncrypto(String strSource) throws Exception {
        byte[] byteSource = strSource.getBytes();
        byte[] byteArr = symmetricEncrypto(byteSource);
        String result = byteArrayToHexString(byteArr);
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Encoder.byteArrayToHexString("我".getBytes()));
//        System.out.println(Encoder.MD5Encode("我".getBytes()));
//        System.out.println(Encoder.SHA1Encode("我".getBytes()));

        String uiatc = null;
//        try {
//            byte[] byteArr = Encoder.symmetricEncrypto("fee".getBytes());
//            uiatc = Encoder.byteArrayToHexString(byteArr);
//        } catch (Exception ex) {
//        }
        try {
            uiatc = Encoder.symmetricEncrypto(System.currentTimeMillis() + "," + "fee");
        } catch (Exception ex) {
            Logger.getLogger(Encoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(uiatc);
        try {
            System.out.println(Decoder.symmetricDecrypto("82d9eda349f249b881458e2ad409bba41e161e00191cd0b1"));
        } catch (Exception ex) {
            Logger.getLogger(Encoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
