<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>豆瓣书籍</h1>
<h2>书籍查询</h2>
<form action="" method="post">
    <input type="text">
    <input type="text">
</form>
<h2>基本的显示</h2>
<ol>
    <li><a href="cn/zailin/ebook/basic?wordCount=true">书籍字数最多的书籍</a></li>
    <li><a href="cn/zailin/ebook/basic?currentPrice=true">价格最贵的书籍 </a></li>
    <%--<li><a href="cn/zailin/ebook/basic?currentPrice=true">书籍标签最多的书籍</a></li>--%>
    <li><a href="cn/zailin/ebook/basic?rating=true">评分最高的书籍</a></li>
    <li><a href="cn/zailin/ebook/basic?comments=true">评论最多的书籍</a></li>
    <%--<li><a href="cn/zailin/ebook/basic?currentPrice=true">翻译书籍最多的译者</a></li>--%>
</ol>

<h2>根据数据来分析</h2>
<ol>
    <li><a href="">出版商及其出版的书籍数量对比</a></li>
    <li><a href="">供应商及其提供的书籍数量</a></li>
    <li><a href="">书籍类别及书籍数量对比</a></li>
    <li><a href="">作者分布</a></li>
    <li><a href="">时间分布</a></li>
    <li><a href="">评分的分布</a></li>
    <li><a href="">标签种类及其个数分布</a></li>
</ol>
</body>
</html>