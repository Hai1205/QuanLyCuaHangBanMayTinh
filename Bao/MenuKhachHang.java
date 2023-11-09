import java.util.Scanner;

public class MenuKhachHang {
    private DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang();

    public void MENU() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Quan Li Khach Hang ====");
            System.out.println("1. Them Khach Hang");
            System.out.println("2. Sua Khach Hang");
            System.out.println("3. Xoa Khach Hang");
            System.out.println("4. Tim Kiem Khach Hang");
            System.out.println("5. Thong Ke Khach Hang");
  /*
            Thành viên: 
            Hạng Bạc: Người mua hàng hoàn thành 3 đơn hàng hoặc chi tiêu 3.000.000 đồng 
            => Ưu đãi: được voucher giảm 10% giá trị đơn hàng
            Hạng Vàng: Người mua hàng hoàn thành 75 đơn hàng hoặc chi tiêu 5.000.000 đồng 
            => Ưu đãi: được voucher giảm 20% giá trị đơn hàng
            Hạng Kim Cương: Người mua hàng hoàn thành 75 đơn hàng hoặc chi tiêu 20.000.000 đồng
            => Ưu đãi: được voucher giảm 40% giá trị đơn hàng
             */            
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    KhachHang kh = new KhachHang();
                    kh.nhap();
                    danhSachKhachHang.them(kh);
                    break;
                case 2:
                    System.out.println("Nhap ma khach hang can sua: ");
                    String maKhachHang1 = sc.next();
                    KhachHang khSua = danhSachKhachHang.timkiem(maKhachHang1);
                    if (khSua != null) {
                        KhachHang khMoi = new KhachHang();
                        khMoi.nhap();
                        danhSachKhachHang.sua(khSua, khMoi);
                    } else {
                        System.out.println("Khong tim thay khachang: " + maKhachHang1);
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma khach hang can xoa: ");
                    String maKhachHangXoa = sc.next();
                    KhachHang khXoa = danhSachKhachHang.timkiem(maKhachHangXoa);
                    if (khXoa != null) {
                        danhSachKhachHang.xoa(khXoa);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maKhachHangXoa);
                    }
                    break;
                case 4:
                    System.out.println("Nhap ma khach hang can tim: ");
                    String maKhachHangCanTim = sc.next();
                    KhachHang timkh = danhSachKhachHang.timkiem(maKhachHangCanTim);
                    if (timkh != null) {
                        danhSachKhachHang.timkiem(maKhachHangCanTim);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maKhachHangCanTim);
                    }
                    break;
                case 5:
                
                        break;
                case 6:
                    System.out.println("Ket thuc chuong trinh.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }
}
