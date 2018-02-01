<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>豆瓣书籍分析平台</title>
    <link rel="stylesheet" type="text/css" href="view/css/common.css">
    <script type="text/javascript" src="view/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="view/js/main.js" charset="UTF-8"></script>
</head>
<body>
    <!--头部-->
    <div class="head">
        <div class="logo">
            <!--<a href=""><img src="view/images/logo1.pnga" alt="豆瓣图书平台"/></a>-->
        </div>
        <div>豆瓣书籍分析平台</div>
    </div>
    <!--左边-->
    <div id="leftSideBar" class="line">
        <ul class="sideNav">
            <li>
                <div class="menu basicView">
                    <span><a>基本的显示</a></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li>
                        <span><a href="cn/zailin/ebook/basic?wordCount=true">书籍字数最多的书籍</a></span>
                    </li>
                    <li>
                        <span><a href="cn/zailin/ebook/basic?currentPrice=true">价格最贵的书籍</a></span>
                    </li>
                    <li>
                        <span><a href="cn/zailin/ebook/basic?rating=true">评分最高的书籍</a></span>
                    </li>
                    <li>
                        <span><a href="cn/zailin/ebook/basic?comments=true" target="main">评论最多的书籍</a></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><a>书籍查询</a></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li class="viewList">
                        <span><a href="hy_list.html" target="main">查询</a></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><a>根据数据来分析</a></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li>
                        <span><a href="lfpz.html" target="main">出版商及其出版的书籍数量对比</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">供应商及其提供的书籍数量</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">书籍类别及书籍数量对比</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">作者分布</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">时间分布</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">评分的分布</a></span>
                    </li>
                    <li>
                        <span><a href="fwqkz.html" target="main">标签种类及其个数分布</a></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><a href="cqxt.html" target="_blank">重启</a></span>
                </div>
            </li>
            <li>
                <div class="menu">
                    <span><a href="tcxt.html" target="_blank">退出系统</a></span>
                </div>
            </li>
        </ul>
    </div>
    <div id="main" class="line" style="width: 70px;height: 100%">
        <div id="contain">
            <%--<ul>--%>
                <%--<li><a href="cn/zailin/ebook/basic?wordCount=true">书籍字数最多的书籍</a></li>--%>
                <%--<li><a href="cn/zailin/ebook/basic?currentPrice=true">价格最贵的书籍 </a></li>--%>
                <%--&lt;%&ndash;<li><a href="cn/zailin/ebook/basic?currentPrice=true">书籍标签最多的书籍</a></li>&ndash;%&gt;--%>
                <%--<li><a href="cn/zailin/ebook/basic?rating=true">评分最高的书籍</a></li>--%>
                <%--<li><a href="cn/zailin/ebook/basic?comments=true">评论最多的书籍</a></li>--%>
                <%--&lt;%&ndash;<li><a href="cn/zailin/ebook/basic?currentPrice=true">翻译书籍最多的译者</a></li>&ndash;%&gt;--%>
            <%--</ul>--%>

        </div>
    </div>
    <footer class="foot">
        <div>&copy;Copyright 2018 CreateBy:万在林</div>
    </footer>
</body>
</html>