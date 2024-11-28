import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so tien gui:");
        double tienGui = sc.nextDouble();
        System.out.println("Nhap lai suat hang nam:");
        double laiSuat = sc.nextDouble();
        System.out.println("Nhap so thang gui:");
        double soThanggui = sc.nextDouble();

        System.out.println(" Tien gui: " +tienGui);
        System.out.println(" Lai suat hang nam: " +laiSuat);
        System.out.println(" So thang gui: " +soThanggui);

        double lai = tienGui * (laiSuat/(100*12)) * soThanggui;
        double tongTien = tienGui + lai;
        System.out.println(" So tien lai la: " +lai);
        System.out.println(" So tien goc cuoi ki: " +tongTien);
    }
}
