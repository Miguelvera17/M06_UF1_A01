<em><h1 align="center"> 🎉 Welcome to My Store! 🛒 </h1>  </em>

# 📚 Overview
This Java project is a simple store management system that allows users to create and manage orders. Users can add client information, create articles for orders, 
and save them in various formats (TXT, CSV, and binary).

# 💻 Features
````
a) Client Management: Create and manage client information.
b) Order Creation: Add multiple articles to an order.
c) Document Handling: Save orders in different formats:
d) TXT: Human-readable text format.
e) CSV: Comma-separated values for easy data manipulation.
f) Binary: Compact binary format for efficiency.
g) Data Retrieval: Read previously saved orders from files.
````

# 📦 Project Structure

````
├── M06_UF1_A01
    ├── Entrada.java          # Class for handling user input
    ├── Article.java          # Class for managing articles
    ├── Client.java           # Class for managing client information
    ├── Fitxer.java           # Class for file operations
    └── Store.java            # Main class for the store application
    └── README.md             # Project documentation
````   

# 📖 Usage
Step 1: Client Information
When prompted, enter the client’s name, phone number, and order date.

````
======= Client information =======
Name:        Miguel
Phone:       +34 628528182
Order's date: 2024-10-09
==================================
```` 

Step 2: Add Articles
You can add multiple articles to the order. For each article, enter the name, quantity, and unit.

```` 
Indicate your order
=========== Article 1 ===========
Article/es: Coffee
Quantity:   2
Unit:       kg
================================
```` 

````
Would you like to add more articles? [y] [n]
----> y
````
Step 3: Save Order
Choose the format to save the order:

````
a) Albaran  (TXT)
b) Binary   (DAT)
c) CSV      (CSV)
````

Step 4: Read Previous Orders
You can read saved orders by specifying the file path when prompted.

# 📄 File Formats
TXT Format
````
Client's name:  Miguel
Client's phone: +34 628528182
Order's date:   2024-10-09

Quantity       Units     Article
============= ========== ===========
2.0           kg        Coffee
````

CSV Format
````
Miguel;+34 628528182;2024-10-09;Coffee;2;kg
````

Binary Format

# ❌ Error Handling
The application handles various exceptions, such as:

1. FileNotFoundException: Displays an error message if the specified file path is incorrect.
2. IOException: Catches general I/O errors during file operations.
3. EOFException: Indicates if the end of the file has been reached unexpectedly.

🎊 Thank you for using My Store! Happy ordering! 🎊