import java.util.Date;

public class Client {
    public static String name;
    public static int phone;
    
    public static Date current = new Date();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }



    public Client(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public static void main (String[] args) {
        System.out.println("Welcome to my store");
        System.out.println("=====================\n");
        System.out.println("What would you want to do? \n new charge [s] \n show a charge [c] \n exit [x]");
        String action = Entrada.readLine();
        if (action.equals("s")) {
            System.out.println("Please complete the following info\n");
        System.out.print("Name: ");
        name = Entrada.readLine();
        System.out.print("Phone: ");
        phone = Integer.parseInt(Entrada.readLine());
        System.out.print("Date: " + current);
        }
        
        
    }
}