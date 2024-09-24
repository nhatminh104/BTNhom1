package Tuan3.git;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Moi nhap vao ba so: ");
        System.out.println("a = ");
        double a = sc.nextDouble();
        System.out.println("b = ");
        double b = sc.nextDouble();
        System.out.println("c = ");
        double c = sc.nextDouble();
        if (a<=b && a<c){
            System.out.println("So nho nhat trong ba so la: " +a);
        } else if (b<=c && b<a) {
            System.out.println("So nho nhat trong ba so la: " +b);
        } else if (c<=a && c<b) {
            System.out.println("So nho nhat trong ba so la: " +c);
        } else if (a==b && b==c) {
            System.out.println("So nho nhat trong ba so la: " +a);
        }
    }
}
