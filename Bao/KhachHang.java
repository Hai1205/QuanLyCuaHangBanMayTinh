import java.util.Scanner;

public class KhachHang {
    private String maKH;
    private String ho;
    private String ten;
    private String diachi;
    private String sdt;

    public KhachHang() {
        this.maKH = "Unknown";
        this.ho = "Unknown";
        this.ten = "Unknown";
        this.diachi = "Unknown";
        this.sdt = "Unknown";
    }
    
    public KhachHang(String maKH, String ho, String ten, String diachi, String sdt) {
        setMaKH(maKH);
        setHo(ho);
        setTen(ten);
        setDiaChi(diachi);
        setSDT(sdt);
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getMaKH(){
        return maKH;
    }

    public String getHo(){
        return ho;
    }

    public String getTen(){
        return ten;
    }
    
    public String getDiaChi(){
        return diachi;
    }

    public String getSDT(){
        return sdt;
    }


    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.next();
        System.out.print("Nhap ho: ");
        ho = sc.next();
        System.out.print("Nhap ten: ");
        ten = sc.next();
        System.out.print("Nhap dia chi: ");
        diachi = sc.next();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.next();
    }
    
    public void xuat(){
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ho khach hang: "+ ho);
        System.out.println("Ten khach hang: " + ten);
        System.out.println("Dia chi khach hang: "+ diachi);
        System.out.println("So dien thoai khach hang: " + sdt);
    }
}
