import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SACHTHAMKHAO extends SACH implements ISACH {
    @Override
    public double ngayMuonTra() {
        return 15;
    }
    
    @Override
    public boolean kiemTraHanTra(Date ngayMuon, Date ngayTra) {
        long diffInMillies = ngayTra.getTime() - ngayMuon.getTime();
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff <= ngayMuonTra();
    }
} 