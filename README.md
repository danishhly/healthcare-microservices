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
