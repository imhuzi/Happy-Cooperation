<%-- 
    Document     :  index
    Encoding     :  UTF-8
    Link         :  http://imhuzi.net
    Created on   :  Oct 12, 2013, 12:33:01 AM
    Author       :  Huzi.Wang [huzi.wh@gmail.com]
    Version      :  1.0
    Copyright    :  Copyright(c) 2013 http://imhuzi.net
    Description  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Cooperation admin</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css"></link>
    </head>
    <body>
        <%@include file="comm/_gnav.jsp" %>
        <div class="container">
            <div>
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#">用户统计</a></li>
                    <li><a href="#">注册用户</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            员工<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">所有员工</a></li>
                            <li><a href="#">添加员工</a></li>
                            <li><a href="#">KPI</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div></div>
        <script data-main="/assets/app/admin" src="/assets/js/require.js"></script>
    </body>
</html>
