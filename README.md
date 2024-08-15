<center>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

<h2 align="center">
  <img  height="100" alt="spring boot"  src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png">
</h2>
</center>


This project is as service built following the constraints described on challenges repo from [backend-br](https://github.com/backend-br), you can check it out [here](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)


The challenge proposes that we built a web API tha will receive a POST request with an costumer data we should follow some rules to decie wich type of loan this costumer has access to.

- [Spring boot]()
- [Java 17]()


## How to run

- Clone this repository
```bash
git clone https://github.com/mmjck/java.git
```

- Enter in directory application

```
cd loans/
```

- Run application with **Maven**

```
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`
 


### example payload request

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "AM"
}
```

### example payload response

```json
{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```
