import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("========== Menu =========");
            printMenu();
            System.out.println("=========================");
            System.out.print("Chọn: "); choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    removeItem(sc);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }

    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    static void addItem(Scanner sc) {
        System.out.print("Nhập tên hàng: "); String name = sc.nextLine();
        System.out.print("Nhập giá hàng: "); double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: "); int quantity = Integer.parseInt(sc.nextLine());

        names.add(name);
        prices.add(price);
        quantities.add(quantity);

        printItems();
    }

    static void removeItem(Scanner sc) {
        System.out.print("Bạn muốn xóa mặt hàng thứ mấy?: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index <= 0 || index > names.size()) {
            System.out.println("Giỏ hàng không có gì!");
            return;
        }

        names.remove(index - 1);
        prices.remove(index - 1);
        quantities.remove(index - 1);

        printItems();
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }

        return total;
    }

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }
}