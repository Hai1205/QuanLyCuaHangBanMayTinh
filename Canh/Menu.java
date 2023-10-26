
import java.util.Scanner;

public class Menu {
    private DanhSachSanPham danhSachSanPham;

    public Menu() {
        danhSachSanPham = new DanhSachSanPham();
    }

    public void hienThiMenu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Nhap danh sach san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Them san pham");
            System.out.println("4. Cap nhat thong tin san pham");
            System.out.println("5. Xoa san pham");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống

            switch (luaChon) {
                case 1:
                    danhSachSanPham.nhapDanhSach();
                    break;
                case 2:
                    danhSachSanPham.xuatDanhSach();
                    break;
                case 3:
                    themSanPham();
                    break;
                case 4:
                    capNhatSanPham();
                    break;
                case 5:
                    xoaSanPham();
                    break;
                case 0:
                    System.out.println("Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (luaChon != 0);
    }

    private void themSanPham() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chon loai san pham (1. Laptop / 2. PC): ");
        int loaiSanPham = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng trống
    
        System.out.println("Loai san pham duoc chon: " + loaiSanPham); // Thêm dòng này
    
        if (loaiSanPham == 1) {
            LapTop laptop = new LapTop("", "", 0, 0, "", 0, "");
            laptop.nhapThongTin();
            danhSachSanPham.themSanPham(laptop);
        } else if (loaiSanPham == 2) {
            PC pc = new PC("", "", 0, 0, "", "");
            pc.nhapThongTin();
            danhSachSanPham.themSanPham(pc);
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }
    

    private void capNhatSanPham() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham can cap nhat: ");
        String maSanPhamCanCapNhat = scanner.nextLine();

        for (SanPham sanPham : danhSachSanPham.getDanhSach()) {
            if (sanPham.getMaSanPham().equals(maSanPhamCanCapNhat)) {
                if (sanPham instanceof LapTop) {
                    LapTop laptopCapNhat = new LapTop("", "", 0, 0, "", 0, "");
                    laptopCapNhat.nhapThongTin();
                    danhSachSanPham.suaSanPham(maSanPhamCanCapNhat, laptopCapNhat);
                } else if (sanPham instanceof PC) {
                    PC pcCapNhat = new PC("", "", 0, 0, "", "");
                    pcCapNhat.nhapThongTin();
                    danhSachSanPham.suaSanPham(maSanPhamCanCapNhat, pcCapNhat);
                }
                return;
            }
        }

        System.out.println("Khong tim thay san pham co ma: " + maSanPhamCanCapNhat);
    }

    private void xoaSanPham() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham can xoa: ");
        String maSanPhamCanXoa = scanner.nextLine();
        danhSachSanPham.xoaSanPham(maSanPhamCanXoa);
    }
}
