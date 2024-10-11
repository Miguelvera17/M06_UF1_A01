import java.util.ArrayList;
import java.util.Locale;

public class Article {

    private String name;                // name of the article
    private Float quantity;             // quantity of the article/es
    private String unit;                // unit of the quantity
    
    public Article(){}                  // Default constructor 
    
    public Article(String name, Float quantity, String unit) {        // Constructor specific
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {                       // Getter
        return name;
    }

    public void setName(String name) {              // Setter
        this.name = name;
    }

    public Float getQuantity() {                    // Getter
        return quantity;
    }

    public void setQuantity(Float quantity) {       // Setter
        this.quantity = quantity;
    }

    public String getUnit() {                       // Getter
        return unit;
    }

    public void setUnit(String unit) {              // Setter
        this.unit = unit;
    }

    public static ArrayList<Article> createArticle(Client client) {             // Method to create a list of articles for each client
        int num = 1;
        ArrayList<Article> articles = new ArrayList<>();
        System.out.println("\nIndicate your order");
        String loop = "y";
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
                    System.out.println("\nQuantity no valid, try again\n");
                }
            }           
                System.out.print("Unit:\t    ");
                String unit = Entrada.readLine();
                System.out.println("================================");
                client.articles = new Article(articleName,quantity,unit);
                articles.add(client.articles);
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
        return articles;
    }

    @Override
    public String toString() {                                                  // Give a special format
        return String.format(Locale.US,"\n%-13.1f %-10s %-15s", this.quantity, this.unit, this.name);}

    public static String toCSV(Article article) {                               // Give format of csv
        String a = article.getName() + ";" + article.getQuantity() + ";" + article.getUnit();
        return a;
    }
}
