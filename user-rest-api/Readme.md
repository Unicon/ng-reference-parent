
https://spring.io/guides/gs/accessing-data-rest/
https://spring.io/guides/gs/accessing-data-rest/

curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"last_name\" : \"Baggins\" }" http://localhost:8447/user

curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8447/user



curl -i http://localhost:8447/user