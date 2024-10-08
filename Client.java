public class Client {

    public String name;
    public String phone;
    public String date;
    public Article article;

    public Client() {}

    public Client(String name, String phone, String date) {
        this.name = name;
        this.phone = phone;
        this.date = date;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static Client createClient() {
        System.out.print("\n" +
                                "======= Client information =======\n" +
                                "Name:\t\t");
                String name = Entrada.readLine();
                System.out.print("Phone:\t\t");
                String phone = Entrada.readLine();
                System.out.print("Order's date:\t");
                String date = Entrada.readLine();
                System.out.println("==================================");
                Client client = new Client(name,phone,date);
                return client;
    }

}
