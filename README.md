<h2 align="center">
  Desafio Backend: Encurtador de URL
</h2>

Resolução do desafio proposto pelo repositorio Backend Brasil, confira detalhes [neste link](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md).

## :rocket: Tecnologias utilizadas

* Java
* Spring Boot
* Spring Data MongoDB
* Docker
* MongoDB

:mag: Baixe o projeto e teste você mesmo na prática.

## How to run

- Clone repository

- Build **MongoDB** image on Docker

```
docker-compose build -d
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

Application will be running  `http://localhost:8080/`


## Endpoints 

The REST API app is described below.


---
### Create short Url 
`POST /shortener/`

### request
body: 
```json
{
	"url":"https://www.google.com"
}
```

### response
```
{
	"url": "http://localhost:8080/84mQnp"
}
```
---

### Redired short Url 
`POST /urls/`

### request
```
curl http://localhost:8080/urls
```
### response
```
[
	{
		"id": "84mQnp",
		"fullUrl": "https://www.google.com",
		"expiresAt": "2024-06-22T14:30:52.782"
	},
]
```

---
### Redired short Url 

`GET /{id}`

### request
```
http://localhost:8080/<id>
```

### response
`Redirect to site`



