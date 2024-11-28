package TaiKhoanNganHang;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern; // tìm kiếm và kiểm tra xem một chuỗi có phù hợp với mẫu không

// Lớp trừu tượng cho tài khoản ngân hàng
public abstract class TaiKhoanNH {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;
    protected String tenDangKy;

    public TaiKhoanNH(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String tenDangKy) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
        this.tenDangKy = tenDangKy;
    }

    // Phương thức tạo số tài khoản ngẫu nhiên
    public static String generateSoTaiKhoan() {
        Random random = new Random();
        StringBuilder soTaiKhoan = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            soTaiKhoan.append(random.nextInt(10)); // Thêm ký tự số ngẫu nhiên từ 0 đến 9
        }
        return soTaiKhoan.toString();
    }

    // Phương thức đăng ký
    public static void dangKy(DanhSachTaiKhoan dsTaiKhoan) {
        Scanner sc = new Scanner(System.in);
        String regexTenChuTaiKhoan = "^[A-Z][a-z]+( [A-Z][a-z]+)*$";
        String regexTenDangKy = "^[0-9]{10,11}$";
        String regexMatKhau = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        System.out.println("Đăng ký tài khoản");
        String chuTaiKhoan;
        // Nhập tên chủ tài khoản
        while (true) {
            System.out.print("Mời nhập tên chủ tài khoản: ");
            chuTaiKhoan = sc.nextLine();
            if (!chuTaiKhoan.trim().isEmpty() && Pattern.matches(regexTenChuTaiKhoan, chuTaiKhoan)) {
                break; // Thoát vòng lặp nếu tên chủ tài khoản hợp lệ
            } else {
                System.out.println("Tên chủ tài khoản không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String tenDangKy;

        // Nhập tên đăng ký
        while (true) {
            System.out.print("Mời nhập tên đăng ký (SDT): ");
            tenDangKy = sc.nextLine();
            if (Pattern.matches(regexTenDangKy, tenDangKy) && !dsTaiKhoan.isTaiKhoanDaTonTai(tenDangKy)) {
                break; // Thoát vòng lặp nếu tên đăng ký hợp lệ và chưa tồn tại
            } else {
                System.out.println("Tên đăng ký không hợp lệ hoặc đã tồn tại. Vui lòng nhập lại.");
            }
        }

        String matKhau;

        // Nhập mật khẩu
        while (true) {
            System.out.print("Mời nhập mật khẩu: ");
            matKhau = sc.nextLine();
            if (Pattern.matches(regexMatKhau, matKhau)) {
                break; // Thoát vòng lặp nếu mật khẩu hợp lệ
            } else {
                System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại.");
                System.out.println("Yêu cầu mật khẩu:");
                System.out.println("- Tối thiểu 8 ký tự.");
                System.out.println("- Phải có ít nhất một chữ hoa.");
                System.out.println("- Phải có ít nhất một chữ thường.");
                System.out.println("- Phải có ít nhất một chữ số.");
                System.out.println("- Phải có ít nhất một ký tự đặc biệt.");
            }
        }

        // Tạo tài khoản với số tài khoản ngẫu nhiên
        TaiKhoanNH taiKhoan = new TaiKhoanTT(generateSoTaiKhoan(), chuTaiKhoan, 0, matKhau, tenDangKy);
        dsTaiKhoan.themTaiKhoan(tenDangKy, taiKhoan); // Sử dụng tên đăng ký để thêm vào danh sách
        System.out.println("Đăng ký thành công!");
        System.out.println("Số tài khoản của bạn: " + taiKhoan.soTaiKhoan);
    }

    // Phương thức đăng nhập
    public static TaiKhoanNH dangNhap(DanhSachTaiKhoan dsTaiKhoan) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Đăng nhập tài khoản");
        String tenDangKy;
        String matKhau;
        while (true) {
            System.out.print("Tên đăng nhập: ");
            tenDangKy = sc.nextLine();
            // Kiểm tra tên đăng nhập
            if (!dsTaiKhoan.isTaiKhoanDaTonTai(tenDangKy)) {
                System.out.println("Tài khoản không tồn tại. Vui lòng nhập lại.");
                continue;
            }
            // Nếu tên đăng nhập hợp lệ, tiếp tục yêu cầu nhập mật khẩu
            while (true) {
                System.out.print("Mật khẩu: ");
                matKhau = sc.nextLine();
                // Lấy tài khoản từ danh sách
                TaiKhoanNH taiKhoan = dsTaiKhoan.layTaiKhoan(tenDangKy);
                if (taiKhoan != null && taiKhoan.matKhau.equals(matKhau)) {
                    return taiKhoan; // Trả về tài khoản nếu mật khẩu đúng
                } else {
                    System.out.println("Mật khẩu không đúng. Vui lòng nhập lại.");
                }
            }
        }
    }

    // Phương thức đổi mật khẩu
    public boolean doiMatKhau() {
        Scanner sc = new Scanner(System.in);
        // Nhập mật khẩu hiện tại
        System.out.print("Mời nhập mật khẩu hiện tại: ");
        String matKhauHienTai = sc.nextLine();
        // Kiểm tra mật khẩu hiện tại
        while (!matKhauHienTai.equals(this.matKhau)) {
            System.out.println("Mật khẩu hiện tại không đúng. Vui lòng nhập lại.");
            matKhauHienTai = sc.nextLine();
        }
        // Nhập mật khẩu mới
        String regexMatKhauMoi = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        String matKhauMoi;
        while (true) {
            System.out.print("Mời nhập mật khẩu mới: ");
            matKhauMoi = sc.nextLine();
            // Kiểm tra mật khẩu mới
            if (matKhauMoi.equals(this.matKhau)) {
                System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ. Vui lòng nhập lại.");
                continue;
            }
            if (Pattern.matches(regexMatKhauMoi, matKhauMoi)) {
                this.matKhau = matKhauMoi;
                System.out.println("Đổi mật khẩu thành công!");
                return true;
            } else {
                System.out.println("Mật khẩu mới không hợp lệ. Vui lòng nhập lại.");
                System.out.println("Yêu cầu mật khẩu:");
                System.out.println("- Tối thiểu 8 ký tự.");
                System.out.println("- Phải có ít nhất một chữ hoa.");
                System.out.println("- Phải có ít nhất một chữ thường.");
                System.out.println("- Phải có ít nhất một chữ số.");
                System.out.println("- Phải có ít nhất một ký tự đặc biệt.");
            }
        }
    }

    // Phương thức gửi tiền
    public abstract void guiTien();

    // Phương thức trừu tượng để rút tiền
    public abstract void rutTien();

    // Phương thức kiểm tra số dư
    public void kiemTraSoDu() {
        System.out.println("Số dư hiện tại: " + soDu);
    }

    // Phương thức hiển thị thông tin tài khoản
    public void hienThiThongTin() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Chủ tài khoản: " + chuTaiKhoan);
        System.out.println("Số dư: " + soDu);
    }
}