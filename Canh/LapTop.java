import java.util.Scanner;

public class LapTop extends SanPham {
    private int pin;
    private String styleNguoiDung;

    public LapTop(String maSanPham, String tenSanPham, int soLuong, double donGia, String donViTinh, int pin, String styleNguoiDung) {
        super(maSanPham, tenSanPham, soLuong, donGia, donViTinh);
        this.pin = pin;
        this.styleNguoiDung = styleNguoiDung;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap dung luong pin: ");
        pin = scanner.nextInt();
        scanner.nextLine(); // Thêm dòng này để xử lý việc đọc dòng trống
        System.out.print("Nhap style nguoi dung: ");
        styleNguoiDung = scanner.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Dung luong pin: " + pin);
        System.out.println("Style nguoi dung: " + styleNguoiDung);
    }
}