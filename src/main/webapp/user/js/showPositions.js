var currentPage = 1;//当前页
var pageCount;//总页数
$(function () {
    $.ajax({
        url: "getPositionsPage",
        type: "POST",
        data: {
            currentPage: currentPage
        },
        success: function (data) {
            //console.log(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                console.log(pageCount)
                var list = this.list;
                $(list).each(function () {
                    if (this.stauts == 1) {
                        $(".shwo").append(" <dl>\n" +
                            "                <dd>\n" +
                            "                    <h3><a href=\"http://www.hunt007.com/employer/viewInvite/8269728/72698867.htm\">" + this.post + "</a><em>|</em><a\n" +
                            "                            href=\"http://www.hunt007.com/employer/viewInfo/8269728.htm\">" + this.company.name + "</a></h3>\n" +
                            "                    <p class=\"request\">" + this.puttime + "\n" +
                            "                        <em>/</em>\n" +
                            "                        <b class=\"salary\">￥" + this.salary + "</b>\n" +
                            "                    </p>\n" +
                            "                    <p class=\"company_advantage\">" + this.require + "</p>\n" +
                            "                </dd>\n" +
                            "            </dl>")
                    }
                })
                $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")

            })
        }
    })
})

//点击分页后触发该事件
function getPage(currentPage) {
    console.log(currentPage)
    if (currentPage > 0 && currentPage <= pageCount) {
        $(".shwo").html("");
        $(".fenye").html("");
        $.ajax({
            url: "getPositionsPage",
            type: "POST",
            data: {
                currentPage: currentPage
            },
            success: function (data) {
                // alert(data)
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        if (this.stauts == 1) {
                            $(".shwo").append(" <dl>\n" +
                                "                <dd>\n" +
                                "                    <h3><a href=\"http://www.hunt007.com/employer/viewInvite/8269728/72698867.htm\">" + this.post + "</a><em>|</em><a\n" +
                                "                            href=\"http://www.hunt007.com/employer/viewInfo/8269728.htm\">" + this.company.name + "</a></h3>\n" +
                                "                    <p class=\"request\">" + this.puttime + "\n" +
                                "                        <em>/</em>\n" +
                                "                        <b class=\"salary\">￥" + this.salary + "</b>\n" +
                                "                    </p>\n" +
                                "                    <p class=\"company_advantage\">" + this.require + "</p>\n" +
                                "                </dd>\n" +
                                "            </dl>")
                        }
                    })
                    $(".fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")
                })
            }
        })
    }
}

//显示详细信息
function information(id) {
    $.ajax({
        url: "getPositionsById",
        type: "POST",
        data: {
            id: id
        },
        success: function (data) {
            $("#id").val(data.id)
            $("#post").val(data.post)
            $("#salary").val(data.salary)
            $("#name").val(data.company.name)
            $("#address").val(data.company.address)
            $("#email").val(data.company.email)
            $("#phone").val(data.company.phone)
            $("#require").val(data.require)
            $("#introdu").val(data.company.introdu)
        }
    })


}

function pass(id) {
    $.ajax({
        url: "positionsPss",
        type: "POST",
        data: {
            id: id
        },
        success: function (data) {
            if (data == 1) {
                window.location.reload()
            }
        }
    })
}