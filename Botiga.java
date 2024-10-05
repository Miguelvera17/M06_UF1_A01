

public class Botiga {
    
    public static Client client = new Client();
    public static Article article = new Article();
    public static int num = 1;
    public static String loop = "y";

    public static void main (String[] args) {
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
            while (loop.equals("y") ) {
                System.out.println("\nIndicate your order\n" +
                                "\n" + "=========== Article " + num + " ==========");
                System.out.print("Article/es: ");
                String articleName = Entrada.readLine();
                article.setName(articleName);
                System.out.print("Quantity:   ");
                float quantity = Float.parseFloat(Entrada.readLine());
                article.setQuantity(quantity);
                System.out.print("Unit:\t    ");
                String unit = Entrada.readLine();
                article.setUnit(unit);
                System.out.println("================================");
                System.out.println("\nWould you like to add more articles? [y] [n]\n" );
                loop = Entrada.readLine();
                num++;
            }
            System.out.print("\nWhich document you want?:\n" + 
                                "a) Albaran  [a] \n" + 
                                "b) Binary   [b]\n" +
                                "c) CSV \t    [c] \n" +
                                "\nSelect your option: ");
            String docu = Entrada.readLine();
            if (docu.equals("a")) {

            }
            if (docu.equals("b")) {

            }
            if (docu.equals("c")) {

            }
        }    
        if (action.equals("s")) {

        }
        if (action.equals("x")) {
            System.out.println("\nBye\n");
        }
    }
}