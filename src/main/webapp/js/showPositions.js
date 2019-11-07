var currentPage = 1;//当前页
var pageCount;//总页数
var searchPageCount;//搜索后的分页最大页
var content;//搜索框的内容
$(function () {
    $.ajax({
        url: "user/getPositionsPage",
        type: "POST",
        data: {
            currentPage: currentPage
        },
        success: function (data) {
            // console.log(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                // console.log(pageCount)
                var list = this.list;
                $(list).each(function () {
                    $("#show").append("\t\t\t\t\t\t\t<div class=\"single-post d-flex flex-row\">\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"thumb\">\n" +
                        "\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t<ul class=\"tags\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">艺术</a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">媒体</a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">设计</a>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t\t</ul>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"details\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div class=\"title d-flex flex-row justify-content-between\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div class=\"titles\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\"><h4>" + this.post + "</h4></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<h6>" + this.company.name + "</h6>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<ul class=\"btns\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModal'  onclick='information(" + this.id + ")'><span>查看评论</span></a></li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModa2'  onclick='message(" + this.id + ")'><span>评论</span></a></li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">申请</a></li>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t<p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t" + this.company.introdu + "\n" +
                        "\t\t\t\t\t\t\t\t\t</p>\n" +
                        "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-map\"></span> " + this.require + "</p>\n" +
                        "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-database\"></span> ￥" + this.salary + "</p>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t</div>")

                })
                $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")

            })
        }
    })


    //点击搜索搜索内容
    $("#search").click(function () {
        content = $("#searchContent").val()
        $.ajax({
            url: "user/searchPostPage",
            type: "POST",
            data: {
                currentPage: 1,
                name: content
            },
            success: function (data) {
                if (data !== "") {
                    // console.log(data)
                    //getPage(currentPage)
                    $("#show").html("");
                    $(".fenye").html("");
                    $(data).each(function () {
                        searchPageCount = this.pageCount;//获取总页数
                        var list = this.list;
                        $(list).each(function () {
                            $("#show").append("\t\t\t\t\t\t\t<div class=\"single-post d-flex flex-row\">\n" +
                                "\t\t\t\t\t\t\t\t<div class=\"thumb\">\n" +
                                "\t\t\t\t\t\t\t\t\t\n" +
                                "\t\t\t\t\t\t\t\t\t<ul class=\"tags\">\n" +
                                "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">艺术</a>\n" +
                                "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">媒体</a>\n" +
                                "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">设计</a>\t\t\t\t\t\n" +
                                "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                                "\t\t\t\t\t\t\t\t\t</ul>\n" +
                                "\t\t\t\t\t\t\t\t</div>\n" +
                                "\t\t\t\t\t\t\t\t<div class=\"details\">\n" +
                                "\t\t\t\t\t\t\t\t\t<div class=\"title d-flex flex-row justify-content-between\">\n" +
                                "\t\t\t\t\t\t\t\t\t\t<div class=\"titles\">\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\"><h4>" + this.post + "</h4></a>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<h6>" + this.company.name + "</h6>\t\t\t\t\t\n" +
                                "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                                "\t\t\t\t\t\t\t\t\t\t<ul class=\"btns\">\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModal'  onclick='information(" + this.id + ")'><span>查看评论</span></a></li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModa2'  onclick='message(" + this.id + ")'><span>评论</span></a></li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">申请</a></li>\n" +
                                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                                "\t\t\t\t\t\t\t\t\t</div>\n" +
                                "\t\t\t\t\t\t\t\t\t<p>\n" +
                                "\t\t\t\t\t\t\t\t\t\t" + this.company.introdu + "\n" +
                                "\t\t\t\t\t\t\t\t\t</p>\n" +
                                "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-map\"></span> " + this.require + "</p>\n" +
                                "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-database\"></span> ￥" + this.salary + "</p>\n" +
                                "\t\t\t\t\t\t\t\t</div>\n" +
                                "\t\t\t\t\t\t\t</div>")
                        })
                        $(".fenye").append("<a onclick='getSearchPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + pageCount + ")'>尾页</a>")
                    })


                }
            }
        })
    })

    //点击进入后台
    $(function () {
        $.ajax({
            url: "user/findUser",
            type: "POST",
            success: function (data) {
               console.log(data)
                $("#name").html(data.username)
                $("#name").attr('href','user/user.html')
            }
        })
    })


})

