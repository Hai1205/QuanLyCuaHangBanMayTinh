package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLPhieuNhapHang {
    private DSPhieuNhapHang dspnh = new DSPhieuNhapHang();

    public QLPhieuNhapHang() {
    }

    public QLPhieuNhapHang(DSPhieuNhapHang dspnh) {
        this.dspnh = dspnh;
    }

    public void menu() {
        Static.clearScreen();
        
        int choice;
        do {
            System.out.println("---- Phieu nhap hang ----");
            System.out.println("1. Hien thi danh sach phieu nhap hang");
            System.out.println("2. Them phieu nhap hang");
            System.out.println("3. Xoa thong tin phieu nhap hang");
            System.out.println("4. Sua phieu nhap hang");
            System.out.println("5. Tra cuu phieu nhap hang");
            System.out.println("6. thoat");
            System.out.print("chon chuc nang (1-6): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dspnh.xuat();
                    break;
                case 2:
                    dspnh.them();
                    break;
                case 3:
                    dspnh.xoa();
                    break;
                case 4:
                    dspnh.sua();
                    break;
                case 5:
                    dspnh.timKiem();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 6);
    }
}
