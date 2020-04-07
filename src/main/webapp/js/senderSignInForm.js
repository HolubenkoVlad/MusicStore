function send() {
      var loginForm   = $('#form').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/login.do"></c:url>',
                data: loginForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                    if (obj.status) {
                        window.location.href = '<c:url value="/'+obj.message+'.jsp"></c:url>';                  
                    } else {
                        alert(obj.message);
                    }
                }
            });
}