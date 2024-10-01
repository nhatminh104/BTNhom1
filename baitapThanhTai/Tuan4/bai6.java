package tuan4;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một số nguyên: ");
        int number = scanner.nextInt();

        if (isSymmetric(number)) {
            System.out.println(number + " là số đối xứng.");
        } else {
            System.out.println(number + " không phải là số đối xứng.");
        }

        scanner.close();
    }

    public static boolean isSymmetric(int number) {
        String strNumber = Integer.toString(number);
        String reversed = new StringBuilder(strNumber).reverse().toString();
        return strNumber.equals(reversed);
    }
}