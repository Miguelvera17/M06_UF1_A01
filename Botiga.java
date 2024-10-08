import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Botiga {
    
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
                            System.out.println("\nNumber no valid, try again\n");
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
                
                System.out.println("\nWhich document you want?:\n" + 
                                    "a) Albaran  [a] \n" + 
                                    "b) Binary   [b]\n" +
                                    "c) CSV \t    [c] \n");
                System.out.print("----> ");
                String opt = Entrada.readLine();
                
                if (opt.equals("a")) {
                    Fitxer.createAlbaran(articles);
                    System.out.println("\nPrinted document");
                    break;
                }
                if (opt.equals("b")) {
                    
                    System.out.println("\nDocument created successfully");
                    break;
                }
                if (opt.equals("c")) {
                    Fitxer.createCSV(articles);
                    System.out.println("\nDocument created successfully");
                    break;
                }
            }
            //Option to show a previus order   
            if (action.equals("s")) {
                System.out.print("\nIndicate the path: ");
                String filePath = Entrada.readLine();
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;

                    // Read the lines 
                    while ((line = br.readLine()) != null) {

                        // Separate the values by ";"
                        String[] values = line.split(";");
                        String clientName = values[0];
                        String clientPhone = values[1];
                        String orderDate = values[2];
                        System.out.println("\nClient's name:  " + clientName);
                        System.out.println("Client's phone: " + clientPhone);
                        System.out.println("Order's date:   " + orderDate);
                        System.out.println(String.format("%-12s %-10s %-12s", "Quantity", "Units", "Article"));
                        System.out.println(String.format("=========== ========== ==========="));
                        for (int i = 3; i < values.length; i += 3) {
                            String article = values[i];
                            String quantity = values[i + 1];
                            String units = values[i + 2];
        
                            // Imprimir la información del artículo
                            System.out.println(String.format(Locale.US, "%-12s %-10s %-12s", quantity, units, article));
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
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