import java.util.Scanner;

public class Tuan3_Bai1 {
    static Double x;
    static Scanner sc = new Scanner(System.in);

    public void Nhap(){
        System.out.println("Nhap mot so: ");
        x = sc.nextDouble();
    }

    public void KTra(){
        if (x>0)
            System.out.println("So vua nhap la so duong");
        else
            if (x<0)
                System.out.println("So vua nhap la so am");
            else
                System.out.println("So vua nhap bang 0");
    }


    public static void main(String[] args) {
        Tuan3_Bai1 t = new Tuan3_Bai1();
        t.Nhap();
        t.KTra();
    }
}
