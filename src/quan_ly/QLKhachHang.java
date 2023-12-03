package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLKhachHang {
    private DSKhachHang dskh;
    private String maKhachHang;

    public QLKhachHang(DSKhachHang dskh) {
        this.dskh = dskh;
    }

    public void setMKH(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("---- Khach hang ----");
            System.out.println("1. Hien thi danh sach khach hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Xoa thong tin khach hang");
            System.out.println("4. Sua khach hang");
            System.out.println("5. Tim kiem khach hang");
            System.out.println("6. Thong ke khach hang");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dskh.xuat();
                    break;
                case 2:
                    dskh.them();
                    break;
                case 3:
                    dskh.xoa();
                    break;
                case 4:
                    dskh.sua();
                    break;
                case 5:
                    dskh.timKiem();
                    break;
                case 6:
                    dskh.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
