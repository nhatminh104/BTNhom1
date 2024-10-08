package SINHVIEN;

import java.util.Scanner;

public class SinhVien {
    private String msv;
    private String ten;
    private String ngaySinh;
    private double dtb;

    public String getMsv() {
        return msv;
    }
    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getDtb() {
        return dtb;
    }
    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public SinhVien(){}

    public SinhVien(String msv, String ten, String ngaySinh, double dtb) {
        this.msv = msv;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.dtb = dtb;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap thong tin cua sinh vien: ");
        System.out.println("Moi nhap ma sinh vien: ");
        msv = sc.nextLine();
        System.out.println("Moi nhap ten sinh vien: ");
        ten = sc.nextLine();
        System.out.println("Moi nhap ngay sinh cua sinh vien: ");
        ngaySinh = sc.nextLine();
        System.out.println("Moi nhap diem trung binh cua sinh vien: ");
        dtb = sc.nextDouble();
    }

    public void Xuat(){
        System.out.println("Ma sinh vien: " +msv);
        System.out.println("Ten sinh vien: " +ten);
        System.out.println("Ngay sinh cua sinh vien: " +ngaySinh);
        System.out.println("Diem trung binh cua sinh vien: " +dtb);
    }
    public static void sapXep(SinhVien[] dssv) {
        int n = dssv.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dssv[j].dtb < dssv[j + 1].dtb) {
                    SinhVien tg = dssv[j];
                    dssv[j] = dssv[j + 1];
                    dssv[j + 1] = tg;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        SinhVien[] danhSach = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            danhSach[i] = new SinhVien();
            System.out.println("\nNhap thong tin sinh vien thu " +(i + 1));
            danhSach[i].Nhap();
        }
        sapXep(danhSach);
        System.out.println("\nDanh sach sinh vien sau khi sap xep: ");
        for (SinhVien sv : danhSach) {
            sv.Xuat();
        }
    }
}
