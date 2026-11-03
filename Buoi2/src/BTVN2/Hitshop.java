package BTVN2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Hitshop{

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.println("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    readAndAddItem(sc);
                    break;
                case 2:
                    readAndRemoveItem(sc);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;
                case 5:
                    search(sc);
                    break;
                case 6:
                    payment();
                    break;
                case 0:
                    System.out.println("Kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();

        }while(choice != 0);

        sc.close();
    }

    static void printMenu(){
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Thanh toán");
        System.out.println("0. Thoát");
    }

    static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }

    static void readAndAddItem(Scanner sc) {
        System.out.print("Nhập tên mặt hàng: ");
        String name = sc.nextLine().trim();

        System.out.print("Nhập đơn giá : ");
        double price = sc.nextDouble();

        System.out.print("Nhập số lượng : ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (name.isBlank() || price <= 0 || quantity <= 0) {
            System.out.println("Thông tin mặt hàng không hợp lệ");
            return;
        }

        addItem(name, price, quantity);
        System.out.println("Đã thêm mặt hàng thành công");
    }

    static void removeItem(int index) {

        if (index < 0 || index >= names.size()) {
            System.out.println("Không tìm thấy mặt hàng");
            return;
        }

        names.remove(index);
        prices.remove(index);
        quantities.remove(index);
    }

    static void readAndRemoveItem(Scanner scanner) {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống");
            return;
        }

        printItems();
        System.out.print("Nhập số thứ tự cần xóa : ");

        int displayNumber = scanner.nextInt();
        scanner.nextLine();

        int index = displayNumber - 1;
        removeItem(index);
    }

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        System.out.println("---- DANH SÁCH GIỎ HÀNG ----");

        for (int i = 0; i < names.size(); i++) {

            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | Đơn giá: %.0f | SL: %d | Thành tiền: %.0f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }

    static double calculateTotal() {

        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }
    static void payment() {

        double subtotal = calculateTotal();
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng trống");
            return;
        }

        double VAT_RATE = subtotal * 0.1;
        double SHIPPING_FEE = 200000;
        double finalTotal = subtotal + VAT_RATE + SHIPPING_FEE;

        System.out.println("Tiền hàng: " + subtotal);
        System.out.println("Vat cố định: " + VAT_RATE);
        System.out.println("Phí vận chuyển: " + SHIPPING_FEE);
        System.out.println("Tổng thanh toán: " + finalTotal);
    }

    static void search(Scanner sc) {

        if (names.isEmpty()) {
            System.out.println("Giỏ hàng trống");
            return;
        }

        System.out.println("Nhập tên hàng");
        String input = sc.nextLine().trim();

        boolean find = false;
        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(input)) {
                System.out.println("Tìm thấy mặt hàng:");
                System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                        i + 1,
                        names.get(i),
                        prices.get(i),
                        quantities.get(i),
                        prices.get(i) * quantities.get(i));

                find = true;
                break;
            }
        }

        if (find == false) {
            System.out.println("Không tìm thấy mặt hàng");
        }
    }
}