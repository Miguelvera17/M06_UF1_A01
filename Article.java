import java.util.ArrayList;

public class Article {

    private String name;
    private String quantity;
    private String unit;
    private static String mensaje = ("Client's name:  " + Client.getName() + "\n" +
            "Client's phone: " + Client.getPhone() + "\n" +
            "Order's date:   " + Client.getDate() + "\n" +
            "Quantity       Units     Article\n"  +
            "============= ========== ===========");
    
    public Article(){}
    
    public Article(String name, String quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static String createAlbaran(ArrayList<Article> articles) {
        int count = 0;
        String a = "";
        while (count < articles.size()) {
                a = a + articles.get(count);
                count++;
        }
        return mensaje + a;
    }

    public static String createCSV(ArrayList<Article> articles) {
        int count = 0;
        String a = "";
        while (count < articles.size()) {
            if (count == 0) {
                a = a + articles.get(count).getName() + ";" + articles.get(count).getQuantity() + ";" + articles.get(count).getUnit() ;
            } else {
                a = a + ";" + articles.get(count).getName() + ";" + articles.get(count).getQuantity() + ";" + articles.get(count).getUnit();
            }
            
            count++;
    }
        return a;
    }

    @Override
    public String toString() {
        return String.format("\n%-10s %-10s %-15s", this.quantity, this.unit, this.name);}

    public String toCSV() {
        return "System.";
    }
}
