$(function () {
    $.ajax({
        url: "findUser",
        type: "POST",
        success: function (data) {
            $("#id").val(data.id)
            $("#username").val(data.username)
            $("#password").val(data.password)
            $("#name").val(data.name)
            $("#sex").val(data.sex)
            $("#birthday").val(data.birthday)
            $("#school").val(data.school)
            $("#phone").val(data.phone)
            $("#email").val(data.email)
            $("#trade").val(data.trade)
            $("#salary").val(data.salary)
            $("#tip").val(data.tip)
        }
    })

    $("#update").click(function () {
        $.ajax({
            url: "updateUser",
            type: "POST",
            data: $("#publish").serialize(),
            success: function (data) {
                if (data > 0) {
                    alert("修改成功！")
                    window.location.reload()
                }
            }
        })
    })

})