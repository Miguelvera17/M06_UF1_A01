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
# 🏬 Store.java

- Static variables:

1. public static Article article: Representa un artículo en la tienda.
2. public static int num: Count the number of articles (start in 1).

- Método main(String[] args): The main flow is managed here. 
````
n) Generate new order.
s) Show a order.
x) Exit.
````
- The menu is shown when the program is launched and runs in a while loop until the user enters the exit option (x).

- Generate a new order (n):

1. Calls Client.createClient() to create a new client.
2. Calls Article.createArticle(client) to generate a list of articles associated with the client.
3. Fitxer.selectDocument(articles, client) allows the user to select the type of document they want to create.

- Show previous order (s):

1. Calls Fitxer.selectReadDocument() to allow the user to select and view a previously saved order document.
2. Input validation: If the user enters an invalid option, an error message is displayed, prompting them to try again.

# 👦👧 Client.java

1. Attributes
````
a) public String name: Stores the name of the client.
b) public String phone: Stores the client's phone number.
c) public String date: Stores the date associated with the client's order.
d) public Article articles: Represents the articles associated with the client (though it seems to be a single Article, this might need to be an ArrayList<Article> for multiple articles).
````
2. Constructors
````
a) Default Constructor: public Client() {} This constructor allows the creation of a Client object without initializing its attributes.
b) Specific: This constructor initializes the name, phone, and date attributes with the provided values when a Client object is created.
````
3. Getter and Setter 
````
Getters:

a) public String getName() returns the client's name.
b) public String getPhone() returns the client's phone number.
c) public String getDate() returns the order date.

Setters:

a) public void setName(String name) updates the client's name.
b)public void setPhone(String phone) updates the client's phone number.
c) public void setDate(String date) updates the order date.
````
4. Method to Create a New Client
````
a) public static Client createClient(): This static method prompts the user to enter the client's information via the console. It performs the following steps:

- Prints a header for client information.
- Asks the user to input the client's name, phone number, and order date using Entrada.readLine(), which likely reads input from the console.
- Displays a line indicating the end of input.
- Creates a new Client object using the provided information and returns it
````
# Article: 

1. Attributes
````
a) private String name: Holds the name of the article.
b) private Float quantity: Represents the quantity of the article. It is a Float to allow for decimal values (e.g., 1.5 kg).
c)private String unit: Specifies the unit of measurement for the quantity (e.g., kg, liters).
````
2. Constructors
````
a) Default : This constructor allows creating an Article object without initializing its attributes.
b) Specific : This constructor initializes the name, quantity, and unit attributes with the provided values when a new Article object is created.
````
3. Getter and Setter 
The class provides getter and setter methods for each attribute, allowing controlled access and modification:
````
Getters:

a) public String getName(): Returns the name of the article.
b) public Float getQuantity(): Returns the quantity of the article.
c) public String getUnit(): Returns the unit of measurement.

Setters:

a) public void setName(String name): Updates the name of the article.
b) public void setQuantity(Float quantity): Updates the quantity of the article.
c) public void setUnit(String unit): Updates the unit of measurement.
````
4. Method to Create a List of Articles
````
a )public static ArrayList<Article> createArticle(Client client): This static method allows users to create a list of articles associated with a client. Here’s how it works:
````

5. Method for String Representation
````
a) public String toString(): This method provides a custom string representation of the Article object, formatted for output. It uses String.format to ensure that the output is neatly aligned.
````
6. Method for CSV Format
````
a) public static String toCSV(Article article): This static method converts an Article object to a CSV (Comma-Separated Values) format string, which is useful for exporting data. It concatenates the article's name, quantity, and unit, separated by semicolons.
````

# Fitxer


# Entrada

1. private static BufferedReader reader: static instance of BufferedReader that is initialized to read from System.in.
2. public static String readLine(): read a full line of text input from the console.
3. IOException Handling: enclosed a try-catch block to handle potential IOException that can occur during input reading.
4. IOException: throws a RuntimeException with the original exception as its cause, ensuring that any issues are propagated up the call stack.


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