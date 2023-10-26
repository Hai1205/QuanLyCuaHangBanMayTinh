import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham {
    private SanPham[] danhSach;
    private int soLuong;

    public DanhSachSanPham() {
        danhSach = new SanPham[0];
        soLuong = 0;
    }

    public void themSanPham(SanPham sanPham) {
        danhSach = Arrays.copyOf(danhSach, soLuong + 1);
        danhSach[soLuong] = sanPham;
        soLuong++;
    }

    public void xoaSanPham(String maSanPham) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSanPham().equals(maSanPham)) {
                for (int j = i; j < soLuong - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }
                soLuong--;
                danhSach = Arrays.copyOf(danhSach, soLuong);
                System.out.println("Da xoa san pham co ma : " + maSanPham);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + maSanPham);
    }

    public void suaSanPham(String maSanPham, SanPham sanPhamMoi) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSanPham().equals(maSanPham)) {
                danhSach[i] = sanPhamMoi;
                System.out.println("Da cap nhat thong tin san pham co ma: " + maSanPham);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + maSanPham);
    }

    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong san pham: ");
        int soLuongSanPham = scanner.nextInt();
        scanner.nextLine(); // Thêm dòng này để xử lý việc đọc dòng trống

        for (int i = 0; i < soLuongSanPham; i++) {
            System.out.println("Nhap thong tin san pham thu  " + (i + 1));
            System.out.print("Chon loai san pham (1. Laptop / 2. PC): ");
            int loaiSanPham = scanner.nextInt();
            scanner.nextLine(); // Thêm dòng này để xử lý việc đọc dòng trống

            if (loaiSanPham == 1) {
                LapTop laptop = new LapTop("", "", 0, 0, "", 0, "");
                laptop.nhapThongTin();
                themSanPham(laptop);
            } else if (loaiSanPham == 2) {
                PC pc = new PC("", "", 0, 0, "", "");
                pc.nhapThongTin();
                themSanPham(pc);
            } else {
                System.out.println("Lua chon khong hop le.");
                i--; // Quay lại nhập lại thông tin sản phẩm này
            }
        }
    }

    public void xuatDanhSach() {
        for (int i = 0; i < soLuong; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin san pham thu " + (i + 1));
            danhSach[i].xuatThongTin();
            System.out.println("--------------------------");
        }
    }

    public SanPham[] getDanhSach() {
        return danhSach;
    }
    
}