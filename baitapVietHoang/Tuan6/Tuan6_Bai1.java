import java.util.Scanner;

public class Tuan6_Bai1 {
        private double A;

        public double getB() {

            return B;
        }

        public void setB(double b) {

            B = b;
        }

        public double getA() {

            return A;
        }

        public void setA(double a) {

            A = a;
        }

        private double B;

        public Tuan6_Bai1(double a, double b) {
            this.A = a;
            this.B = b;
        }

        public double tinhChuVi()
        {

            return (A+B)*2;
        }

        public double tinhDienTich(){

            return (A*B);
        }

        public Tuan6_Bai1()
        {}

        public void Nhap(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap chieu dai A: ");
            this.A = sc.nextDouble();
            System.out.print("Nhap chieu rong B: ");
            this.B = sc.nextDouble();
        }

        public void Xuat(){
            System.out.println("A: "+this.A);
            System.out.println("B: "+this.B);
            System.out.println("Chu vi la: "+this.tinhChuVi());
            System.out.println("Dien tich la: "+this.tinhDienTich());
        }

        public static void main(String[] args) {
            Tuan6_Bai1 h = new Tuan6_Bai1();
            h.Nhap();
            h.Xuat();
        }

}
