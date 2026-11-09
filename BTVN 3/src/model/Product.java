package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    private static int count = 0;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        count++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public static int getCount() {
        return count;
    }

    public void setStock(int stock) {
        if(stock < 0){
            System.out.println("So luong kho phai duong");
        }
        else{
            this.stock = stock;
        }
    }

    public void setPrice(double price) {
        if(price <= 0){
            System.out.println("Gia tien lon hon 0");
        }
        else{
            this.price = price;
        }
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            System.out.println("Ten san pham khong de trong");
        }
        else{
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
