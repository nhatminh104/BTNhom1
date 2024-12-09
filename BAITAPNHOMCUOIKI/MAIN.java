import java.util.Date;
import java.util.Scanner;
import java.io.IOException;

public class MAIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DANHSACHSACH danhSachSach = new DANHSACHSACH();
        
        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ SÁCH ===");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Xem danh sách sách");
            System.out.println("3. Sửa thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Đọc dữ liệu từ file");
            System.out.println("6. Ghi dữ liệu vào file");
            System.out.println("7. Thoát");
            System.out.println("8. Tính tiền phạt");
            System.out.print("Chọn chức năng (1-8): ");
            
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            
            if (luaChon == 1) {
                System.out.print("Chọn loại sách (Giáo trình/Sách tham khảo): ");
                String loaiSach = scanner.nextLine();
                System.out.print("Nhập tên sách: ");
                String tenSach = scanner.nextLine();
                System.out.print("Nhập mã sách: ");
                String maSach = scanner.nextLine();
                System.out.print("Nhập tác giả: ");
                String tacGia = scanner.nextLine();
                System.out.print("Nhập nhà xuất bản: ");
                String nhaXuatBan = scanner.nextLine();
                System.out.print("Nhập tình trạng (Còn/Đã mượn): ");
                String tinhTrang = scanner.nextLine();
                System.out.print("Nhập trạng thái (Mới/Cũ): ");
                String trangThai = scanner.nextLine();
                System.out.print("Nhập giá tiền sách: ");
                double giaTien = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ nhớ đệm
                
                danhSachSach.themSachMoi(loaiSach, tenSach, maSach, tacGia, 
                    nhaXuatBan, tinhTrang, trangThai, giaTien);
                System.out.println("Đã thêm sách thành công!");
            } 
            else if (luaChon == 2) {
                System.out.println("\nDanh sách sách trong thư viện:");
                danhSachSach.viewLichSuMuonSach();
            }
            else if (luaChon == 3) {
                System.out.print("Nhập mã sách cần sửa: ");
                String maSach = scanner.nextLine();
                SACH sach = danhSachSach.timSach(maSach);
                
                if (sach != null) {
                    System.out.print("Nhập tên sách mới: ");
                    String tenSach = scanner.nextLine();
                    System.out.print("Nhập tác giả mới: ");
                    String tacGia = scanner.nextLine();
                    System.out.print("Nhập nhà xuất bản mới: ");
                    String nhaXuatBan = scanner.nextLine();
                    System.out.print("Nhập tình trạng mới (Còn/Đã mượn): ");
                    String tinhTrang = scanner.nextLine();
                    System.out.print("Nhập trạng thái mới (Mới/Cũ): ");
                    String trangThai = scanner.nextLine();
                    
                    sach.setTenSach(tenSach);
                    sach.setTacGia(tacGia);
                    sach.setNhaXuatBan(nhaXuatBan);
                    sach.setTinhTrang(tinhTrang);
                    sach.setTrangThai(trangThai);
                    
                    System.out.println("Đã cập nhật thông tin sách thành công!");
                } else {
                    System.out.println("Không tìm thấy sách với mã này!");
                }
            }
            else if (luaChon == 4) {
                System.out.print("Nhập mã sách cần xóa: ");
                String maSach = scanner.nextLine();
                if (danhSachSach.xoaSach(maSach)) {
                    System.out.println("Đã xóa sách thành công!");
                } else {
                    System.out.println("Không tìm thấy sách với mã này!");
                }
            }
            else if (luaChon == 5) {
                System.out.print("Nhập đường dẫn file cần đọc: ");
                String filePath = scanner.nextLine();
                try {
                    danhSachSach.docFile(filePath);
                    System.out.println("Đã đọc dữ liệu từ file thành công!");
                } catch (IOException e) {
                    System.out.println("Lỗi khi đọc file: " + e.getMessage());
                }
            }
            else if (luaChon == 6) {
                System.out.print("Nhập đường dẫn file cần ghi: ");
                String filePath = scanner.nextLine();
                try {
                    danhSachSach.ghiFile(filePath);
                    System.out.println("Đã ghi dữ liệu vào file thành công!");
                } catch (IOException e) {
                    System.out.println("Lỗi khi ghi file: " + e.getMessage());
                }
            }
            else if (luaChon == 7) {
                System.out.println("Tạm biệt!");
                break;
            }
            else if (luaChon == 8) {
                System.out.print("Nhập mã sách bị mất/hỏng: ");
                String maSach = scanner.nextLine();
                SACH sach = danhSachSach.timSach(maSach);
                
                if (sach != null) {
                    System.out.print("Nhập tình trạng mất/hỏng (Mất/Hỏng): ");
                    String tinhTrangMatHong = scanner.nextLine();
                    double tienPhat = 0;
                    
                    if (tinhTrangMatHong.equalsIgnoreCase("Hỏng")) {
                        tienPhat = sach.getGiaTien() * 0.3;
                    } else if (tinhTrangMatHong.equalsIgnoreCase("Mất")) {
                        tienPhat = sach.getGiaTien() * 1.2;
                    }
                    
                    System.out.println("Tiền phạt: " + tienPhat);
                } else {
                    System.out.println("Không tìm thấy sách với mã này!");
                }
            }
            else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        scanner.close();
    }
} 