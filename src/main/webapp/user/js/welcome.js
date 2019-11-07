$(function () {
    $.ajax({
        url: "findUser",
        type: "POST",
        success: function (data) {
            $("#welcome").html("欢迎您：" + data.username)
        }
    })
    //注销
    $("#exit").click(function () {
        $.ajax({
            url: "exitUser",
            type: "POST",
            success: function (data) {
                console.log(data)
                if (data == 0) {
                    window.location.href = "../login.html"
                }
            }
        })
    })

})