var currentPage = 1;//当前页
var pageCount;//总页数
var cid;
var post;//职位名称
var require;//职位描述
var salary;//薪资
var puttime;//发布时间
var name1;//公司名
var address;//地址
var email;//邮箱
var phone;//电话
var introdu;//描述
$(function () {
    var href = window.location.href;
    var split = href.split("id=");
    var id = split[1];
    cid = id;
    $.ajax({
        url: "getCommentPage",
        type: "POST",
        data: {
            id: cid,
            currentPage: currentPage
        },
        success: function (data) {
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                var list = this.list;
                $(list).each(function () {
                    $("tbody:eq(0)").append("  <tr>\n" +
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
                        "                        <div class=\"rate-sku\"><p title=\"颜色分类:BL8833A\"><span>评论人：</span>" + this.user.username + "</p>\n" +
                        "                            </div>\n" +
                        "                        <div class=\"rate-user-profile\"><p title=\"\"></p></div>\n" +
                        "                    </td>\n" +
                        "                    <td class=\"col-author\">\n" +
                        "                        <div class=\"rate-user-info\"><span><a class='btn btn-danger btn-xs'>删除</a></span></div>\n" +
                        "                    </td>\n" +
                        "                </tr>\n")
                    /* 获取所有信息*/
                    post = this.positions.post;
                    require = this.positions.require;
                    salary = this.positions.salary;
                    puttime = this.positions.puttime;
                    name1 = this.company.name;
                    address = this.company.address;
                    email = this.company.email;
                    phone = this.company.phone;
                    introdu = this.company.introdu;
                })
                $("#post").html(post)
                $("#post1").html(post)
                $("#require").html(require)
                $("#salary").html(salary)
                $("#puttime").html(puttime)
                $("#name1").html(name1)
                $("#address").html(address)
                $("#email").html(email)
                $("#phone").html(phone)
                $("#introdu").html(introdu)

                $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + this.pageCount + ")'>尾页</a>")
            })
        }
    })
})

//点击分页后触发该事件
function getPage(currentPage) {
    if (currentPage > 0 && currentPage <= pageCount) {
        $("tbody:eq(0)").html("");
        $(".fenye").html("");
        $.ajax({
            url: "getCommentPage",
            type: "POST",
            data: {
                id: cid,
                currentPage: currentPage
            },
            success: function (data) {
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        $("tbody:eq(0)").append("  <tr>\n" +
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
                            "                        <div class=\"rate-sku\"><p title=\"颜色分类:BL8833A\"><span>评论人：</span>" + this.user.username + "</p>\n" +
                            "                            </div>\n" +
                            "                        <div class=\"rate-user-profile\"><p title=\"\"></p></div>\n" +
                            "                    </td>\n" +
                            "                    <td class=\"col-author\">\n" +
                            "                        <div class=\"rate-user-info\"><span><a class='btn btn-danger btn-xs'>删除</a></span></div>\n" +
                            "                    </td>\n" +
                            "                </tr>\n")
                    })

                    $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + this.pageCount + ")'>尾页</a>")
                })
            }
        })
    }
}