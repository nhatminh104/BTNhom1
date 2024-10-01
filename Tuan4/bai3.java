package Tuan4.git;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap vao mot so nguyen duong: ");
        int n = sc.nextInt();
        int gt = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                gt = gt * i;
            }
            System.out.println(" giai thua cua " + n + " la " + gt);
        } else if (n == 0 || n == 1) {
            System.out.println(" giai thua cua " + n + " la 1 ");
        } else
            System.out.println("moi nhap lai!");
    }
}