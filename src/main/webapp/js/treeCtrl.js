/**
 * Created by luzi on 2016/9/4.
 */
myApp.controller('TreeCtrl', function ($scope, $http, $sessionStorage, uuid2, toAllMsg) {
    /* 装载数据 */
    $scope.dataForTheTree = [
        { "title": "我的工程", "id": "0", "children": [], states: [] }
    ];
    if (angular.isUndefined($sessionStorage.datas_85422)) {
//        $http({method: 'GET', url: 'js/data.json'}).
//            success(function (data, status, headers, config) {
//                console.log(data);
//                $scope.stateObjects = data;
//                // when the response is available
//            });
    } else {
        $scope.dataForTheTree = angular.copy($sessionStorage.datas_85422);
    }

    /*保存数据*/
    toAllMsg.receive(function (d, data) {
        $sessionStorage.datas_85422 = angular.copy($scope.dataForTheTree);
        console.log($sessionStorage.datas_85422 );
    }, "save");

    function rmNode(nodeId, node) {
        for (var i = 0; i < node.children.length; i++) {
            if (node.children[i].id == nodeId) {
                node.children.splice(i, 1);
                return true;
            }
        }
        for (var i = 0; i < node.children.length; i++) {
            if (rmNode(nodeId, node.children[i])) {
                return true;
            }
        }
    }

    $scope.showSelected = function (sel) {
        console.log("selected " + sel.states);
        toAllMsg.send(sel.states, "changeStates");
        /* all data */
        toAllMsg.send($scope.dataForTheTree, "changeData");
    };
    $scope.addChildNode = function (node) {
        node.children.push({ "title": node.title + "副本", "id": uuid2.newuuid(), "children": [], states: []});
    };
    $scope.removeNode = function (node) {
        rmNode(node.id, $scope.dataForTheTree[0]);
    };

    /*初始*/
    $scope.showSelected($scope.dataForTheTree [0]);
});
