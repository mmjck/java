<center>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

<h2 align="center">
  <img  height="100" alt="spring boot"  src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png">
</h2>
</center>



- [Spring boot]()
- [H2]()
- [Java 17]()


## How to run

- Clone this repository
```bash
git clone https://github.com/mmjck/java.git
```

- Enter in directory application

```
cd ms/
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`
 

### Requests

`POST /players`

```json
{
	"name": "Test",
	"email": "random@email.com",
	"phone": "92996991122",
	"groupType": "AVENGERS"
}
```


`GET /players`


```json
{
	"total": 1,
	"data": [
		{
			"id": 1,
			"codiname": "Hulk",
			"name": "Test",
			"email": "Antoinette1@example.org",
			"phone": "92996991122",
			"groupType": "AVENGERS"
		},
  ]
}
```


