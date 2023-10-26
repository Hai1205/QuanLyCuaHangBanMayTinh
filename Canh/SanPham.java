import java.util.Scanner;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private int soLuong;
    private double donGia;
    private String donViTinh;

    public SanPham(String maSanPham, String tenSanPham, int soLuong, double donGia, String donViTinh) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }

    // Getter và setter cho maSanPham
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    // Getter và setter cho tenSanPham
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    // Getter và setter cho soLuong
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Getter và setter cho donGia
    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    // Getter và setter cho donViTinh
    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

     public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        maSanPham = scanner.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSanPham = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = scanner.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = scanner.nextDouble();
        scanner.nextLine(); // Thêm dòng này để xử lý việc đọc dòng trống
        System.out.print("Nhap don vi tinh: ");
        donViTinh = scanner.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("Ma san pham: " + maSanPham);
        System.out.println("Ten san pham: " + tenSanPham);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Don vi tinh: " + donViTinh);
    }
}
