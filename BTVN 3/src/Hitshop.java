import  model.Product;
import model.Customer;
import model.CartItem;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Hitshop {

    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");

    private static final List<CartItem> cart = new ArrayList<>();

    static void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        cart.add(item);
        System.out.println("Them mat hang vao gio");
    }

    static void removeItem(int index) {
        index = index -1;
        if (index >= 0 && index < cart.size()) {
            cart.remove(index);
            System.out.println("Da xoa mat hang");
        } else {
            System.out.println("Khong tim thay");
        }
    }

    static void printItems(){
        System.out.println("Khach hang hien tai: " + currentCustomer);

        if(cart.isEmpty()){
            System.out.println("Gio hang dang trong");
            return;
        }
        for(int i = 0; i < cart.size(); i++){
            CartItem item = cart.get(i);
            Product product = item.getProduct();
            System.out.println( (i + 1) + ". " +
                    item.getProduct().getId() + " | " +
                    item.getProduct().getName() + " | " +
                    item.getProduct().getPrice() + " | " +
                    "SL: " + item.getQuantity() + " | " +
                    "Tồn kho: " + item.getProduct().getStock() + " | " +
                    "Thành tiền: " + item.getTotal());
        }
    }

    static double calculateTotal(){
        double t = 0;

        for(int i = 0; i < cart.size(); i++){
            t += cart.get(i).getTotal();
        }

        return t;
    }

    static void printMenu(){
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("so san pham da tao: " + Product.getCount());

        Product p1 = new Product("P01", "Ao thun", 150000, 20 );
        Product p2 = new Product("P02", "Binh nuoc", 50000, 10);

        int choice;

        do {
            printMenu();
            System.out.println("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Danh sach san pham:");
                    System.out.println("P01 - Ao thun - 150000");
                    System.out.println("P02 - Binh nuoc - 50000");

                    System.out.print("Nhap ma san pham: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap so luong: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if (id.equals("P01")) {
                        addItem(p1, quantity);
                    } else if (id.equals("P02")) {
                        addItem(p2, quantity);
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;

                case 2:
                    System.out.print("Nhap so thu tu mat hang can xoa: ");
                    removeItem(sc.nextInt());
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
            System.out.println();

        }while(choice != 0);

        sc.close();
    }
}