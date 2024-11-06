package TaiKhoanNganHang;

import java.util.Scanner;

public class TaiKhoanTK extends TaiKhoanNH {
    private double laiSuatKyHan = 0.04;
    private double laiSuatKhongKyHan = 0.025;
    private boolean coKyHan; // Kỳ hạn (true: có kỳ hạn, false: không kỳ hạn)
    private int thoiGianGui;
    private double soDuTietKiem = 0.0;

    public TaiKhoanTK(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String tenDangKy) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, tenDangKy);
    }

    // Phương thức nhập thông tin từ HashMap
    public void nhapThongTin(String soTaiKhoan) {
        TaiKhoanNH taiKhoan = DanhSachTaiKhoan.layTaiKhoan(soTaiKhoan);
        if (taiKhoan != null) {
            this.soTaiKhoan = taiKhoan.soTaiKhoan;
            this.chuTaiKhoan = taiKhoan.chuTaiKhoan;
            this.soDu = taiKhoan.soDu;
            System.out.println("Thông tin tài khoản tiết kiệm đã được lấy thành công.");
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }
    }

    // Phương thức gửi tiền vào tài khoản tiết kiệm
    @Override
    public void guiTien() {
        Scanner sc = new Scanner(System.in);
        // Nhập kiểu gửi
        System.out.print("Bạn muốn gửi có kỳ hạn (1) hay không có kỳ hạn (0)? ");
        int luaChonKyHan = sc.nextInt();
        coKyHan = (luaChonKyHan == 1);
        // Nhập số tiền gửi
        System.out.print("Mời nhập vào số tiền cần gửi vào tài khoản tiết kiệm: ");
        double soTienGui = sc.nextDouble();
        if (soTienGui > 0) {
            soDuTietKiem += soTienGui;
            System.out.printf("Gửi tiền thành công: %.2f đồng%n", soTienGui);
            System.out.printf("Số dư tài khoản tiết kiệm hiện tại: %.2f đồng%n", soDuTietKiem);
            // Nhập số tháng gửi
            if (coKyHan) {
                System.out.print("Mời nhập số tháng gửi: ");
                thoiGianGui = sc.nextInt();
            } else {
                System.out.print("Mời nhập số tháng muốn tính lãi (không kỳ hạn): ");
                thoiGianGui = sc.nextInt();
            }
            // Tính toán và hiển thị tổng số tiền nhận được
            double tongTienNhanDuoc = tinhTongTien();
            System.out.println("Tổng số tiền nhận được sau " + (coKyHan ? thoiGianGui + " tháng" : thoiGianGui + " tháng không có kỳ hạn") + ": " + tongTienNhanDuoc);
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }

    // Phương thức rút tiền
    @Override
    public void rutTien() {
        Scanner sc = new Scanner(System.in);
        if (coKyHan) {
            System.out.println("Không thể rút tiền từ tài khoản có kỳ hạn trước khi hết hạn.");
        } else {
            System.out.print("Mời nhập vào số tiền cần rút: ");
            double soTienRut = sc.nextDouble();
            // Kiểm tra số tiền rút có hợp lệ không
            if (soTienRut > 0 && soTienRut <= soDuTietKiem) {
                // Tính lãi cho thời gian gửi đã nhập trước đó
                double laiTinhTrenSoThang = soDuTietKiem * laiSuatKhongKyHan * (thoiGianGui / 12.0);
                double tongTienKhiRut = soDuTietKiem + laiTinhTrenSoThang - soTienRut;
                soDuTietKiem -= soTienRut;
                System.out.printf("Rút tiền thành công: %.2f đồng%n", soTienRut);
                System.out.printf("Tổng tiền bạn sẽ nhận được: %.2f đồng%n", tongTienKhiRut);
                System.out.printf("Số dư tài khoản tiết kiệm hiện tại: %.2f đồng%n", soDuTietKiem);
            } else {
                System.out.println("Rút tiền không thành công. Kiểm tra số dư tài khoản tiết kiệm.");
            }
        }
    }

    // Phương thức hiển thị thông tin tài khoản
    public void hienThiThongTin() {
        System.out.println("Thông tin tài khoản tiết kiệm:");
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Chủ tài khoản: " + chuTaiKhoan);
        System.out.printf("Số dư tài khoản tiết kiệm: %.2f đồng%n", soDuTietKiem);
        System.out.printf("Lãi suất: %.2f%%%n", coKyHan ? laiSuatKyHan * 100 : laiSuatKhongKyHan * 100);
        System.out.println("Có kỳ hạn: " + (coKyHan ? "Có" : "Không"));
        if (coKyHan) {
            System.out.println("Thời gian gửi: " + thoiGianGui + " tháng");
        }
        double tongTienNhanDuoc = tinhTongTien();
        System.out.printf("Tổng số tiền nhận được sau %s: %.2f đồng%n", (coKyHan ? thoiGianGui + " tháng" : thoiGianGui + " tháng không có kỳ hạn"), tongTienNhanDuoc);
    }

    // Phương thức tính lãi
    public double tinhLai() {
        if (coKyHan) {
            // Tính lãi cho thời gian gửi nếu có kỳ hạn
            return soDuTietKiem * laiSuatKyHan * (thoiGianGui / 12.0);
        } else {
            // Tính lãi không kỳ hạn
            return soDuTietKiem * laiSuatKhongKyHan * (thoiGianGui / 12.0);
        }
    }

    // Phương thức tính tổng tiền nhận được
    public double tinhTongTien() {
        return soDuTietKiem + tinhLai();
    }
}