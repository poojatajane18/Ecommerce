# Ecommerce Product Catalogue REST API
This repository contains a Java-based RESTful API implementation for an ecommerce product catalogue system. The system is designed to handle complex, nested data structures for products and utilizes MongoDB for data storage. Below are instructions for setting up and using this project.

## Setup Instructions
### Requirements
- Java Development Kit (JDK) version 8 or higher
- Maven
- MongoDB (running locally or hosted)

### Set Up MongoDB
- Ensure MongoDB is installed and running.
- Create a database named ecommerce in MongoDB.
  
### Configure Application Properties
- Open src/main/resources/application.properties.
- Adjust MongoDB connection details if necessary :
  ```json
  spring.data.mongodb.host=localhost  
  spring.data.mongodb.port=27017    
  spring.data.mongodb.database=ecommerce 

## API Endpoints
The API provides the following endpoints:

### Products
- GET /products: Get all products.
- GET /products/{id}: Get a product by ID.
- POST /products: Create a new product.
- PUT /products/{id}: Update an existing product.
- DELETE /products/{id}: Delete a product by ID.
- GET /products/category/{category}: Get products by category.
- GET /products/search?keyword={keyword}: Search products by name or description.
- GET /products/filter?attributeName={name}&attributeValue={value}: Filter products by attribute.
### Ratings
- POST /products/{productId}/rate: Rate a product.
### Availability
- PUT /products/{productId}/availability: Update product availability.

## Sample Data Model

```json
{
  "name": "Product Name",
  "description": "Product Description",
  "price": 29.99,
  "categories": ["Electronics", "Gadgets"],
  "attributes": [
    { "color": "Black" },
    { "size": "Large" },
    { "brand": "Brand X" }
  ],
  "availability": {
    "inStock": true,
    "quantity": 100
  },
  "ratings": [
    {
      "userId": "user123",
      "rating": 4,
      "comment": "Great product!"
    },
    {
      "userId": "user456",
      "rating": 5,
      "comment": "Very satisfied."
    }
  ]
}


