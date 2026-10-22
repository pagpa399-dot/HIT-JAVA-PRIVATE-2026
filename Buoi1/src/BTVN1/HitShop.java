package BTVN1;

import java.util.Scanner;

public class HitShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final double VAT_RATE = 0.10;
        final double SHIPPING_FEE = 20000;

        System.out.println("Ten mat hang: ");
        String productName = scanner.nextLine();

        System.out.println("Don gia: ");
        double unitPrice = scanner.nextDouble();

        System.out.println("So luong: ");
        int quantity = scanner.nextInt();

        double subtotal = unitPrice * quantity;
        double totalPayment = subtotal + subtotal*VAT_RATE + SHIPPING_FEE;


        System.out.println("----Hoa Don Tam Tinh----");
        System.out.println("Ten mat hang: " + productName);
        System.out.println("Don gia: " + unitPrice);
        System.out.println("So luong: " + quantity);
        System.out.println("Thanh tien: " + subtotal);
        System.out.println("Tong thanh toan: " + totalPayment);

        scanner.close();
    }

}
