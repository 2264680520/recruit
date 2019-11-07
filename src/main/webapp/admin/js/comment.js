var currentPage = 1;//当前页
var pageCount;//总页数
$(function () {
    $.ajax({
        url: "getPositionsWithCompanyPage",
        type: "POST",
        data: {
            currentPage: currentPage
        },
        success: function (data) {
            // alert(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                // alert("currentPage"+currentPage)
                //alert("pageCount"+pageCount)
                var list = this.list;
                $(list).each(function () {
                    $("tbody:eq(0)").append("<tr><td>" + this.positions.post + "</td>" +
                        "<td>" + this.company.name + "</td>" +
                        "<td>" + this.company.address + "</td>" +
                        "<td>" + this.count + "</td>" +
                        "<td><a class='btn btn-primary btn-xs' href='commentInformation.html?id=" + this.positions.id + "'>查看所有评论</a>&nbsp;&nbsp;" +
                        "</td></tr>")
                })
                $("div:eq(0)").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")

            })
        }
    })
})

//点击分页后触发该事件
function getPage(currentPage) {
    if (currentPage > 0 && currentPage <= pageCount) {
        $("tbody:eq(0)").html("");
        $("div:eq(0)").html("");
        $.ajax({
            url: "getPositionsWithCompanyPage",
            type: "POST",
            data: {
                currentPage: currentPage
            },
            success: function (data) {
                // alert(data)
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        $("tbody:eq(0)").append("<tr><td>" + this.positions.post + "</td>" +
                            "<td>" + this.company.name + "</td>" +
                            "<td>" + this.company.address + "</td>" +
                            "<td>" + this.count + "</td>" +
                            "<td><a  class='btn btn-primary btn-xs' href='commentInformation.html?id=" + this.positions.id + "'>查看所有评论</a>&nbsp;&nbsp;" +
                            "</td></tr>")
                    })
                    $("div:eq(0)").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + this.pageCount + ")'>尾页</a>")
                })
            }
        })
    }
}

//显示详细信息
function information(id) {
    $.ajax({
        url: "getCompanyById",
        type: "POST",
        data: {
            id: id
        },
        success: function (data) {
            $("#id").val(data.id)
            $("#username").val(data.username)
            $("#password").val(data.password)
            $("#name").val(data.name)
            $("#address").val(data.address)
            $("#email").val(data.email)
            $("#phone").val(data.phone)
            $("#introdu").val(data.introdu)
        }
    })
    //点击修改
    $("#btu").click(function () {
        $.ajax({
            url: "updateCompanyByAdmin",
            type: "POST",
            data: $(".form-horizontal:eq(0)").serialize(),
            success: function (data) {
                if (data > 0) {
                    alert("修改成功")
                    window.location.reload()
                }
            }
        })
    })
}