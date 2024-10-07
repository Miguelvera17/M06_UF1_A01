import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;

public class Fitxer {

    private static String a;
    private static int count = 0;
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
            while (count < articles.size()) {
                a = a + articles.get(count);
                count++;
                line.write(a);
            }
            line.close();
        }
    }

    public static void createCSV(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\" + "encarrecs_client_" + Botiga.client.getName() + "_"+ System.currentTimeMillis() + ".csv";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
            line.write(Botiga.client.getName() + ";" + Botiga.client.getPhone() + ";" + Botiga.client.getDate());
            while (count < articles.size()) {
                a = a + ";" + articles.get(count).getName() + ";" + articles.get(count).getQuantity() + ";" + articles.get(count).getUnit();
                count++;
                line.write(a);
            }
            line.close();
        }
    }

    public static void createBinari(ArrayList<Article> articles) throws IOException{
        String fileName = "C:\\Users\\accesadades\\" + "encarrecs_client_" + Botiga.client.getName() + "_"+ System.currentTimeMillis() + ".dat";
        File file = new File(fileName);
        try (FileWriter line = new FileWriter(file)) {
            line.write(Botiga.client.getName() + ";" + Botiga.client.getPhone() + ";" + Botiga.client.getDate());
            while (count < articles.size()) {
                a = a + ";" + articles.get(count).getName() + ";" + articles.get(count).getQuantity() + ";" + articles.get(count).getUnit();
                count++;
                line.write(a);
            }
            line.close();
        }
    }
    
    /*  Method void to read the file f1
    public static void read() {
		try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
    
            bufferedReader.close();
            fileReader.close();
    
        } catch (FileNotFoundException e) {
            System.out.println("EL FITXER NO EXISTEIX");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
