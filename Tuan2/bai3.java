package Tuan_2.git;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Moi ban nhap vao hai so nguyen: ");
        double a = sc.nextDouble();
        System.out.println(" a = " +a);
        double b = sc.nextDouble();
        System.out.println(" b = " +b);
        System.out.println(" Tong cua hai so " +a+ " va " +b+ " la: " +(a + b));
        System.out.println(" Hieu cua hai so " +a+ " va " +b+ " la: " +(a - b));
        System.out.println(" Tich cua hai so " +a+ " va " +b+ " la: " +(a * b));
        System.out.println(" Thuong cua hai so " +a+ " va " +b+ " la: " +(a / b));
        System.out.println(" Phan du cua " +a+ " chia cho " +b+ " la: " +(a % b));
    }
}
