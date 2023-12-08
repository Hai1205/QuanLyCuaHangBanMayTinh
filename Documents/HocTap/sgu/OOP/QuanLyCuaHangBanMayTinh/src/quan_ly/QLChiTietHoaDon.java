package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLChiTietHoaDon {
    private DSChiTietHoaDon dscthd;

    public QLChiTietHoaDon() {
        dscthd = new DSChiTietHoaDon();
    }

    public QLChiTietHoaDon(DSChiTietHoaDon dscthd) {
        this.dscthd = dscthd;
    }

    public void menu() {
        Static.clearScreen();
        
        int choice;
        do {
            System.out.println("---- Chi tiet hoa don ----");
            System.out.println("1. Hien thi danh sach chi tiet hoa don");
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xoa chi tiet hoa don");
            System.out.println("4. Sua thong tin chi tiet hoa don");
            System.out.println("5. Tim kiem chi tiet hoa don");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dscthd.xuat();
                    break;
                case 2:
                    dscthd.them();
                    break;
                case 3:
                    dscthd.xoa();
                    break;
                case 4:
                    dscthd.sua();
                    break;
                case 5:
                    dscthd.timKiem();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 6);
    }
}
