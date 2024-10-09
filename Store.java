import java.io.*;
import java.util.ArrayList;

public class Store {
    
    public static Client client;
    public static Article article;
    public static int num = 1;
    public static String loop = "y";
    

    public static void main (String[] args) throws IOException {
        ArrayList<Article> articles = new ArrayList<>();
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
        // Verify is the option is correct, "x" to exit
        while (!action.equals("x")) {
            // Option to generate a new order
            if (action.equals("n")) {
                System.out.print("\n" +
                                "======= Client information =======\n" +
                                "Name:\t");
                String name = Entrada.readLine();
                System.out.print("Phone:\t");
                String phone = Entrada.readLine();
                System.out.print("Date:\t");
                String date = Entrada.readLine();
                System.out.println("==================================");
                client = new Client(name,phone,date);
                System.out.println("\nIndicate your order");
                while (loop.equals("y") ) {
                    System.out.println("\n=========== Article " + num + " ==========");
                    System.out.print("Article/es: ");
                    String articleName = Entrada.readLine();
                    float quantity = 0; //Initialize quantity
                    boolean validQuantity = false; // To verify  if quantity is valid
                    while (!validQuantity) {
                        System.out.print("Quantity:   ");
                        String quantityInput = Entrada.readLine();
                        
                        try {
                            quantity = Float.parseFloat(quantityInput);
                            validQuantity = true; 
                        } catch (NumberFormatException e) {
                            System.out.println("\nQuantity no valid, try again\n");
                        }
                    }
                    System.out.print("Unit:\t    ");
                    String unit = Entrada.readLine();
                    System.out.println("================================");
                    client.article = new Article(articleName,quantity,unit);
                    articles.add(client.article);
                    while (true) {
                        System.out.println("\nWould you like to add more articles? [y] [n]" );
                        System.out.print("----> " );
                        loop = Entrada.readLine();
                        if (loop.equals("n")) {
                            break;
                        }
                        if (loop.equals("y")) {
                            num++;
                            break;
                        } else {
                            System.out.println("\nNo valid, choose a correct option\n");
                        }
                    }
                }
                
                while (true) {
                    System.out.println("\nWhich document do you want?:\n" + 
                                    "a) Albaran  [a] \n" + 
                                    "b) Binary   [b]\n" +
                                    "c) CSV \t    [c] \n");
                    System.out.print("----> ");
                    String opt = Entrada.readLine();
                    if (opt.equals("a")) {
                        Fitxer.createAlbaran(articles);
                        
                        break;
                    }
                    if (opt.equals("b")) {
                        Fitxer.createBinari(articles);
                        
                        break;
                    }
                    if (opt.equals("c")) {
                        Fitxer.createCSV(articles);
    
                        break;
                    }
                    if(!opt.equals("a") && !opt.equals("b") && !opt.equals("c")) {
                        System.out.println("\n=======================");
                        System.out.println("Invalid option\nChoose a correct option");
                        System.out.println("======================="); 
                    }
                }
                break;
            }
            //Option to show a previus order   
            if (action.equals("s")) {
                System.out.println("\nWhich document do you want read?:\n" +  
                                    "a) Binary   [b]\n" +
                                    "b) CSV \t    [c] \n" +
                                    "c) Exit\t    [x]");
                System.out.print("----> ");
                String ans = Entrada.readLine();
                
                if (ans.equals("b")) {
                    Fitxer.readBinari();
                    break;
                }
                if (ans.equals("c")) {
                    Fitxer.readCSV();
                    break;
                }
                if (ans.equals("x")) {
                    break;
                }
                System.out.println("\n=======================");
                System.out.println("Invalid option\nChoose a correct option");
                System.out.println("=======================");
            }
            // If the option is not correct will ask again to choose the correct
            else {
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
        }
        System.out.println("\nBye\n");
    }
}