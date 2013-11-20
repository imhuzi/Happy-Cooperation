package com.hudongfenxiang.utils;

import com.hudongfenxiang.model.Mail;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @FileName : MailUtil.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.cms.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-8-13, 1:36:42
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *   mail util类
 */
public class MailUtil {

    public static String MAIL_SERVER;
    public static String MAIL_SERVER_PASSWORD;
    public static String MAIL_SENDER;
    public static String MAIL_FROM;
    public static String MAIL_CONTENT_TYPE;
    public static String MAIL_SUBJECT;
    private static String configFile = "conf/mail.properties";

    static {
        Properties p = PropertyUtil.read(configFile);
        MAIL_SERVER = p.getProperty("server");
        MAIL_SERVER_PASSWORD = p.getProperty("password");
        MAIL_SENDER = p.getProperty("sender");
        MAIL_FROM = p.getProperty("from");
        MAIL_CONTENT_TYPE = p.getProperty("contentType");
        MAIL_SUBJECT = p.getProperty("subject");
    }

    public static boolean sendMail(String to, String subject, String content) {
        boolean result = false;
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setContent(content);
        result = sendMail(mail);
        return result;
    }

    public static void sendMailAsyn(Mail mail) {
        final Mail mail2 = mail;
        Thread t = new Thread() {
            @Override
            public void run() {
                sendMail(mail2);
            }
        };
        t.start();
    }

    public static boolean sendMail(Mail mail) {
        boolean result = true;
        SimpleEmail sm = new SimpleEmail();
        sm.setHostName(mail.getMailServer());
        sm.setSubject(mail.getSubject());
        sm.setContent(mail.getContent(), mail.getContentType());
        if (mail.getPassword() != null) {
            sm.setAuthentication(mail.getFrom(), mail.getPassword());
        }
        try {
            sm.setFrom(mail.getFrom(), mail.getSender());
            String[] tos = mail.getTo().split("[,;]");
            for (String to : tos) {
                sm.addTo(to);
            }
            sm.send();
        } catch (EmailException ex) {
            result = false;
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static void setConfig(Mail mail) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<String, Object> m = BeanUtilsBean.getInstance().describe(mail);
        PropertyUtil.write(configFile, m);
    }

    public static void main(String[] args) {
//        Mail mail = new Mail();
//        mail.setMailServer("smtp.163.com");
//        mail.setFrom("wanghuiwl320@l63.com");
//        mail.setTo("949454756@qq.com");
//        mail.setPassword(".....");
//        mail.setSender("测试人员");
//        mail.setSubject("测试test");
//        mail.setContent("测试TEST。haha!");
//        MailUtil.sendMail(mail);

        Mail mail = new Mail();
        System.out.println("mailFrom:" + mail.getFrom());
//        mail.setMailServer("smtp.exmail.qq.com");
//        mail.setFrom("noreplay@lezhai365.com");
        mail.setTo("949454756@qq.com");
//        mail.setPassword("");
//        mail.setSender("项目测试人员");
//        mail.setSubject("send mail test.");
        mail.setContent("哈哈！都睡了嘛？我测试下 sendmail");
        MailUtil.sendMail(mail);
    }
}
