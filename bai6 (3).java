package tuan3;
import java.util.Scanner;
public class bai6 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nhập số thứ nhất: ");
	        double soThuNhat = scanner.nextDouble();
	        System.out.print("Nhập số thứ hai: ");
	        double soThuHai = scanner.nextDouble();
	        System.out.println("Chọn phép toán:");
	        System.out.println("1. Cộng");
	        System.out.println("2. Trừ");
	        System.out.println("3. Nhân");
	        System.out.println("4. Chia");
	        System.out.print("Nhập lựa chọn của bạn: ");
	        int luaChon = scanner.nextInt();
	        double ketQua;
	        switch (luaChon) {
	            case 1:
	                ketQua = soThuNhat + soThuHai;
	                System.out.println(soThuNhat + " + " + soThuHai + " = " + ketQua);
	                break;
	            case 2:
	                ketQua = soThuNhat - soThuHai;
	                System.out.println(soThuNhat + " - " + soThuHai + " = " + ketQua);
	                break;
	            case 3:
	                ketQua = soThuNhat * soThuHai;
	                System.out.println(soThuNhat + " * " + soThuHai + " = " + ketQua);
	                break;
	            case 4:
	                if (soThuHai == 0) {
	                    System.out.println("Không thể chia cho 0");
	                } else {
	                    ketQua = soThuNhat / soThuHai;
	                    System.out.println(soThuNhat + " / " + soThuHai + " = " + ketQua);
	                }
	                break;
	            default:
	                System.out.println("Lựa chọn không hợp lệ");
	        }
	}
}
