const app = angular.module("app", []);
app.controller("cart-ctrl", function($http, $scope, $location) {

    $scope.quantity = 1;

    $scope.plus = function() {

        // Get the field name
        var quantity = $scope.quantity;

        // If is not undefined

        $scope.quantity += 1;
        // Increment
    }
    $scope.minus = function() {

        // Get the field name
        var quantity = $scope.quantity;

        // If is not undefined

        // Increment
        if (quantity > 1) {
            $scope.quantity -= 1;
        }

    }





    $scope.form = {};
    $scope.hoahon = {};


    $scope.cart = {
        items: [],
        add(id) {
            
            let quantity = document.getElementById('qtycart').value;
            var item = this.items.find(item => item.productid === id);
            if (item) {
                item.qty += $scope.quantity;
                this.saveToLocalStorage();
            } else {

                $http.get(`/quyenshop/customer/product/${id}`).then(response => {
                    
                    if (response.data.sale != 0) {
                        var sale = ((response.data.price) * (response.data.sale)) / 100;
                        var price = (response.data.price) - (sale);
                        response.data.price = price;
                        response.data.qty = $scope.quantity;
                       
                        this.items.push(response.data);
                        this.saveToLocalStorage();
                        console.log(response);
                    } else if (response.data.sale == 0) {
                        response.data.qty = $scope.quantity;
                        
                        this.items.push(response.data);
                        this.saveToLocalStorage();
                        console.log(response);
                    }


                })
            }


        },
        remove(id) {
            var index = this.items.findIndex(item => item.productid == id);
            this.items.splice(index, 1);
            // console.log(items);
            this.saveToLocalStorage();

        },
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        amt_of(items) {},
        get count() {
            return this.items.map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() {
            return this.items.map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("carts", json);
        },
        loadFromLocalStorage() {
            var json = localStorage.getItem("carts");
            this.items = json ? JSON.parse(json) : [];
        }

    }

    $scope.cart.loadFromLocalStorage();
    $scope.order = {
        username: $("#username").text(),
        total: $scope.cart.amount,
        get orderDetail() {
            return $scope.cart.items.map(item => {
                return {
                    prodid: item.productid,
                    productname: item.productname,
                    price: item.price,
                    qty: item.qty


                }
            });
        },
        order() {

            var order = angular.copy(this);
            order.address = $scope.address;
            order.phone = $scope.phone;
            order.fullname = $scope.fullname;
            order.total = $scope.cart.amount;

            var url = "http://localhost:8080/quyenshop/customer/ord-cpl";
            $http.post(url, order).then(response => {

                console.log("Thêm thành công", response);
                $scope.cart.clear();
                location.href = "/quyenshop/customer/order-complete";
            })

        }



    }
    console.log($scope.cart.amount)
})