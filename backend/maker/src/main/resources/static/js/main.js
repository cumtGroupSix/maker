$(function(){
    var imgWidth=$(".img-list div img").css("width");
    $(".img-list div img").css("height",imgWidth);
    $(".img-list div .position-absolute").css("left",imgWidth);
    $(".img-list div .position-absolute img").css("height","200px")
    $(".img-list div").on("mouseenter",function(){
        $(this).children(".position-absolute").css("visibility","visible");
    });
    $(".img-list div").on("mouseleave",function(){
        $(this).children(".position-absolute").css("visibility","hidden");
    })
})