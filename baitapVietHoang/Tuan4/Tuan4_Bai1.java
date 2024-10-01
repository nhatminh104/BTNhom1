import java.util.Scanner;

public class Tuan4_Bai1 {

    static int n, i, tong;

    public static void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mot so  n: ");
        n=sc.nextInt();
    }

    public static void Tong(){
        tong= 0;
        for(i=1; i<=n; i++)
        {
            tong= tong+ i;
        }
    }

    public static void Xuat(){
        System.out.println("tong cac chu so tu 1 den n: " +tong);
    }


    public static void main(String[] args) {
        Nhap();
        Tong();
        Xuat();
    }
}
