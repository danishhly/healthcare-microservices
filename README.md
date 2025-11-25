# Healthcare Microservices 🏥 (WIP)

A cloud-native healthcare application backend built using **Java 17** and **Spring Boot 3**. This project demonstrates a microservices architecture pattern including Service Discovery, Centralized Configuration, API Gateway routing, and containerization.

> **⚠️ Note:** This project is currently in the **initial development phase**. Features are being added incrementally.

## 🏗️ Architecture Overview

The system consists of the following independent microservices:

| Service | Description | Port |
| :--- | :--- | :--- |
| **Eureka Server** | Service Discovery Server (Netflix Eureka). | `8762` |
| **Config Server** | Centralized configuration for all microservices. | `8888` |
| **API Gateway** | Entry point for the application. Routes traffic to specific services. | `8085` |
| **Patient Service** | Manages patient records (CRUD operations) backed by PostgreSQL. | `Dynamic` |

### Infrastructure
* **Database**: PostgreSQL (running in a Docker container).
* **Orchestration**: Docker Compose.

## 🛠️ Tech Stack

* **Language**: Java 17
* **Framework**: Spring Boot 3.3 / 3.5
* **Cloud Stack**: Spring Cloud (Gateway, Config, Netflix Eureka)
* **Database**: PostgreSQL
* **Tools**: Maven, Docker, Lombok, Actuator

## 🚀 Getting Started

### Prerequisites
* Docker & Docker Compose
* Java 17 SDK (if running locally without Docker)
* Maven

### Option 1: Run with Docker Compose (Recommended)
The easiest way to start the entire system is using Docker Compose.

1.  Clone the repository.
2.  Navigate to the project root.
3.  Run the following command:

```bash
docker-compose up --build
```

This will spin up:

* PostgreSQL database.
* Eureka Server.
* Config Server (loads configs from the local config-repo folder).
* Patient Service.
* API Gateway.

### Option 2: Run Manually (Local Dev)
If you want to run services individually via Maven, ensure you start them in this order:

1.Config Server:
```bash
cd config-server
./mvnw spring-boot:run
```
2.Eureka Server:
```bash
cd eureka-server
./mvnw spring-boot:run
```

3.Patient Service (Ensure you have a local Postgres DB running or update application.yml):
```bash
cd patient-service
./mvnw spring-boot:run
```
4.API Gateway:
```bash
cd api-gateway/api-gateway
./mvnw spring-boot:run
```

### 🔌 API Endpoints
All requests should be routed through the API Gateway on port 8085.

Patient Service Routes
Base URL: http://localhost:8085/api/v1/patients
```bash
Method,  Endpoint,  Description,  Payload
GET,       /,       Get all patients,   -
GET,     /{id},     Get patient by ID,  -
POST,       /,      Create a new patient,  JSON (see below)
PUT,     /{id},     Update patient details, JSON
DELETE,  /{id},     Delete a patient,   -
```

Sample JSON Payload for Creation:
```
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phone": "1234567890"
}
```

### Roadmap & Todo
Since this is a starting point, the following features are planned:

[ ] Doctor Service: Management of doctors and schedules.

[ ] Appointment Service: Booking logic between Patients and Doctors.

[ ] Security: Implementation of OAuth2 / Keycloak / JWT.

[ ] Resilience: Circuit Breakers (Resilience4j) and Retry logic.

[ ] Distributed Tracing: Integration with Zipkin or Micrometer.

[ ] Frontend: A React/Angular dashboard for the hospital management.

## 🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
