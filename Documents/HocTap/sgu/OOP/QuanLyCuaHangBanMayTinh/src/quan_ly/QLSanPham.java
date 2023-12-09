package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLSanPham {
    private DSSanPham dssp;

    public QLSanPham() {
        dssp = new DSSanPham();
    }
    
    public QLSanPham(DSSanPham dssp) {
        this.dssp = dssp;
    }

    public void menu() {
        Static.clearScreen();

        int choice;
        do {
            System.out.println("---- San pham ----");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Sua thong tin san pham");
            System.out.println("4. Tra cuu thong tin san pham");
            System.out.println("5. Tim kiem san pham theo gia");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dssp.xuat();
                    break;
                case 2:
                    dssp.xoa();
                    break;
                case 3:
                    dssp.sua();
                    break;
                case 4:
                    dssp.timKiem();
                    break;
                case 5:
                    dssp.timKiemDStheoKhoangDG();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 6);
    }

    public void menuUser() {
        Static.clearScreen();

        int choice;
        do {
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Tra cuu thong tin san pham");
            System.out.println("3. Tim kiem san pham theo gia");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang (1-4): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dssp.xuat();
                    break;
                case 2:
                    dssp.timKiem();
                    break;
                case 3:
                    dssp.timKiemDStheoKhoangDG();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 4);
    }
}