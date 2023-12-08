package thanh_phan;

import thuc_thi.Static;

public class PhieuBaoHanh {
    private String maBaoHanh, maSanPham, maHoaDon, thoiGianBH, maKhachHang;

    public PhieuBaoHanh() {}

    public PhieuBaoHanh(String maBaoHanh, String maSanPham, String maHoaDon, String maKhachHang, String thoiGianBH) {
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
        if (maBaoHanh == null || maBaoHanh.isEmpty()) {
            System.out.print("Ma bao hanh: ");
            setMaBaoHanh(Static.scanner.nextLine());
        }

        if (maSanPham == null || maSanPham.isEmpty()) {
            System.out.print("Ma san pham: ");
            setMaSanPham(Static.scanner.nextLine());
        }

        if (maHoaDon == null || maHoaDon.isEmpty()) {
            System.out.print("Ma hoa don: ");
            setMaHoaDon(Static.scanner.nextLine());
        }

        if (maKhachHang == null || maKhachHang.isEmpty()) {
            System.out.print("Ma khach hang: ");
            setMaKhachHang(Static.scanner.nextLine());
        }

        System.out.print("Thoi gian bao hanh: ");
        setThoiGianBH(Static.scanner.nextLine());
    }

    public void xuat() {
        System.out.println("----------------------+----------------------+----------------------+----------------------+---------------------");
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", maBaoHanh, maSanPham, maHoaDon, maKhachHang, thoiGianBH);
    }

    @Override
    public String toString() {
        return maBaoHanh + ", " + maSanPham + ", " + maHoaDon + ", " + maKhachHang + ", " + thoiGianBH;
    }
}
