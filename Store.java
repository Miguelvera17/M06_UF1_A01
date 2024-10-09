import java.io.*;
import java.util.ArrayList;

public class Store {
    
    public static Article article;
    public static int num = 1;
    
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
        // Option to exit
        while (!action.equals("x")) {
            // Option to generate a new order
            if (action.equals("n")) {
                // Create a new client
                Client client = Client.createClient();
                // Create a list of articles for the client
                ArrayList<Article> articles = Article.createArticle(client);
                // Select the document you want to create
                Fitxer.selectDocument(articles, client);
            }
            //Option to show a previus order   
            if (action.equals("s")) {
                // Select the document you want to read
                Fitxer.selectReadDocument();
                
            }
            // If the option is not correct, it will ask again to choose the correct one.
            if (!action.equals("s") && !action.equals("n")) {
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