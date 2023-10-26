import java.util.Scanner;

public class PC extends SanPham {
    private String hangManHinh;

    public PC(String maSanPham, String tenSanPham, int soLuong, double donGia, String donViTinh, String hangManHinh) {
        super(maSanPham, tenSanPham, soLuong, donGia, donViTinh);
        this.hangManHinh = hangManHinh;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hang man hinh: ");
        hangManHinh = scanner.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Hang man hinh: " + hangManHinh);
    }
}