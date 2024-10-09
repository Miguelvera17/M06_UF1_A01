import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Fitxer {
    private static String a = "";
    public static void createAlbaran(ArrayList<Article> articles, Client client) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".txt";
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write("Client's name:  " + client.getName() + "\n" +
            "Client's phone: " + client.getPhone() + "\n" +
            "Order's date:   " + client.getDate() + "\n" +
            "\nQuantity       Units     Article\n"  +
            "============= ========== ===========");
            for (int i = 0; i < articles.size(); i++) {
                a = articles.get(i).toString();
                line.write(a);
            }
            line.close();
            System.out.println("\nDocument created successfully");
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCSV(ArrayList<Article> articles, Client client) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".csv";
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write(client.getName() + ";" + client.getPhone() + ";" + client.getDate() + ";");
            for (int i = 0; i < articles.size(); i++) {
                if (i == articles.size()-1) {
                    a = a + Article.toCSV(articles.get(i));
                } else {
                    a = a + Article.toCSV(articles.get(i)) + ";";
                }
            }
            line.write(a);
            line.close();
            System.out.println("\nDocument created successfully");
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBinari(ArrayList<Article> articles, Client client) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + client.getName() + "_"+ System.currentTimeMillis() + ".dat";
        File file = new File(fileName);
        try (FileOutputStream fileStr1 = new FileOutputStream(file)) {
            DataOutputStream line = new DataOutputStream(fileStr1);
            line.writeUTF(client.getName());
            line.writeUTF(client.getPhone());
            line.writeUTF(client.getDate());
            for (int i = 0; i < articles.size(); i++) {
                Article art = articles.get(i);
                line.writeFloat(art.getQuantity());
                line.writeUTF(art.getUnit());
                line.writeUTF(art.getName());
            }
            line.close();
            fileStr1.close();
            System.out.println("\nDocument created successfully");
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, documento no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinari() {
        // Ask for the path of the document you want to read
        System.out.print("\nIndicate the path: ");
        String filePath = Entrada.readLine();
        try (FileInputStream f1 = new FileInputStream(filePath)) {
            DataInputStream f = new DataInputStream(f1);
            System.out.println("\nClient's name: " + f.readUTF());
            System.out.println("Client's phone: " + f.readUTF());
            System.out.println("Order's date: " + f.readUTF());
            System.out.println("\nQuantity       Units     Article\n" + 
                                "============= ========== ===========");
            while (f.available() > 0) {
                System.out.println(String.format(Locale.US, "%-13.1f %-10s %s", f.readFloat(), f.readUTF(), f.readUTF()));
            }
            f.close();
            f1.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, path not correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV () {
        // Ask for the path of the document you want to read
        System.out.print("\nIndicate the path: ");
        String filePath = Entrada.readLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the lines until it finds null 
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
                    if (i+2 < values.length) {
                        String article = values[i];
                        String quantity = values[i + 1];
                        String units = values[i + 2];
                        System.out.println(String.format(Locale.US, "%-12s %-10s %-12s", quantity, units, article));
                    } else {
                        System.out.println("FAIL, an error occurred while reading");
                    }
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, path not correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectDocument(ArrayList<Article> articles , Client client) throws IOException{
        while (true) {
            System.out.println("\nWhich document do you want?:\n" + 
                            "a) Albaran  [a] \n" + 
                            "b) Binary   [b]\n" +
                            "c) CSV \t    [c] \n");
            System.out.print("----> ");
            String select = Entrada.readLine();
            if (select.equals("a")) {
                createAlbaran(articles, client);
                
                break;
            }
            if (select.equals("b")) {
                Fitxer.createBinari(articles, client);
                
                break;
            }
            if (select.equals("c")) {
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

    public static void selectReadDocument() throws IOException {
        System.out.println("\nWhich document do you want read?:\n" +  
                                    "a) Binary   [b]\n" +
                                    "b) CSV \t    [c] \n" +
                                    "c) Exit\t    [x]");
        System.out.print("----> ");
        String ans = Entrada.readLine();
                
        if (ans.equals("b")) {
            Fitxer.readBinari();
        }
        if (ans.equals("c")) {
            Fitxer.readCSV();
        }
        if (ans.equals("x")) {
        }
        if (!ans.equals("b") && !ans.equals("c") && !ans.equals("x")) {
            System.out.println("\n=======================");
            System.out.println("Invalid option\nChoose a correct option");
            System.out.println("=======================");
        }
    }
}
