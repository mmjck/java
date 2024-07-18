<h3 align="center">
   Backend Challenge Anota ai
</h3>


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)


## :rocket: Technologies used

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [PostgreSql]()
* [Docker](https://docs.docker.com/engine/install/)



## How to run

- Clone this repository
```bash
git clone https://github.com/mmjck/java.git
```

- Build **MongoDB** and image on Docker


```
docker-compose build -d
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`
 

**API POSTS**

```markdown
POST /add-post - Save post (View)
GET /posts - Get all posts (View)
GET /add-post - Get form to create post (View)
GET /posts/{id} - Get post by id (View)
```
 