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
                    <li>
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
                    <li class="analyze">
                        <span><a href="cn/zailin/ebook/analyze/Press">出版商及其出版的书籍数量对比</a></span>
                    </li>
                    <li class="analyze">
                        <span><a href="cn/zailin/ebook/analyze/Provider">供应商及其提供的书籍数量</a></span>
                    </li>
                    <li>
                        <span><a>书籍类别及书籍数量对比</a></span>
                    </li>
                    <li>
                        <span><a>作者分布</a></span>
                    </li>
                    <li>
                        <span><a>时间分布</a></span>
                    </li>
                    <li class="pie">
                        <span><a href="cn/zailin/ebook/analyze/Rating">评分的分布</a></span>
                    </li>
                    <li class="analyze">
                        <span><a href="cn/zailin/ebook/analyze/KeyWord">标签种类及其个数分布</a></span>
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

    <div id="main" class="line" style="width: 85%;height: 1200px;">
        <div id="contain" style="width: 100%;height: 1160px;">

        </div>
        <div class="r_foot">
            <div class="r_foot_m">
                <span>
                    <input name="" type="checkbox" value="">
                    <em>全部选中</em>
                </span>
                <a href="" class="btn">删除</a>
                <a href="" class="btn">刷新</a>

                <!--分页-->
                <div class="page">
                    <a href="" class="prev"><img src="view/images/icon7.png" alt=""/></a>
                    <a class="now">1</a>
                    <a href="">2</a>
                    <a href="">3</a>
                    <a href="">4</a>
                    <a href="">5</a>
                    <a href="">6</a>
                    <a href="" class="next"><img src="view/images/icon8.png" alt=""/></a>
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