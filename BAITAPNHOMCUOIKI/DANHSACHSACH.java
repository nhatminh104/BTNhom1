import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DANHSACHSACH implements FILE {
    private List<SACH> danhSach;

    public DANHSACHSACH() {
        danhSach = new ArrayList<>();
    }

    public void addSach(SACH sach) {
        danhSach.add(sach);
    }

    public void removeSach(SACH sach) {
        danhSach.remove(sach);
    }

    public void viewLichSuMuonSach() {
        for (SACH sach : danhSach) {
            sach.hienThiThongTin();
            System.out.println("------------------------");
        }
    }

    public SACH timSach(String maSach) {
        for (SACH sach : danhSach) {
            if (sach.getMaSach().equals(maSach)) {
                return sach;
            }
        }
        return null;
    }

    public boolean xoaSach(String maSach) {
        SACH sachCanXoa = timSach(maSach);
        if (sachCanXoa != null) {
            danhSach.remove(sachCanXoa);
            return true;
        }
        return false;
    }

    public void themSachMoi(String loaiSach, String tenSach, String maSach, 
                            String tacGia, String nhaXuatBan, 
                            String tinhTrang, String trangThai, double giaTien) {
        SACH sachMoi;
        if (loaiSach.equalsIgnoreCase("Giao trinh")) {
            sachMoi = new GIAOTRINH();
        } else {
            sachMoi = new SACHTHAMKHAO();
        }

        sachMoi.setTenSach(tenSach);
        sachMoi.setMaSach(maSach);
        sachMoi.setTacGia(tacGia);
        sachMoi.setNhaXuatBan(nhaXuatBan);
        sachMoi.setTinhTrang(tinhTrang);
        sachMoi.setTrangThai(trangThai);
        sachMoi.setNgayMuon(new Date());
        sachMoi.setHanTra(new Date());
        sachMoi.setGiaTien(giaTien);

        if (sachMoi instanceof ISACH) {
            ISACH sachInterface = (ISACH) sachMoi;
            if (sachInterface.kiemTraHanTra(sachMoi.getNgayMuon(), sachMoi.getHanTra())) {
                addSach(sachMoi);
                System.out.println("Thêm sách thành công!");
            } else {
                System.out.println("Thời gian mượn không hợp lệ! Vượt quá số ngày cho phép.");
            }
        }
    }

    @Override
    public void docFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) {
                    String loaiSach = data[0];
                    String tenSach = data[1];
                    String maSach = data[2];
                    String tacGia = data[3];
                    String nhaXuatBan = data[4];
                    String trangThai = data[5];
                    String tinhTrang = data[6];
                    double giaTien = Double.parseDouble(data[7]);

                    themSachMoi(loaiSach, tenSach, maSach, tacGia, nhaXuatBan, 
                               tinhTrang, trangThai, giaTien);
                }
            }
        }
    }

    @Override
    public void ghiFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (SACH sach : danhSach) {
                String loaiSach = (sach instanceof GIAOTRINH) ? "Giao trinh" : "Sach tham khao";
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%.2f",
                    loaiSach,
                    sach.getTenSach(),
                    sach.getMaSach(),
                    sach.getTacGia(),
                    sach.getNhaXuatBan(),
                    sach.getTrangThai(),
                    sach.getTinhTrang(),
                    sach.getGiaTien()
                ));
                writer.newLine();
            }
        }
    }
} 