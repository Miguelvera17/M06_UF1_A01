import java.io.*;
import java.util.ArrayList;


public class Botiga {
    
    public static Client client = new Client();
    public static Article article = new Article();
    public static int num = 1;
    public static String loop = "y";
    static String f1 = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\file.txt" ;

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
                            "Select your request: ");
        String action = Entrada.readLine();
        // Verify is the option is correct, "x" to exit
        while (!action.equals("x")) {
            // Option to generate a new order
            if (action.equals("n")) {
                System.out.print("\n" +
                                "======= Client information =======\n" +
                                "Name:\t");
                String name = Entrada.readLine();
                client.setName(name);
                System.out.print("Phone:\t");
                String phone = Entrada.readLine();
                client.setPhone(phone);
                System.out.print("Date:\t");
                String date = Entrada.readLine();
                client.setDate(date);
                System.out.println("==================================");
                System.out.println("\nIndicate your order");
                while (loop.equals("y") ) {
                    System.out.println("\n=========== Article " + num + " ==========");
                    System.out.print("Article/es: ");
                    String articleName = Entrada.readLine();
                    System.out.print("Quantity:   ");
                    String quantity = Entrada.readLine();
                    System.out.print("Unit:\t    ");
                    String unit = Entrada.readLine();
                    System.out.println("================================");
    
                    Article article = new Article(articleName,quantity,unit);
                    articles.add(article);
                    System.out.println("\nWould you like to add more articles? [y] [n]\n" );
                    loop = Entrada.readLine();
                    num++;
                }
                
                System.out.print("\nWhich document you want?:\n" + 
                                    "a) Albaran  [a] \n" + 
                                    "b) Binary   [b]\n" +
                                    "c) CSV \t    [c] \n" +
                                    "\nSelect your option: ");
                
                String opt = Entrada.readLine();
                
                if (opt.equals("a")) {
                    write(Article.createAlbaran(articles));
                    System.out.println("\nPrinted document");
                    break;
                }
                if (opt.equals("b")) {
                    write(Article.createCSV(articles));
                    System.out.println("Document created successfully");
                    break;
                }
                if (opt.equals("c")) {
                    System.out.println("Document created successfully");
                    break;
                }
                
            }
            //Option to show a previus order   
            if (action.equals("s")) {
                read();
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
                            "Select your request: ");
                action = Entrada.readLine();
            }
        }
        System.out.println("\nBye");
    }

    // Method void to write in file f1
    public static void write(String document) {
		try {
			FileOutputStream file = new FileOutputStream(f1);
			DataOutputStream str1 = new DataOutputStream(file); 
			str1.writeUTF(document);
			str1.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The document not exits");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    // Method void to read the file f1
    public static void read() {
		try {
            FileReader fileReader = new FileReader(f1);
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
    }
}