<%-- 
    Document     :  _gnav
    Encoding     :  UTF-8
    Link         :  http://imhuzi.net
    Created on   :  Nov 17, 2013, 1:13:35 AM
    Author       :  Huzi.Wang [huzi.wh@gmail.com]
    Version      :  1.0
    Copyright    :  Copyright(c) 2013 http://imhuzi.net
    Description  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/admin" class="navbar-brand">乐协 <em><small>让工作更简单</small></em></a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="/admin/task">首页</a>
                </li>
                <li>
                    <a href="/admin/article">文章</a>
                </li>
                <li>
                    <a href="/admin/recruitment">任务</a>
                </li>
                <li>
                    <a href="/admin/recruitment">招聘</a>
                </li>
                <li >
                    <a href="/admin/kpi">用户管理</a>
                </li>
                <li>
                    <a href="/admin/recruitment">设置</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="../about">当前登录用户</a>
                </li>
            </ul>
        </nav>
    </div>
</header>