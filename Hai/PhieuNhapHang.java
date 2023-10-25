import java.util.Scanner;

public class PhieuNhapHang {
    private CTPNH ctpnh;
    // private NhanVien nv;
    private NhaSanXuat nsx;

    private String maPhieuNhap, ngayNhap, maNhanVien, maNhaSanXuat;
    private int tongTien;

    public PhieuNhapHang() {
        maPhieuNhap = "";
        ngayNhap = "";
        maNhanVien = "";
        maNhaSanXuat = "";
        tongTien = 0;
    }

    public PhieuNhapHang(String maPhieuNhap, String ngayNhap, String maNhanVien, String maNhaSanXuat, int tongTien) {
        setMPN(maPhieuNhap);
        setNN(ngayNhap);
        setMNV(maNhanVien);
        setMNSX(maNhaSanXuat);
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
        // ctpnh.setMPN(maPhieuNhap);
    }

    public void setNN(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setMNV(String maNhanVien) {
        this.maNhanVien = maNhanVien;
        // nv.setMNV(maNhanVien);
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
        // nsx.setMNSX(maNhaSanXuat);
    }

    public void setTT(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getMPN() {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma phieu nhap: ");
        maPhieuNhap = scanner.nextLine();
        System.out.println("ngay nhap: ");
        ngayNhap = scanner.nextLine();
        System.out.println("ma nhan vien: ");
        maNhanVien = scanner.nextLine();
        System.out.println("ma nha san xuat: ");
        maNhaSanXuat = scanner.nextLine();
        System.out.println("tong tien: ");
        tongTien = scanner.nextInt();
    }

    public void xuat() {
        System.out.println("ma phieu nhap: " + getMPN());
        System.out.println("ngay nhap: " + getNN());
        System.out.println("ma nhan vien: " + getMNV());
        System.out.println("ma nha san xuat: " + getMNSX());
        System.out.println("tong tien: " + getTT());
    }
}
