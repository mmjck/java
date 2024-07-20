<h3 align="center">
   Backend Challenge PicPay
</h3>


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

## :rocket: Technologies used

* [Java 21](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [h2]()
* [Docker](https://docs.docker.com/engine/install/)
* [KafKa](https://docs.docker.com/engine/install/)


## How to run

- Clone this repository

- Build **Kafka** and image on Docker

```
docker-compose build -d
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`
 

**API transactions**

```markdown
POST /transactions - Create transactions 

{
	"value": "100",
	"payer": "1",
	"payee": "2"
}
```

```markdown
GET /transactions - List all transactions

```
