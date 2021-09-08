app.controller("authority-ctrl", function($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];
    $scope.initialize = function() {
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
            console.log("Load Role Success", resp)
        })

        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
            console.log("Load Admin", resp)
        })

        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
            console.log("Load Authorities Success", resp)
        }).catch(err => {
            $location.path("/unauthorized");
        })

    }
    $scope.authority_of = function(acc, role) {
        if ($scope.authorities) {
            return $scope.authorities.find(ur => ur.user.username == acc.username && ur.role.roleid == role.roleid);
        }
    }

    $scope.authority_changed = function(acc, role) {
        var authority = $scope.authority_of(acc, role);
        if (authority) {
            $scope.revoke_authority(authority);
        } else {
            authority = { user: acc, role: role };
            console.log("Authorities", authority);
            $scope.grant_authority(authority);
        }
    }

    $scope.grant_authority = function(authority) {
        authority.roleid = authority.role.roleid;
        authority.username = authority.user.username;
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data);
        }).catch(err => {
            console.log("Err", err);
        })
    }

    $scope.revoke_authority = function(authority) {
       
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
        }).catch(err => {
            console.log("Err", err);
        })
    }

    $scope.initialize();
});