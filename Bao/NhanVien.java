import java.util.Scanner;

public class NhanVien {
    private String maNhanVien;
    private String hoNhanVien;
    private String tenNhanVien;
    private String ngaySinh;
    private long luong;

    public NhanVien() {
        this.maNhanVien = "Unknown";
        this.hoNhanVien = "Unknown";
        this.tenNhanVien = "Unknown";
        this.ngaySinh = "Unknown";
        this.luong = 0;
    }
    
    public NhanVien(String maNhanVien, String hoNhanVien, String tenNhanVien, String ngaySinh, long luong) {
        setMaNhanVien(maNhanVien);
        setHoNhanVien(hoNhanVien);
        setTenNhanVien(tenNhanVien);
        setNgaySinh(ngaySinh);
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

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public String getMaNhanVien(){
        return maNhanVien;
    }

    public String getHoNhanVien(){
        return hoNhanVien;
    }

    public String getTenNhanVien(){
        return tenNhanVien;
    }
    
    public String getNgaySinh(){
        return ngaySinh;
    }

    public long getLuong(){
        return luong;
    }


    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = sc.next();
        System.out.print("Nhap ho: ");
        hoNhanVien = sc.next();
        System.out.print("Nhap ten: ");
        tenNhanVien = sc.next();
        System.out.print("Nhap ngay sinh: ");
        ngaySinh = sc.next();
        System.out.print("Nhap luong: ");
        luong = sc.nextLong();
    }
    
    public void xuat(){
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ho nhan vien: "+ hoNhanVien);
        System.out.println("Ten nhan vien: " + tenNhanVien);
        System.out.println("Ngay sinh nhan vien: "+ ngaySinh);
        System.out.println("Luong nhan vien la: " + luong);
    }
}
