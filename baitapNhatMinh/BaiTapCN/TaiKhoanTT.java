package TaiKhoanNganHang;

import java.util.Scanner;

public class TaiKhoanTT extends TaiKhoanNH {
    private double phiGiaoDich = 1000.0;
    private double mucThauChi = 50000000.0;

    public TaiKhoanTT(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String tenDangKy) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, tenDangKy);
    }

    // Phương thức nhập thông tin từ danh sách tài khoản
    public void nhapThongTin(String soTaiKhoan) {
        TaiKhoanNH taiKhoan = DanhSachTaiKhoan.layTaiKhoan(soTaiKhoan);
        if (taiKhoan != null) {
            this.soTaiKhoan = taiKhoan.soTaiKhoan;
            this.chuTaiKhoan = taiKhoan.chuTaiKhoan;
            this.soDu = taiKhoan.soDu;
            System.out.println("Thông tin tài khoản thanh toán đã được lấy thành công.");
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }
    }

    @Override
    public void guiTien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập vào số tiền cần gửi vào tài khoản thanh toán: ");
        double soTienGui = sc.nextDouble();
        if (soTienGui > 0) {
            soDu += soTienGui;
            System.out.printf("Gửi tiền thành công: %.2f đồng%n", soTienGui);
            System.out.printf("Số dư hiện tại: %.2f đồng%n", soDu);
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }

    // Phương thức rút tiền
    @Override
    public void rutTien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập vào số tiền cần rút: ");
        double soTienRut = sc.nextDouble();
        // Kiểm tra số tiền rút có hợp lệ không, bao gồm cả phí giao dịch
        if (soTienRut > 0 && soTienRut + phiGiaoDich <= (soDu + mucThauChi)) {
            soDu -= (soTienRut + phiGiaoDich);
            System.out.printf("Rút tiền thành công: %.2f đồng%n", soTienRut);
            System.out.printf("Phí giao dịch: %.2f đồng%n", phiGiaoDich);
            System.out.printf("Số dư hiện tại: %.2f đồng%n", soDu);
        } else {
            System.out.println("Rút tiền không thành công. Kiểm tra số dư, mức thấu chi và phí giao dịch.");
        }
    }

    // Phương thức chuyển khoản
    public void chuyenKhoan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập số tiền cần chuyển: ");
        double soTien = sc.nextDouble();
        // Nhập tài khoản đích
        System.out.print("Mời nhập số tài khoản nhận: ");
        String soTaiKhoanKhac = sc.next();
        soDu -= soTien;
        System.out.println("Chuyển khoản thành công. Số tiền: " + soTien + ". Số dư hiện tại: " + soDu);
    }

    // Phương thức thanh toán hóa đơn
    public void thanhToanHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập số tiền cần thanh toán: ");
        double soTien = sc.nextDouble();
        System.out.print("Mời nhập dịch vụ thanh toán: ");
        String dichVu = sc.next();
        if (soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Thanh toán hóa đơn " + dichVu + " thành công. Số tiền: " + soTien + ". Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Số dư không đủ để thanh toán hóa đơn " + dichVu + ".");
        }
    }

    // Phương thức hiển thị thông tin tài khoản
    public void hienThiThongTin() {
        System.out.println("Thông tin tài khoản thanh toán:");
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Chủ tài khoản: " + chuTaiKhoan);
        System.out.println("Số dư: " + soDu);
        System.out.println("Phí giao dịch: " + phiGiaoDich + " đồng");
        System.out.println("Mức thấu chi: " + mucThauChi + " đồng");
    }
}