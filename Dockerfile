FROM tomcat:8.5.15-jre8

FROM mysql:5.6

# Setup the custom configuration
ADD mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf

MAINTAINER Ravi Kumar Balla <ravikumar2026@gmail.com>

ADD target/springBoot-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]

EXPOSE 8080

