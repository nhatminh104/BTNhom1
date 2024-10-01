import java.util.Scanner;

public class Tuan3_Bai2 {

    static float x;
    static Scanner sc = new Scanner(System.in);

    public void Nhap(){
        System.out.println("Nhap diem trung binh cua hoc sinh: ");
        x = sc.nextFloat();
    }

    public void Xep(){
        if (x<=10 && x>=8.5)
            System.out.println("Hoc sinh dat loai Gioi");
        else
            if (x<8.5 && x>=7)
                System.out.println("Hoc sinh dat loai Kha");
            else
                if (x<7 && x>=5.5)
                    System.out.println("Hoc sinh dat loai Trung Binh");
                else
                    if (x<5.5 && x>=0)
                        System.out.println("Hoc sinh dat loai Yeu");
                    else
                        System.out.println("Diem khong hop le");
    }


    public static void main(String[] args) {
        Tuan3_Bai2 t = new Tuan3_Bai2();
        t.Nhap();
        System.out.println("Diem trung binh cua sinh: " +x);
        t.Xep();
    }
}
