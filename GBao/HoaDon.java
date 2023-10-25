import java.util.Scanner;

public class HoaDon {
    private String maHoaDon;
    private String ngay;
    private String maNhanVien;
    private String maKhachHang;
    private double tongTien;

public HoaDon(String maHoaDon, String ngay, String maNhanVien, String maKhachHang, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngay = ngay;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getNgay() {
        return ngay;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma hoa don: ");
        setMaHoaDon(scanner.nextLine());

        System.out.print("Nhap ngay: ");
        setNgay(scanner.nextLine());

        System.out.print("Nhap ma nhan vien: ");
        setMaNhanVien(scanner.nextLine());

        System.out.print("Nhap ma khach hang: ");
        setMaKhachHang(scanner.nextLine());

        System.out.print("Nhap tong tien: ");
        setTongTien(scanner.nextDouble());
    }

    public void xuat() {
        System.out.println("Ma hoa don: " + getMaHoaDon());
        System.out.println("Ngay: " + getNgay());
        System.out.println("Ma nhan vien: " + getMaNhanVien());
        System.out.println("Ma khach hang: " + getMaKhachHang());
        System.out.println("Tong tien: " + getTongTien());
    }
}

