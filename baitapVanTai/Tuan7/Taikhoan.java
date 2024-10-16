package Tuan7;

import java.util.Scanner;

public class Taikhoan {
    public Scanner sc=new Scanner(System.in);
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private int soDu;
    public String getsoTaiKhoan()
    {
        return this.soTaiKhoan;
    }
    public void setsoTaiKhoan(String sTK)
    {
        this.soTaiKhoan=sTK;
    }
    public String getchuTaiKhoan()
    {
        return this.chuTaiKhoan;
    }
    public void setchuTaiKhoan(String cTK)
    {
        this.chuTaiKhoan=cTK;
    }
    public int getsoDu()
    {
        return this.soDu;
    }
    public void setsoDu(int SD)
    {
        this.soDu=SD;
    }
    public Taikhoan(){ 
    } 
    public Taikhoan(String soTK,String chuTK,int soDu){
        this.soTaiKhoan=soTK;
        this.chuTaiKhoan=chuTK;
        this.soDu=soDu;
    }
    public void guiTien(){
        System.out.println("Nhap so tien can gui:");
        int tienGui=sc.nextInt();
        this.soDu+=tienGui;
    }
    public void rutTien(){
        System.out.println("Nhap so tien can rut:");
        int tienRut=sc.nextInt();
        this.soDu-=tienRut;
    }
    public int ktraSoDu(){
        return this.soDu;
    }
    public void Nhap(){
    Scanner Sc=new Scanner(System.in);
    System.out.print("Nhap so tai khoan ");
    this.soTaiKhoan=Sc.nextLine();
    System.out.print("Nhap chu tai khoan ");
    this.chuTaiKhoan=Sc.nextLine();
    System.out.print("Nhap so du ");
    this.soDu=Sc.nextInt();
    }
    public static void main(String[] args) {
        Taikhoan tk=new Taikhoan();
        tk.Nhap();
        tk.guiTien();
        tk.rutTien();
        System.out.println("So du con lai la:"+tk.soDu);
    }
}

