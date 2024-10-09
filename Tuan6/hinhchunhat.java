package baitapJAVAHDT;

import java.util.Scanner;

public class hinhchunhat {
    private static int count;
    private double a;
    private double b;

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }

    public hinhchunhat(){
        count++;
    }
    public hinhchunhat(double a, double b) {
        this.a = a;
        this.b = b;
        count++;
    }

    public double tinhChuvi(){

        return(( a + b ) * 2);
    }
    public double tinhDientich(){

        return (a * b);
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap canh a = " );
        this.a= sc.nextDouble();
        System.out.println(" Nhap canh b = " );
        this.b= sc.nextDouble();
    }
    public void Xuat(){
        System.out.println("a = " +this.a);
        System.out.println("b = " +this.b);
        System.out.println("Chu vi hinh chu nhat la: " +tinhChuvi());
        System.out.println("Dien tich hinh chu nhat la: " +tinhDientich());
    }

    public static void main(String[] args) {
        hinhchunhat hcn1 = new hinhchunhat();
        hcn1.Nhap();
        hcn1.Xuat();

        hinhchunhat hcn2 = new hinhchunhat(5,9);
        hcn2.Xuat();

        System.out.println("So hinh chu nhat la: " +hinhchunhat.count);
    }
}


