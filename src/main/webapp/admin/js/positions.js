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
            // alert(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                // alert("currentPage"+currentPage)
                //alert("pageCount"+pageCount)
                var list = this.list;
                $(list).each(function () {
                    if (this.stauts == 0) {
                        $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                            "<td>" + this.salary + "</td>" +
                            "<td>" + this.company.name + "</td>" +
                            "<td>" + this.puttime + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                            "<a class='btn btn-danger btn-xs' onclick='pass(" + this.id + ")'>通过</a></td></tr>")
                    } else {
                        $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                            "<td>" + this.salary + "</td>" +
                            "<td>" + this.company.name + "</td>" +
                            "<td>" + this.puttime + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;" +
                            "<font color='green' >已通过</font></td></tr>")
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
                        if (this.stauts == 0) {
                            $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                                "<td>" + this.salary + "</td>" +
                                "<td>" + this.company.name + "</td>" +
                                "<td>" + this.puttime + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                                "<a class='btn btn-danger btn-xs' onclick='pass(" + this.id + ")'>通过</a></td></tr>")
                        } else {
                            $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                                "<td>" + this.salary + "</td>" +
                                "<td>" + this.company.name + "</td>" +
                                "<td>" + this.puttime + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;" +
                                "<font color='green' >已通过</font></td></tr>")
                        }
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