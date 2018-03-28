(function (w, d, u) {
    document.getElementById('userName').innerHTML = sessionStorage.getItem("userName");
    $("#login").hide();
    $("#login").click(function () {
        window.location.href = "/get/sessions/news?userName=" + sessionStorage.getItem("userName");
    });
    if (sessionStorage.getItem("userName") == null) {
        $("#index").hide();
        $("#sendMessageOrBuyCart").hide();
    }
    $("#logout").click(function () {
        $.ajax({
            type: "post",
            data: {},
            url: "/logout?userName=" + sessionStorage.getItem("userName"),
            dataType: "json",
            success: function (result) {
                sessionStorage.clear();
                //window.location.reload();
                window.location.href = "/get/sessions/new";
            },
            error: function (result) {
                alert("退出失败" + result);
            }
        });
    });
})(window, document);