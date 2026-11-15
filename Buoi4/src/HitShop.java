import  model.Product;
import model.Customer;
import model.CartItem;
import model.Book;
import model.Order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {

    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");

    private static final List<CartItem> cart = new ArrayList<>();

    private static final List<Product> products = new ArrayList<>();

    private static final Product p1 = new Product("P01", "Ao thun", 150000, 20 );
    private static final Product p2 = new Product("P02", "Binh nuoc", 50000, 10);

    private static final Book p3 = new Book("P03", "Java cơ bản", 120000, 5, "An Nguyen");


//    static void addItem(Product product, int quantity) {
//        CartItem item = new CartItem(product, quantity);
//        cart.add(item);
//        System.out.println("Them mat hang vao gio");
//

    static void addItems(Scanner sc) {
        System.out.print("Nhap ma san pham: ");
        String id = sc.nextLine();

        Product product = null;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equalsIgnoreCase(id)) {
                product = products.get(i);
                break;
            }
        }

        if (product == null) {
            System.out.println("Khong tim thay san pham!");
            return;
        }

        System.out.print("Nhap so luong: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("So luong khong hop le!");
            return;
        }

        cart.add(new CartItem(product, quantity));

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
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
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
        System.out.println("5. printCatalog");
        System.out.println("6. Kiem tra don hang");
        System.out.println("0. Thoát");
    }

    static void printCatalog() {

        System.out.println("----DANH SACH SAN PHAM----");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getDescription());
        }
    }

    static void testOrder() {

        Order order = new Order(currentCustomer, "O01");

        order.addItem(new CartItem(p1, 2));
        order.addItem(new CartItem(p2, 1));

        order.confirm();
        System.out.println("Trang thai: " + order.getStatus());

        order.cancel();
        System.out.println("Sau khi huy: " + order.getStatus());
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    products.add(p1);
    products.add(p2);
    products.add(p3);

    System.out.println("so san pham da tao: " + Product.getCount());

    int choice;

    do {
        printMenu();
        System.out.println("Chọn: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
//
            case 1:
                addItems(sc);
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
            case 5:
                printCatalog();
                break;
            case 6:
                testOrder();
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