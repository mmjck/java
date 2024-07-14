<h3 align="center">
  Desafio Backend do BTG Pactual
</h3>

This project was developed by according  hexagonal architecture 


<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">

</p>



## :rocket: Tecnologias utilizadas

* [Java 21](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Spring Boot](https://spring.io/projects/spring-boot)


* [RabbitMQ](https://www.rabbitmq.com/)
* [MongoDB]()
* [Docker](https://docs.docker.com/engine/install/)



## How to run

- Clone this repository

- Build **Mongo** and **RabbitMQ** image on Docker

```
docker-compose build -d
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

Application will be running  `http://localhost:8080/` ✅   
 

## Endpoints 

The REST API app is described below.
 

---
### Create order
To create an order, you need acces que dashboard and publih new message with payload bellow:

```json
   {
       "codigoPedido": 1001,
       "codigoCliente": 1,
       "itens": [
           {
               "produto": "lápis",
               "quantidade": 100,
               "preco": 1.10
           },
           {
               "produto": "caderno",
               "quantidade": 10,
               "preco": 1.00
           }
       ]
   }
```


`GET customer/{cystiner_id}/orders`


example

```
curl  http://customer/1/orders`
```

Response
```json
{
	"summary": {
		"total_orders": 120.00
	},
	"data": [
		{
			"orderId": 1001,
			"customerId": 100,
			"total": 120.00
		}
	],
	"pagination": {
		"page": 0,
		"pageSize": 10,
		"totalElements": 1,
		"totalPages": 1
	}
}
```