import java.util.*;

public class Article {

    static String name;
    static String quantity;
    static String unit;
    ArrayList<String> list = new ArrayList<>();
    
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

    public Article(String name, String quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Article(){}

    public static String createAlbaran(Article[] array, int num) {
        String mensaje = ("Nom del client: " + Client.getName() + "\n" +
        "Telefon del client: " + Client.getPhone() + "\n" +
        "Data de l'encarrec: " + Client.getDate() + "\n" +
        "Quantitat   	Unitats	    Article\n" +
        "====================================\n");
        String s = "";
        for (int i = 0; i < num; i++) {
            s = s + array[i].getName() + array[i].getQuantity() + array[i].getUnit() + "\n";
        }
        return mensaje + s;
    }

    public String toString() {
        return String.format("\n    Vi: %s\n    Preu: %d\n    Estoc: %d\n" + //
                        "", this.name, this.quantity, this.unit);
    }

    public String toCSV() {
        return "System.";
    }
}