//搜索后点击分页发生的页面展示
function getSearchPage(currentPage) {
    if (currentPage > 0 && currentPage <= searchPageCount) {
        $("#show").html("");
        $(".fenye").html("");
        $.ajax({
            url: "user/searchPostPage",
            type: "POST",
            data: {
                currentPage: currentPage,
                name: content
            },
            success: function (data) {
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        $("#show").append("\t\t\t\t\t\t\t<div class=\"single-post d-flex flex-row\">\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"thumb\">\n" +
                            "\t\t\t\t\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t<ul class=\"tags\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">艺术</a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">媒体</a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">设计</a>\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t</ul>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"details\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div class=\"title d-flex flex-row justify-content-between\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div class=\"titles\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\"><h4>" + this.post + "</h4></a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<h6>" + this.company.name + "</h6>\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<ul class=\"btns\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModal'  onclick='information(" + this.id + ")'><span>查看评论</span></a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModa2'  onclick='message(" + this.id + ")'><span>评论</span></a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">申请</a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t<p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t" + this.company.introdu + "\n" +
                            "\t\t\t\t\t\t\t\t\t</p>\n" +
                            "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-map\"></span> " + this.require + "</p>\n" +
                            "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-database\"></span> ￥" + this.salary + "</p>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t</div>")
                    })
                    $(".fenye").append("<a onclick='getSearchPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getSearchPage(" + pageCount + ")'>尾页</a>")
                })


            }
        })

    }
}


//点击分页后触发该事件
function getPage(currentPage) {
    if (currentPage > 0 && currentPage <= pageCount) {
        $("#show").html("");
        $(".fenye").html("");
        $.ajax({
            url: "user/getPositionsPage",
            type: "POST",
            data: {
                currentPage: currentPage
            },
            success: function (data) {
                // alert(data)
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        $("#show").append("\t\t\t\t\t\t\t<div class=\"single-post d-flex flex-row\">\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"thumb\">\n" +
                            "\t\t\t\t\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t<ul class=\"tags\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">艺术</a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">媒体</a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">设计</a>\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t\t</li>\n" +
                            "\t\t\t\t\t\t\t\t\t</ul>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"details\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div class=\"title d-flex flex-row justify-content-between\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div class=\"titles\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\"><h4>" + this.post + "</h4></a>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<h6>" + this.company.name + "</h6>\t\t\t\t\t\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<ul class=\"btns\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModal'  onclick='information(" + this.id + ")'><span>查看评论</span></a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a data-toggle='modal' data-target='#myModa2'  onclick='message(" + this.id + ")'><span>评论</span></a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">申请</a></li>\n" +
                            "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t<p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t" + this.company.introdu + "\n" +
                            "\t\t\t\t\t\t\t\t\t</p>\n" +
                            "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-map\"></span> " + this.require + "</p>\n" +
                            "\t\t\t\t\t\t\t\t\t<p class=\"address\"><span class=\"lnr lnr-database\"></span> ￥" + this.salary + "</p>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t</div>")
                    })
                    $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")
                })
            }
        })
    }
}

var page = 1;
var pageSize;//总页数
var pid;

