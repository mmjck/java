<h1 align="center">
  Messaging Spring Boot
</h1>

System to introduce the messaging concept presented [in this video](https://youtu.be/97TF2xZgAhU) using Spring Boot and Kafka.

## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring for Kafka](https://docs.spring.io/spring-kafka/reference/html/)
- [Kafka](https://kafka.apache.org)
- [Docker Compose](https://docs.docker.com/compose/)

## How to run

- Run Kafka with Docker Compose:
```
$ docker-compose up
```

- Add in /etc/hosts the hostname `kafka`.
- Clonar repositório git
- Build project
```
$ ./mvnw clean package
```
- Run application:
```
$ java -jar target/messaging-springboot-0.0.1-SNAPSHOT.jar
```

- Send a "hello"
```
$ http :8080/kafka/hello/dev

HTTP/1.1 200
Connection: keep-alive
Content-Length: 2
Content-Type: text/plain;charset=UTF-8
Date: Wed, 18 May 2024 16:21:05 GMT
Keep-Alive: timeout=60

OK
```

- View message received in the log:
```
Consumer Message: Hello, dev
```