# RestauranteSystem

## Overview
RestauranteSystem is a Java application designed to manage restaurant orders. It provides functionalities to insert and manage orders in a database, making it easier for restaurant staff to handle customer requests efficiently.

## Project Structure
```
RestauranteSystem
├── src
│   └── restaurantesystem
│       ├── PedidoDAO.java
│       ├── Pedido.java
│       ├── Conexao.java
│       └── database
│           └── create_tables.sql
├── README.md
```

## Files Description
- **PedidoDAO.java**: Contains the `PedidoDAO` class responsible for database operations related to the `Pedido` entity. It includes methods for inserting new orders into the database.
  
- **Pedido.java**: Defines the `Pedido` class, which represents an order. It includes properties such as `prato` (dish), `bebida` (drink), `observacoes` (observations), and `mesa` (table), along with their respective getters and setters.

- **Conexao.java**: Manages the database connection, including methods to establish and close connections to the database.

- **create_tables.sql**: Contains SQL statements to create the necessary tables in the database for the RestauranteSystem application. It defines the structure of the tables, including columns and their data types.

## Setup Instructions
1. Ensure you have a Java Development Kit (JDK) installed on your machine.
2. Set up a database (e.g., MySQL, PostgreSQL) and configure the connection details in the `Conexao.java` file.
3. Execute the SQL statements in `create_tables.sql` to create the required tables in your database.
4. Compile and run the application to start managing restaurant orders.

## Usage
- Use the `PedidoDAO` class to interact with the database and manage orders.
- Create instances of the `Pedido` class to represent individual orders.
- Utilize the methods in `Conexao` to handle database connections as needed.