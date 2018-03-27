(function (w, d, u) {
    var salerName = sessionStorage.getItem("salerName");
    util.get('salerName').innerHTML = salerName;
    $("#login").hide();
})(window, document);