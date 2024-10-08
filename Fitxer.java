import java.io.*;
import java.util.ArrayList;

public class Fitxer {

    private static String a = "";

    public static void createAlbaran(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".txt";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
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
            System.out.println("\nFAIL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCSV(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".csv";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
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
            System.out.println("\nFAIL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBinari(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Store.client.getName() + "_"+ System.currentTimeMillis() + ".dat";
        File file = new File(fileName);
        FileOutputStream fileStr1 = new FileOutputStream(file);
        try (DataOutputStream line = new DataOutputStream(fileStr1)) {
            line.writeUTF(Store.client.getName());
            line.writeUTF(Store.client.getPhone());
            line.writeUTF(Store.client.getDate());
            for (int i = 0; i < articles.size(); i++) {
                a = articles.get(i).getName() + " " + articles.get(i).getUnit() + " " + articles.get(i).getQuantity();
                line.writeBytes(a);
            }
            line.close();
            fileStr1.close();
            System.out.println("\nDocument created successfully");
        } catch (FileNotFoundException e) {
            System.out.println("\nFAIL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
