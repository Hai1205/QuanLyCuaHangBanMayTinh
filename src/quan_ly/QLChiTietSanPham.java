package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLChiTietSanPham {
    private DSChiTietSanPham dsctsp;

    public QLChiTietSanPham(DSChiTietSanPham dsctsp) {
        this.dsctsp = dsctsp;
    }

    public void menu() {
        Static.clearScreen();
        
        int choice;
        do {
            System.out.println("---- Chi tiet san pham ----");
            System.out.println("1. Hien thi danh sach chi tiet san pham");
            System.out.println("2. Them chi tiet san pham");
            System.out.println("3. Xoa thong tin chi tiet san pham");
            System.out.println("4. Sua chi tiet san pham");
            System.out.println("5. Tim kiem chi tiet san pham");
            System.out.println("6. Thong ke chi tiet san pham");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dsctsp.xuat();
                    break;
                case 2:
                    dsctsp.them();
                    break;
                case 3:
                    dsctsp.xoa();
                    break;
                case 4:
                    dsctsp.sua();
                    break;
                case 5:
                    dsctsp.timKiem();
                    break;
                case 6:
                    dsctsp.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
