package TaiKhoanNganHang;

import java.util.Scanner;

public class TestTaiKhoan {
    public static void main(String[] args) {
        DanhSachTaiKhoan dsTaiKhoan = new DanhSachTaiKhoan();
        Scanner sc = new Scanner(System.in);
        // Đăng ký tài khoản
        TaiKhoanNH.dangKy(dsTaiKhoan);
        // Đăng nhập
        TaiKhoanNH taiKhoan = TaiKhoanNH.dangNhap(dsTaiKhoan);
        // Chọn chức năng
        while (true) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Kiểm tra số dư");
            System.out.println("2. Gửi tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Đổi mật khẩu");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int luaChonChucNang = sc.nextInt();
            if (luaChonChucNang == 5) {
                System.out.println("Thoát chương trình.");
                break;
            }

            switch (luaChonChucNang) {
                case 1:
                    taiKhoan.kiemTraSoDu();
                    break;
                case 2:
                    taiKhoan.guiTien();
                    break;
                case 3:
                    taiKhoan.rutTien(); // Gọi phương thức rút tiền
                    break;
                case 4:
                    taiKhoan.doiMatKhau();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        // Chọn loại tài khoản
        while (true) {
            System.out.println("\nChọn loại tài khoản:");
            System.out.println("1. Tài khoản tiết kiệm");
            System.out.println("2. Tài khoản thanh toán");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = sc.nextInt();
            if (luaChon == 3) {
                System.out.println("Thoát chương trình.");
                break;
            }

            TaiKhoanNH taiKhoanChon;
            if (luaChon == 1) {
                taiKhoanChon = new TaiKhoanTK(taiKhoan.soTaiKhoan, taiKhoan.chuTaiKhoan, taiKhoan.soDu, taiKhoan.matKhau, taiKhoan.tenDangKy);
            } else if (luaChon == 2) {
                taiKhoanChon = new TaiKhoanTT(taiKhoan.soTaiKhoan, taiKhoan.chuTaiKhoan, taiKhoan.soDu, taiKhoan.matKhau, taiKhoan.tenDangKy);
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            while (true) {
                System.out.println("\nChọn chức năng:");
                System.out.println("1. Kiểm tra số dư");
                System.out.println("2. Gửi tiền");
                System.out.println("3. Rút tiền");
                System.out.println("4. Hiển thị thông tin tài khoản");
                if (luaChon == 2) { // Chỉ tài khoản thanh toán có chức năng chuyển khoản và thanh toán
                    System.out.println("5. Chuyển khoản");
                    System.out.println("6. Thanh toán hóa đơn");
                }
                System.out.println("7. Thoát");
                System.out.print("Lựa chọn của bạn: ");
                int luaChonChucNangTaiKhoan = sc.nextInt();

                if (luaChonChucNangTaiKhoan == 7) {
                    System.out.println("Đăng xuất khỏi tài khoản.");
                    break;
                }

                switch (luaChonChucNangTaiKhoan) {
                    case 1:
                        taiKhoanChon.kiemTraSoDu();
                        break;
                    case 2:
                        taiKhoanChon.guiTien();
                        break;
                    case 3:
                        taiKhoanChon.rutTien(); // Rút tiền từ tài khoản đã chọn
                        break;
                    case 4:
                        taiKhoanChon.hienThiThongTin();
                        break;
                    case 5:
                        if (luaChon == 2) {
                            ((TaiKhoanTT) taiKhoanChon).chuyenKhoan();
                        } else {
                            System.out.println("Chức năng không khả dụng cho tài khoản tiết kiệm.");
                        }
                        break;
                    case 6:
                        if (luaChon == 2) {
                            ((TaiKhoanTT) taiKhoanChon).thanhToanHoaDon();
                        } else {
                            System.out.println("Chức năng không khả dụng cho tài khoản tiết kiệm.");
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
        sc.close();
    }
}