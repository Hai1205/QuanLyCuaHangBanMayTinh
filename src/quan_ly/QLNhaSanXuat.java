package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLNhaSanXuat {
    private DSNhaSanXuat dsnsx;

    public QLNhaSanXuat() {
        dsnsx = new DSNhaSanXuat();
    }

    public QLNhaSanXuat(DSNhaSanXuat dsnsx) {
        this.dsnsx = dsnsx;
    }

    public void menu() {
        Static.clearScreen();
        
        int choice;
        do {
            System.out.println("---- Nha san xuat ----");
            System.out.println("1. Hien thi danh sach nha san xuat");
            System.out.println("2. Them nha san xuat");
            System.out.println("3. Xoa thong tin nha san xuat");
            System.out.println("4. Sua nha san xuat");
            System.out.println("5. Tim kiem nha san xuat");
            System.out.println("6. Thong ke nha san xuat");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dsnsx.xuat();
                    break;
                case 2:
                    dsnsx.them();
                    break;
                case 3:
                    dsnsx.xoa();
                    break;
                case 4:
                    dsnsx.sua();
                    break;
                case 5:
                    dsnsx.timKiem();
                    break;
                case 6:
                    dsnsx.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
