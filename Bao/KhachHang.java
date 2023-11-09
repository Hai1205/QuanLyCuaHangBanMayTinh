import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String hoKhachHang;
    private String tenKhachHang;
    private String diaChi;
    private String soDienThoai;

    public KhachHang() {
        this.maKhachHang = "Unknown";
        this.hoKhachHang = "Unknown";
        this.tenKhachHang = "Unknown";
        this.diaChi = "Unknown";
        this.soDienThoai = "Unknown";
    }
    
    public KhachHang(String maKhachHang, String hoKhachHang, String tenKhachHang, String diaChi, String soDienThoai) {
        setMaKhachHang(maKhachHang);
        setHoKhachHang(hoKhachHang);
        setTenKhachHang(tenKhachHang);
        setDiaChi(diaChi);
        setSoDienThoai(soDienThoai);
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHoKhachHang(String hoKhachHang) {
        this.hoKhachHang = hoKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaKhachHang(){
        return maKhachHang;
    }

    public String getHoKhachHang(){
        return hoKhachHang;
    }

    public String getTenKhachHang(){
        return tenKhachHang;
    }
    
    public String getDiaChi(){
        return diaChi;
    }

    public String getSoDienThoai(){
        return soDienThoai;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        maKhachHang = sc.next();
        System.out.print("Nhap ho: ");
        hoKhachHang = sc.next();
        System.out.print("Nhap ten: ");
        tenKhachHang = sc.next();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.next();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.next();
    }
    
    public void xuat(){
        System.out.println("Ma khach hang: " + maKhachHang);
        System.out.println("Ho khach hang: "+ hoKhachHang);
        System.out.println("Ten khach hang: " + tenKhachHang);
        System.out.println("Dia chi khach hang: "+ diaChi);
        System.out.println("So dien thoai khach hang: " + soDienThoai);
    }
}
