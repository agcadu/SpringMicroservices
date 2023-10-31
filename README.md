![Encabezado del Proyecto](./header.png)
# SpringMicroservices

## Introducción

### Beneficios de la Arquitectura de Microservicios:
La arquitectura de microservicios permite construir una aplicación como una colección de servicios independientes, los cuales están desacoplados entre sí. Los beneficios clave incluyen:

- **Escalabilidad**: Cada microservicio puede ser escalado de manera independiente, permitiendo un control más preciso sobre los recursos y los costos.
- **Mantenibilidad**: Las bases de código más pequeñas son más fáciles de mantener y entender.
- **Flexibilidad**: Diferentes microservicios pueden ser escritos en diferentes lenguajes, frameworks, y pueden usar diferentes tecnologías de almacenamiento de datos.

### Spring Cloud y Spring Eureka:
- **Spring Cloud**: Proporciona herramientas para que los desarrolladores construyan rápidamente algunos de los patrones comunes en sistemas distribuidos (por ejemplo, gestión de configuración, descubrimiento de servicios, circuit breakers, etc.).

- **Spring Eureka**: Un registro de servicios para balanceo de carga resiliente y failover, parte de Spring Cloud.

## Descripción de la Aplicación

Esta aplicación demuestra una arquitectura de microservicios utilizando Spring Boot, Spring Cloud y Spring Eureka. La aplicación comprende los siguientes componentes:

- **microservice-config-server**: Un servidor de configuración centralizado que externaliza las propiedades de configuración para los microservicios.

- **microservice-eureka**: El servidor Eureka que actúa como un registro de servicios facilitando el descubrimiento de servicios.

- **microservice-gateway**: La pasarela de API que enruta las solicitudes a los microservicios apropiados.

- **microservice-course**: Gestiona los datos de los cursos y utiliza una base de datos PostgreSQL.

- **microservice-student**: Gestiona los datos de los estudiantes y utiliza una base de datos MySQL.

- **Feign Client**: Facilita la comunicación entre los microservicios `microservice-course` y `microservice-student`.

## Despliegue Local

La aplicación está dockerizada y se puede desplegar localmente utilizando Docker y Docker Compose.

1. Clona el repositorio desde GitHub:
   ```bash
   git clone https://github.com/agcadu/SpringMicroservices.git
    ```
    ```bash
   cd SpringMicroservices
    ```
2. Construye e inicia los contenedores de Docker:
    ```bash
   docker compose up
    ```

## Pruebas

Se proporciona una colección de Postman llamada `Microservices.postman_collection.json` para probar la aplicación.

## Acceso a las Bases de Datos

El acceso a las bases de datos se configura a través de las variables de entorno de Docker Compose:

- Base de datos de estudiantes: `jdbc:mysql://localhost:3306/student_db`, usuario: `root`, contraseña: `root`
- Base de datos de cursos: `jdbc:postgresql://localhost:5432/course_db`, usuario: `postgres`, contraseña: `postgres`


