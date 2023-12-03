package thanh_phan;

import thuc_thi.Static;

public class NhaSanXuat {
    private String maNhaSanXuat, tenNhaSanXuat;

    public NhaSanXuat() {}

    public NhaSanXuat(String maNhaSanXuat, String tenNhaSanXu) {
        setMNSX(maNhaSanXuat);
        setTNSX(tenNhaSanXu);
    }

    public NhaSanXuat(NhaSanXuat other) {
        this.maNhaSanXuat = other.maNhaSanXuat;
        this.tenNhaSanXuat = other.tenNhaSanXuat;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setTNSX(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public String getMNSX() {
        return maNhaSanXuat;
    }
    
    public String getTNSX() {
        return tenNhaSanXuat;
    }

    public void nhap() {
        if (maNhaSanXuat == null || maNhaSanXuat.isEmpty()) {
            System.out.print("Ma nha san xuat: ");
            setMNSX(Static.scanner.nextLine());
        }

        System.out.print("Ten nha san xuat: ");
        setTNSX(Static.scanner.nextLine());
    }

    public void xuat() {
        // System.out.println("Ma nha san xuat: " + getMNSX());
        // System.out.println("Ten nha san xuat: " + getTNSX());
        System.out.println("1");
    }

    @Override
    public String  toString() {
        return maNhaSanXuat + ", " + tenNhaSanXuat;
    }
}
