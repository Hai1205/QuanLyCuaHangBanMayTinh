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
        Static.clearScreen();

        int choice;

        if (maKhachHang == null || maKhachHang.isEmpty()) {
            do {
                System.out.println("---- Hoa don ----");
                System.out.println("1. Hien thi danh sach hoa don");
                System.out.println("2. Them hoa don");
                System.out.println("3. Xoa hoa don");
                System.out.println("4. Sua thong tin hoa don");
                System.out.println("5. Tra cuu hoa don");
                System.out.println("6. thoat");
                System.out.print("Chon chuc nang (1-6): ");
                choice = Static.checkInputIsInt();
                Static.scanner.nextLine();

                switch (choice) {
                    case 1:
                        dshd.xuat();
                        break;
                    case 2:
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
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon lai!");
                }
            } while (choice != 6);
        } else {
            do {
                System.out.println("1. Mua hang");
                System.out.println("2. Lich su mua hang");
                System.out.println("3. Tra cuu hoa don");
                System.out.println("4. Tra hang");
                System.out.println("5.Thoat");
                System.out.print("Chon chuc nang (1-5): ");
                choice = Static.checkInputIsInt();
                Static.scanner.nextLine();

                switch (choice) {
                    case 1: 
                        dshd.setMKH(maKhachHang);
                        dshd.nhap();
                        break;
                    case 2: 
                        dshd.xuatDStheoMKH(maKhachHang);
                        break;
                    case 3: 
                        dshd.timKiem();
                        break;
                    case 4:
                        dshd.xoa();
                    case 5: 
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon lai!");
                }
            } while (choice != 5);
        }
    }
}
