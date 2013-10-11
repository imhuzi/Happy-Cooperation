package com.hudongfenxiang.model;

import com.hudongfenxiang.utils.MailUtil;


/**
 *
 * @FileName : Mail.java
 * @Encoding : UTF-8
 * @Package : com.lezhai365.cms.model
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-8-13, 1:34:52
 * @Author       :  Hui.Wang [wanghui@lezhai365.com]
 * @Version      :  1.0
 * @Copyright   : Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *
 */
public class Mail {

    private String to;
    private String from;
    private String sender;
    private String header;
    private String subject;
    private String content;
    private String xMailer;
    private String password;
    private String mailServer;
    private String contentType;
    private String mimeVersion;

    public Mail() {
        this.from = MailUtil.MAIL_FROM;
        this.sender = MailUtil.MAIL_SENDER;
        this.password = MailUtil.MAIL_SERVER_PASSWORD;
        this.mailServer = MailUtil.MAIL_SERVER;
        this.contentType = MailUtil.MAIL_CONTENT_TYPE;
        this.subject = MailUtil.MAIL_SUBJECT;
    }

    public Mail(String from, String sender, String password, String mailServer, String contentType,String subject) {
        this.from = from;
        this.sender = sender;
        this.password = password;
        this.mailServer = mailServer;
        this.contentType = contentType;
        this.subject = subject;
    }
    
    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the xMailer
     */
    public String getxMailer() {
        return xMailer;
    }

    /**
     * @param xMailer the xMailer to set
     */
    public void setxMailer(String xMailer) {
        this.xMailer = xMailer;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mailServer
     */
    public String getMailServer() {
        return mailServer;
    }

    /**
     * @param mailServer the mailServer to set
     */
    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the mimeVersion
     */
    public String getMimeVersion() {
        return mimeVersion;
    }

    /**
     * @param mimeVersion the mimeVersion to set
     */
    public void setMimeVersion(String mimeVersion) {
        this.mimeVersion = mimeVersion;
    }
    
}
