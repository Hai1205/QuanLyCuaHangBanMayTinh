import java.util.Scanner;

public class NhaSanXuat {
    // private PhieuNhapHang pnh;
    // private CTSP ctsp;

    private String maNhaSanXuat, tenNhaSanXuat;

    NhaSanXuat() {
        maNhaSanXuat = "";
        tenNhaSanXuat = "";
    }

    NhaSanXuat(String maNhaSanXuat, String tenNhaSanXu) {
        setMNSX(maNhaSanXuat);
        setTNSX(tenNhaSanXu);
    }

    NhaSanXuat(NhaSanXuat other) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma nha san xuat: ");
        maNhaSanXuat = scanner.nextLine();

        System.out.print("ten nha san xuat: ");
        tenNhaSanXuat = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("ma nha san xuat: " + getMNSX());
        System.out.println("ten nha san xuat: " + getTNSX());
    }

    @Override
    public String  toString() {
        return maNhaSanXuat + ", " + tenNhaSanXuat;
    }
}
