public class OrderManagementSystem {
    public static void main(String[] args) {

    }
}

enum ItemTypes {
    BEVERAGE, PASTRY;
}

interface Orderable {
    double getPrice();
}

abstract class MenuItem implements Orderable {
    String name;
    double price;
    ItemTypes itemType;

    public MenuItem(String name, double price, ItemTypes itemType) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Beverage extends MenuItem {

    public Beverage(String name, double price, String size, boolean isIced) {
        super(name, price, ItemTypes.BEVERAGE);

    }
}