## Quickstart ##

# COMPILE PROJECT #

To compile the application you need to start the command from cmd ".\compile-run.cmd"

# RUN DOCKER ENVIRONMENT WINDOWS #

to run the application it is necessary to open cmd and write these commands:

- ".\compile-run.cmd"
- ".\run-docker.cmd"

N.B. To be able to run Docker locally you need to connect your Docker account to the Docker Hub!
Sometimes it happens that it gives the same problem even if you are logged in, so go to C:\Users\{Username} and delete
the .docker file, after which follow one of 2 ways:
1) Open terminal, type 'docker login' and log in 2) Log in to docker desktop
# RUN DOCKER ENVIRONMENT LINUX #

To run the application on Docker you need to start the commands from cmd:

- ".\compile-run.sh"

## Description of the project

Below is a list of services included in the suite, including documentation and links for the interface (username and
password can be found in the project configurations)


| Servizio       | Documentazione                                                                          | Link di acceso                                             |
|----------------|-----------------------------------------------------------------------------------------|------------------------------------------------------------|
| Gateway        | [Spring Gateway](https://spring.io/projects/spring-cloud-gateway)                       | [Swagger Centralizzato](http://localhost:8080/swagger-ui/) |
| Config Server  | [Spring Config](https://spring.io/projects/spring-cloud-config)                         | N.D.                                                       |
| Eureka         | [Eureka Server](https://github.com/spring-guides/gs-service-registration-and-discovery) | [Eureka UI](http://localhost:8761/)                        |
| Zipkin         | [OpenZipkin](https://zipkin.io/)                                                        | [Zipkin UI](http://localhost:9411/zipkin/)                 |
| RabbitMQ       | [RabbitMQ](https://www.rabbitmq.com/)                                                   | [Management UI](http://localhost:15672/)                   |
| Prometheus     | [Prometheus](https://prometheus.io/)                                                    | N.D.                                                       |
| Grafana        | [Grafana](https://grafana.com/)                                                         | [Grafana UI](http://localhost:3000/)                       |
| ElastichSearch | [ElastichSearch](https://grafana.com/)                                                  | [ElastichSearch UI] (http://localhost:9200)                |
