# Email Microservice
## Uber Backend Challenge

The challenge is describe on `coding_challenge.mb` file



![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

## :rocket: Technologies used

* [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [AWS Simple Email Service](https://aws.amazon.com/pt/ses/)


## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

2. Install dependencies with Maven

3. Update `application.properties` puting your AWS Credentials

```yaml
aws.region={REGION}
aws.accessKeyId={ACCESS_KEY_ID}
aws.secretKey={SECRET_KEY}
```
## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints
The API provides the following endpoints:

**GET EMAIL**
```markdown
POST /api/email/send - Send a e-mail from your sender to the destination
```

**BODY**
```json
{
  "to": "your_email",
  "subject": "test",
  "body": "test"
}
```

