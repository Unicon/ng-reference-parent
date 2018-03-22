



function getParameterByName(name) {
    var match = RegExp('[#&]' + name + '=([^&]*)').exec(window.location.hash);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}

function getAccessToken() {
    return getParameterByName('access_token');
}

function getIdToken() {
    return getParameterByName('id_token');
}