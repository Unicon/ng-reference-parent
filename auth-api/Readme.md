## Docker Instructions
docker run  --rm -d --name auth-api -p 8444:8444 -t wpng/auth-api:latest


curl 'https://localhost:8444/actuator/health' -i -k