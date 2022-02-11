# SpringBoot-API

REST API based on Java Spring Boot.

## Prerequisites

* JDK 1.8
* Maven 3.x


## How to Run 

## Features
 
## Endpoints
View the Swagger UI open your browser to here:
```
http://localhost:8080/swagger-ui/
```

### Transmitter configuration 
Retrieve transmitter Configuration information. 
```
curl --location --request GET 'http://localhost:8080/well-known/sse-configuration'
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
curl --location --request POST 'http://localhost:8080/sse/stream' \
--header 'Content-Type: application/json' \
--data-raw '{
  "iss": "https://tr.example.com",
  "aud": [
    "http://receiver.example.com/web",
    "http://receiver.example.com/mobile"
  ],
  "delivery": [
      "https://schemas.openid.net/secevent/risc/delivery-method/push",
      "https://schemas.openid.net/secevent/risc/delivery-method/push"
  ],
  "events_requested": [
    "urn:example:secevent:events:type_100",
    "urn:example:secevent:events:type_3",
    "urn:example:secevent:events:type_4"
  ]
}'
```

#### Status Endpoint 
Receivers can read stream status, update steam status.
```
curl -X GET 'http://localhost:8080/sse/status'
```
```
curl --location --request POST 'http://localhost:8080/sse/status' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status": "enabled"
}'
```

#### Add Subject Endpoint
```
curl --location --request POST 'http://localhost:8080/sse/subjects:add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "format":"email",
    "email":"tom@gmail.com"
}'
```
#### Remove Subject Endpoint
```
curl --location --request POST 'http://localhost:8080/sse/subjects:remove' \
--header 'Content-Type: application/json' \
--data-raw '{
    "format":"email",
    "email":"afffv@gmail.com"
}'
```

#### Verification Endpoint 
Sends verification Event over the Event Stream to check whether the stream is working properly.
```
curl --location --request POST 'http://localhost:8080/sse/verify'
```


