import java.util.Date;

public interface ISACH {
    double ngayMuonTra();
    boolean kiemTraHanTra(Date ngayMuon, Date ngayTra);
}