## Building Microservice using Spring Cloud/NetFlix OSS

> This Repo contains **five microservices** named as -

* Config Service (A service which contains all microservices configuration)
* Gateway Service (A service which handles all customer endpoints)
* Eureka Service (A service which is used to discover other microservices)
* Product Service (A simple microservice)
* Product Count Service (A simple microservice)

---
To run these services, please follow below order
> Config Service
``` bash
  Config service runs on port 8888
  mvn spring-boot:run
```

> Product Service
``` bash
  Product service runs on port 8081
  mvn spring-boot:run
```

> Product Count Service
``` bash
  Product Count service runs on port 8082
  mvn spring-boot:run
```

> Eureka Service
``` bash
  Eureka service runs on port 9090
  mvn spring-boot:run
```
> Gateway Service
``` bash
  Gateway service runs on port 8080
  mvn spring-boot:run
```
---
> Microservices Configuration 

| Service Name     | URL          |
| -------- | -------------- |
| Gateway service | http:localhost:8080/ |
| Eureka service | http:localhost:9090/ |
| Product service | http:localhost:8081/ |
| Product Count service | http:localhost:8082/ |
| Config service | http:localhost:8888/ |

---
> Finally, to user, only one end point will be exposed as below
```` bash
    Gateway Service access http://localhost:8080/
````
```` bash
    To access Product Service, use http://localhost:8080/productservice/products/
````
```` bash
    To access Product Count Service, use http://localhost:8080/productcountservice/productcount/
````



