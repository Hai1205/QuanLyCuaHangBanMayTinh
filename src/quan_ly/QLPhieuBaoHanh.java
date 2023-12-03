package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLPhieuBaoHanh {
    private DSPhieuBaoHanh dspbh;

    public QLPhieuBaoHanh() {
        dspbh = new DSPhieuBaoHanh();
    }

    public QLPhieuBaoHanh(DSPhieuBaoHanh dspbh) {
        this.dspbh = dspbh;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("---- Phieu bao hanh ----");
            System.out.println("1. Hien thi danh sach phieu bao hanh");
            System.out.println("2. Them phieu bao hanh");
            System.out.println("3. Xoa phieu bao hanh");
            System.out.println("4. Sua thong tin phieu bao hanh");
            System.out.println("5. Tim kiem phieu bao hanh");
            System.out.println("6. Thong ke phieu bao hanh");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dspbh.xuat();
                    break;
                case 2:
                    dspbh.them();
                    break;
                case 3:
                    dspbh.xoa();
                    break;
                case 4:
                    dspbh.sua();
                    break;
                case 5:
                    dspbh.timKiem();
                    break;
                case 6:
                    dspbh.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
