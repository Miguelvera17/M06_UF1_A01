import java.util.*;

public class Article {

    String name;
    float quantity;
    String unit;

    ArrayList<String> list = new ArrayList<>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Article(String name, float quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Article(){}
    
    public String toString() {
        return "System.";
    }

    public String toCSV() {
        return "System.";
    }
}
