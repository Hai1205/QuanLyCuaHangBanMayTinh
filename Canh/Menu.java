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
            System.out.println("4. Sua thong tin san pham");
            System.out.println("5. Xoa san pham");
            System.out.println("6. Tim kiem san pham");
            System.out.println("7. Thong ke san pham");
           // System.out.println("8. Ghi danh sach vao file");
           // System.out.println("9. Doc danh sach tu file");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    danhSachSanPham.Nhap();
                    break;
                case 2:
                    danhSachSanPham.Xuat();
                    break;
                case 3:
                    Them();
                    break;
                case 4:
                    Sua();
                    break;
                case 5:
                    Xoa();
                    break;
                case 6:
                    TimKiem();
                    break;
                case 7:
                    danhSachSanPham.ThongKe();
                    break;
               /*  case 8:
                    GhiDanhSachVaoFile();
                    break;
                case 9:
                    DocDanhSachTuFile();
                    break; */
                case 0:
                    System.out.println("Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (luaChon != 0);
    }

    private void Them() {
        danhSachSanPham.Nhap();
    }
    
    private void Sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham can cap nhat: ");
        String maSanPhamCanCapNhat = scanner.nextLine();
    
        // Create a new instance of LapTop (you can modify this based on your hierarchy)
        LapTop lapTopMoi = new LapTop("", "", 0, 0, "", 0, "");
    
        danhSachSanPham.Sua(maSanPhamCanCapNhat, lapTopMoi);
    }
    

    private void Xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham can xoa: ");
        String maSanPhamCanXoa = scanner.nextLine();
        danhSachSanPham.Xoa(maSanPhamCanXoa);
    }

    private void TimKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham can tim kiem: ");
        String tenSanPhamCanTimKiem = scanner.nextLine();
        danhSachSanPham.TimKiem(tenSanPhamCanTimKiem);
    }

  /*   private void GhiDanhSachVaoFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten file de ghi danh sach: ");
        String tenFile = scanner.nextLine();
        danhSachSanPham.GhiDuLieuVaoFile(tenFile);
    }

    private void DocDanhSachTuFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten file de doc danh sach: ");
        String tenFile = scanner.nextLine();
        danhSachSanPham.DocDuLieuTuFile(tenFile);
    }
    */
    public void docDuLieuTuFile(String tenFile) {
        danhSachSanPham.DocDuLieuTuFile(tenFile);
    }
}
