package thuc_thi;

import java.util.Scanner;

public class Static {
    public static Scanner scanner = new Scanner(System.in);

    // Xóa màn hình console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Kiểm tra đầu vào của người dùng có phải kiểu Integer hay không
    public static int checkInputIsInt() {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                break;
            } else {
                System.out.println("Khong hop le!");
                System.out.print("Xin nhap lai: ");
                scanner.next();
            }
        }
        return choice;
    }
}
