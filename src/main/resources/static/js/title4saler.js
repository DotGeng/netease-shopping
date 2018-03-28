(function (w, d, u) {
    document.getElementById('salerName').innerHTML = sessionStorage.getItem("salerName");
    $("#login").hide();
    $("#login").click(function () {
        window.location.href = "/get/sessions/news?salerName=" + sessionStorage.getItem("salerName");
    });
    if (sessionStorage.getItem("salerName") == null) {
        $("#index").hide();
        $("#sendMessageOrBuyCart").hide();
    }
    $("#logout").click(function () {
        $.ajax({
            type: "post",
            data: {},
            url: "/logout?salerName=" + sessionStorage.getItem("salerName"),
            dataType: "json",
            success: function (result) {
                sessionStorage.clear();
                //window.location.reload();
                window.location.href = "/get/sessions/saler/news";
            },
            error: function (result) {
                alert("退出失败" + result);
            }
        });
    });
})(window, document);