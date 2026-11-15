package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    private static int count = 0;

    public Product(String id, String name, double price, int stock) {

        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("Ma khong duoc trong");
        }

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Ten khong duoc trong");
        }

        if(price <= 0){
            throw new IllegalArgumentException("Gia phai lon hon 0");
        }

        if(stock <= 0){
            throw new IllegalArgumentException("So luong khong duoc am");
        }

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

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Gia phai lon hon 0");
        }
        else{
            this.price = price;
        }
    }

    public void decreaseStock(int quantity){
        if(quantity <= 0 || quantity > stock){
            throw new IllegalArgumentException("So luong khing hop le");
        }
        stock -= quantity;
    }

    public String getDescription(){
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | ton: " + stock;
    }
}