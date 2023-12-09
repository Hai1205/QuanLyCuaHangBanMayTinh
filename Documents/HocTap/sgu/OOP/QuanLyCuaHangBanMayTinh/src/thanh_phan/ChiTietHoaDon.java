package thanh_phan;

import danh_sach.DSSanPham;
import thuc_thi.Static;

public class ChiTietHoaDon {
    private DSSanPham dssp;

    private String maHoaDon, maSanPham, maBaoHanh;
    private int soLuongMua, donGia, thanhTien;

    public ChiTietHoaDon() {
        dssp = new DSSanPham();

        dssp.xuatFile();
    }

    public ChiTietHoaDon(String maHoaDon, String maSanPham, String maBaoHanh, int soLuongMua, int donGia, int thanhTien) {
        setMaHoaDon(maHoaDon);
        setMaSanPham(maSanPham);
        setMaBaoHanh(maBaoHanh);
        setSoLuongMua(soLuongMua);
        setDonGia(donGia);
        setThanhTien(thanhTien);
    }

    public ChiTietHoaDon(ChiTietHoaDon other) {
        this.maHoaDon = other.maHoaDon;
        this.maSanPham = other.maSanPham;
        this.maBaoHanh = other.maBaoHanh;
        this.soLuongMua = other.soLuongMua;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
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

    public int getDonGia() {
        return donGia;
    }

    public int getThanhTien() {
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

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setDonGia() {
        int index = dssp.timKiem(this.maSanPham);
        setDonGia(dssp.getSanPham(index).getDG());
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setThanhTien() {
        setThanhTien(this.soLuongMua * this.donGia);
    }

    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public void nhap() {
        if (maHoaDon == null || maHoaDon.isEmpty()) {
            System.out.print("Ma hoa don: ");
            setMaHoaDon(Static.scanner.nextLine());
        }
    
        if (maSanPham == null || maSanPham.isEmpty()) {
            System.out.print("Ma san pham: ");
            setMaSanPham(Static.scanner.nextLine());
        }
    
        if (maBaoHanh == null || maBaoHanh.isEmpty()) {
            System.out.print("Ma bao hanh: ");
            setMaBaoHanh(Static.scanner.nextLine());
        }
    
        System.out.print("So luong mua: ");
        setSoLuongMua(Static.checkInputIsInt());
        Static.scanner.nextLine();
    
        setDonGia();

        setThanhTien();
    }

    public void xuat() {
        System.out.println("-----------------+-----------------+-----------------+-----------------+-----------------+----------------");
        System.out.format(" %-15s | %-15s | %-15s | %-15s | %-15s | %-15s%n", maHoaDon, maSanPham, maBaoHanh, soLuongMua, donGia, thanhTien);
    }

    @Override
    public String toString() {
        return maHoaDon + ", " + maSanPham + ", " + maBaoHanh + ", " + soLuongMua + ", " + donGia + ", " + thanhTien;
    }
}
