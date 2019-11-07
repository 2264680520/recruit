var currentPage = 1;//当前页
var pageCount;//总页数
$(function () {
    $.ajax({
        url: "selectAllPss",
        type: "POST",
        data: {
            currentPage: currentPage
        },
        success: function (data) {

            if (data.list != "") {
                $(data).each(function () {
                    currentPage = this.currentPage;//获取当前页
                    pageCount = this.pageCount;//获取总页数
                    var list = this.list;
                    $(list).each(function () {
                        $("tbody:eq(0)").append("<tr><td>您发布的招聘" + this.post + "信息审核已通过</td>" +
                            "<td>" + this.puttime + "</td></tr>")
                    })
                    $("#fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")
                })
            } else {
                $("tbody:eq(0)").append("<tr><td>暂无消息</td></tr>")
            }

        }
    })
})

//点击分页后触发该事件
function getPage(currentPage) {
    if (currentPage > 0 && currentPage <= pageCount) {
        $("tbody:eq(0)").html("");
        $("#fenye").html("");
        $.ajax({
            url: "selectAllPss",
            type: "POST",
            data: {
                currentPage: currentPage
            },
            success: function (data) {
                console.log(data)
                if (data.list != "") {
                    $(data).each(function () {
                        var list = this.list;
                        $(list).each(function () {
                            // console.log(this.post)
                            $("tbody:eq(0)").append("<tr><td>您发布的招聘" + this.post + "信息审核已通过</td>" +
                                "<td>" + this.puttime + "</td></tr>")
                        })
                        $("#fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")
                    })
                } else {
                    $("tbody:eq(0)").append("<tr><td>暂无消息</td></tr>")
                }

            }
        })
    }
}

