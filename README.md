AlphaCart – E-Commerce Web Application

README Documentation | CodeAlpha Internship Project

**1. Project Overview**

AlphaCart is an e-commerce web application developed as part of the CodeAlpha internship. It is intended to provide an online shopping experience where users can browse products, view product details, manage a shopping cart, and place orders. Confirm that each feature described below is implemented in the current source code before publishing this document.

**2. Features**

Product listing and product details

Product search

Shopping cart and quantity management

Order placement using customer details

Product stock validation

Retrieval of saved order information
**
**3. Technologies Used****

Programming language

Java 17

Backend framework

Spring Boot

Web/API layer

Spring Web (REST API)

Database

H2 Database

Data access

Spring Data JPA

Frontend

HTML, CSS, JavaScript

Build tool

Maven

**4. Project Structure**

CodeAlpha-Ecommerce/
├── pom.xml
├── .gitignore
└── src/
    └── main/
        ├── java/
        │   └── com/codealpha/ecommerce/
        └── resources/
            ├── application.properties
            └── static/
                ├── index.html
                ├── style.css
                └── app.js
****
**5**.** REST API Endpoints******

Method

Endpoint

Description

GET

/api/products

Retrieve all products

GET

/api/products/1

Retrieve a product by ID (example ID)

POST

/api/orders

Place a new order

GET

/api/orders

Retrieve orders

6. **Installation and Setup**

Prerequisites

Java 17 or later

Maven

Git

Steps to Run

Clone the repository:

git clone https://github.com/payilijayakumar-creator/CodeAlpha-Ecommerce.git

Navigate to the project folder:

cd CodeAlpha-Ecommerce

Start the application:

mvn spring-boot:run

Open in a browser:

http://localhost:8081

7. **Learning Outcomes**

Understanding Java web application development

Creating REST APIs with Spring Boot

Performing database operations with Spring Data JPA

Connecting frontend components to backend APIs

Implementing shopping-cart and order-processing logic

8.** **Future Enhancements****

User registration and login

Payment gateway integration

Product filtering and sorting

Order history for individual customers

Integration with a persistent production database

9. Project Information

Project Name: AlphaCart – E-Commerce Web Application

Organization: CodeAlpha

Project Type: Internship Project

Status: Academic/Internship Project

Note: Update the technology stack, endpoints, project structure, and run instructions to match the actual repository. Do not list features or dependencies that are not present in the code.
