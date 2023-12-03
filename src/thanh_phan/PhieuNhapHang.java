package thanh_phan;

import danh_sach.DSChiTietPhieuNhapHang;
import thuc_thi.Static;

public class PhieuNhapHang {
    private DSChiTietPhieuNhapHang dsctpnh;

    private String maPhieuNhap, maNhanVien, maNhaSanXuat, ngayNhap;
    private int tongTien;

    public PhieuNhapHang() {
        dsctpnh = new DSChiTietPhieuNhapHang();
    }

    public PhieuNhapHang(String maPhieuNhap, String maNhanVien, String maNhaSanXuat, String ngayNhap, int tongTien) {
        setMPN(maPhieuNhap);
        setMNV(maNhanVien);
        setMNSX(maNhaSanXuat);
        setNN(ngayNhap);
        setTT(tongTien);
    }

    public PhieuNhapHang(PhieuNhapHang other) {
        this.maPhieuNhap = other.maPhieuNhap;
        this.ngayNhap = other.ngayNhap;
        this.maNhanVien = other.maNhanVien;
        this.maNhaSanXuat = other.maNhaSanXuat;
        this.tongTien = other.tongTien;
    }

    public void setMPN(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public void setMNV(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setNN(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTT() {
        int tong = 0;

        ChiTietPhieuNhapHang[] ds = dsctpnh.timKiemDStheoMPNH(this.maPhieuNhap);

        for (ChiTietPhieuNhapHang ctpnh : ds) {
            tong += ctpnh.getTT();
        }

        setTT(tong);
    }

    public void setTT(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getMPNH() {
        return maPhieuNhap;
    }

    public String getNN() {
        return ngayNhap;
    }

    public String getMNV() {
        return maNhanVien;
    }

    public String getMNSX() {
        return maNhaSanXuat;
    }

    public int getTT() {
        return tongTien;
    }

    public void nhap() {
        if (maPhieuNhap == null || maPhieuNhap.isEmpty()) {
            System.out.print("Ma phieu nhap: ");
            setMPN(Static.scanner.nextLine());
        }

        if (maNhanVien == null || maNhanVien.isEmpty()) {
            System.out.print("Ma nhan vien: ");
            setMNV(Static.scanner.nextLine());
        }

        if (maNhaSanXuat == null || maNhaSanXuat.isEmpty()) {
            System.out.print("Ma nha san xuat: ");
            setMNSX(Static.scanner.nextLine());
        }

        System.out.print("Ngay nhap hang: ");
        setNN(Static.scanner.nextLine());

        if (tongTien != 0) {
            setTT();
        }
    }

    public void xuat() {
        System.out.println("Ma phieu nhap: " + getMPNH());
        System.out.println("Ma nhan vien: " + getMNV());
        System.out.println("Ma nha san xuat: " + getMNSX());
        System.out.println("Ngay nhap hang: " + getNN());
        System.out.println("Tong tien: " + getTT());
    }

    @Override
    public String toString() {
        return maPhieuNhap + ", " + maNhanVien + ", " + maNhaSanXuat + ", " + ngayNhap + ", " + tongTien;
    }
}
