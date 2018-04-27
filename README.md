
mvn clean install

Run MySQL using Docker

docker pull mysql/mysql-server:5.6

docker run --name=mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -d mysql/mysql-server:5.6

docker ps

