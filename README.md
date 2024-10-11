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
Store.java

- Variables estáticas:

1. public static Article article: Representa un artículo en la tienda.
2. public static int num: Cuenta el número de artículos creados (inicia en 1).

- Método main(String[] args): El flujo principal se gestiona aquí. Presenta un menú que permite al usuario elegir entre las siguientes opciones:
````
n) Crear un nuevo pedido.
s) Mostrar un pedido anterior.
x) Salir del sistema.
````
- The menu is shown when the program is launched and runs in a while loop until the user enters the exit option (x).

- Generate a new order (n):

1. Calls Client.createClient() to create a new client.
2. Calls Article.createArticle(client) to generate a list of articles associated with the client.
3. Fitxer.selectDocument(articles, client) allows the user to select the type of document they want to create.

- Show previous order (s):

1. Calls Fitxer.selectReadDocument() to allow the user to select and view a previously saved order document.
2. Input validation: If the user enters an invalid option, an error message is displayed, prompting them to try again.

- Client: Responsible for creating and managing client instances. Provides static methods to initialize clients.

- Article: Manages the creation of articles associated with a client.
    ````
    a) createArticle(Client client) generates a list of articles for a given client.`
    ````
- Fitxer: Handles file operations such as creating and reading documents.
````
    a) selectDocument(ArrayList<Article> articles, Client client) allows the creation of a document based on the articles and client.
    b) selectReadDocument() loads a previously saved document for review.
````
- Entrada: Handles console input. It uses a BufferedReader to read user input from the console (System.in).


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