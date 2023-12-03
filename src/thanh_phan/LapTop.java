package thanh_phan;

import thuc_thi.Static;

public class LapTop extends SanPham {
    private String pin, styleNguoiDung;

    public LapTop() {}

    public LapTop(String MaSP, String Ten, int SLCL, int DG, String DVT, String pin, String styleNguoiDung) {
        super(MaSP, Ten, SLCL, DG, DVT);
        this.pin = pin;
        this.styleNguoiDung = styleNguoiDung;
    }
    
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Dung luong pin: ");
        setPin(Static.scanner.nextLine());
        
        System.out.print("Phong cach nguoi dung: ");
        setStyleNguoiDung(Static.scanner.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Dung luong pin: " + pin);
        System.out.println("Phong cach nguoi dung: " + styleNguoiDung);
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setStyleNguoiDung(String styleNguoiDung) {
        this.styleNguoiDung = styleNguoiDung;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + pin + ", " + styleNguoiDung;
    }
}