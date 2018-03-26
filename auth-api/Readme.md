## Docker Instructions
docker run  --rm -d --name auth-api -p 8444:8444 -t wpng/auth-api:latest



curl -i http://localhost:8444/user


curl -k -i -X POST -H "Content-Type:application/json" -d "{  \"login_name\" : \"jsmith\",  \"password\" : \"mypassword\" }" https://localhost:8444/auth
