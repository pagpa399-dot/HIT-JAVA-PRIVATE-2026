package model;

public class Customer {
    private String id;
    private String name;
    private String phone;

    public Customer(String id, String name, String phone) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Mã khách hàng không được rỗng");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tên khách hàng không được rỗng");
        }
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone;
    }
}