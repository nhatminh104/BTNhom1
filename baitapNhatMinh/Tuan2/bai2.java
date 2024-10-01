package Tuan_2.git;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap vao cac thong tin sau: ");
        String hoTen = sc.nextLine();
        System.out.println(" Ho ten cua ban la: " +hoTen);
        int tuoi = sc.nextInt();
        System.out.println(" Tuoi cua ban la: " +tuoi);
        float chieuCao = sc.nextFloat();
        System.out.println(" Chieu cao cua ban la: " +chieuCao);
        System.out.println(" Ban co thich hoc lap trinh khong?");
        boolean traLoi = true;
        if (traLoi) {
            System.out.println("Tôi thích học lập trình.");
        } else {
            System.out.println("Tôi không thích học lập trình.");
        }
    }
}
