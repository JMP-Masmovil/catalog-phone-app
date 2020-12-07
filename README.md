# catalog-phone-app
Catalog Microservice

Microservicio para el acceso al catalogo de telefonos de la aplicación.
Al arrancar el servicio, se crea una base de datos MongoDB en memoria, 
para la gestion de la persistencia de la aplicacion.

#Swagger
http://localhost:8080/swagger-ui.html

#Docker
Create container from shell 
	"mvn package spring-boot:repackage"
	"docker build -t catalog-phone-app/v1 ."