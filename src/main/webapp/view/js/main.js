$(function () {
    /*左边显示*/
    $(".submenu li").click(function (event) {
        event.stopPropagation();
    });
    $(".sideNav").children("li").click(function () {
        $(this).toggleClass('view');
    });
    /*查询基本信息*/
    $(".basicView").click(function () {
        $(".r_foot").show();
        var url = event.target.childNodes[0].getAttribute("url");
        $.ajax({
            url: url,
            success: function (data) {
                console.log(data);
                viewDetailBook(data.contain, data.title, data.page);
            }
        })
    });
    /*饼图*/
    $(".pie").click(function (event) {
        $(".r_foot").hide();
        var url = event.target.childNodes[0].getAttribute("url");
        $.ajax({
            url: url,
            success: function (data) {
                console.log(data);
                pie(data);
            }
        });
        return false;
    });
    /*柱状图*/
    $(".analyze").click(function (event) {
        $(".r_foot").hide();
        var url = event.target.childNodes[0].getAttribute("url");
        $.ajax({
            url: url,
            success: function (data) {
                bar(data);
            }
        });
        return false;
    });
    $(".page").click(function (event) {
        var url = event.target.getAttribute("url");
        console.log(url);
        $.ajax({
            url: url,
            success: function (data) {
                viewDetailBook(data.contain, data.title, data.page);
            }
        });
    });


    /**
     * 显示书籍详情信息
     * @param data
     * @param title
     * @param page
     */
    function viewDetailBook(data, title, page) {
        echarts.dispose(document.getElementById("contain"));
        $("#contain").empty();
        $(".page").empty();
        var length = data.length;
        var fragment = document.createDocumentFragment();
        var table = document.createElement("table");
        var caption = document.createElement("caption");
        caption.setAttribute("align", "top");
        var string = createTitle(title);
        var text = document.createTextNode(string);
        caption.appendChild(text);
        table.appendChild(caption);
        var trOne = document.createElement("tr");
        for (var arr in data[0]) {
            if (arr === "description" || arr === "popularAnnotations" || arr === "subtitle") {
                continue;
            }
            var th = document.createElement("th");
            var text = document.createTextNode(createTh(arr));
            th.appendChild(text);
            trOne.appendChild(th);
        }
        table.appendChild(trOne);
        for (var i = 0; i < length; i++) {
            var tr = document.createElement("tr");
            for (var arr in data[i]) {
                if (arr === "description" || arr === "popularAnnotations" || arr === "subtitle") {
                    continue;
                }
                var value = data[i][arr] === null ? "无" : data[i][arr];

                var th = document.createElement("td");
                var node;
                if (arr === "url") {
                    var a = document.createElement("a");
                    a.setAttribute("href", value);
                    node = document.createTextNode("URL");
                    a.appendChild(node);
                    th.appendChild(a);
                } else if (arr === "pubtime") {
                    var date = value === "无" ? "无" : new Date(value).getFullYear() + "-" + (new Date(value).getMonth() + 1);
                    node = document.createTextNode(date);
                    th.appendChild(node);
                }
                else {
                    node = document.createTextNode(value);
                    th.appendChild(node);
                }
                tr.appendChild(th)
            }
            table.appendChild(tr);
        }
        fragment.appendChild(table);
        document.getElementById("contain").appendChild(fragment);
        createPaging(page.currentPage, page.allPage, title);
    }

    /**
     * 详情介绍栏
     * @param arr
     * @returns {string}
     */
    function createTh(arr) {
        switch (arr) {
            case "title":
                return "标题";
            case "subtitle":
                return "子标题";
            case "authorName":
                return "作者";
            case "translator":
                return "译者";
            case "label":
                return "标签";
            case "press":
                return "出版社";
            case "provider":
                return "供应商";
            case "wordCount":
                return "字数";
            case "rating":
                return "评分";
            case "comments":
                return "评论数";
            case "currentPrice":
                return "现价";
            case "description":
                return "导言";
            case "popularAnnotations":
                return "热门划线";
            case "keyWords":
                return "作品标签";
            case "url":
                return "作品标签";
            case "pubtime":
                return "出版年份";
            default:
                return "错误";
        }
    }

    function createTitle(title) {
        if (title === "comments") {
            return "按评论数排名";
        } else if (title === "wordCount") {
            return "按字数排名";
        } else if (title === "rating") {
            return "按评分排名";
        } else if (title === "currentPrice") {
            return "按当前价格排名";
        }
        return "有问题！";
    }

    function createPaging(currentPage, allPage, title) {
        var page = document.getElementsByClassName("page").item(0);
        var num = 6;
        var fragment = document.createDocumentFragment();
        if (currentPage - 1 > 0) {
            var prev = document.createElement("abbr");
            prev.setAttribute("class", "prev");
            prev.setAttribute("url", "cn/zailin/ebook/basic?" + title + "=true&page=" + (currentPage - 1));
            var img = document.createElement("img");
            img.setAttribute("src", "view/images/icon7.png");
            prev.appendChild(img);
            fragment.appendChild(prev);
        }
        var n = 3;
        while ((n--) > 1) {
            if (currentPage - n > 0) {
                var abbr = document.createElement("abbr");
                var text = document.createTextNode(currentPage - n);
                abbr.setAttribute("url", "cn/zailin/ebook/basic?" + title + "=true&page=" + (currentPage - n));
                abbr.appendChild(text);
                fragment.appendChild(abbr);
            }
        }
        var now = document.createElement("abbr");
        now.setAttribute("class", "now");
        var text = document.createTextNode(currentPage);
        now.appendChild(text);
        fragment.appendChild(now);
        for (var i = currentPage + 1; i < allPage && (i < currentPage + 4); i++) {
            var abbr = document.createElement("abbr");
            abbr.setAttribute("url", "cn/zailin/ebook/basic?" + title + "=true&page=" + (i));
            var text = document.createTextNode(i);
            abbr.appendChild(text);
            fragment.appendChild(abbr);
        }
        if (currentPage < allPage) {
            var next = document.createElement("abbr");
            next.setAttribute("class", "next");
            next.setAttribute("url", "cn/zailin/ebook/basic?" + title + "=true&page=" + (currentPage + 1));
            var img = document.createElement("img");
            img.setAttribute("src", "view/images/icon8.png");
            next.appendChild(img);
            fragment.appendChild(next);
        }
        page.appendChild(fragment);
    }

    /**
     * 柱状图的显示
     * @param data
     * @constructor
     */
    function bar(data) {
        var resultBar = barFormatting(data.data);
        echarts.dispose(document.getElementById("contain"));
        var myChart = echarts.init(document.getElementById("contain"));
        myChart.on("click", function (event) {
            barEvent(event);
        });

        myChart.setOption({
            title: {
                text: data.dataName,
                show: true,
                textStyle: {
                    fontSize: 25
                }
            },
            grid: {
                top: '10%',
                left: '4%',
                right: '10%',
                containLabel: true
            },
            tooltip: {},
            xAxis: {
                data: resultBar.x,
                axisLabel: {
                    interval: 0,
                    rotate: 40
                }
            },
            yAxis: [
                {
                    type: 'value',
                    name: '书籍数量'
                }
            ],
            dataZoom: [
                {
                    type: 'slider',
                    show: true,
                    start: 0,
                    end: 15,
                    handleSize: 8
                }
            ],
            series: [{
                name: '数量',
                type: 'line',
                data: resultBar.y
            },
                {
                    name: '数量',
                    type: 'bar',
                    data: resultBar.y
                }
            ]
        });
        if (data.data.length < 50) {
            myChart.setOption({
                dataZoom: [{
                    show: false,
                    start: 0,
                    end: 100
                }]
            })
        }
    }

    /**
     * 饼图echarts图
     * @param data
     */
    function pie(data) {
        echarts.dispose(document.getElementById("contain"));
        var myChart = echarts.init(document.getElementById("contain"));
        myChart.setOption({
            title: {
                text: data.dataName,
                show: true,
                textStyle: {
                    color: 'Orange',
                    fontSize: 40
                },
                left: 'center'
            },
            tooltip: {},
            series: [
                {
                    name: '评分分布图',
                    type: 'pie',
                    radius: '80%',
                    data: data.data,
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,
                                formatter: '{b} : {c} ({d}%)',
                                textStyle: {
                                    fontSize: 18
                                }
                            }
                            //labelLine :{show:true}
                        }
                    }
                }
            ]

        })
    }

    /**
     * 把接收的数据转化为可以显示的数据
     * @param data
     * @returns {{x: Array, y: Array}}
     */
    function barFormatting(data) {
        var bar = {
            x: [],
            y: []
        };
        for (var i = 0; i < data.length; i++) {
            for (var each in data[i]) {
                if (each === "name") {
                    bar.x.push(data[i][each]);
                }
                else {
                    bar.y.push(data[i][each]);
                }
            }
        }
        return bar;
    }

    /**
     * 柱状图的item事件
     * @param param
     */
    function barEvent(param) {
        console.log(param.name);
        //@TODO 根据参数再次请求服务起返回参数，返回所有列表
    }

});

















