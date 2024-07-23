# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

## :rocket: Technologies used

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [h2]()


## How to run

1. Clone the repository:

2. Install dependencies with Maven


```bash
./mvnw spring-boot:run
```

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080




The API will be accessible at `http://localhost:8080`
 

---
**GET ME**

`GET api/v1/me`  
Return user details using. token You need pass **token authorization** in header


```json
{
	"id": "42",
	"email": "Erin",
	"name": "maria1@gmail.com"
}
```

**POST AUTH**

`POST api/auth/register` - Register a new user 

```json
{
  "email":"test@gmail.com",
  "password": "test123",
  "name": "Example name"
}
```


**POST LOGIN**

`POST api/auth/login` - Register a new user 

```json
{
  "email":"test@gmail.com",
  "password": "test123",
}
```