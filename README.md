<h1 style="text-align: center;">Spring Boot Security MFA Project</h1>

<p style="text-align: center;">
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/spring--boot-3.5.7-brightgreen?logo=springboot" alt="Spring Boot"/>
  </a>
</p>

## Live Demo

TBD

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Requirements](#-requirements)
- [Getting Started](#-getting-started)
    - [Clone the Repository](#1-clone-the-repository)
    - [Start Docker](#2-start-docker)
    - [Build the Project](#3-build-the-project)
    - [Run Project Locally](#4-run-the-project)
    - [Build Docker Image](#5-optional-build-docker-image-docker-should-be-running)
    - [Run Docker Image](#6-optional-running-on-docker)
    - [Deploy on Kubernetes with Helm](#7-optionalrun-on-local-minikube-kubernetes-using-helm-chart)
- [Testing](#-testing)
- [Clean Up](#-cleanup)
- [Reference Documentation](#-reference-documentation)

---

## 🚀 Overview

A modern **Spring Boot** starter project with REST API, Security, JPA, Actuator, Docker, and Kubernetes Helm support.

---

## 🚀 Features

- Spring Boot 3.5.7 (Java 25)
- RESTful API with CRUD endpoints
- Spring Data JPA (H2 in-memory DB)
- Actuator endpoints enabled
- Docker & multi-stage build
- Kubernetes manifests & Helm chart
- GitHub Actions CI/CD

---

## 📦 Requirements

- Git `2.51.0+`
- Java `25`
- Maven `3.9+`
- Spring Boot `3.5.7`
- (Optional)Docker Desktop (tested on `4.48.0`)
- (Optional) Minikube/Helm for Kubernetes

---

## 🛠️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-security-mfa.git
cd spring-boot-3-security-mfa
```

### 2. Start Docker

* this command will start all required services to start application

```bash
docker compose up
```

### 3. Build the Project

```bash
./mvnw clean package -DskipTests
```

* OR for native build run

```bash
./mvnw clean native:compile -Pnative
```

### 4. Run the Project

```bash
./mvnw spring-boot:run
```

* OR Jar file

```bash
java -jar .\target\spring-boot-3-security-mfa-0.0.1-SNAPSHOT.jar
```

* OR Run native image directly

```bash
target/spring-boot-3-security-mfa
```

### 5. (Optional) Build Docker Image (docker should be running)

```bash
./mvnw clean spring-boot:build-image -DskipTests
```

* OR To create the native container image, run the following goal:

```bash
./mvnw clean spring-boot:build-image -Pnative -DskipTests
```

* OR using dockerfile

```bash
docker build --progress=plain --no-cache -f <dockerfile> -t deepaksorthiya/spring-boot-3-security-mfa .
```

* OR Build Using Local Fat Jar In Path ``target/spring-boot-3-security-mfa-0.0.1-SNAPSHOT.jar``

```bash
docker build --build-arg JAR_FILE=target/spring-boot-3-security-mfa-0.0.1-SNAPSHOT.jar -f Dockerfile.jvm --no-cache --progress=plain -t deepaksorthiya/spring-boot-3-security-mfa .
```

* OR if above not work try below command

***you should be in jar file path to work build args***

```bash
cd target
docker build --build-arg JAR_FILE=spring-boot-3-security-mfa-0.0.1-SNAPSHOT.jar -f ./../Dockerfile.jvm --no-cache --progress=plain -t deepaksorthiya/spring-boot-3-security-mfa .
```

| Dockerfile Name                                            |                          Description                           |
|------------------------------------------------------------|:--------------------------------------------------------------:|    
| [Dockerfile](Dockerfile)                                   |  multi stage docker file with Spring AOT and JDK24+ AOT Cache  |
| [Dockerfile.jlink](Dockerfile.jlink)                       |      single stage using JDK jlink feature to reduce size       |
| [Dockerfile.jvm](Dockerfile.jvm)                           |    single stage using with Spring AOT and JDK24+ AOT Cache     |
| [Dockerfile.native](Dockerfile.native)                     |  single stage using graalvm native image using oraclelinux 9   |
| [Dockerfile.native-distro](Dockerfile.native-distro)       | single stage using graalvm native image distroless linux image |
| [Dockerfile.native-micro](Dockerfile.native-micro)         |   single stage using graalvm native image micro linux image    |
| [Dockerfile.native-multi](Dockerfile.native-multi)         |    multi stage using graalvm native image micro linux image    |
| [Dockerfile.springlayeredjar](Dockerfile.springlayeredjar) |          multi stage using spring layererd layout jar          |
| [Dockerfile.springlayoutjar](Dockerfile.springlayoutjar)   |              multi stage using spring layout jar               |

### 6. (Optional) Running On Docker

```bash
docker run -p 8080:8080 --name spring-boot-3-security-mfa deepaksorthiya/spring-boot-3-security-mfa:latest
```

### 7. (Optional)Run on Local minikube Kubernetes using Helm Chart

```bash
cd helm
helm create spring-boot-3-security-mfa
helm lint spring-boot-3-security-mfa
helm install spring-boot-3-security-mfa --values=spring-boot-3-security-mfa/values.yaml spring-boot-3-security-mfa
helm install spring-boot-3-security-mfa spring-boot-3-security-mfa
helm uninstall spring-boot-3-security-mfa
```

---

## 🧪 Testing

- Access the API: [http://localhost:8080](http://localhost:8080)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Postman API Collection

TBD

### Rest API Endpoints

TBD

### Run Unit-Integration Test Cases

```bash
./mvnw clean test
```

To run your existing tests in a native image, run the following goal:

```bash
./mvnw test -PnativeTest
```

---

## 🧹 Cleanup

```bash
docker compose down -v
```

---

## 📚 Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
- [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
- [Spring Data JPA](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jpa-and-spring-data)
- [Validation](https://docs.spring.io/spring-boot//io/validation.html)
- [Flyway Migration](https://docs.spring.io/spring-boot/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

---

<p style="text-align: center;">
  <b>Happy Coding!</b> 🚀
</p>
