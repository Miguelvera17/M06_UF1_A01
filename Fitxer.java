import java.io.*;
import java.util.ArrayList;

public class Fitxer {

    private static String a = "";
    private static String mensaje = ("Client's name:  " + Botiga.client.getName() + "\n" +
            "Client's phone: " + Botiga.client.getPhone() + "\n" +
            "Order's date:   " + Botiga.client.getDate() + "\n" +
            "Quantity       Units     Article\n"  +
            "============= ========== ===========");

    public static void createAlbaran(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Botiga.client.getName() + "_"+ System.currentTimeMillis() + ".txt";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
            line.write(mensaje);
            for (int i = 0; i < articles.size(); i++) {
                a = articles.get(i).toString();
                line.write(a);
            }
            line.close();
        } catch (FileNotFoundException e) {
            System.out.println("The document no exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCSV(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Botiga.client.getName() + "_"+ System.currentTimeMillis() + ".csv";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
            line.write(Botiga.client.getName() + ";" + Botiga.client.getPhone() + ";" + Botiga.client.getDate() + ";");
            for (int i = 0; i < articles.size(); i++) {
                if (i == articles.size()-1) {
                    a = a + Article.toCSV(articles.get(i));
                } else {
                    a = a + Article.toCSV(articles.get(i)) + ";";
                }
            }
            line.write(a);
            line.close();
        } catch (FileNotFoundException e) {
            System.out.println("The document no exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBinari(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\accesadades\\" + "encarrecs_client_" + Botiga.client.getName() + "_"+ System.currentTimeMillis() + ".dat";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
            line.write(Botiga.client.getName() + ";" + Botiga.client.getPhone() + ";" + Botiga.client.getDate());
            for (int i = 0; i < articles.size(); i++) {
                a = a + Article.toCSV(articles.get(i));
            }
            line.write(a);
            line.close();
        } catch (FileNotFoundException e) {
            System.out.println("The document no exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
