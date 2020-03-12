$(function () {
    var vm = new Vue({
        el: '#app',
        data:{
            username: 'admin',
            password: 'admin',
        },
        methods: {
            login: function (event) {
                if(vm.username==""){
                    vm.error = true;
                    vm.errorMsg ="请输入用户名";
                    return false;
                }else if(vm.password==""){
                    vm.error = true;
                    vm.errorMsg ="请输入密码";
                    return false;
                }
                var self = this;
                var data = "username="+vm.username+"&password="+vm.password;
                $.ajax({
                    type: "POST",
                    url: "login",
                    data: data,
                    dataType: "json",
                    success: function(response){
                        if(response.code === 200){//登录成功
                            parent.location.href ='index';
                        }else{
                            pop.info(response.msg)
                        }
                    }
                });
            }
        },
        created: function(){

        }
    });
});