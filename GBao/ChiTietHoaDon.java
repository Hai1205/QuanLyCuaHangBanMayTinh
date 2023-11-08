import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHoaDon;
    private String maSanPham;
    private int soLuongMua;
    private double donGia;
    private double thanhTien;
    private String maBaoHanh;

    public ChiTietHoaDon() {
        this.maHoaDon = "Unknown";
        this.maSanPham = "Unknown";
        this.soLuongMua = 0;
        this.donGia = 0;
        this.thanhTien = 0;
        this.maBaoHanh = "Unknown";
    }

    public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuongMua, double donGia, double thanhTien, String maBaoHanh) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.thanhTien = soLuongMua * donGia;
        this.maBaoHanh = maBaoHanh;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public String getMaBaoHanh() {
        return maBaoHanh;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma hoa don: ");
        setMaHoaDon(scanner.nextLine());

        System.out.print("Nhap ma san pham: ");
        setMaSanPham(scanner.nextLine());

        System.out.print("Nhap so luong mua: ");
        setSoLuongMua(scanner.nextInt());
        scanner.nextLine(); 
        
        System.out.print("Nhap ma bao hanh: ");
        setMaBaoHanh(scanner.nextLine());
        
    }

    public void xuat() {
        System.out.println("Ma hoa don: " + getMaHoaDon());
        System.out.println("Ma san pham: " + getMaSanPham());
        System.out.println("So luong mua: " + getSoLuongMua());
        System.out.println("Don gia: " + getDonGia());
        System.out.println("Thanh tien: " + getThanhTien());
        System.out.println("Ma bao hanh: " + getMaBaoHanh());
        
    }
}
