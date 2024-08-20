# Junior Java Developer Test Task: Customer Management API

This project implements an HTTP API server with basic CRUD operations for the Customer entity using Spring Boot.

## Project Specifications

- Backend: Spring Boot application
- Frontend: Not required
- Database: Any relational persistent SQL DB (MySQL/PostgreSQL/etc.)
- Authentication: Not required

## API Endpoints

### Create Customer
- **POST** `/api/customers`
- **Content-Type:** `application/json`
- **Request Body:**
  ```json
  {
    "fullName": "String (2-50 characters including whitespaces)",
    "email": "String (2-100 characters, unique, must include exactly one @)",
    "phone": "String (6-14 characters, digits only, must start with +, optional)"
  }
  ```
- **Response Body:**
  ```json
  {
    "id": "Long",
    "fullName": "String",
    "email": "String",
    "phone": "String"
  }
  ```

### Read All Customers
- **GET** `/api/customers`
- **Response Body:** List of customer objects
  ```json
  [
    {
      "id": "Long",
      "fullName": "String",
      "email": "String",
      "phone": "String"
    }
  ]
  ```

### Read Customer
- **GET** `/api/customers/{id}`
- **Response Body:**
  ```json
  {
    "id": "Long",
    "fullName": "String",
    "email": "String",
    "phone": "String"
  }
  ```

### Update Customer
- **PUT** `/api/customers/{id}`
- **Content-Type:** `application/json`
- **Request Body:**
  ```json
  {
    "id": "Long",
    "fullName": "String (2-50 characters including whitespaces)",
    "email": "String (not editable)",
    "phone": "String (6-14 characters, digits only, must start with +)"
  }
  ```
- **Response Body:**
  ```json
  {
    "id": "Long",
    "fullName": "String",
    "email": "String",
    "phone": "String"
  }
  ```

### Delete Customer
- **DELETE** `/api/customers/{id}`
- Marks a customer as deleted but leaves their data in the database

## Database Structure

### Customer Table
- `id`: bigint
- `created`: bigint
- `updated`: bigint
- `full_name`: varchar
- `email`: varchar
- `phone`: varchar, nullable
- `is_active`: bool

Note: The `DELETE` operation should only update the `is_active` field to `false`, not remove the record from the database.

Would you like me to explain or elaborate on any part of this README content?
