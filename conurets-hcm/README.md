# Conure HCM

## Prerequisites:
* JDK 1.8 
* Maven 3.*
* Postgres 9.6.*

## Install and run the project
1. Download/clone the project.
2. Build the project using following maven command from project root folder where pom.xml file place.
    * `mvn clean package`
3. Run (docker-compose up -d) for deploying the services on docker.
    * `docker-compose up -d --build`
4. Let's authentication and get JWT token
    ``` 
    curl -X POST http://localhost:9071/hcm/api/authenticate -H 'Content-Type: application/json' -d '{ "origin": "WEB", "emailAddress": "superadmin@conurets.com", "password": "superadmin" }' 
    ```
   You will get following format Json response. data field has the JWT token. It requires for authorization to call rest api.
    ```
    {
        "code": 0,
        "value": "success",
        "data": {
            "token": ""
        }
    }       
    ```

> **Note:** Dockerfile and docker-compose.yml files are in project root directory.

## Swagger
* [Swagger Docs](http://localhost:9071/hcm/v3/api-docs)
* [Swagger Index](http://localhost:9071/hcm/swagger-ui/index.html)
* [Swagger API Docs](http://localhost:9071/hcm/swagger-ui/index.html?configUrl=/hcm/v3/api-docs/swagger-config)
