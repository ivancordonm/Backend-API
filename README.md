# Backend API

Imagine you are assigned to create a minimalistic backend web app for an online shop. The application should operate with the following data entities (the types are generic and provided for reference) :

Customer
- ID (integer)
- Name (string)
- Surname (string)
- Email (string)

ShopItemCategory
- ID (integer)
- Title (string)
- Description (string)

ShopItem
- ID (integer)
- Title (string)
- Description (string)
- Price (float)
- Category (list of ShopItemCategory)

OrderItem
- ID (integer)
- ShopItem (ShopItem)
- Quantity (integer)

Order
- ID (integer)
- Customer (Customer)
- Items (list of OrderItem)

Implement full CRUD APIs for entities Customer, ShopItemCategory, ShopItem, Order. Also add endpoint autotests for each endpoint. Use any data persistence implementation of your choice (but include initialisation of some test data). Include README on how to set up the project, run the application and run tests.

## Setup and Running Instructions

### Prerequisites
- Java 21
- Maven 3.6+

### Setup Project
1. Clone the repository
2. Navigate to the project directory

### Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Run Tests
```bash
mvn test
```

### API Endpoints

#### Customers
- `GET /api/customers` - Get all customers
- `GET /api/customers/{id}` - Get customer by ID
- `POST /api/customers` - Create new customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer

#### Categories
- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get category by ID
- `POST /api/categories` - Create new category
- `PUT /api/categories/{id}` - Update category
- `DELETE /api/categories/{id}` - Delete category

#### Shop Items
- `GET /api/items` - Get all items
- `GET /api/items/{id}` - Get item by ID
- `POST /api/items` - Create new item
- `PUT /api/items/{id}` - Update item
- `DELETE /api/items/{id}` - Delete item

#### Orders
- `GET /api/orders` - Get all orders
- `GET /api/orders/{id}` - Get order by ID
- `POST /api/orders` - Create new order
- `PUT /api/orders/{id}` - Update order
- `DELETE /api/orders/{id}` - Delete order

### Database
The application uses H2 in-memory database with test data automatically initialized on startup.
You can access H2 console at `http://localhost:8080/h2-console` with:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

### Technology Stack
- Java 21
- Spring Boot 3.2.1
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5