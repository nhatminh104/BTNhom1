import java.util.Date;

public class SACH {
    private String tenSach;
    private String maSach;
    private String tacGia;
    private String nhaXuatBan;
    private String trangThai;
    private Date hanTra;
    private String tinhTrang;
    private double giaTien;
    private Date ngayMuon;
    
    public SACH() {}
    
    public SACH(String tenSach, String maSach, String tacGia, String nhaXuatBan, 
                String trangThai, Date hanTra, String tinhTrang, double giaTien) {
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.trangThai = trangThai;
        this.hanTra = hanTra;
        this.tinhTrang = tinhTrang;
        this.giaTien = giaTien;
    }
    
    public void hienThiThongTin() {
        System.out.println("Thông tin sách:");
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Nhà xuất bản: " + nhaXuatBan);
        System.out.println("Trạng thái: " + trangThai);
        System.out.println("Hạn trả: " + hanTra);
        System.out.println("Tình trạng: " + tinhTrang);
    }
    
    public String getTenSach() { 
        return tenSach; }
    public void setTenSach(String tenSach) { 
        this.tenSach = tenSach; }
    
    public String getMaSach() { 
        return maSach; }
    public void setMaSach(String maSach) { 
        this.maSach = maSach; }
    
    public String getTacGia() { 
        return tacGia; }
    public void setTacGia(String tacGia) { 
        this.tacGia = tacGia; }
    
    public String getNhaXuatBan() { 
        return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { 
        this.nhaXuatBan = nhaXuatBan; }
    
    public String getTrangThai() { 
        return trangThai; }
    public void setTrangThai(String trangThai) { 
        this.trangThai = trangThai; }
    
    public Date getHanTra() { 
        return hanTra; }
    public void setHanTra(Date hanTra) { 
        this.hanTra = hanTra; }
    
    public String getTinhTrang() { 
        return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { 
        this.tinhTrang = tinhTrang; }
    
    public double getGiaTien() {
        return giaTien;
    }
    
    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    
    public Date getNgayMuon() {
        return ngayMuon;
    }
    
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
} 