(function(w,d,u){
	var plist = util.get('plist');
	if(!plist){
		return;
	}
	var layer = new Layer();
	var loading = new Loading();
	var page = {
		init:function(){
			plist.addEventListener('click',function(e){
				var ele = e.target;
				var delId = ele.dataset && ele.dataset.del;
				if(delId){
					this.ondel(delId);
					return;
				}
			}.bind(this),false);
		},
		ondel:function(id){
			layer.reset({
				content:'确定要删除该内容吗？',
				onconfirm:function(){
					layer.hide();
					loading.show();
					ajax({
						url:'/api/delete',
						data:{id:id},
						success:function(json){
							this.delItemNode(id);
							loading.result('删除成功');
						}.bind(this)
					});
				}.bind(this)
			}).show();
		},
		delItemNode:function(id){
			var item = util.get('p-'+id);
			if(item && item.parentNode){
				item.parentNode.removeChild(item);
			}
		}
	};
    /*ajax({
        data:{userName:value1,password:value2},
        url:'/test',
		/!*dataType:'json',*!/
        success:function(result){
            loading.hide();
            // 请求成功的跳转地址
            location.href = '/get/index?'+'userName='+value2;
        },
        error:function(message){
            loading.result(message||'登录失败');
            isSubmiting = false;
        }
    });*/
    var userName = localStorage.getItem('userName');
    if ("" != userName || userName != null) {
        document.getElementById('userNameForIndex').innerHTML = userName;
        var logoutElements = document.getElementsByClassName("login");
        for(var i = 0; i < logoutElements.length; i ++) {
            logoutElements[i].style.display="none";
		}
        //
    }
	page.init();
})(window,document);