var identityServer = "https://localhost:8443/cas/oidc/authorize";
var scope = "openid";
var audience = "ref:webclient";
var responseType = "id_token%20token";
var clientId = "reference_client";
var redirectUri = "https://localhost:8445/callback.html";
var nonce = "123456";


function buildLoginLink() {
    return identityServer + "?scope=" + scope
        + "&audience=" + audience
        + "&response_type=" + responseType
        + "&client_id=" + clientId
        + "&redirect_uri=" + redirectUri
        + "&nonce=" + nonce;

}

function buildAuth0LoginLink() {
    var auth0IdentityServer = "https://parkerneff.auth0.com/authorize";
    var auth0Scope = "read:alljokes%20contacts";
    var auth0Audience = "http://chucknorrisworld.com";
    var auth0ResponseType = "id_token%20token";
    var auth0ClientId = "jn0fyjN7sL0hU2nK27Rqy4Fk0JyTnl3D";

    return auth0IdentityServer + "?scope=" + auth0Scope
        + "&audience=" + auth0Audience
        + "&response_type=" + auth0ResponseType
        + "&client_id=" + auth0ClientId
        + "&redirect_uri=" + redirectUri
        + "&nonce=" + nonce;

}


