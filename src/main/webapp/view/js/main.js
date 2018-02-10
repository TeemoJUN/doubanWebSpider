/*左边显示*/
$(function () {
    $(".submenu li").click(function (event) {
        event.stopPropagation();
    });
    $(".sideNav").children("li").click(function () {
        $(this).toggleClass('view');
    });
    $(".basicView").click(function () {
        echarts.dispose(document.getElementById("contain"));
        $.ajax({
            url: "cn/zailin/ebook/basic?rating=true&top=50",
            success: function (data) {
                viewBook(data);
            }
        })
    });

    function viewBook(data) {
        var length = data.length;
        var fragment = document.createDocumentFragment();
        var table = document.createElement("table");
        var trOne = document.createElement("tr");
        for (var arr in data[0]) {
            if (arr == "description" || arr == "popularAnnotations" || arr == "subtitle") {
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
                if (arr == "description" || arr == "popularAnnotations" || arr == "subtitle") {
                    continue;
                }
                var value = data[i][arr] === null ? "无" : data[i][arr];

                var th = document.createElement("td");
                var node;
                if (arr == "url") {
                    var a = document.createElement("a");
                    a.setAttribute("href", value);
                    node = document.createTextNode("URL");
                    a.appendChild(node);
                    th.appendChild(a);
                } else if (arr == "pubtime") {
                    var date = value == "无" ? "无" : new Date(value).getFullYear()+"-"+(new Date(value).getMonth()+1);
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
        console.log(document.getElementById("contain"));
        document.getElementById("contain").appendChild(fragment);
    }

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
    $(".press").click(function () {
        var myChart = echarts.init(document.getElementById("contain"));
        $.ajax({
            url: "cn/zailin/ebook/press",
            success: function (data) {
                var resultBar=barShow(data);
                myChart.setOption({
                    title: {
                        text: '出版商及其出版的书籍数量对比'
                    },
                    grid: {
                        top: '10%',
                        left: '1%',
                        right: '10%',
                        containLabel: true
                    },
                    tooltip: {},
                    legend: {
                        data:['数量']
                    },
                    xAxis: {
                        data: resultBar.x
                    },
                    yAxis: [
                        {
                            type : 'value',
                            name : '书籍数量',
                        }
                    ],
                    dataZoom: [
                        {
                            type: 'slider',
                            show: true,
                            start: 0,
                            end: 50,
                            handleSize: 8
                        }
                    ],
                    series: [{
                        name: '数量',
                        type: 'bar',
                        data: resultBar.y
                    }]
                });
            }
        })
    });
    function barShow(data) {
        var bar={
            x:[],
            y:[]
        };
        for(var i=0;i<data.length;i++){
            for(var each in data[i]){
                if(each=="name"){
                    bar.x.push(data[i][each]);
                }
                else {
                    bar.y.push(data[i][each]);
                }
            }
        }
        return bar;
    }

});

















