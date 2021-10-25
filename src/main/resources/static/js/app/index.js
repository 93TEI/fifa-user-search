var main = {
    init : function () {

        var _this = this;
        $('#btn-user-info').on('click', function () {
            console.log("Test")
            _this.search_user_info();
        });
    },

    search_user_info : function () {
        var nickname = $('#nickname').val();

        $.ajax({
            type: 'GET',
            url: '/api/v1/user/'+nickname,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (res) {
            alert(JSON.stringify(res));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();