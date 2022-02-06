# SpringBoot-API

REST API based on Java Spring, Spring Boot.

## Prerequisites

* JDK 1.8
* Maven 3.x


## How to Run 

## Features

## Endpoints

### Transmitter configuration 
Retrieve transmitter Configuration information. 
```
curl --location --request GET 'http://localhost:8080/sse/stream'
```

### Management API

#### Configuration Endpoint 
Receivers can read, update and delete stream configuration. 
```
curl --location --request GET 'http://localhost:8080/well-known/sse-configuration'
```
```
curl --location --request DELETE 'http://localhost:8080/sse/stream'
```
```
curl --location --request POST 'http://localhost:8080/sse/stream'
```

#### Status Endpoint 
Receivers can read stream status, update steam status.
```
curl -X GET 'http://localhost:8080/sse/status'
```
```
curl -X POST 'http://localhost:8080/sse/status'
```

#### Add Subject Endpoint
```
curl --location --request POST 'http://localhost:8080/sse/subjects:add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "format":"email",
    "email":"randie@gmail.com"
}'
```
#### Remove Subject Endpoint

#### Verification Endpoint 
Sends verification Event over the Event Stream to check whether the stream is working properly.
```
curl --location --request POST 'http://localhost:8080/sse/verify'
```


