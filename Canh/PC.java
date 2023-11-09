import java.util.Scanner;

public class PC extends SanPham {
    private String hangManHinh;

    public PC(String MaSP, String Ten, int SLCL, double DG, String DVT, String hangManHinh) {
        super(MaSP, Ten, SLCL, DG, DVT);
        this.hangManHinh = hangManHinh;
    }

    public String getHangManHinh() {
        return this.hangManHinh;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hang man hinh: ");
        hangManHinh = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Hang man hinh: " + hangManHinh);
    }
}
