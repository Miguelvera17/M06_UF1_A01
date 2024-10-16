import java.io.*;
import java.util.ArrayList;

public class Store {
    
    public static Article article;  // declare an article
    public static int num = 1;      // count the number of articles
    
    public static void main (String[] args) throws IOException {
        System.out.print("Welcome to my store!!\n" +
                            "=====================\n" + 
                            "\n" +
                            "What would you like to do? \n" + 
                            "a) Generate new order   [n] \n" + 
                            "b) Show a order \t[s] \n" + 
                            "c) Exit\t\t\t[x]\n" + 
                            "\n" +
                            "----> ");
        String action = Entrada.readLine();
        while (!action.equals("x")) {                                   // Type [x] to exit
            if (action.equals("n")) {                                   // Type [n] to generate a new order
                Client client = Client.createClient();                           // Create a new client
                ArrayList<Article> articles = Article.createArticle(client);     // Create a list of articles for the client
                Fitxer.selectDocument(articles, client);                         // Select the document you want to create
            }
            if (action.equals("s")) {                                   // Type [s] to show a previus order
                Fitxer.selectReadDocument();                                     // Select the document you want to read
            }
            if (!action.equals("s") && !action.equals("n")) {  // If the option is not correct, it will ask again to choose the correct one.
                System.out.println("\n=======================");
                System.out.println("Invalid option\nChoose a correct option");
                System.out.println("=======================");
                System.out.print("\n" +
                            "What would you like to do? \n" + 
                            "a) Generate new order   [n] \n" + 
                            "b) Show a order \t[s] \n" + 
                            "c) Exit\t\t\t[x]\n" + 
                            "\n" +
                            "----> ");
                action = Entrada.readLine();
            }
            System.out.print("\n" +
                            "What would you like to do? \n" + 
                            "a) Generate new order   [n] \n" + 
                            "b) Show a order \t[s] \n" + 
                            "c) Exit\t\t\t[x]\n" + 
                            "\n" +
                            "----> ");
            action = Entrada.readLine();
        }
        System.out.println("\nBye\n");
    }
}