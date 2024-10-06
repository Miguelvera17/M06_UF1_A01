import java.io.*;


public class Botiga {
    
    public static Client client = new Client();
    public static Article article = new Article();
    public static int num = 1;
    public static String loop = "y";
    static String f1 = "C:\\Users\\migue\\Documents\\Media TIC\\M06\\M06_UF1_A01\\file.txt" ;
    private static Article[] articleArray = new Article[100];

    public static void main (String[] args) throws IOException {
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

                Article art = new Article(articleName,quantity,unit);
                articleArray[num-1] = art;
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
                writeStream(Article.createAlbaran(articleArray, num));
                System.out.println("Printed document");
            }
            if (opt.equals("b")) {
                System.out.println("Document created successfully");
            }
            if (opt.equals("c")) {
                System.out.println("Document created successfully");
            }
            
        }    
        if (action.equals("s")) {

        }
        if (action.equals("x")) {
            System.out.println("\nBye\n");
        }
    }
    public static void writeStream(String document) {
		try {
			FileOutputStream file = new FileOutputStream(f1);
			DataOutputStream str1 = new DataOutputStream(file); 
			str1.writeBytes(document);
			str1.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL FITXER NO EXISTEIX");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private static void readStream() {
		try {
			FileInputStream fileStr1_inp = new FileInputStream(f1);
			
			DataInputStream str2 = new DataInputStream(fileStr1_inp);
			
            int i = 0;

			while (str2.available()>0) {
				int k = str2.readInt();
				System.out.println("el nombre contingut a la posició ["+ i + "] de l'array és: " +k);
                i++;
			}

			str2.close();

			fileStr1_inp.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("EL FITXER NO EXISTEIX");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}