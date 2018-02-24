<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>豆瓣书籍分析平台</title>
    <link rel="stylesheet" type="text/css" href="view/css/common.css">
    <script type="text/javascript" src="view/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="view/js/echarts.min.js"></script>
    <script type="text/javascript" src="view/js/main.js" charset="UTF-8"></script>
</head>
<body style="width: 100%;height: 100%">
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
                <div class="menu">
                    <span><abbr>基本的显示</abbr></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li class="basicView">
                        <span><abbr url="cn/zailin/ebook/basic?wordCount=true">书籍字数最多的书籍</abbr></span>
                    </li>
                    <li class="basicView">
                        <span><abbr url="cn/zailin/ebook/basic?currentPrice=true">价格最贵的书籍</abbr></span>
                    </li>
                    <li class="basicView">
                        <span><abbr url="cn/zailin/ebook/basic?rating=true">评分最高的书籍</abbr></span>
                    </li>
                    <li class="basicView">
                        <span><abbr url="cn/zailin/ebook/basic?comments=true" target="main">评论最多的书籍</abbr></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><abbr>书籍查询</abbr></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li>
                        <span><abbr url="hy_list.html" target="main">查询</abbr></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><abbr>根据数据来分析</abbr></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="submenu">
                    <li class="analyze">
                        <span><abbr url="cn/zailin/ebook/analyze/Press">出版商及其出版的书籍数量对比</abbr></span>
                    </li>
                    <li class="analyze">
                        <span><abbr url="cn/zailin/ebook/analyze/Provider">供应商及其提供的书籍数量</abbr></span>
                    </li>
                    <li class="analyze">
                        <span><abbr url="cn/zailin/ebook/analyze/Label">书籍类别及书籍数量对比</abbr></span>
                    </li>
                    <%--<li>--%>
                        <%--<span><a>作者分布</a></span>--%>
                    <%--</li>--%>
                    <li class="analyze">
                        <span><abbr url="cn/zailin/ebook/analyze/Pubtime">时间分布</abbr></span>
                    </li>
                    <li class="pie">
                        <span><abbr url="cn/zailin/ebook/analyze/Rating">评分的分布</abbr></span>
                    </li>
                    <li class="analyze">
                        <span><abbr url="cn/zailin/ebook/analyze/Key">标签种类及其个数分布</abbr></span>
                    </li>
                </ul>
            </li>
            <li>
                <div class="menu">
                    <span><abbr url="cqxt.html" target="_blank">重启</abbr></span>
                </div>
            </li>
            <li>
                <div class="menu">
                    <span><abbr url="tcxt.html" target="_blank">退出系统</abbr></span>
                </div>
            </li>
        </ul>
    </div>

    <div id="main" class="line" style="width: 85%;height: 1200px;">
        <div id="contain" style="width: 100%;height: 1160px;">

        </div>
        <div class="r_foot">
            <div class="r_foot_m">
                <!--分页-->
                <div class="page">
                </div>
                <!--分页-->
            </div>
        </div>
    </div>

    <footer class="foot">
        <div>&copy;Copyright 2018 CreateBy:万在林</div>
    </footer>
</body>
</html>