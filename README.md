# Web Service?
- 3 keys:
    - talk machine to machine or application to application
    - platform independent (should be ale to talk to an application built in any language)
    - Can communicate over network

# How we service works?
- Application sends REQUEST webs service RESPONSES
- Request and Response also platform independent: XML/JSON

# Service Definition
- Every web service provides service definition
- It contains:
    - Request/Response format: XML/JSON
    - Request Structure
    - Response Structure
    - Endpoint

# Service Provider, Service Consumer
- Provider: Provides service (web service)
- Consumer: Consumes service (Application)

# Transport
- How the service is called:
    - HTTP: Is the service exposed over internet
    - MQ: Is the service exposed over a queue

# SOAP
- XML as request/response exchange format
- Contents:
    - Envelope: container
        - Header: Meta info: authentication, authorization, Signature etc
        - Body: Real content
- Transport
    - MQ/HTTP
- Service Definition
    - Web service definition language (WSDL)
        - endpoint
        - All Operations
        - Request Structure
        - Response structure

# REST
- representational state transfer
- Key: Best use of HTTP
- Resource:
    - Abstraction of HTTP
    - A resource is what a webservice wants to expose to outside world
    - Assign URI to the resource
        - /posts: all posts
        - /posts/post/1: Post with id 1
- No restriction on exchange format
- HTTP transport only
- No specific service standard: WADL/Swagger etc

# Spring boot initializer
- use site: [spring](https://start.spring.io)
- Dependencies:
    - Spring Web: apache tomcat etc
    - JPA: JPA and hibernate to persist data
    - H2: Small DB, later use of MySQL
    - DevTools: Live reload


..............................................................................................................................

# Hello World
- make a sub package under main package in src/main/java/com.in28minutes.rest.webservices.resfulwebservices.helloworld
- Create a controller java class HelloWorldController
- The path to access: http://localhost:8080/hello-world