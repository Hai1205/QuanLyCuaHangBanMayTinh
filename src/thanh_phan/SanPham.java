package thanh_phan;

import thuc_thi.Static;

public abstract class SanPham {
    private String MaSP, Ten, DVT;
    public int SLCL, DG;

    public SanPham() {}

    public SanPham(String MaSP, String Ten, int SLCL, int DG, String DVT) {
        setMaSP(MaSP);
        setTen(Ten);
        setSL(SLCL);
        setDG(DG);
        setDVT(DVT);
    }

    public SanPham(SanPham other) {
        this.MaSP = other.MaSP;
        this.Ten = other.Ten;
        this.SLCL = other.SLCL;
        this.DG = other.DG;
        this.DVT = other.DVT;
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

    public int getDG() {
        return DG;
    }

    public void setDG(int DG) {
        this.DG = DG;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void nhap() {
        if (MaSP == null || MaSP.isEmpty()) {
            System.out.print("Ma san pham: ");
            setMaSP(Static.scanner.nextLine());
        }

        System.out.print("Ten san pham: ");
        setTen(Static.scanner.nextLine());

        if (SLCL == 0) {
            System.out.print("So luong trong kho: ");
            setSL(Static.checkInputIsInt());
            Static.scanner.nextLine();
        }

        System.out.print("Don gia ban: ");
        setDG(Static.checkInputIsInt());
        Static.scanner.nextLine();
        
        System.out.print("Don vi tinh: ");
        setDVT(Static.scanner.nextLine());
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