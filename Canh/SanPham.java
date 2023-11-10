import java.util.Scanner;

public abstract class SanPham {
    private String MaSP;
    private String Ten;
    private int SLCL;
    private double DG;
    private String DVT;

    public SanPham(String MaSP, String Ten, int SLCL, double DG, String DVT) {
        setMaSP(MaSP);
        setTen(Ten);
        setSL(SLCL);
        setDG(DG);
        setDVT(DVT);
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getSL() {
        return SLCL;
    }

    public void setSL(int SLCL) {
        this.SLCL = SLCL;
    }

    public double getDG() {
        return DG;
    }

    public void setDG(double DG) {
        this.DG = DG;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        setMaSP(scanner.nextLine());
        System.out.print("Nhap ten san pham: ");
        setTen(scanner.nextLine());
        System.out.print("Nhap so luong: ");
        setSL(scanner.nextInt());
        System.out.print("Nhap don gia: ");
        setDG(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Nhap don vi tinh: ");
        setDVT(scanner.nextLine());
    }
    
    public void xuat() {
        System.out.println("Ma san pham: " + MaSP);
        System.out.println("Ten san pham: " + Ten);
        System.out.println("So luong: " + SLCL);
        System.out.println("Don gia: " + DG);
        System.out.println("Don vi tinh: " + DVT);
    }
    @Override
    public String toString() {
        return MaSP + ", " + Ten + ", " + SLCL + ", " + DG + ", " + DVT;
    }

}
