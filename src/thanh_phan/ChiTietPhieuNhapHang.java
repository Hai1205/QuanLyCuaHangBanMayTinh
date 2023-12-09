package thanh_phan;

import thuc_thi.Static;

public class ChiTietPhieuNhapHang {

    private String maPhieuNhapHang, maSanPham;
    private int soLuong, donGia, thanhTien;

    public ChiTietPhieuNhapHang() {}

    public ChiTietPhieuNhapHang(String maPhieuNhapHang, String maSanPham, int soLuong, int donGia, int thanhTien) {
        setMPNH(maPhieuNhapHang);
        setMSP(maSanPham);
        setSL(soLuong);
        setDG(donGia);
        setTT(thanhTien);
    }

    public ChiTietPhieuNhapHang(ChiTietPhieuNhapHang other) {
        this.maPhieuNhapHang = other.maPhieuNhapHang;
        this.maSanPham = other.maSanPham;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.setTT(soLuong, donGia);
    }

    public void setMPNH(String maPhieuNhapHang) {
        this.maPhieuNhapHang = maPhieuNhapHang;
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setSL(int soLuong) {
        this.soLuong = soLuong;
        setTT1(soLuong);
    }

    public void setDG(int donGia) {
        this.donGia = donGia;
        setTT2(donGia);
    }

    public void setTT(int soLuong, int donGia) {
        this.thanhTien = soLuong * donGia;
    }

    public void setTT(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTT1(int soLuong) {
        this.thanhTien = soLuong * donGia;
    }

    public void setTT2(int donGia) {
        this.thanhTien = soLuong * donGia;
    }

    public String getMPNH() {
        return maPhieuNhapHang;
    }

    public String getMSP() {
        return maSanPham;
    }

    public int getSL() {
        return soLuong;
    }

    public int getDG() {
        return donGia;
    }

    public int getTT() {
        return thanhTien;
    }

    public void nhap() {
        if (maPhieuNhapHang == null || maPhieuNhapHang.isEmpty()) {
            System.out.print("Ma phieu nhap hang: ");
            setMPNH(Static.scanner.nextLine());
        }

        if (maSanPham == null || maSanPham.isEmpty()) {
            System.out.print("Ma san pham: ");
            setMSP(Static.scanner.nextLine());
        }

        System.out.print("So luong nhap hang: ");
        setSL(Static.checkInputIsInt());
        Static.scanner.nextLine();

        System.out.print("Don gia nhap hang: ");
        setDG(Static.checkInputIsInt());
        Static.scanner.nextLine();

        setTT(soLuong, donGia);
    }

    public void xuat() {
        System.out.println("Ma phieu nhap hang: " + maPhieuNhapHang);
        System.out.println("Ma san pham: " + maSanPham);
        System.out.println("So luong nhap hang: " + soLuong);
        System.out.println("don gia nhap hang: " + donGia);
        System.out.println("Tong tien nhap hang: " + thanhTien);
    }

    @Override
    public String toString() {
        return maPhieuNhapHang + ", " + maSanPham + ", " + soLuong + ", " + donGia + ", " + thanhTien;
    }
}
