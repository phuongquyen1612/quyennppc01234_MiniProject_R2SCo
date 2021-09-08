app.controller("prod-ctrl", function ($scope, $http) {
    let host = "http://localhost:8080/quyenshop/admin"
    $scope.form = {}
    $scope.products = {}
    $scope.categories = {}
    $scope.pdids = {}
    $scope.loaddata = function () {
        var url = `${host}/pd`
        $http.get(url).then(resp => {
            $scope.products = resp.data
            console.log("load success", resp)
        }).catch(error => {
            console.log("Error", error)
        })

        var urlCat = `${host}/ctgry`
        $http.get(urlCat).then(respCat => {
            $scope.categories = respCat.data;
            $scope.form.ctgid = respCat.data[0].categoryid.toString();
            console.log("load success", respCat)
        }).catch(error => {
            console.log("Error", error)
        })

        var urlPro = `${host}/pd`
        $http.get(urlPro).then(respPro => {
            $scope.pdids = respPro.data;
            $scope.form.productid = respPro.data[0].productid;
            console.log("load success", respPro)
        }).catch(error => {
            console.log("Error", error)
        })
    }

    $scope.edit = function (key) {
        var item = angular.copy($scope.form)
        var url = `${host}/pd/${key}`
        $http.get(url, item).then(resp => {
            $scope.form = resp.data
            let check = $scope.categories.filter(cat => cat.categoryid === resp.data.ctgid)
            console.log($scope.form.ctgid)
            $scope.form.ctgid = $scope.form.ctgid.toString();
            $scope.form.productid = resp.data.productid
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
        var url = `${host}/pd`
        var item = angular.copy($scope.form)
        item.newprice = $scope.form.price - ($scope.form.price * ($scope.form.sale / 100));
        $http.post(url, item).then(resp => {
            $scope.products.push(item)
            console.log("Insert success", resp)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)
        })
    }

    $scope.update = function () {
        var item = angular.copy($scope.form);
        item.newprice = $scope.form.price - ($scope.form.price * ($scope.form.sale / 100));
        var url = `${host}/pd/${item.productid}`
        $http.put(url, item).then(resp => {
            var index = $scope.products.findIndex(item => item.productid == $scope.form.productid)
            $scope.products[index] = resp.data
            console.log("Update success", resp)
        }).catch(error => {
            console.log("Error", error)
        })
    }

    $scope.delete = function () {
        var item = angular.copy($scope.form)
        var url = `${host}/pd/${item.productid}`
        $http.delete(url, item).then(resp => {
            var index = $scope.products.findIndex(item => item.productid == $scope.form.productid)
            $scope.products.splice(index, 1)
            console.log("Delete success", resp)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)

        })

    }

    $scope.loaddata();

    var urlimage = `http://localhost:8080/rest/files/images`;
    $scope.url = function (filename) {
        return `${urlimage}/${filename}`;
    }

    $scope.list = function () {
        $http.get(urlimage).then(resp => {
            $scope.filenames = resp.data;
        }).catch(error => {
            console.log("Errors", error);
        });
    }

    $scope.upload = function (files) {
        var form = new FormData();
        for (var i = 0; i < files.length; i++) {
            form.append("files", files[i]);
        }

        $http.post(urlimage, form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.filenames.push(...resp.data);
            $scope.form.image = resp.data.join();
        }).catch(error => {
            console.log("Errors", error);
        });

    };

    $scope.deleteimage = function (filename) {
        $http.delete(`${urlimage}/${filename}`).then(resp => {
            let i = $scope.filenames.findIndex(name => name == filename);
            $scope.filenames.splice(i, 1);
        }).catch(error => {
            console.log("Errors", error);
        });
    }

    $scope.list();
});