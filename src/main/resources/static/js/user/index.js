var vm = new Vue({
    el: '#app',
    data:{
        tableTitle : [ {
            type: 'index',
            title : "序号",
        },
            {
                key : "username",
                title : "账号",
            },{
                key : "nickname",
                title : "姓名",
            },{
                key : "email",
                title : "邮箱",
            },{
                key : "createTime",
                title : "创建时间",
            },{
                title : '操作',
                key : 'action',
                width : 300,
                align : 'center',
                render : function(h, params) {
                    var functionList = [];
                    var edit = h('Button', {
                        props : {
                            type : 'primary',
                            size : 'small',
                        },
                        style : {
                            marginRight : '8px'
                        },
                        on : {
                            click : function() {
                                vm.edit(params.row.id);
                            }
                        }
                    }, '修改');
                    functionList.push(edit);
                    var remove = h('Button', {
                        props : {
                            type : 'primary',
                            size : 'small',
                        },
                        style : {
                            marginRight : '8px'
                        },
                        on : {
                            click : function() {
                                vm.remove(params.row.id);
                            }
                        }
                    }, '删除');
                    functionList.push(remove);
                    var reset = h('Button', {
                        props : {
                            type : 'primary',
                            size : 'small',
                        },
                        style : {
                            marginRight : '8px'
                        },
                        on : {
                            click : function() {
                                vm.reset(params.row.id);
                            }
                        }
                    }, '密码重置');
                    functionList.push(reset);
                    return h('div',{

                    }, functionList);
                }
            }],
        userData:[],
        user : {
            pageSize : 10,
            pageNo : 1,
            content :''
        },
        tableSize : 50,
    },
    methods: {
        load:function(){
            $.ajax({
                type: "POST",
                url: "/user/list",
                dataType: "json",
                success: function(response){
                    if(response.code === 200){//登录成功
                        vm.tableSize = response.data.total;
                        vm.userData = response.data.list;
                    }
                }
            });
        },
        changePage:function(){

        },
        changePageSize:function(){

        },
        add:function(){
            dialogOpen({
                title: "新增",
                url: "/user/add",
                scroll : true,
                width:  "40%",
                height:  "60%",
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                },
            });
        },
        edit:function(id){
            dialogOpen({
                title: "修改",
                url: "/user/add",
                scroll : true,
                width:  "40%",
                height:  "60%",
                success:function(iframeId){
                    top.frames[iframeId].vm.formUser.id = id
                    top.frames[iframeId].vm.setForm();
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                },
            });
        },
        remove:function(id){
            var index = top.layer.confirm('确认要删除吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.SaveForm({
                    url :  "/user/remove",
                    param : {id:id},
                    json:true,
                    success : function(result) {
                        top.layer.close(index);
                        vm.load();
                    }
                });
            });
        },
        reset:function(id){
            dialogOpen({
                title: "修改",
                url: "base/user/reset.shtml",
                scroll : true,
                width:  "25%",
                height:  "25%",
                success:function(iframeId){
                    top.frames[iframeId].vm.formUser.id = id
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                },
            });
        }
    },
    created: function(){
        this.load();
    }
});