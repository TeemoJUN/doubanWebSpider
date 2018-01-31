
/*左边显示*/
$(function(){
    $('.sideNav > li').click(function(){
        $(this).toggleClass('view');
    });

    //控制页面显示大小
    var mainHeight = $(window).height();
    $('.sideNav').css('height',mainHeight+'px');
})