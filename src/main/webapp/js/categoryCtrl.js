/**
 * Created by Administrator on 2016/12/5.
 */
myApp.controller('CategoryCtrl', function ($scope,uuid2,toAllMsg, datasource) {
    console.log('CategoryCtrl ini');
    // 是否是编辑状态
    $scope.editting = false;
    // 类目数据
    $scope.categorys = datasource.allCategory();
    // 编辑类目
    $scope.category = {
        name:'',
        curr:null,
        ini:function(o){
            this.curr = o;
            if(angular.isUndefined(o)){
                this.name = '';
            }else{
                this.name =o.name;
            }
        },
        // 添加或修改类目
        save:function(){
            if(angular.isUndefined(this.curr)){
                // 添加类目
                $scope.categorys.push({
                    id: uuid2.newuuid(),
                    name:this.name,
                    categorys:[]
                });
            }else{
                // 修改类目
                this.curr.name = this.name;
            }
        },
        // 删除类目
        del:function(o){
            $scope.categorys.remove(o);
        }
    };
    // 编辑子类目
    $scope.subCategory = {
        name:'',
        parent:null,
        currParent:null,
        curr:null,
        ini:function(p,o){
            this.parent = p;
            this.curr = o;
            this.currParent = p;
            if(angular.isUndefined(o)){
                this.name = '';
            }else{
                this.name =o.name;
            }
        },
        // 添加或修改类目
        save:function(){
            if(angular.isUndefined(this.curr)){
                // 添加类目
                this.currParent.categorys.push({
                    id: uuid2.newuuid(),
                    name:this.name,
                });
            }else{
                // 修改类目
                this.curr.name = this.name;
                if(this.currParent != parent){
                    this.parent.categorys.remove(this.curr);
                    this.currParent.categorys.push(this.curr);
                }
            }
        },
        // 删除类目
        del:function(o){
            this.currParent.categorys.remove(o);
        }
    };
    // 选择某个子类目
    $scope.onCategoryselected = function(o){
        console.log('selected category:'+ o.name);
        toAllMsg.send(o,"changeCategory");
    };
});