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

angular.element(document).ready(function () {
    angular.bootstrap(document, ['myApp']);
});