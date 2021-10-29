var main = {
    init : function () {

        var _this = this;
        $('#btn-user-info').on('click', function () {
            _this.search_user_info();
        });
    },

    search_user_info : function () {
        var nickname = $('#nickname').val();

        $.ajax({
            type: 'GET',
            url: '/api/v1/user/'+nickname,
            dataType: 'text',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            window.location.href = '/user/info/'+nickname;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();