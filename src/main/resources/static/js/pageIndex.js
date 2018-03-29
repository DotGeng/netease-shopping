(function (w, d, u) {
    var plist = util.get('plist');
    if (!plist) {
        return;
    }
    var layer = new Layer();
    var loading = new Loading();
    // 给全部产品a标签指定点击事件

    var page = {

        init: function () {
            plist.addEventListener('click', function (e) {
                var ele = e.target;
                var delId = ele.dataset && ele.dataset.del;
                if (delId) {
                    this.ondel(delId);
                    return;
                }
            }.bind(this), false);
        },
        delItemNode: function (id) {
            var item = util.get('p-' + id);
            if (item && item.parentNode) {
                item.parentNode.removeChild(item);
            }
        }
    };

    var userName = sessionStorage.getItem('userName');
    jQuery.hrefgoodsdetail = function (goodsId) {
        sessionStorage.setItem("goodsId", goodsId);
    };
    var getResult = function () {
        $.ajax({
            type: "get",
            url: "/visitor/all/goods?userName=" + sessionStorage.getItem("userName"),
            dataType: "json",
            async: true,
            success: function (result) {
                var n = result.content.length;
                var listResult = result.content;
                if (n == 0) {
                    alert("系统按时无数据，请稍后重试");
                }
                $("#plist").empty();
                $("#plist").append('<ul class="f-cb" id="plist">');
                for (var i = 0; i < n; i++) {
                    var temp = '<li id="p-" + i + ">' +
                        '<a href="/goods/page/detail?userName=' + sessionStorage.getItem("userName") + '" onclick="jQuery.hrefgoodsdetail(' + listResult[i].goodsId + ')" class="link">' +
                        '<div class="img"><img src= "' + listResult[i].pictureUrl + '"  alt=""></div>' +
                        '<h3>' + listResult[i].title + '</h3>' +
                        '<div class="price"><span class="v-unit">¥</span><span class="v-value">' + listResult[i].goodsPrice + '</span></div>';
                    if (listResult[i].hasSeal == 1) {
                        temp = temp + '<span class="had"><b>已购买</b></span>';
                    }
                    temp = temp + '</li>';
                    $("#plist").append(temp);
                }
                $("#plist").append('</ul>');
                document.getElementById("selector_1").className = "z-sel";
                document.getElementById("selector_2").className = "";
            }
        });
    };
    if ("" != userName && userName != null) {
        document.getElementById('userName').innerHTML = userName;
        document.getElementById('sendMessageOrBuyCart').innerHTML = '<a  href="/static/show/purchase">购物车</a>';
        var logoutElements = document.getElementsByClassName("login");
        for (var i = 0; i < logoutElements.length; i++) {
            logoutElements[i].style.display = "none";
        }
    } else { // 用户未登录greetingLabel
        document.getElementById('greetingLabel').innerHTML = "游客您好，请<a class=\"login\" href=\"./login.html\">[登录]</a>";
        $("#notSealGoods").hide();
        getResult();

    }
    // 给未购买a标签指定点击事件
    $("#selector_2").click(function () {
        $.ajax({
            data: {userName: sessionStorage.getItem("userName")},
            type: "post",
            url: "/goods/not/seal?userName=" + sessionStorage.getItem("userName"),
            dataType: "json",
            async: true,
            success: function (result) {

                var n = result.content.length;
                var listResult = result.content;
                if (n == 0) {
                    alert("系统按时无数据，请稍后重试");
                }
                $("#plist").empty();
                $("#plist").append('<ul class="f-cb" id="plist">');
                for (var i = 0; i < n; i++) {
                    $("#plist").append('' +
                        '<li id="p-" + i + ">' +
                        '<input style="display:none" value="' + listResult[i].goodsId + '"/>' +
                        /*'<a href="javascript:void(0);" onclick="" class="link">' +*/
                        '<a href="/goods/page/detail?userName=' + sessionStorage.getItem("userName") + '" onclick="jQuery.hrefgoodsdetail(' + listResult[i].goodsId + ')" class="link">' +
                        '<div class="img"><img src= "' + listResult[i].pictureUrl + '"  alt=""></div>' +
                        '<h3>' + listResult[i].content + '</h3>' +
                        '<div class="price"><span class="v-unit">¥</span><span class="v-value">' + listResult[i].goodsPrice + '</span></div>' +
                        '</a>');
                }
                $("#plist").append('</ul>');
                document.getElementById("selector_1").className = "";
                document.getElementById("selector_2").className = "z-sel";
            }
        });
    });
    // 给全部内容添加点击事件
    $("#selector_1").click(function () {
        getResult();
    });
    /*// 给某一个商品信息添加ajax事件
     var goodsLinks = $(".link");
     for (var i = 0; i < goodsLinks.length; i ++) {
     $("#showDetails").click(
     goodsLinks[i]
     );
     }*/


    getResult();
    page.init();
})(window, document);