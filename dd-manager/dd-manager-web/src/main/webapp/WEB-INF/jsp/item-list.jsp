<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>
<script>
    //添加工具栏
    var toolbar = [{
        iconCls:'icon-add',
        text:'新增',
        handler:function () {
            console.log('add');
        }
    },{
        iconCls:'icon-remove',
        text:'删除',
        handler:function () {
            //console.log('remove');
            var selections = $('#dg').datagrid('getSelections');
            console.log(selections);//Array Array [ Object, ... ] //每选中一列，就多一个Object
            if(selections.length == 0 ){
                //没有选择记录时
                $.messager.alert('提示','请至少选中一条记录！');
                return;
            }

            //至少选中一条记录时
            //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
            //function(r) 如果用户点击的是"确定"，那么r=true
            $.messager.confirm('确认','您确认要删除记录吗?',function (r) {
                if(r){
                    //用于存放id的集合
                    var ids = [];
                    //遍历选中的记录，将记录的id存放到js数组中
                    for(var i=0;i<selections.length;i++){
                        ids.push(selections[i].id);
                    }
                    //把ids异步提交到后台
                    $.post(
                        //url:请求后台的哪个地址来进行处理，相当于url,String类型
                        'items/batch/3',//删除要吧status改为3
                        //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                        //{'ids[]':ids,'status':status},
                        {'ids[]':ids},
                        //callback:后台处理成功的回调函数，相当于success，function类型
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        //dataType:返回的数据类型，如：json，String类型
                        'json'
                    );
                }
            });
        }
    },{
        iconCls:'icon-edit',
        text:'编辑',
        handler:function () {
            console.log('edit');
        }
    },{
        iconCls:'icon-up',
        text:'上架',
        handler:function () {
            //console.log('up');
            var selections = $('#dg').datagrid('getSelections');
            console.log(selections);//Array Array [ Object, ... ] //每选中一列，就多一个Object
            if(selections.length == 0 ){
                $.messager.alert('提示','请至少选中一条记录！');
                return;
            }
            $.messager.confirm('确认','您确认要上架吗?',function (r) {
                if(r){
                    var ids = [];
                    for(var i=0;i<selections.length;i++){
                        ids.push(selections[i].id);
                    }
                    $.post(
                        'items/batch/1',//上架要吧status改为1
                        {'ids[]':ids},
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    },{
        iconCls:'icon-down',
        text:'下架',
        handler:function () {
            //console.log('down');
            var selections = $('#dg').datagrid('getSelections');
            console.log(selections);//Array Array [ Object, ... ] //每选中一列，就多一个Object
            if(selections.length == 0 ){
                $.messager.alert('提示','请至少选中一条记录！');
                return;
            }
            $.messager.confirm('确认','您确认要下架吗?',function (r) {
                if(r){
                    var ids = [];
                    for(var i=0;i<selections.length;i++){
                        ids.push(selections[i].id);
                    }
                    $.post(
                        'items/batch/2',//下架要吧status改为2
                        {'ids[]':ids},
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    }
    ];

    //初始化数据表格
    $('#dg').datagrid({
        //允许多列排序
        multiSort: true,
        //将工具栏添加到数据表格中
        toolbar: toolbar,

        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        //调用了ItemAction里的action
        url: 'items',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20,50,100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},

            {field: 'id', title: '商品编号', width: 100, sortable: true},//排序上下箭头
            {field: 'title', title: '商品名称', width: 100, sortable: true},

            {field: 'sellPoint', title: '卖点', width: 100},
            //自定义的属性
            {field: 'catName', title: '分类名称', width: 100},
            //后台判断  商品状态
            {field: 'statusName', title: '商品状态(后台)',width: 100},
            //前台判断  商品状态
            {field: 'status', title: '商品状态(前台)',width: 100,formatter:function (value,row,index) {
                console.group();
                console.log(value);
                console.log(row);
                console.log(index);
                console.groupEnd();
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            //{field: 'price', title: '价格', width: 100, align: 'right'},
            {field: 'priceView', title: '价格', width: 100, align: 'right'},
            {field: 'created', title: '创建时间', width: 100,formatter:function (value,row,index) {
                return moment(value).format('LL');
            }},
            //{field: 'updated', title: '修改时间', width: 100}
            {field: 'updatedTime', title: '修改时间', width: 100}

        ]]
    });
</script>