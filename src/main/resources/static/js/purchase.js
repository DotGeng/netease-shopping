(function (w, d, u) {
    var userName = sessionStorage.getItem("userName");
    util.get('userName').innerHTML = userName;
    $("#login").hide();
    var page = {
        init: function () {
            $.ajax({
                url: '/goods/purchased?userName='+ userName,
                /*dataType:'json',*/
                type: "post",
                dataType: "json",
                async: true,
                success: function (result) {
                    var listResult = result.content;
                    var n = listResult.length;
                    $("#purchaseGoods").empty();
                    var sumPrice = 0;
                    var tmp = "";
                    for (var i = 0; i < n; i++) {
                        tmp = '<colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>';
                        tmp = tmp + '<thead><tr><th>内容图片</th><th>内容名称</th><th>选购数量</th><th>购买价格</th></tr></thead>';
                        tmp = tmp + ' <tbody>'+
                            '<tr>' +
                            '<td><a href="./show.html"><img src="'+listResult[i].prictureUrl+'" alt=""></a></td>' +
                            '<td><h4><a href="./show.html">' + listResult[i].goodsName + '</a></h4></td>' +
                            '<td><span class="value">'+ listResult[i].soldCount +'</span></td>' +
                            '<td><span class="v-unit">¥</span><span class="value">'+ listResult[i].goodsPrice +'</span></td>' +
                            '</tr>' +
                            '</tbody>';
                        sumPrice = sumPrice + listResult[i].goodsPrice * listResult[i].soldCount;
                    }
                    tmp = tmp + '<tfoot>' +
                        '<tr>' +
                        '<td colspan="3"><div class="total">总计：</div></td>' +
                        '<td><span class="v-unit">¥</span><span class="value">'+ sumPrice + '</span></td>'+
                        '</tr>' +
                        '</tfoot>';
                    $("#purchaseGoods").append(tmp);
                },
                error: function (message) {
                }
            });
        }
    };

    jQuery.backPurchaseCart = function () {
        window.location.href="/goods/page/detail?userName=" + userName;
    };
    jQuery.cleanPurchaseCart = function () {
        $.ajax({
            url: '/goods/purchased/clean?userName='+ userName,
            type: "post",
            dataType: "json",
            async: true,
            success: function (result){
                alert("恭喜您购买成功，请去账户查看购买到的宝贝");
                $("#purchaseGoods").empty();
            },
            error: function (result) {
                alert("error" + result);
            }
        });
    };
    page.init();
})(window, document);