function addToCart(it_id){
            $.ajax({
            	type: "POST",
                url: '<c:url value="/add_to_cart.do"></c:url>',
                data: {
                    id:it_id
                },
                success: function (msg){
                    alert("Продукт добавлен в корзину");
                }
            });
}