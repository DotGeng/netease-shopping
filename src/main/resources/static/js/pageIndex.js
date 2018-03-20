(function (w, d, u) {
    var plist = util.get('plist');
    if (!plist) {
        return;
    }
    var layer = new Layer();
    var loading = new Loading();
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
        ondel: function (id) {
            layer.reset({
                content: '确定要删除该内容吗？',
                onconfirm: function () {
                    layer.hide();
                    loading.show();
                    ajax({
                        url: '/api/delete',
                        data: {id: id},
                        success: function (json) {
                            this.delItemNode(id);
                            loading.result('删除成功');
                        }.bind(this)
                    });
                }.bind(this)
            }).show();
        },
        delItemNode: function (id) {
            var item = util.get('p-' + id);
            if (item && item.parentNode) {
                item.parentNode.removeChild(item);
            }
        }
    };

    var userName = sessionStorage.getItem('userName');
    var getResult = function(){
        $.ajax({
            type: "get",
            url: "/visitor/all/goods",
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
                        '<a href="./show.html" class="link">' +
                        '<div class="img"><img src= "'+ listResult[i].pictureUrl +'"  alt=""></div>' +
                        '<h3>内容</h3>' +
                        '<div class="price"><span class="v-unit">¥</span><span class="v-value">'+listResult[i].goodsPrice+'</span></div>';
                    if(listResult[i].hasSeal == 1) {
                        temp = temp + '<span class="had"><b>已购买</b></span>';
                    }
                    temp = temp + '</li>';
                    $("#plist").append(temp);
                }
                $("#plist").append('</ul>');
                document.getElementById("selector_1").className="z-sel";
                document.getElementById("selector_2").className="";
            }
        });
    };
    if ("" != userName && userName != null) {
        document.getElementById('userNameForIndex').innerHTML = userName;
        document.getElementById('sendMessageOrBuyCart').innerHTML = '<a  href="./public.html">购物车</a>';
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
    $("#notSealGoods").click(function () {
        $.ajax({
            data:{userName:sessionStorage.getItem("userName")},
            type: "post",
            url: "/goods/not/seal?userName="+sessionStorage.getItem("userName"),
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
                        '<a id="showDetail" class="link">' +
                        '<div class="img"><img src= "'+ listResult[i].pictureUrl +'"  alt=""></div>' +
                        '<h3>内容</h3>' +
                        '<div class="price"><span class="v-unit">¥</span><span class="v-value">'+listResult[i].goodsPrice+'</span></div>' +
                        '</a>');
                }
                $("#plist").append('</ul>');
                document.getElementById("selector_1").className="";
                document.getElementById("selector_2").className="z-sel";
                /*var my_class_name = document.getElementById("selector_1").className;
                document.getElementById("selector_1").className  = document.getElementById("selector_2").className;
                document.getElementById("selector_2").className = my_class_name;*/
            }
        });
    });
    // 给某一个商品信息添加ajax事件
    $("#showDetail").click(

        
    );
    // 给全部产品a标签指定点击事件
    $("#allGoods").click(function() {
        getResult();
    });
    getResult();
    page.init();
})(window, document);