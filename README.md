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


* [AWS Lambda]()
* [SQS]()
* [S3]()
* [MongoDB]()
* [Docker](https://docs.docker.com/engine/install/)



**Config Values**

```yaml
aws.region=${REGION}
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}
```


## How to run

- Clone this repository
```bash
git clone https://github.com/mmjck/java.git
```

- Build **MongoDB** and image on Docker


```
cd anota-ai/local 
docker-compose build -d
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`
 

**API PRODUCT**

```markdown
POST /api/product - Create a new product
GET /api/product - Retrieve all products
PUT /api/product/{id} - Updates a product
DELETE /api/product/{id} - Delete a product
```
 
**BODY**
```json
{
  "title": "Produto para postar no tópico",
  "description": "",
  "ownerId": "4444444",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 10000
}
```

**API CATEGORY**
```markdown
POST /api/category - Create a new category
GET /api/category - Retrieve all categories
PUT /api/category/{id} - Updates a category
DELETE /api/category/{id} - Delete a category
```

**BODY**
```json
{
  "id": "393948882828",
  "title": "Teste",
  "description": "",
  "ownerId": "4444444"
}
```