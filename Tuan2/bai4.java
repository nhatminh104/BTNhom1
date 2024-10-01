package Tuan_2.git;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap vao cac thong tin sau: ");
        double tienGui = sc.nextDouble();
        System.out.println(" So tien gui: " +tienGui);
        double laiSuat = sc.nextDouble();
        System.out.println(" Lai suat hang nam: " +laiSuat);
        double soThanggui = sc.nextDouble();
        System.out.println(" So thang gui: " +soThanggui);
        //Tinh lai don.
        double laiDon = tienGui * (laiSuat/(100*12)) * soThanggui;
        double tongTienlaidon = tienGui + laiDon;
        System.out.println(" So tien lai don: " +laiDon);
        System.out.println(" So tien goc cua lai don cuoi ki: " +tongTienlaidon);
        //Tinh lai kep.
        double tongTienlaiKep = (tienGui * Math.pow((1 + (laiSuat/(100*12))),soThanggui));
        double laiKep = tongTienlaiKep - tienGui;
        System.out.println(" So tien lai kep: " +laiKep);
        System.out.println(" So tien goc cua lai kep cuoi ki: " +tongTienlaiKep);
    }
}
