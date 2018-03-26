docker run --name wpng-mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_USER=wpnguser -e MYSQL_PASSWORD=secret -e MYSQL_DATABASE=wpng -d -p 3306:3306 mysql:5
