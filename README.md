# 🚀 Quantity Measurement App – Microservices (UC21)

A **Microservices-based Quantity Measurement Application** built using **Spring Boot & Spring Cloud**.

Implements **Service Discovery, API Gateway, Feign Communication, and Circuit Breaker (Resilience4j)**.

---

## 🧩 Services

- **Eureka Server (8761)** → Service Registry  
- **API Gateway (8080)** → Routing & Load Balancing  
- **Measurement Service (8081)** → Core Logic (Conversion, Operations)  
- **User Service (8082)** → Stores History  

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Cloud (Eureka, Gateway)  
- OpenFeign  
- Resilience4j  
- H2 Database  

---

## 🚀 How to Run

1. Start **Eureka Server**
2. Start **User Service**
3. Start **Measurement Service**
4. Start **API Gateway**

Open: http://localhost:8761

---

## 🧪 API Example

**POST**
