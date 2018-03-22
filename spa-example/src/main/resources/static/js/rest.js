function getUser() {

    jQuery.ajax({
        type: "GET",
        url: "http://localhost:8081/user/parker",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, status, jqXHR) {
            // $('.first-name').append(data.firstName);
            // $('.last-name').append(data.lastName);
        },

        error: function (jqXHR, status) {
            // error handler
        }
    )};
}

