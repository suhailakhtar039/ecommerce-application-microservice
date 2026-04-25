# 🛒 Spring Boot Microservices eCommerce Application

A production-grade **microservices-based eCommerce system** built using **Spring Boot**, following modern distributed system design principles including **service discovery, API gateway, fault tolerance, messaging, and observability**.

---

## 🚀 Tech Stack

* **Backend:** Spring Boot, Spring Cloud
* **Service Discovery:** Eureka Server
* **API Gateway:** Spring Cloud Gateway
* **Configuration Management:** Spring Cloud Config Server
* **Database:** PostgreSQL / MongoDB
* **Messaging:** RabbitMQ, Apache Kafka
* **Security:** OAuth2, Keycloak
* **Resilience:** Resilience4j (Circuit Breaker, Retry)
* **Tracing & Monitoring:** Zipkin, Spring Boot Actuator
* **Containerization:** Docker
* **Orchestration:** Kubernetes

---

## 🏗️ Architecture Overview

This project follows a **microservices architecture**, where each service is independently deployable and communicates over REST or messaging queues.

### Core Components:

* **API Gateway**

  * Single entry point for all client requests
  * Handles routing, authentication, and rate limiting

* **Service Registry (Eureka)**

  * Enables dynamic service discovery
  * Eliminates hardcoded service URLs

* **Config Server**

  * Centralized configuration management
  * Supports externalized configs for all environments

* **Microservices**

  * Product Service
  * Order Service
  * Payment Service
  * User Service

---

## 📚 Features Implemented

### 🔹 Microservices Fundamentals

* Service decomposition
* Inter-service communication (REST & Messaging)

### 🔹 API Gateway

* Centralized routing using Spring Cloud Gateway
* Load balancing with Eureka

### 🔹 Service Discovery

* Eureka server and client setup
* Dynamic service registration

### 🔹 Configuration Management

* Centralized configs using Config Server
* Environment-based configurations

### 🔹 Fault Tolerance & Resilience

* Circuit Breaker using Resilience4j
* Retry mechanisms
* Fallback handling

### 🔹 Asynchronous Communication

* RabbitMQ for event-driven communication
* Apache Kafka for distributed streaming

### 🔹 Observability

* Distributed tracing using Zipkin
* Metrics and health checks via Actuator

### 🔹 Security

* OAuth2 authentication
* Keycloak integration

### 🔹 Database Handling

* PostgreSQL (relational)
* MongoDB (NoSQL)

### 🔹 Containerization & Deployment

* Dockerized microservices
* Kubernetes deployment support

---

## ⚙️ Project Structure

```
├── api-gateway
├── config-server
├── eureka-server
├── product-service
├── order-service
├── payment-service
├── user-service
├── common-library
└── docker
```

---

## 🔄 Inter-Service Communication

### 1. Synchronous (REST)

* Using RestTemplate / WebClient / OpenFeign

### 2. Asynchronous (Messaging)

* RabbitMQ → Event-driven workflows
* Kafka → High-throughput data streaming

---

## 🛡️ Fault Tolerance Strategy

* Circuit Breaker → Prevent cascading failures
* Retry → Handle transient failures
* TimeLimiter → Avoid long-running calls
* Bulkhead → Isolate resources

---

## 📊 Observability

* **Actuator Endpoints:** Health, metrics
* **Zipkin:** Distributed tracing
* Logs aggregation supported

---

## 🐳 Running with Docker

```bash
docker-compose up --build
```

---

## ☸️ Kubernetes Deployment

```bash
kubectl apply -f k8s/
```

---

## 🔐 Security

* OAuth2-based authentication
* Keycloak for identity management

---

## 📦 Build & Run

### Build

```bash
mvn clean install
```

### Run Individual Service

```bash
mvn spring-boot:run
```

---

## 🌐 API Gateway URL

```
http://localhost:8888/
```

---

## 📌 Future Enhancements

* CI/CD pipeline integration
* Advanced rate limiting
* Caching with Redis
* GraphQL gateway support

---

## 🤝 Contribution

Contributions are welcome. Please fork the repo and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Suhail Akhtar**
Software Development Engineer | Java | Spring Boot | Microservices

---
