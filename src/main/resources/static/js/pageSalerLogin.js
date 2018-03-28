(function (w, d, u) {
    sessionStorage.clear();
    var loginForm = util.get('loginForm');
    if (!loginForm) {
        return;
    }
    var userName = loginForm['userName'];
    var password = loginForm['password'];
    var salerName = loginForm['salerName'];
    var isSubmiting = false;
    var loading = new Loading();
    var page = {
        init: function () {
            loginForm.addEventListener('submit', function (e) {
                if (!isSubmiting && this.check()) {
                    var value1;
                    var isSaler = false;
                    if (userName != null) {
                        value1 = userName.value;
                    } else {
                        value1 = salerName.value;
                        isSaler = true;
                    }
                    //var value2 = md5(password.value);
                    // 密码传输改为不用md5加密
                    var value2 = password.value;

                    isSubmiting = true;
                    loading.show();
                    ajax({
                        data: {salerName: value1, password: value2},
                        url: '/sessions/saler/index',
                        /*dataType:'json',*/
                        success: function (result) {
                            loading.hide();
                            // 请求成功的跳转地址
                            if (!isSaler) {
                                location.href = '/get/index?' + 'userName=' + value1;
                                sessionStorage.setItem("userName", value1);
                            } else {
                                location.href = '/get/sessions/saler/index?' + 'salerName=' + value1;
                                sessionStorage.setItem("salerName", value1)
                            }

                        },
                        error: function (message) {
                            loading.result(message || '登录失败');
                            isSubmiting = false;
                        }
                    });
                }
            }.bind(this), false);
            [salerName, password].forEach(function (item) {
                item.addEventListener('input', function (e) {
                    item.classList.remove('z-err');
                }.bind(this), false);
            }.bind(this));
        },
        check: function () {
            var result = true;
            [
                [salerName, function (value) {
                    return value == ''
                }],
                [password, function (value) {
                    return value == ''
                }]
            ].forEach(function (item) {
                var value = item[0].value.trim();
                if (item[1](value)) {
                    item[0].classList.add('z-err');
                    result = false;
                }
                item[0].value = value;
            });
            return result;
        }
    };
    page.init();
})(window, document);