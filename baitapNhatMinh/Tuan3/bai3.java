package Tuan3.git;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("moi nhap vao ba so: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if (a != 0) {
            double delta = Math.pow(b,2) - 4*a*c;
            if (delta<0)
                System.out.println(" Phuong trinh vo nghiem ");
            else if (delta > 0) {
                double x1 = ((-b + Math.sqrt(delta))/(2*a));
                double x2 = ((-b - Math.sqrt(delta))/(2*a));
                System.out.println(" nghiem x1 = " +x1);
                System.out.println(" nghiem x2 = " +x2);
            } else if (delta == 0) {
                double x = (-b)/(2*a);
                System.out.println(" nghiem x = " +x);
            }
        }
    }
}
