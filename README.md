# Java Multi-Module Clean Architecture Showcase

This demo project is a showcase of a clean architecture approach using a hexagonal (ports and adapters) design in a multi-module Java project with Spring Boot.

## Architecture

The project follows the principles of **Hexagonal Architecture**, also known as **Ports and Adapters**. This architectural style aims to create a loosely coupled application that can be easily tested and maintained.

- **Domain (business module):** This is the core of the application. It contains the business logic, models, and use cases. It has no dependencies on any other layer.
- **Adapters (entrypoint, gateway, repository modules):** These modules contain the implementation details that connect the application to the outside world. This includes web controllers, database repositories, and external service clients. They depend on the business layer.

## Modules

The project is divided into the following modules:

- `application`: The main Spring Boot application, responsible for starting the application and wiring all the components together.
- `business`: The core domain logic, containing use cases, domain models, and interfaces for gateways.
- `entrypoint`: Contains the primary adapters that drive the application, such as REST controllers.
- `gateway`: Implements the secondary adapters that the application uses to connect to external services, like the currency conversion API.
- `repository`: Implements the database interaction logic, providing concrete implementations of the repository interfaces defined in the domain.

## How to Run

1.  **Build the project:**
    ```bash
    ./gradlew build
    ```

2.  **Run the application:**
    ```bash
    java -jar application/build/libs/application.jar
    ```

The application will be available at `http://localhost:8080`.

## Endpoints

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **Get User by ID:** `GET /users/{id}`
- **Create User:** `POST /users`
- **Get Account by ID:** `GET /accounts/{id}`
- **Create Account:** `POST /accounts`
- **Get Card by ID:** `GET /cards/{id}`
- **Create Card:** `POST /cards`
- **Currency Conversion:** `GET /currency/convert?from={from}&to={to}&amount={amount}`
- **H2 Console:** `http://localhost:8080/h2-console`
  - **JDBC URL:** `jdbc:h2:mem:exampledb`
  - **User Name:** `sa`
  - **Password:** `password`
