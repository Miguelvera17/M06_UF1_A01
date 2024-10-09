import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Fitxer {
    private static String a = "";
    public static void createAlbaran(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".txt";
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write("Client's name:  " + Store.client.getName() + "\n" +
            "Client's phone: " + Store.client.getPhone() + "\n" +
            "Order's date:   " + Store.client.getDate() + "\n" +
            "Quantity       Units     Article\n"  +
            "============= ========== ===========");
            for (int i = 0; i < articles.size(); i++) {
                a = articles.get(i).toString();
                line.write(a);
            }
            line.close();
            System.out.println("\nDocument created successfully");
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL, document no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCSV(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".csv";
        File file = new File(fileName);
        try (BufferedWriter line = new BufferedWriter(new FileWriter(file))) {
            line.write(Store.client.getName() + ";" + Store.client.getPhone() + ";" + Store.client.getDate() + ";");
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
            System.out.println("\nFAIL, document no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBinari(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".dat";
        File file = new File(fileName);
        try (FileOutputStream fileStr1 = new FileOutputStream(file)) {
            DataOutputStream line = new DataOutputStream(fileStr1);
            line.writeUTF(Store.client.getName());
            line.writeUTF(Store.client.getPhone());
            line.writeUTF(Store.client.getDate());
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
            System.out.println("\nFAIL, document no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinari() {
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
            System.out.println("\nFAIL, document no created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV () {
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
    }
}
