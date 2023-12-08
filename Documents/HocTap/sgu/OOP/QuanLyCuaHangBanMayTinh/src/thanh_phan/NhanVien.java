package thanh_phan;

import thuc_thi.Static;;

public class NhanVien {
    private String maNhanVien, hoNhanVien, tenNhanVien, ngaySinh;
    private int KPI, luong;

    public NhanVien() {}

    public NhanVien(String maNhanVien, String hoNhanVien, String tenNhanVien, String ngaySinh, int KPI, int luong) {
        setMaNhanVien(maNhanVien);
        setHoNhanVien(hoNhanVien);
        setTenNhanVien(tenNhanVien);
        setNgaySinh(ngaySinh);
        setKPI(KPI);
        setLuong(luong);
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setKPI(int KPI) {
        this.KPI = KPI;
        setLuong();
    }

    public void setLuong() {
        int thuong = 0;
        int maxKPI = 10;
        if (KPI >= maxKPI) {
            thuong = 1000000 + 1000000 * (KPI - maxKPI) / 10;
        }
        setLuong(5000000 + thuong);
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public int getKPI() {
        return KPI;
    }

    public int getLuong() {
        return luong;
    }

    public void nhap() {
        if (maNhanVien == null || maNhanVien.isEmpty()) {
            System.out.print("Ma khach hang: ");
            setMaNhanVien(Static.scanner.nextLine());
        }
        System.out.print("Ho nhan vien: ");
        setHoNhanVien(Static.scanner.nextLine());

        System.out.print("Ten nhan vien: ");
        setTenNhanVien(Static.scanner.nextLine());

        System.out.print("Ngay sinh: ");
        setNgaySinh(Static.scanner.nextLine());

        setLuong();
    }

    public void xuat() {
        System.out.println("----------------------+----------------------+----------------------+----------------------+----------------------+----------------------");
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s | %-20s%n", maNhanVien, hoNhanVien, tenNhanVien, ngaySinh, KPI, luong);
    }

    @Override
    public String toString() {
        return maNhanVien + ", " + hoNhanVien + ", " + tenNhanVien + ", " + ngaySinh + ", " + KPI + ", " + luong;
    }
}
