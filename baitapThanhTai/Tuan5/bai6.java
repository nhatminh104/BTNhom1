package tuan5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("\nChọn một tùy chọn:");
            System.out.println("1. Thêm phần tử");
            System.out.println("2. Xóa phần tử");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập phần tử cần thêm: ");
                    String elementToAdd = scanner.nextLine();
                    System.out.print("Nhập vị trí để thêm phần tử (0 - " + list.size() + "): ");
                    int addPosition = scanner.nextInt();
                    if (addPosition >= 0 && addPosition <= list.size()) {
                        list.add(addPosition, elementToAdd);
                        System.out.println("Phần tử đã được thêm.");
                    } else {
                        System.out.println("Vị trí không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập vị trí cần xóa (0 - " + (list.size() - 1) + "): ");
                    int removePosition = scanner.nextInt();
                    if (removePosition >= 0 && removePosition < list.size()) {
                        list.remove(removePosition);
                        System.out.println("Phần tử đã được xóa.");
                    } else {
                        System.out.println("Vị trí không hợp lệ.");
                    }
                    break;

                case 3:
                    System.out.println("Danh sách hiện tại: " + list);
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}