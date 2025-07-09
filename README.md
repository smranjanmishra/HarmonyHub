# HarmonyHub - Enterprise Resource Management System

## 🚀 Overview

HarmonyHub is a comprehensive **Enterprise Resource Management (ERM)** system built with Spring Boot 3.5.3 and Java 21. This robust application provides a complete solution for managing products, customers, employees, transactions, and business operations through a RESTful API architecture.

## 🏗️ Architecture & Technology Stack

### Core Technologies
- **Java 21** - Latest LTS version for optimal performance
- **Spring Boot 3.5.3** - Modern application framework
- **Spring Data JPA** - Object-relational mapping
- **MySQL Database** - Reliable data persistence
- **Lombok** - Reduces boilerplate code
- **Spring Cloud Config** - Configuration management

### Design Patterns
- **RESTful API Design** - Standard HTTP methods and status codes
- **Layered Architecture** - Controllers → Services → Repositories → Models
- **DTO Pattern** - Data Transfer Objects for API responses
- **Global Exception Handling** - Centralized error management
- **Dependency Injection** - Spring's IoC container

## 📊 Business Domain

HarmonyHub manages the following core business entities:

### 🛍️ Products Management
- Product catalog with categories and suppliers
- Inventory tracking and stock level management
- Price management and sorting capabilities
- Product categorization and supplier relationships

### 👥 Customer Management
- Customer profile management
- Contact information tracking
- Transaction history association
- Customer relationship management

### 👨‍💼 Employee Management
- Employee profile management
- Department and role assignments
- Employee lifecycle management
- Partial updates support (PATCH operations)

### 💰 Transaction Management
- Sales transaction recording
- Multi-entity transaction tracking
- Transaction history and reporting
- Customer and product association

### 🏢 Organizational Structure
- **Categories** - Product classification
- **Suppliers** - Vendor management
- **Departments** - Organizational units
- **Roles** - Employee role definitions

## 🔧 API Endpoints

### Products API (`/products`)
```
GET    /products                    - Get all products
GET    /products/{id}               - Get product by ID
GET    /products/category/{id}      - Get products by category
GET    /products/sortByPrice        - Get products sorted by price
POST   /products                    - Create new product
PUT    /products                    - Update product
DELETE /products/{id}               - Delete product
```

### Customers API (`/users`)
```
GET    /users                       - Get all customers
GET    /users/{id}                  - Get customer by ID
POST   /users                       - Create new customer
PUT    /users/{id}                  - Update customer
DELETE /users/{id}                  - Delete customer
```

### Employees API (`/employees`)
```
GET    /employees                   - Get all employees
GET    /employees/{id}              - Get employee by ID
POST   /employees                   - Create new employee
PUT    /employees/{id}              - Replace employee
PATCH  /employees/{id}              - Update employee (partial)
DELETE /employees/{id}              - Delete employee
```

### Transactions API (`/transactions`)
```
GET    /transactions                - Get all transactions
GET    /transactions/{id}           - Get transaction by ID
GET    /transactions?productId=X    - Filter by product
GET    /transactions?customerId=Y   - Filter by customer
POST   /transactions                - Record new transaction
PUT    /transactions                - Update transaction
DELETE /transactions/{id}           - Cancel transaction
```

## 🗄️ Database Schema

### Core Entities
- **Product** - Product catalog with pricing and inventory
- **Customer** - Customer profiles and contact information
- **Employee** - Employee management and roles
- **Transaction** - Sales and business transactions
- **Category** - Product classification system
- **Supplier** - Vendor and supplier management
- **Department** - Organizational structure
- **Role** - Employee role definitions

### Relationships
- **One-to-Many**: Customer → Transactions, Product → Transactions
- **Many-to-One**: Product → Category, Product → Supplier
- **One-to-Many**: Employee → Department, Employee → Role

## 🛡️ Error Handling

### Global Exception Handler
- **ProductNotFoundException** - 404 Not Found
- **CategoryNotFoundException** - 404 Not Found
- **SupplierNotFoundException** - 404 Not Found
- **TransactionNotFoundException** - 400 Bad Request
- **CustomerNotFoundException** - 404 Not Found
- **Generic Exception Handler** - 500 Internal Server Error

### Standardized Error Response
```json
{
  "message": "Error description",
  "resolution": "Suggested resolution"
}
```

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- MySQL 8.0 or higher
- Maven 3.6+ (or use Maven wrapper)

### Database Setup
1. Create MySQL database: `harmonyHubDB`
2. Update `application.properties` with your database credentials

### Running the Application
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Using Maven (if installed)
mvn spring-boot:run
```

### Configuration
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/harmonyHubDB
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

## 🧪 Testing

The project includes comprehensive test coverage:
- Unit tests for services
- Integration tests for controllers
- Repository layer testing
- Exception handling validation

## 📈 Features & Capabilities

### ✅ Implemented Features
- **CRUD Operations** - Complete Create, Read, Update, Delete for all entities
- **RESTful API Design** - Standard HTTP methods and status codes
- **Data Validation** - Input validation and error handling
- **Relationship Management** - Complex entity relationships
- **Search & Filter** - Product and transaction filtering
- **Sorting** - Product sorting by price
- **Partial Updates** - PATCH operations for employees
- **Exception Handling** - Global exception management
- **DTO Pattern** - Clean API responses
- **Database Integration** - MySQL with JPA/Hibernate

### 🔄 Data Flow
1. **Client Request** → REST Controller
2. **Controller** → Service Layer (Business Logic)
3. **Service** → Repository Layer (Data Access)
4. **Repository** → Database (MySQL)
5. **Response** → DTO Transformation → Client

## 🏆 Project Highlights

### Technical Excellence
- **Modern Java Features** - Java 21 with latest language features
- **Spring Boot Best Practices** - Industry-standard patterns
- **Clean Architecture** - Separation of concerns
- **Scalable Design** - Easy to extend and maintain
- **Production Ready** - Error handling and logging

### Business Value
- **Complete ERM Solution** - End-to-end business management
- **Flexible API** - Easy integration with frontend applications
- **Data Integrity** - Proper relationships and constraints
- **Audit Trail** - Transaction tracking and history
- **Multi-tenant Ready** - Extensible for multiple organizations

## 📝 Development Notes

### Code Quality
- **Lombok Integration** - Reduced boilerplate code
- **Consistent Naming** - Clear and descriptive naming conventions
- **Proper Annotations** - JPA and Spring annotations used correctly
- **Exception Safety** - Comprehensive error handling
- **API Documentation** - Self-documenting REST endpoints

### Performance Considerations
- **JPA Optimization** - Efficient database queries
- **DTO Pattern** - Minimized data transfer
- **Lazy Loading** - Optimized entity relationships
- **Connection Pooling** - Database connection management

## 🔮 Future Enhancements

### Potential Improvements
- **Authentication & Authorization** - JWT-based security
- **API Documentation** - Swagger/OpenAPI integration
- **Caching Layer** - Redis integration
- **Audit Logging** - Comprehensive audit trails
- **Reporting Module** - Business intelligence features
- **Notification System** - Real-time alerts
- **File Upload** - Product image management
- **Export Features** - Data export capabilities

---

*HarmonyHub - Where Business Meets Technology* 🚀
