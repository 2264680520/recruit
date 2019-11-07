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
            //alert(data)
            $(data).each(function () {
                currentPage = this.currentPage;//获取当前页
                pageCount = this.pageCount;//获取总页数
                var list = this.list;
                $(list).each(function () {
                    if (this.stauts == 0){
                        $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                            "<td>" + this.salary + "</td>" +
                            "<td>" + this.require + "</td>" +
                            "<td>" + this.puttime + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                            "<a class='btn btn-danger btn-xs'>删除</a></td>" +
                            "<td><font color='gray' >待审核</font></td></tr>")
                    }else {
                        $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                            "<td>" + this.salary + "</td>" +
                            "<td>" + this.require + "</td>" +
                            "<td>" + this.puttime + "</td>" +
                            "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                            "<a class='btn btn-danger btn-xs'>删除</a></td>" +
                            "<td><font color='green' >审核通过</font></td></tr>")
                    }

                })
                $("#fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + pageCount + ")'>尾页</a>")

            })
        }
    })

    //发布招聘
    $("#addPositions").click(function () {
        $.ajax({
            url: "addPositions",
            type: "POST",
            data: $("#publish").serialize(),
            success: function (data) {
                if (data > 0) {
                    alert("发布成功")
                    window.location.reload()
                }
            }
        })
    })

})

//点击分页后触发该事件
function getPage(currentPage) {
    //alert(currentPage)
    if (currentPage > 0 && currentPage <= pageCount) {
        $("tbody:eq(0)").html("");
        $("#fenye").html("");
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
                        if (this.stauts == 0){
                            $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                                "<td>" + this.salary + "</td>" +
                                "<td>" + this.require + "</td>" +
                                "<td>" + this.puttime + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                                "<a class='btn btn-danger btn-xs'>删除</a></td>" +
                                "<td><font color='gray' >待审核</font></td></tr>")
                        }else {
                            $("tbody:eq(0)").append("<tr><td>" + this.post + "</td>" +
                                "<td>" + this.salary + "</td>" +
                                "<td>" + this.require + "</td>" +
                                "<td>" + this.puttime + "</td>" +
                                "<td><a data-toggle='modal' data-target='#myModal' class='btn btn-primary btn-xs' onclick='information(" + this.id + ")'>详情</a>&nbsp;&nbsp;" +
                                "<a class='btn btn-danger btn-xs'>删除</a></td>" +
                                "<td><font color='green' >审核通过</font></td></tr>")
                        }
                    })
                    $("#fenye").append("<a onclick='getPage(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage - 1) + ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + (this.currentPage + 1) + ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='getPage(" + this.pageCount + ")'>尾页</a>")
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
            $("#stauts").val(data.stauts)
            $("#post").val(data.post)
            $("#require").val(data.require)
            $("#salary").val(data.salary)
            $("#puttime").val(data.puttime)
        }
    })
    //点击修改
    $("#btu").click(function () {
        $.ajax({
            url: "updatePositionsByCompany",
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