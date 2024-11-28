package TaiKhoanNganHang;
import java.util.HashMap;
import java.util.Map;
// Lớp quản lý danh sách tài khoản
class DanhSachTaiKhoan {
    private static Map<String, TaiKhoanNH> danhSachTaiKhoan = new HashMap<>();

    public static TaiKhoanNH layTaiKhoan(String soTaiKhoan) {
        return danhSachTaiKhoan.get(soTaiKhoan);
    }

    // Phương thức thêm tài khoản
    public static void themTaiKhoan(String soTaiKhoan, TaiKhoanNH taiKhoan) {
        danhSachTaiKhoan.put(soTaiKhoan, taiKhoan);
    }

    // Kiểm tra tài khoản tồn tại
    public static boolean isTaiKhoanDaTonTai(String soTaiKhoan) {
        return danhSachTaiKhoan.containsKey(soTaiKhoan);
    }
}

