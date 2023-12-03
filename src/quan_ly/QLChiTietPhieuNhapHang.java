package quan_ly;

import danh_sach.*;
import thuc_thi.Static;

public class QLChiTietPhieuNhapHang {
    private DSChiTietPhieuNhapHang dsctpnh;

    public QLChiTietPhieuNhapHang(DSChiTietPhieuNhapHang dsctpnh) {
        this.dsctpnh = dsctpnh;
    }

    public void menu() {
        Static.clearScreen();
        
        int choice;
        do {
            System.out.println("---- Chi tiet phieu nhap hang ----");
            System.out.println("1. Hien thi danh sach chi tiet phieu nhap hang");
            System.out.println("2. Them chi tiet phieu nhap hang");
            System.out.println("3. Xoa thong tin chi tiet phieu nhap hang");
            System.out.println("4. Sua chi tiet phieu nhap hang");
            System.out.println("5. Tim kiem chi tiet phieu nhap hang");
            System.out.println("6. Thong ke chi tiet phieu nhap hang");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    dsctpnh.xuat();
                    break;
                case 2:
                    dsctpnh.them();
                    break;
                case 3:
                    dsctpnh.xoa();
                    break;
                case 4:
                    dsctpnh.sua();
                    break;
                case 5:
                    dsctpnh.timKiem();
                    break;
                case 6:
                    dsctpnh.thongKe();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }
}
