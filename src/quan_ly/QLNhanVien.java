package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLNhanVien {
    private DSNhanVien dsnv;

    public QLNhanVien() {
        dsnv = new DSNhanVien();
    }

    public QLNhanVien(DSNhanVien dsnv) {
        this.dsnv = dsnv;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("---- Nhan vien ----");
            System.out.println("1. Hien thi danh sach nhan vien");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Xoa thong tin nhan vien");
            System.out.println("4. Sua nhan vien");
            System.out.println("5. Tim kiem nhan vien");
            System.out.println("6. Thong ke nhan vien");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dsnv.xuat();
                    break;
                case 2:
                    dsnv.them();
                    break;
                case 3:
                    dsnv.xoa();
                    break;
                case 4:
                    dsnv.sua();
                    break;
                case 5:
                    dsnv.timKiem();
                    break;
                case 6:
                    dsnv.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
