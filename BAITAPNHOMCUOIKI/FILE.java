import java.io.IOException;

public interface FILE {
    String FILE_PATH = "src/data.txt"; // Đường dẫn mặc định cho file text
    void docFile(String filePath) throws IOException;
    void ghiFile(String filePath) throws IOException;
} 