app.controller("users-ctrl", function ($scope, $http) {
    let host = "http://localhost:8080/quyenshop/admin/users"
    $scope.form = {}
    $scope.users = []
    $scope.form.activated = false;
    $scope.loaddata = function () {
        var url = `${host}`
        $http.get(url).then(resp => {
            $scope.users = resp.data
            console.log("Load user", resp)
        }).catch(error => {
            console.log("Error", error)
        })

    }

    $scope.edit = function (key) {

        var url = `${host}/${key}`
        $http.get(url).then(resp => {
            $scope.form = resp.data
            $scope.form.username = resp.data.username
            console.log("Edit success", resp)
        }).catch(error => {
            console.log("Error", error)
        })

    }

    $scope.reset = function () {
        $scope.form = {}
        $scope.loaddata();
    }

    $scope.insert = function () {
        var url = `${host}`
        var item = angular.copy($scope.form)
        $http.post(url, item).then(resp => {
            $scope.users.push(item)
            console.log("Insert success", resp)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)
        })
    }

    $scope.update = function () {
        var item = angular.copy($scope.form);

        var url = `${host}/${item.username}`
        $http.put(url, item).then(resp => {
            var index = $scope.users.findIndex(item => item.username == $scope.form.username)
            $scope.users[index] = resp.data
            console.log("Update success", resp)
        }).catch(error => {
            console.log("Error", error)
        })
    }

    $scope.delete = function () {
        var item = angular.copy($scope.form)
        var url = `${host}/${item.username}`
        $http.delete(url, item).then(resp => {
            var index = $scope.users.findIndex(item => item.username == $scope.form.username)
            $scope.users.splice(index, 1)
            console.log("Delete success", resp)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)

        })

    }

    $scope.loaddata();

});