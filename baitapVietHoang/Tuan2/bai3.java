import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("tong bang: " + a + "+" + b + "=" +(a + b) );
        System.out.println("hieu bang: " + a + "-" + b + "=" +(a - b) );
        System.out.println("tich bang: " + a + "*" + b + "=" +(a * b) );
        System.out.println("thuong bang: " + a + "/" + b + "=" +(a / b) );
        System.out.println("phan du bang: " + a + "%" + b + "=" +(a % b) );
    }
}

