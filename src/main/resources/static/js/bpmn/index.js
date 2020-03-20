$(function () {
    let vm = new Vue({
        el: '#app',
        data:{
            tableTitle : [ {
                type: 'index',
                title : "序号",
            },
                {
                    key : "name",
                    title : "名称",
                },{
                    key : "category",
                    title : "分类",
                },{
                    key : "key",
                    title : "主键",
                },{
                    key : "metaInfo",
                    title : "详情",
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
                                    vm.edit(params.row);
                                }
                            }
                        }, '修改');
                        functionList.push(edit);
                        var show = h('Button', {
                            props : {
                                type : 'primary',
                                size : 'small',
                            },
                            style : {
                                marginRight : '8px'
                            },
                            on : {
                                click : function() {
                                    vm.show(params.row.bpmnImage);
                                }
                            }
                        }, '查看');
                        functionList.push(show);
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
                        var upload = h('Button', {
                            props : {
                                type : 'primary',
                                size : 'small',
                            },
                            style : {
                                marginRight : '8px'
                            },
                            on : {
                                click : function() {
                                    vm.upload(params.row.id);
                                }
                            }
                        }, '附件上传');
                        functionList.push(upload);
                        return h('div',{

                        }, functionList);
                    }
                }],
            bpmnData:[],
            bpmn : {
                pageSize : 10,
                pageNo : 1,
                content :''
            },
            tableSize : 50,
        },
        methods: {
            load:function(){
                $.SetForm({
                    url :  "/bpmn/list",
                    //param : this.bpmn,
                    success : function(response) {
                        vm.tableSize = response.data.total;
                        vm.bpmnData = response.data.list;
                    }
                });
            },
            changePage:function(){

            },
            changePageSize:function(){

            },
            add:function(){
                $('.sidebar-menu', parent.document).find("li[data-src='bpmn/add.shtml']").trigger("click");
            },
            edit:function(model){
                bpmn.LocalStorage.set({
                    key : "bpmnId",
                    value : model.id,
                });
                bpmn.LocalStorage.set({
                    key : "bpmnName",
                    value : model.modelName,
                });
                var  objs = parent.document.getElementsByTagName("iframe");
                $(objs).attr("src", "bpmn/add.shtml");
                window.parent.location.hash = "bpmn/add.shtml";
            },
            show:function(bpmnImage){
                dialogOpen({
                    title: '流程图',
                    content : "<img  style='width: auto;height: auto; max-width: 100%; max-height: 100%;' src="+bpmnImage+"  > ",
                    scroll : true,
                    width: '90%',
                    height: '90%',
                    btn:[],
                    yes : function(iframeId) {

                    },
                });
            },
            remove:function(id){
                top.layer.confirm('确认要删除吗？', {
                    btn: ['确认','取消'] //按钮
                }, function(){
                    $.SetForm({
                        url :  "/bpmn/remove",
                        param : {id:id},
                        json:true,
                        success : function(result) {
                            vm.load();
                        }
                    });
                });
            },
            upload: function(){
                dialogOpen({
                    title: "上传附件",
                    url: "bpmn/upload.shtml",
                    scroll : true,
                    width:  "80%",
                    height:  "80%",
                    yes : function(iframeId) {
                        //top.frames[iframeId].vm.acceptClick();
                    },
                });
            }
        },
        created: function(){
            this.load();
        }
    });
});