import java.util.Scanner;

public class LapTop extends SanPham {
    private int pin;
    private String styleNguoiDung;

    public LapTop(String MaSP, String Ten, int SLCL, double DG, String DVT, int pin, String styleNguoiDung) {
        super(MaSP, Ten, SLCL, DG, DVT);
        this.pin = pin;
        this.styleNguoiDung = styleNguoiDung;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap dung luong pin: ");
        pin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap style nguoi dung: ");
        styleNguoiDung = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Dung luong pin: " + pin);
        System.out.println("Style nguoi dung: " + styleNguoiDung);
    }

    public int getPin() {
        return this.pin;
    }

    public String getStyleNguoiDung() {
        return this.styleNguoiDung;
    }
}
