package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLHoaDon {
    private DSHoaDon dshd;
    private String maKhachHang;

    public QLHoaDon() {
        dshd = new DSHoaDon();
    }

    public QLHoaDon(DSHoaDon dshd) {
        this.dshd = dshd;
    }

    public void setMKH(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("---- Hoa don ----");
            System.out.println("1. Hien thi danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Sua thong tin hoa don");
            System.out.println("5. Tim kiem hoa don");
            System.out.println("6. Thong ke hoa don");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    if (maKhachHang == null || maKhachHang.isEmpty())
                        dshd.xuat();
                    else
                        dshd.xuatDStheoMKH(maKhachHang);
                    break;
                case 2:
                    dshd.setMKH(maKhachHang);
                    dshd.them();
                    break;
                case 3:
                    dshd.xoa();
                    break;
                case 4:
                    dshd.sua();
                    break;
                case 5:
                    dshd.timKiem();
                    break;
                case 6:
                    dshd.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
