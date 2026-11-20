package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<CartItem> items;
    private String status;

    public Order(Customer customer, String id) {
        this.customer = customer;
        this.id = id;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void addItem(CartItem item){
        if(item == null){
            throw new IllegalArgumentException("Không hợp lệ");
        }

        items.add(item);
    }

    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void confirm(){
        if(status.equals("PENDING")){
            status = "CONFIRMED";
        }
    }

    public void cancel(){
        if(status.equals("PENDING")){
            status = "CANCELLED";
        }
    }
}

