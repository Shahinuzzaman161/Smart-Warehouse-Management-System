interface User {
    void showUserRole();
    String getUserName();
}

class Admin implements User {
    private String adminName;

    public Admin(String name) {
        this.adminName = name;
    }

    @Override
    public void showUserRole() {
        System.out.println("Role: System Administrator");
    }

    @Override
    public String getUserName() {
        return adminName;
    }
}

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract void calculateTax();
    
    public void displayInfo() {
        System.out.println("Product: " + name + " | Base Price: " + price);
    }
}

class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public void calculateTax() {
        double tax = getPrice() * 0.15;
        System.out.println("Total Price (with 15% Tax): " + (getPrice() + tax));
    }
}

class Food extends Product {
    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public void calculateTax() {
        double tax = getPrice() * 0.05;
        System.out.println("Total Price (with 5% Tax): " + (getPrice() + tax));
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        User admin = new Admin("Md.Shahinuzzaman");
        
        System.out.println("Logged in as: " + admin.getUserName());
        admin.showUserRole();
        
        Product laptop = new Electronics("Laptop", 80000);
        Product apple = new Food("Apple (1kg)", 250);

        System.out.println("\n Inventory Details ");
        laptop.displayInfo();
        laptop.calculateTax();

        System.out.println("\n Inventory Details ");
        apple.displayInfo();
        apple.calculateTax();
    }
}
