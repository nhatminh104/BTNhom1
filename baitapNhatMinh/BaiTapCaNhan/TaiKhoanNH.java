package TaiKhoanNganHang;

import java.util.Scanner;

public class TaiKhoanNH {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    public double soDu;
    private String matKhau;

    public TaiKhoanNH(){

    }

    public TaiKhoanNH(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập số tài khoản: ");
        soTaiKhoan = sc.nextLine();
        System.out.println("Mời nhập tên chủ tài khoản: ");
        chuTaiKhoan = sc.nextLine();
        System.out.println("Mời nhập số dư của bạn: ");
        soDu = sc.nextDouble();
        System.out.println("Mời nhập mật khẩu của bạn: ");
        matKhau = new Scanner(System.in).nextLine();
    }

    public void Xuat(){
        System.out.println("Số tài khoản: " +soTaiKhoan);
        System.out.println("Chủ tài khoản: " +chuTaiKhoan);
        System.out.println("Số dư: " +soDu);
        System.out.println("Mật khẩu: " +matKhau);
    }

    public void guiTien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập vào số tiền cần gửi: ");
        double soTienGui = sc.nextDouble();
        if (soTienGui > 0) {
            soDu += soTienGui;
            System.out.println("Gửi tiền thành công: " + soTienGui);
        } else {
            System.out.println("Gửi số tiền không hợp lệ. Số tiền gửi phải lớn hơn 0.");
        }
    }

    public void rutTien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập vào số tiền cần rút: ");
        double soTienRut = sc.nextDouble();
        if (soTienRut > 0 && soTienRut <= soDu) {
            soDu -= soTienRut;
            System.out.println("Rút tiền thành công: " + soTienRut);
        } else {
            System.out.println("Rút tiền không thành công. Mời kiểm tra lại.");
        }
    }

    public void doiMatKhau() {
        Scanner sc = new Scanner(System.in);
        String matKhauCu;
        while (true) {
            System.out.print("Mật khẩu cũ: ");
            matKhauCu = sc.nextLine();

            if (this.matKhau.equals(matKhauCu)) {
                break;
            } else {
                System.out.println("Sai mật khẩu cũ. Vui lòng nhập lại.");
            }
        }
        String matKhauMoi;
        do {
            System.out.print("Mật khẩu mới: ");
            matKhauMoi = sc.nextLine();
            if (matKhauCu.equals(matKhauMoi)) {
                System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ. Vui lòng nhập lại.");
            }
        } while (matKhauCu.equals(matKhauMoi));
        this.matKhau = matKhauMoi;
        System.out.println("Đổi mật khẩu thành công!");
    }

    public void kiemTraMatKhau(){
        System.out.println("Mật khẩu mới:"+this.matKhau);
    }

    public void kiemTraSoDu() {
        System.out.println("Số dư hiện tại: " +soDu);
    }
}
