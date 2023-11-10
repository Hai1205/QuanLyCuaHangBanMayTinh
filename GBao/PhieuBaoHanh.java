import java.util.Scanner;

public class PhieuBaoHanh {
    private String maBaoHanh;
    private String maSanPham;
    private String maHoaDon;
    private String thoiGianBH;
    private String maKhachHang;

    public PhieuBaoHanh() {
        this.maBaoHanh = "Unknown";
        this.maSanPham = "Unknown";
        this.maHoaDon = "Unknown";
        this.thoiGianBH = "Unknown";
        this.maKhachHang = "Unknown";
    }

    public PhieuBaoHanh(String maBaoHanh, String maSanPham, String maHoaDon, String thoiGianBH, String maKhachHang) {
        this.maBaoHanh = maBaoHanh;
        this.maSanPham = maSanPham;
        this.maHoaDon = maHoaDon;
        this.thoiGianBH = thoiGianBH;
        this.maKhachHang = maKhachHang;
    }

    public String getMaBaoHanh() {
        return maBaoHanh;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getThoiGianBH() {
        return thoiGianBH;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setThoiGianBH(String thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma bao hanh: ");
        setMaBaoHanh(scanner.nextLine());

        System.out.print("Nhap ma san pham: ");
        setMaSanPham(scanner.nextLine());

        System.out.print("Nhap ma hoa don: ");
        setMaHoaDon(scanner.nextLine());

        System.out.print("Nhap thoi gian bao hanh: ");
        setThoiGianBH(scanner.nextLine());

        System.out.print("Nhap ma khach hang: ");
        setMaKhachHang(scanner.nextLine());
    }

    public void xuat() {
        System.out.println("Ma bao hanh: " + getMaBaoHanh());
        System.out.println("Ma san pham: " + getMaSanPham());
        System.out.println("Ma hoa don: " + getMaHoaDon());
        System.out.println("Thoi gian bao hanh: " + getThoiGianBH());
        System.out.println("Ma khach hang: " + getMaKhachHang());
    }
}
