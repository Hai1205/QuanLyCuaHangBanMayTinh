import java.util.Scanner;

public class NhanVien {
    private String maNv;
    private String ho;
    private String ten;
    private String ngaysinh;
    private long luong;

    public NhanVien() {
        this.maNv = "Unknown";
        this.ho = "Unknown";
        this.ten = "Unknown";
        this.ngaysinh = "Unknown";
        this.luong = 0;
    }
    
    public NhanVien(String maNv, String ho, String ten, String ngaysinh, long luong) {
        setMaNV(maNv)
        setHo(ho);
        setTen(ten);
        setNgaySinh(ngaysinh);
        setLuong(luong);
    }

    public void setMaNV(String maNv) {
        this.maNv = maNv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public String getMaNV(){
        return maNv;
    }

    public String getHo(){
        return ho;
    }

    public String getTen(){
        return ten;
    }
    
    public String getNgaySinh(){
        return ngaysinh;
    }

    public long getLuong(){
        return luong;
    }


    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNv = sc.next();
        System.out.print("Nhap ho: ");
        ho = sc.next();
        System.out.print("Nhap ten: ");
        ten = sc.next();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.next();
        System.out.print("Nhap luong: ");
        luong = sc.nextLong();
    }
    
    public void xuat(){
        System.out.println("Ma nhan vien: " + maNv);
        System.out.println("Ho nhan vien: "+ ho);
        System.out.println("Ten sinh vien: " + ten);
        System.out.println("Ngay sinh nhan vien: "+ ngaysinh);
        System.out.println("Luong nhan vien la: " + luong);
    }
}