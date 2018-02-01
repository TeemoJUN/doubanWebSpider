/*左边显示*/
$(function(){
    $(".submenu li").click(function (event) {
        event.stopPropagation();
    });
    $(".sideNav").children("li").click(function(){
        $(this).toggleClass('view');
    });
    $(".basicView").click(function () {
        $.ajax({
            url: "cn/zailin/ebook/basic?rating=true",
            success: function (data) {
                viewBook(data[0]);
            }
        })
    })
    function viewBook(data) {
        console.log(data.title);
        console.log(data.subtitle);
        console.log(data.authorName);
        console.log(data.translator);
        console.log(data.label);
        console.log(data.press);
        console.log(data.provider);
        console.log(data.wordCount);
        console.log(data.rating);
        console.log(data.comments);
        console.log(data.currentPrice);
        console.log(data.description);
        console.log(data.popularAnnotations);
        console.log(data.keyWords);
        console.log(data.url);
    }
    //控制页面显示大小
    var mainHeight = $(window).height();
    $('.sideNav').css('height',mainHeight+'px');
})