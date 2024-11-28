package Tuan4.git;

import java.util.Scanner;

public class bai4 {
    public static boolean kiemTra(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Moi nhap vao mot so nguyen: ");
        int n=sc.nextInt();
        if(kiemTra(n)){
            System.out.println(n+" la so nguyen to");
        } else {
            System.out.println(n+" khong phai la so nguyen to");
        }
    }
}

