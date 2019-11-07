$(function () {
    $.ajax({
        url: "findCompany",
        type: "POST",
        success: function (data) {
            $("#welcome").html("欢迎您：" + data.username)
        }
    })
    //注销
    $("#exit").click(function () {
        $.ajax({
            url: "exitCompany",
            type: "POST",
            success: function (data) {
                if (data == 0) {
                    window.location.href = "../login.html"
                }
            }
        })
    })

})