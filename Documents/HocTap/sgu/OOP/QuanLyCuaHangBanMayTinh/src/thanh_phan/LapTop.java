package thanh_phan;

import thuc_thi.Static;

public class LapTop extends SanPham {
    private String pin, loai;

    public LapTop() {}

    public LapTop(String MaSP, String Ten, int SLCL, int DG, String DVT, String pin, String loai) {
        super(MaSP, Ten, SLCL, DG, DVT);
        this.pin = pin;
        this.loai = loai;
    }
    
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Dung luong pin: ");
        setPin(Static.scanner.nextLine());
        
        System.out.print("Phong cach nguoi dung: ");
        setLoai(Static.scanner.nextLine());
    }

    @Override
    public void xuat() {
        System.out.println("----------------------+---------------------------+-----------------+-----------------+-----------------+-----------------+-----------------+------------------");
        System.out.printf(" %-20s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n", getMaSP(), getTen(), getDVT(), getSL(), getDG(), pin, loai, null);
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + pin + ", " + loai;
    }
}