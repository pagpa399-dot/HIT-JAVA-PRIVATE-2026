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

    private static final Product p1 = new Product("P01", "Ao thun", 150000, 20);
    private static final Product p2 = new Product("P02", "Binh nuoc", 50000, 10);
    private static final Book p3 = new Book("P03", "Java cơ bản", 120000, 5, "An Nguyen");

    private static final List<CartItem> cart = new ArrayList<>();
    private static final List<Product> products = new ArrayList<>();

    static void addItems(Scanner sc) {
        System.out.print("Nhập mã sản phẩm: ");
        String id = sc.nextLine();

        Product product = null;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equalsIgnoreCase(id)) {
                product = products.get(i);
                break;
            }
        }

        if (product == null) {
            System.out.println("Không tìm thấy sanr phẩm");
            return;
        }

        System.out.print("Nhập số lượng: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }

        cart.add(new CartItem(product, quantity));
        System.out.println("Đã thêm mặt hàng vào giỏ");

    }

    static void removeItem(int index) {
        index = index -1;
        if (index >= 0 && index < cart.size()) {
            cart.remove(index);
            System.out.println("Đã xóa mặt hàng");
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    static void printItems(){
        System.out.println("Khách hàng hiện tại: " + currentCustomer);

        if(cart.isEmpty()){
            System.out.println("Giỏ hàng đang trống");
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
        System.out.println("6. Kiểm tra đơn hàng");
        System.out.println("0. Thoát");
    }

    static void printCatalog() {

        System.out.println("----DANH SÁCH SẢN PHẨM----");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getDescription());
        }
    }

    static void testOrder() {

        Order order1 = new Order(currentCustomer, "O01");

        order1.addItem(new CartItem(p1, 2));
        order1.addItem(new CartItem(p2, 1));

        System.out.println("Trạng thái ban đầu: " + order1.getStatus());
        System.out.println("Tổng đơn hàng: " + order1.getTotal());

        order1.confirm();
        order1.cancel();
        System.out.println("Trạng thái order1: " + order1.getStatus());

        Order order2 = new Order(currentCustomer, "002");

        order2.cancel();
        order2.confirm();
        System.out.println("Trạng thái order2: " + order2.getStatus());
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    products.add(p1);
    products.add(p2);
    products.add(p3);

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
                System.out.print("Nhập thứ tự mặt hàng cần xóa: ");
                int index = sc.nextInt();
                sc.nextLine();
                removeItem(index);
                break;
            case 3:
                printItems();
                break;
            case 4:
                System.out.println("Tổng tiền: " + calculateTotal());
                break;
            case 5:
                printCatalog();
                break;
            case 6:
                testOrder();
                break;
            case 0:
                System.out.println("Thoát");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
        System.out.println();

    }while(choice != 0);

    sc.close();
    }
}