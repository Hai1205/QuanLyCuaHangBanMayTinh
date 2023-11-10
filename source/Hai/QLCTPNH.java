import java.util.Scanner;

public class QLCTPNH {
    private DSCTPNH dsctpnh;

    public QLCTPNH(DSCTPNH dsctpnh) {
        this.dsctpnh = dsctpnh;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        dsctpnh.xuatFile();
        do {
            System.out.println("---- Menu ----");
            System.out.println("1. xem danh sach chi tiet phieu nhap hang");
            System.out.println("2. them 1 chi tiet phieu nhap hang");
            System.out.println("3. xoa 1 chi tiet phieu nhap hang");
            System.out.println("4. sua thong tin 1 chi tiet phieu nhap hang");
            System.out.println("5. tim kiem 1 chi tiet phieu nhap hang");
            System.out.println("6. thong ke");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dsctpnh.xuat();
                    break;
                case 2:
                    dsctpnh.them();
                    break;
                case 3:
                    dsctpnh.xoa();
                    break;
                case 4:
                    dsctpnh.sua();
                    break;
                case 5:
                    dsctpnh.timKiem();
                    break;
                case 6:
                    dsctpnh.thongKe();
                    break;
                case 7:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            }
            dsctpnh.nhapFile(false);
        } while (choice != 7);
    }
}