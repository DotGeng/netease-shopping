(function(w,d,u){
    var page = {
        init: function () {
            var userName = sessionStorage.getItem("userName");
            $.ajax({
                url: '/booing/user?userName=' + userName,
                type: "post",
                dataType: "json",
                async: true,
                success: function (result) {
                    var listResult = result.content;
                    var n = listResult.length;
                    $("#account").empty();
                    var sumPrice = 0;
                    var tmp = "";
                    for (var i = 0; i < n; i++) {
                        tmp = '<colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>';
                        tmp = tmp + '<thead><tr><th>内容图片</th><th>标题</th><th>选购时间</th><th>购买价格</th><th>选购数量</th></tr></thead>';
                        tmp = tmp + ' <tbody>'+
                            '<tr>' +
                            '<td><a href="./show.html"><img src="'+listResult[i].pictureUrl+'" alt=""></a></td>' +
                            '<td><h4><a href="./show.html">' + listResult[i].title + '</a></h4></td>' +
                            '<td><span class="value">'+ listResult[i].purchaseTime +'</span></td>' +
                            '<td><span class="v-unit">¥</span><span class="value">'+ listResult[i].buyedPrice +'</span></td>' +
                            '<td><span class="value">'+ listResult[i].goodsNum +'</span></td>' +
                            '</tr>' +
                            '</tbody>';
                        sumPrice = sumPrice + listResult[i].buyedPrice * listResult[i].goodsNum;
                    }
                    tmp = tmp + '<tfoot>' +
                        '<tr>' +
                        '<td colspan="3"><div class="total">总计：</div></td>' +
                        '<td><span class="v-unit">¥</span><span class="value">'+ sumPrice + '</span></td>'+
                        '</tr>' +
                        '</tfoot>';
                    $("#account").append(tmp);
                },
                error: function (message) {

                }
            });
        }
    };


    page.init();
})(window,document);