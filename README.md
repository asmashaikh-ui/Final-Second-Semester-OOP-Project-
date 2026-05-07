# Final-Second-Semester-OOP-Project-
# Cafe Inventory Management System 

## Project Description

This project is developed for our Object Oriented Programming semester project using Java language. The main purpose of this system is to help managing inventory records in simple and organized way. In this system user can manage items, suppliers, customers, sales and purchases.

We used Java OOP concepts like classes, objects, inheritance, encapsulation and polymorphism. We also connected MySQL database with Java using JDBC connector.

This project is console based application and all records are stored in database.

---

# Student Details

| Name                   | CMS ID      | Section |
| ---------------------- | ----------- | ------- |
| Asma Riaz Shaikh       | 023-25-0022 | BSCS-E  |
---

# Purpose of Project

The purpose of this project is to make inventory management easier and more efficient. Managing products manually can create mistakes and confusion sometimes, so this system helps keeping all records properly.

This project also helped us understanding practical implementation of Object Oriented Programming concepts in Java.

---

# Features of Project

* Add new items
* Update item details
* Remove items
* Manage suppliers
* Manage customers
* Record purchases
* Record sales
* Database connectivity using MySQL
* Login system
* Dashboard service

---

# Main Classes and Modules

## Model Package

### Person.java

Base class for different persons in system.

### Admin.java

Admin class for managing inventory system.

### Customer.java

Stores customer related information.

### Supplier.java

Stores supplier information.

### Item.java

Stores item details like item id, name, quantity and price.

### Purchase.java

Handles purchase records.

### Sales.java

Handles sales records.

---

## Service Package

### DBConnection.java

Used for connecting Java application with MySQL database.

### LoginService.java

Handles login functionality.

### ItemService.java

Performs item operations.

### CustomerService.java

Performs customer operations.

### SupplierService.java

Performs supplier operations.

### PurchaseService.java

Handles purchase related operations.

### SaleService.java

Handles sale related operations.

### DashboardService.java

Displays dashboard related details.

### InventoryOperations.java

Contains inventory related operations and functionalities.

---

## UI Package

### MainMenu.java

Main class of project which displays menu and starts the application.

---

# OOP Concepts Used

* Classes and Objects
* Encapsulation
* Inheritance
* Polymorphism
* Method Overriding
* Packages
* JDBC Database Connectivity
* Exception Handling

---

# Technologies Used

* Java
* MySQL
* JDBC Connector
* IntelliJ / Eclipse / NetBeans

---

# Database File

Database SQL file is included:

```text
Inventory.sql
```

Import this file in MySQL before running the project.

---

# How to Run Project

## Requirements

* JDK 17 or above
* MySQL Database
* Java IDE

---

## Steps to Run

1. Import `Inventory.sql` file in MySQL.
2. Open project in IDE.
3. Add MySQL JDBC connector jar file.
4. Run `MainMenu.java` file.

---

# Folder Structure

```text
fixed/
 ├── model/
 │     ├── Admin.java
 │     ├── Customer.java
 │     ├── Item.java
 │     ├── Person.java
 │     ├── Purchase.java
 │     ├── Sales.java
 │     └── Supplier.java
 │
 ├── service/
 │     ├── CustomerService.java
 │     ├── DashboardService.java
 │     ├── DBConnection.java
 │     ├── InventoryOperations.java
 │     ├── ItemService.java
 │     ├── LoginService.java
 │     ├── PurchaseService.java
 │     ├── SaleService.java
 │     └── SupplierService.java
 │
 ├── ui/
 │     └── MainMenu.java
 │
 ├── Inventory.sql
 └── mysql-connector-j-9.6.0.jar
```

---

# GitHub Repository Link

(https://github.com/asmashaikh-ui/Final-Second-Semester-OOP-Project-)

---

# Project Demo Video

PASTE YOUR YOUTUBE VIDEO LINK HERE

---

# Conclusion

This project was really good learning experience for me. I learned how real Java applications are structured using OOP concepts and database connectivity. I also learned project management during this semester project.
