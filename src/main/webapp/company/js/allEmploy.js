var currentPage = 1;//当前页
var pageCount;//总页数
$(function () {
    $.ajax({
        url: "getEmployPage",
        type: "POST",
        data: {
            currentPage: currentPage
        },
        success: function (data) {
            //console.log(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                // alert("currentPage"+currentPage)
                //alert("pageCount"+pageCount)
                var list = this.list;
                $(list).each(function () {
                    if (this.stauts == 0) {
                        $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                            "<td>" + this.user.trade + "</td>" +
                            "<td>" + this.user.school + "</td>" +
                            "<td>" + this.user.salary + "</td>" +
                            "<td>" + this.user.phone + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;&nbsp;" +
                            "<a class='btn btn-danger btn-xs' onclick='pass(1," + this.id + ")'>同意</a>&nbsp;&nbsp;" +
                            "<a class='btn btn-danger btn-xs' onclick='pass(2," + this.id + ")'>拒绝</a></td></tr>")
                    } else if (this.stauts == 1) {
                        $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                            "<td>" + this.user.trade + "</td>" +
                            "<td>" + this.user.school + "</td>" +
                            "<td>" + this.user.salary + "</td>" +
                            "<td>" + this.user.phone + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;" +
                            "<font color='green' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已同意</font></td></tr>")
                    } else {
                        $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                            "<td>" + this.user.trade + "</td>" +
                            "<td>" + this.user.school + "</td>" +
                            "<td>" + this.user.salary + "</td>" +
                            "<td>" + this.user.phone + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;" +
                            "<font color='green' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已拒绝</font></td></tr>")
                    }

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
            url: "getEmployPage",
            type: "POST",
            data: {
                currentPage: currentPage
            },
            success: function (data) {
                // alert(data)
                $(data).each(function () {
                    var list = this.list;
                    $(list).each(function () {
                        if (this.stauts == 0) {
                            $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                                "<td>" + this.user.trade + "</td>" +
                                "<td>" + this.user.school + "</td>" +
                                "<td>" + this.user.salary + "</td>" +
                                "<td>" + this.user.phone + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;&nbsp;" +
                                "<a class='btn btn-danger btn-xs' onclick='pass(1," + this.id + ")'>同意</a>&nbsp;&nbsp;" +
                                "<a class='btn btn-danger btn-xs' onclick='pass(2," + this.id + ")'>拒绝</a></td></tr>")
                        } else if (this.stauts == 1) {
                            $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                                "<td>" + this.user.trade + "</td>" +
                                "<td>" + this.user.school + "</td>" +
                                "<td>" + this.user.salary + "</td>" +
                                "<td>" + this.user.phone + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;" +
                                "<font color='green' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已通过</font></td></tr>")
                        } else {
                            $("tbody:eq(0)").append("<tr><td>" + this.user.name + "</td>" +
                                "<td>" + this.user.trade + "</td>" +
                                "<td>" + this.user.school + "</td>" +
                                "<td>" + this.user.salary + "</td>" +
                                "<td>" + this.user.phone + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + JSON.stringify(this) + ")'>详情</a>&nbsp;" +
                                "<font color='green' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已拒绝</font></td></tr>")
                        }
                    })
                    $("div:eq(0)").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + this.pageCount + ")'>尾页</a>")
                })
            }
        })
    }
}

//显示详细信息
function information(data) {
    //console.log(data)
    $("#post").val(data.positions.post)
    $("#name").val(data.user.name)
    $("#sex").val(data.user.sex)
    $("#birthday").val(data.user.birthday)
    $("#school").val(data.user.school)
    $("#trade").val(data.user.trade)
    $("#phone").val(data.user.phone)
    $("#email").val(data.user.email)
    $("#salary").val(data.user.salary)
    $("#tip").val(data.user.tip)

}

/*审核求职者*/
function pass(stauts, id) {
    $.ajax({
        url: "updateEmployByCompany",
        type: "POST",
        data: {
            id: id,
            stauts: stauts
        },
        success: function (data) {
            alert("操作成功")
            window.location.reload()
        }
    })
}