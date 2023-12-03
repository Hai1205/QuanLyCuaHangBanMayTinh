package thanh_phan;

import danh_sach.*;
import thuc_thi.Static;

public class HoaDon {
    private DSChiTietHoaDon dscthd;
    private String maHoaDon, ngay, maNhanVien, maKhachHang;
    public int tongTien;

    public HoaDon() {
        dscthd = new DSChiTietHoaDon();
    }

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String ngay, int tongTien) {
        setMaHoaDon(maHoaDon);
        setMaNhanVien(maNhanVien);
        setMaKhachHang(maKhachHang);
        setNgay(ngay);
        setTongTien(tongTien);
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

    public int getTongTien() {
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

    public void setTongTien() {
        int tong = 0;

        ChiTietHoaDon[] ds = dscthd.timKiemDStheoMHD(this.maHoaDon);

        for (ChiTietHoaDon cthd : ds) {
            tong += cthd.getThanhTien();
        }

        setTongTien(tong);
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void nhap() {
        if (maHoaDon == null || maHoaDon.isEmpty()) {
            System.out.print("Ma hoa don: ");
            setMaHoaDon(Static.scanner.nextLine());
        }

        if (maNhanVien == null || maNhanVien.isEmpty()) {
            System.out.print("Ma nhan vien: ");
            setMaNhanVien(Static.scanner.nextLine());
        }

        if (maKhachHang == null || maKhachHang.isEmpty()) {
            System.out.print("Ma khach hang: ");
            setMaKhachHang(Static.scanner.nextLine());
        }

        System.out.print("Ngay mua: ");
        setNgay(Static.scanner.nextLine());

        setTongTien();
    }

    public void xuat() {
        System.out.println("Ma hoa don: " + getMaHoaDon());
        System.out.println("Ma nhan vien: " + getMaNhanVien());
        System.out.println("Ma khach hang: " + getMaKhachHang());
        System.out.println("Ngay mua: " + getNgay());
        System.out.println("Tong tien: " + getTongTien());
    }

    @Override
    public String toString() {
        return maHoaDon + ", " + maNhanVien + ", " + maKhachHang + ", " + ngay + ", " + tongTien;
    }
}