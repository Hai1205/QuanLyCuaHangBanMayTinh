import java.util.Scanner;

public class QLDSSP {
    private DanhSachSanPham dssp;

    public QLDSSP(DanhSachSanPham dssp)
    {
        this.dssp = dssp;
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        dssp.xuatFile();
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Them san pham");
            System.out.println("3. Sua thong tin san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Tim kiem san pham");
            System.out.println("6. Thong ke san pham");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dssp.xuat();
                    break;
                case 2:
                    dssp.them();
                    break;
                case 3:
                    dssp.sua();
                    break;
                case 4:
                    dssp.xoa();
                    break;
                case 5:
                    dssp.timKiem();
                    break;
                case 6:
                    dssp.thongKe();
                    break;
                case 7:
                    System.out.println("Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
            dssp.nhapFile(false);
        } while (choice != 0);
    }
}