$(function () {
    $.ajax({
        url: "findCompany",
        type: "POST",
        success: function (data) {
            console.log(data)
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

    $("#update").click(function () {
        $.ajax({
            url: "updateCompany",
            type: "POST",
            data: $("#publish").serialize(),
            success: function (data) {
                if (data > 0) {
                    alert("修改成功！")
                    parent.location.reload(); //刷新父亲对象（用于框架）
                }
            }
        })
    })

})