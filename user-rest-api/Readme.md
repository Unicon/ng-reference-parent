
https://spring.io/guides/gs/accessing-data-rest/
https://spring.io/guides/gs/accessing-data-rest/



docker run --name wpng-mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_USER=wpnguser -e MYSQL_PASSWORD=secret -e MYSQL_DATABASE=wpng -d -p 3306:3306 mysql:5


curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"last_name\" : \"Baggins\" }" http://localhost:8447/user

curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8447/user



curl -i http://localhost:8447/user