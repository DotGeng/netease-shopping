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
    /**/
    var userName = sessionStorage.getItem('userName');
    if ("" != userName && userName != null) {
        document.getElementById('userNameForIndex').innerHTML = userName;
        var logoutElements = document.getElementsByClassName("login");
        for (var i = 0; i < logoutElements.length; i++) {
            logoutElements[i].style.display = "none";
        }
    } else { // 用户未登录greetingLabel
        document.getElementById('greetingLabel').innerHTML = "游客您好，请<a class=\"login\" href=\"./login.html\">[登录]</a>";
        /*ajax({
         url:'/visitor/all/goods',
         dataType:'json',
         type: "GET",
         success:function(result){
         var JsonObjs = eval('(' + result + ')');
         var n=JsonObjs.length;
         if(n==0){
         alert("系统按时无数据，请稍后重试");
         }
         for(var i = 0; i < JsonObjs.length; i++) {
         $("#plist").removeChild($("li[id^='p-']"));
         $("#plist").append("tianjiatianjia");
         }
         },
         error:function(message){
         alert("服务器异常，请稍后重试");
         }
         });*/
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
                    $("#plist").append('' +
                        '<li id="p-" + i + ">' +
                            '<a href="./show.html" class="link">' +
                                '<div class="img"><img src= "'+ listResult[i].pictureUrl +'"  alt=""></div>' +
                                '<h3>内容</h3>' +
                                '<div class="price"><span class="v-unit">¥</span><span class="v-value">'+listResult[i].goodsPrice+'</span></div>' +
                            '</a>' +
                        '<span class="u-btn u-btn-normal u-btn-xs del" data-del="9">删除</span></li>');
                }
                $("#plist").append('</ul>');
            }
        });
    }
    page.init();
})(window, document);