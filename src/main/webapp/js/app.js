var myApp = angular.module('myApp', ['treeControl', 'angularUUID2', 'ngStorage']);
/* 用于全局广博 */
myApp.factory('toAllMsg', function ($rootScope) {
    return {
        send: function (msg, key) {
            $rootScope.$emit('to-all-15875-' + key, msg);
        },
        receive: function (fun, key) {
            $rootScope.$on('to-all-15875-' + key, function (d, data) {
                fun(d, data);
            });
        }
    };
});
// 数据访问
myApp.factory('datasource', function ($http) {
    let dataVar;

    function getData() {
        if (angular.isUndefined(dataVar)) {
            $.ajax({
                url : 'js/data.json',
                async: false,
                dataType:'json',
                success: function (result) {
                    console.log(result);
                    dataVar = result;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("error"+errorThrown);
                }
            });
            console.log(dataVar);
        }
    }

    return {
        // 获得所有类目
        allCategory: function () {
            getData();
            return dataVar.categorys;
        }
    };
});
// 启动angular
angular.element(document).ready(function () {
    angular.bootstrap(document, ['myApp']);
});
// 删除数组中某个元素
Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};