import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Fitxer {
    private static String a = "";
    public static void createAlbaran(ArrayList<Article> articles, Client client) throws IOException{    //Method to create a delivery note
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".txt";//select your path
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write("Client's name:  " + client.getName() + "\n" +
            "Client's phone: " + client.getPhone() + "\n" +
            "Order's date:   " + client.getDate() + "\n" +                    // Write the client's information  
            "\nQuantity       Units     Article\n"  +
            "============= ========== ===========");
            for (int i = 0; i < articles.size(); i++) {                       // Read all the articles of the client
                a = articles.get(i).toString(); 
                line.write(a);                                                // Write the list of articles
            }
            line.close();
            System.out.println("\nDocument created successfully");          // The document is created
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");             // The document isn't created
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCSV(ArrayList<Article> articles, Client client) throws IOException{  //Method to create a file in CSV
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".csv";//select your path
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write(client.getName() + ";" + client.getPhone() + ";" + client.getDate() + ";");      // Write the client's information
            for (int i = 0; i < articles.size(); i++) {                       // Read all the articles of the client
                if (i == articles.size()-1) {
                    a = a + Article.toCSV(articles.get(i));                   // Accumulate
                } else {
                    a = a + Article.toCSV(articles.get(i)) + ";";             // Accumulate 
                }
            }
            line.write(a);                                                    // Write the line
            line.close();                                                     // Close the line
            System.out.println("\nDocument created successfully");          // The document is created
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");             // The document isn't created
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBinari(ArrayList<Article> articles, Client client) throws IOException{     //Method to create a file in binary
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".dat";//select your path
        File file = new File(fileName);
        try (FileOutputStream fileStr1 = new FileOutputStream(file)) {
            DataOutputStream line = new DataOutputStream(fileStr1);
            line.writeUTF(client.getName());                                // Write the name of the client (String)
            line.writeUTF(client.getPhone());                               // Write the phone of the client (String)
            line.writeUTF(client.getDate());                                // Write the date (String)
            for (int i = 0; i < articles.size(); i++) {
                Article art = articles.get(i);
                line.writeFloat(art.getQuantity());                         // Write the quantity (Float)
                line.writeUTF(art.getUnit());                               // Write the units (String)
                line.writeUTF(art.getName());                               // Write the name of the article (String)
            }
            line.close();
            fileStr1.close();
            System.out.println("\nDocument created successfully");      // The document is created
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");         // The document isn't created
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinari() {
        // Ask for the path of the document you want to read
        System.out.print("\nIndicate the path: ");                           // Ask for the path
        String filePath = Entrada.readLine();
        try (FileInputStream f1 = new FileInputStream(filePath)) {
            DataInputStream f = new DataInputStream(f1);
            System.out.println("\nClient's name: " + f.readUTF());              // Print name of the client (String)
            System.out.println("Client's phone: " + f.readUTF());               // Print phone of the client (String)
            System.out.println("Order's date: " + f.readUTF());                 // Print date (String)
            System.out.println("\nQuantity       Units     Article\n" + 
                                    "============= ========== ===========");

            System.out.println(String.format(Locale.US, "%-13.1f %-10s %s", f.readFloat(), f.readUTF(), f.readUTF()));  // Print the list of article (Flaot, String, String)
            f.close();
            f1.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, path not correct");         // The document is not found
            
        } 
        catch (EOFException e) {
            System.out.println("\nFAIL, incorrect document");       // Not correct extension
        }
        catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static void readCSV () {
        // Ask for the path of the document you want to read
        System.out.print("\nIndicate the path: ");                          // Ask for the path
        String filePath = Entrada.readLine();
        if (filePath.endsWith(".csv")) {                               // Check the suffix
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;

                // Read the lines until it finds null 
                while ((line = br.readLine()) != null) {

                    // Separate the values by ";"
                    String[] values = line.split(";");
                    String clientName = values[0];
                    String clientPhone = values[1];
                    String orderDate = values[2];
                    System.out.println("\nClient's name:  " + clientName);      // Print name of the client (String)
                    System.out.println("Client's phone: " + clientPhone);       // Print phone of the client (String)
                    System.out.println("Order's date:   " + orderDate);         // Print date (String)
                    System.out.println(String.format("%-12s %-10s %-12s", "Quantity", "Units", "Article"));
                    System.out.println(String.format("=========== ========== ==========="));
                    for (int i = 3; i < values.length; i += 3) {
                        String article = values[i];
                        String quantity = values[i + 1];
                        String units = values[i + 2];
                        System.out.println(String.format(Locale.US, "%-12s %-10s %-12s", quantity, units, article));    // Print the list of article (Flaot, String, String)
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\nFAIL, path not correct");         // The document is not found
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nFAIL, incorrect document");           // Not correct extension
        }
    }

    public static void selectDocument(ArrayList<Article> articles , Client client) throws IOException{      // Method to create a document
        while (true) {
            System.out.println("\nWhich document do you want?:\n" + 
                            "a) Albaran  [a] \n" + 
                            "b) Binary   [b]\n" +
                            "c) CSV \t    [c] \n");
            System.out.print("----> ");
            String select = Entrada.readLine();
            if (select.equals("a")) {                           // to create a delivery note
                createAlbaran(articles, client);
                
                break;
            }
            if (select.equals("b")) {                           // to create a binary file
                Fitxer.createBinari(articles, client);
                
                break;
            }
            if (select.equals("c")) {                           // to create a .csv file
                Fitxer.createCSV(articles, client);

                break;
            }
            if(!select.equals("a") && !select.equals("b") && !select.equals("c")) {
                System.out.println("\n=======================");
                System.out.println("Invalid option\nChoose a correct option");
                System.out.println("======================="); 
            }
        }
    }

    public static void selectReadDocument() throws IOException {            // Method to choose which document you want to read
        System.out.println("\nWhich document do you want read?:\n" +  
                                    "a) Binary   [b]\n" +
                                    "b) CSV \t    [c] \n" +
                                    "c) Exit\t    [x]");
        System.out.print("----> ");
        String ans = Entrada.readLine();
                
        if (ans.equals("b")) {                                      // [b] to read a binary file
            Fitxer.readBinari();
        }
        if (ans.equals("c")) {                                      // [c] to read a .CSV file
            Fitxer.readCSV();
        }
        if (ans.equals("x")) {                                      // [x] to exit
        }
        if (!ans.equals("b") && !ans.equals("c") && !ans.equals("x")) {
            System.out.println("\n=======================");
            System.out.println("Invalid option\nChoose a correct option");
            System.out.println("=======================");
        }
    }
}
