package thanh_phan;

import thuc_thi.Static;

public class PC extends SanPham {
    private String hangManHinh;

    public PC() {}
    
    public PC(String MaSP, String Ten, int SLCL, int DG, String DVT, String hangManHinh) {
        super(MaSP, Ten, SLCL, DG, DVT);
        this.hangManHinh = hangManHinh;
    }
    
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap hang man hinh: ");
        setHangManHinh(Static.scanner.nextLine());
    }
    
    @Override
    public void xuat() {
        System.out.println("----------------------+---------------------------+-----------------+-----------------+-----------------+-----------------+-----------------+------------------");
        System.out.printf(" %-20s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n", getMaSP(), getTen(), getDVT(), getSL(), getDG(), null, null, hangManHinh);
    }
   
    public void setHangManHinh(String hangManHinh) {
        this.hangManHinh = hangManHinh;
    }
    @Override
    public String toString() {
        return super.toString() + ", " + hangManHinh;
}

}