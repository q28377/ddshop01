
var ddshop = {
    //点击左侧导航树上的节点，添加选项卡
    registerMenuEvent:function(){
        //alert("zzzz");
        //约定大于配置：jquery对象前面加上$,如果是DOM对象不需要加$
        var $tree = $('#menu .easyui-tree');
        //将当前树打印到控制台
        //console.log($tree);
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
//                debugger;
                //判断选项卡是否重复打开了
                if($('#tab').tabs('exists',text)){
                    //alert(123);
                    $('#tab').tabs('select',text);//选中并刷新
                }else{
                    $('#tab').tabs('add',{
                        title: text,
                        href: href,
                        closable:true
                    });
                }
            }
        });
    }

};



