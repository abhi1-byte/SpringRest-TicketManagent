# 🗺️ Tourist REST API

A Spring Boot 3.x REST API for managing tourists and their details.  
Documented with **OpenAPI 3** and **Swagger UI** for easy exploration.

---

## 🚀 Features
- CRUD operations for tourist data
- OpenAPI 3 specification auto-generated via `springdoc-openapi`
- Interactive Swagger UI at `/swagger-ui/index.html`
- JSON request/response support

---

## 📸 Proof of Concept

### Swagger UI Overview
<img width="3730" height="1790" alt="image" src="https://github.com/user-attachments/assets/efeb1b01-a2c5-4853-9eda-7975475401a9" />


---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3.x**
- **springdoc-openapi-starter-webmvc-ui**
- **Maven**
- **Swagger UI**

---

## 📂 Project Structure
```
src/
 ├─ main/
 │   ├─ java/com/abhi
 │   │   ├─ config
 │   │   ├─ controller
 │   │   ├─ dao
 │   │   ├─ error
 │   │   ├─ exception
 │   │   ├─ exceptionadvice
 │   │   ├─ model
 │   │   ├─ service
 │   │   └─ SpringRestTicketManagementAppApplication.java
 │   └─ resources
 │       ├─ application.yml
 │       └─ static/
 └─ test/
```

---

## 📦 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/abhi1-byte/SpringRest-TicketManagent.git
   cd tourist-api
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

---

## 📜 API Documentation

- **Swagger UI**: [http://localhost:9999/RestMiniProject/swagger-ui/index.html](http://localhost:9999/RestMiniProject/swagger-ui/index.html)
- **OpenAPI JSON**: [http://localhost:9999/RestMiniProject/v3/api-docs](http://localhost:9999/RestMiniProject/v3/api-docs)

---
