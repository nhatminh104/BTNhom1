import java.util.Scanner;

public class bai2 {
    static String Ten;
    static double Tuoi;
    static double CCao;
    static boolean Thich;

    static Scanner sc = new Scanner(System.in);
    static void Nhap() {
        System.out.println("Nhap ten cua ban:");
        Ten = sc.nextLine();

        System.out.println("Nhap tuoi cua ban:");
        Tuoi =sc.nextDouble();

        System.out.println("Nhap chieu cao cua ban:");
        CCao =sc.nextDouble();

        System.out.println("Ban co thich lap trinh ko:");
        Thich =sc.nextBoolean();
    }

    static void Xuat() {
        System.out.println("Ten cua ban la:" +Ten);
        System.out.println("Tuoi cua ban la:" +Tuoi);
        System.out.println("Chieu cao cua ban la:" +CCao);
        if (Thich) {
            System.out.println("Tôi thích học lập trình.");
        } else {
            System.out.println("Tôi không thích học lập trình.");
        }
    }

    public static void main(String[] args) {
        Nhap();
        Xuat();
    }
}
