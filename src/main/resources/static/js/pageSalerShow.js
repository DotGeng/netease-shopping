(function (w, d, u) {
    var showContent = util.get('showContent');
    if (!showContent) {
        return;
    }
    var loading = new Loading();
    var layer = new Layer();
    var page = {
        init: function () {
            var goodsId = sessionStorage.getItem("goodsId");
            var salerName = sessionStorage.getItem("salerName");
            $.ajax({
                data: {goodsId: goodsId},
                url: '/goods/detail?salerName=' + salerName,
                type: "post",
                dataType: "json",
                async: true,
                success: function (result) {
                    var goods = result.content;
                    util.get('salerName').innerHTML = salerName;
                    $("#login").hide();
                    var hasSealClass = "u-btn u-btn-primary";
                    var price = goods.goodsPrice;
                    var hasBuyedPrice = "display:none";
                    var buyButton = "";
                    if (goods.hasSeal == 1) {
                        hasSealClass = "u-btn u-btn-primary z-dis";
                        price = goods.buyedPrice;
                        hasBuyedPrice = "";
                        buyButton = "display:none";
                        $("#buyButton").unbind("click");

                    }

                    var tmp = '<div class="img"><img src="' + goods.pictureUrl + '" alt=""></div>' +
                        '<div class="cnt">' +
                        '<h2>' + goods.goodsName + '</h2>' +
                        '<p class="summary">' + goods.goodsAbstract + '</p>' +
                        '<div class="price">' +
                        '<span class="v-unit">¥</span><span class="v-value">' + price + '</span>' +
                        '</div>' +
                        '<div class="oprt f-cb">' +
                        '<a href="./edit.html" class="u-btn u-btn-primary">编 辑</a>' +
                        '</div>' +
                        '</div>';
                    $("#showContent").empty();
                    $("#showContent").append(tmp);
                    $("#detailContents").empty();
                    $("#detailContents").append(goods.content);
                },
                error: function (message) {
                    loading.result(message || '购买失败');
                }
            });
            showContent.addEventListener('click', function (e) {
                var ele = e.target;
                var buy = ele && ele.dataset.buy;
                if (buy) {
                    layer.reset({
                        content: '确认购买本内容吗？',
                        onconfirm: function () {
                            layer.hide();
                            loading.show();
                            ajax({
                                data: {id: buy},
                                url: '/api/buy',
                                success: function (result) {
                                    loading.result('购买成功', function () {
                                        location.href = './account.html';
                                    });
                                },
                                error: function (message) {
                                    loading.result(message || '购买失败');
                                }
                            });
                        }.bind(this)
                    }).show();
                    return;
                }
            }.bind(this), false);
        }
    };
    page.init();
})(window, document);