# IBM-test

## Puesta en marcha
Para probar la aplicación se deben seguir los siguientes pasos:

1. Levantar la BD de MySQL.

Renombrar el fichero env.sample a .env para que el docker-compose.yml pueda obtener las variables.

*La forma correcta sería hacer uso de los secrets de GitHub para que el valor de las variables se mantuviese oculto. Sin embargo por temas de simplicidad y dado que no estamos guardando realmente ningún tipo de información confidencial, en este caso, estas variables pueden ser públicas.*

Sobre la raiz del proyecto levantar el contenedor de la BD utilizando:
```
docker compose up -d
```

2. Ejecutar el jar de la aplicación.

El proyecto utiliza Java 17 por lo que debemos configurarlo para que utilice el JDK correspondiente.

![image](https://github.com/Lizarraga/IBM-test/assets/9576198/e9519327-160b-455f-bc6e-af9caa69a2a6)

Ejecutar la clase principal IbmtestApplication.

![image](https://github.com/Lizarraga/IBM-test/assets/9576198/454960aa-3d30-43b7-9f19-a93f50378cd5)

3. Llamar al endpoint.

Importar la colección de la raiz del repositorio: IBM test.postman_collection.json.

Realizar la petición GET indicando el id del cliente en la URL

![image](https://github.com/Lizarraga/IBM-test/assets/9576198/30049fbb-3cb3-4e60-b920-c0b7bc89dcbb)

## Dependencias utilizadas
* Spring Boot 3.1.0: Base del proyecto
* Java 17: Minima versión del jdk compatible con versiones superiores Spring Boot 3
* Spring JPA: Persistencia de datos. Utiliza Spring Data e Hibernate
* Spring MVC: API REST. Integración de un Tomcat embebido en la aplicación
* MySQL connector: Conexión con la BD de MySQL
* H2: Base de datos en memoria para la ejecución de los test
* Lombok: Librería para la reducción de código repetitivo
* Docker/Docker compose: Gestión del contenedor de BD de la aplicación