//显示详细信息
function information(id) {
    //console.log(id)
    $("#content").html("");
    $(".fenye2").html("");
    pid = id;
    $.ajax({
        url: "user/getCommentPage",
        type: "POST",
        data: {
            id: pid,
            currentPage: page
        },
        success: function (data) {
            $(data).each(function () {
                pageSize = this.pageCount;
                var list = this.list;
                if (list != "") {
                    $(list).each(function () {
                        $("#content").append("  <tr>\n" +
                            "                    <td class=\"tm-col-master\" data-spm-anchor-id=\"a220o.1000855.0.i4.274e63aaCNftOy\">\n" +
                            "                        <div class=\"tm-rate-content\">\n" +
                            "                            <div class=\"tm-rate-fulltxt\">\n" +
                            "                                " + this.content + "\n" +
                            "                            </div>\n" +
                            "                            <div class=\"tm-m-photos\">\n" +
                            "                                <ul class=\"tm-m-photos-thumb\"\n" +
                            "                                    data-spm-anchor-id=\"a220o.1000855.0.i1.274e63aaCNftOy\"></ul>\n" +
                            "                                <div class=\"tm-m-photo-viewer\" style=\"width:0px;height:0px;display:none;\"><img src=\"\">\n" +
                            "                                    <a class=\"tm-m-photo-viewer-navleft\"><i class=\"tm-m-photo-viewer-navicon\"></i></a>\n" +
                            "                                    <a class=\"tm-m-photo-viewer-navright\"><i class=\"tm-m-photo-viewer-navicon\"></i></a>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"tm-rate-date\" style='color: #ccc;'>" + this.rtime + "</div>\n" +
                            "                    </td>\n" +
                            "                    <td class=\"col-meta\">\n" +
                            "                        <div class=\"rate-sku\"><p title=\"颜色分类:BL8833A\"><span></span>" + this.user.username + "</p>\n" +
                            "                            </div>\n" +
                            "                        <div class=\"rate-user-profile\"><p title=\"\"></p></div>\n" +
                            "                    </td>\n</tr>\n")
                    })
                    $(".fenye2").append("<a onclick='getPage2(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + this.pageCount + ")'>尾页</a>")

                } else {
                    $("#content").append("<tr><td>暂无评论</td></tr>")
                }

            })
        }
    })

}

//点击分页后触发该事件
function getPage2(currentPage) {
    if (currentPage > 0 && currentPage <= pageSize) {

        $("#content").html("");
        $(".fenye2").html("");
        $.ajax({
            url: "user/getCommentPage",
            type: "POST",
            data: {
                id: pid,
                currentPage: currentPage
            },
            success: function (data) {
                $(data).each(function () {
                    var list = this.list;
                    if (list != "") {
                        $(list).each(function () {
                            $("#content").append("  <tr>\n" +
                                "                    <td class=\"tm-col-master\" data-spm-anchor-id=\"a220o.1000855.0.i4.274e63aaCNftOy\">\n" +
                                "                        <div class=\"tm-rate-content\">\n" +
                                "                            <div class=\"tm-rate-fulltxt\">\n" +
                                "                                " + this.content + "\n" +
                                "                            </div>\n" +
                                "                            <div class=\"tm-m-photos\">\n" +
                                "                                <ul class=\"tm-m-photos-thumb\"\n" +
                                "                                    data-spm-anchor-id=\"a220o.1000855.0.i1.274e63aaCNftOy\"></ul>\n" +
                                "                                <div class=\"tm-m-photo-viewer\" style=\"width:0px;height:0px;display:none;\"><img src=\"\">\n" +
                                "                                    <a class=\"tm-m-photo-viewer-navleft\"><i class=\"tm-m-photo-viewer-navicon\"></i></a>\n" +
                                "                                    <a class=\"tm-m-photo-viewer-navright\"><i class=\"tm-m-photo-viewer-navicon\"></i></a>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                        <div class=\"tm-rate-date\" style='color: #ccc;'>" + this.rtime + "</div>\n" +
                                "                    </td>\n" +
                                "                    <td class=\"col-meta\">\n" +
                                "                        <div class=\"rate-sku\"><p title=\"颜色分类:BL8833A\"><span></span>" + this.user.username + "</p>\n" +
                                "                            </div>\n" +
                                "                        <div class=\"rate-user-profile\"><p title=\"\"></p></div>\n" +
                                "                    </td>\n</tr>\n")
                        })
                        $(".fenye2").append("<a onclick='getPage2(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage2(" + this.pageCount + ")'>尾页</a>")

                    } else {
                        $("#content").append("<tr><td>暂无评论</td></tr>")
                    }

                })
            }
        })
    }
}

//发表
function message(pId) {
    $("#id").val(pId)
    $("#publish").off().on('click', function () {
        $.ajax({
            url: "user/addComment",
            type: "POST",
            data: $("#comment").serialize(),
            success: function (data) {
                if (data > 0) {
                    /*  window.location.reload()*/
                    $("#news").val("")
                }
            }
        })
    })


}