import java.util.Scanner;

public class CTSP {
    // private NhaSanXuat nsx;
    // private SanPham sp;

    private String maSanPham, RAM, CPU, hardDisk, graphicCard, OS, maNhaSanXuat, tenNhaSanXuat, namSanXuat;

    public CTSP() {}

    public CTSP(String maSanPham, String RAM, String CPU, String hardDisk, String graphicCard, String OS, String maNhaSanXuat, String tenNhaSanXuat, String namSanXuat) {
        setMSP(maSanPham);
        setRAM(RAM);
        setCPU(CPU);
        setHD(hardDisk);
        setGC(graphicCard);
        setOS(OS);
        setMNSX(maNhaSanXuat);
        setTNSX(tenNhaSanXuat);
        setTGSX(namSanXuat);
    }

    public CTSP(CTSP other) {
        this.maSanPham = other.maSanPham;
        this.RAM = other.RAM;
        this.CPU = other.CPU;
        this.hardDisk = other.hardDisk;
        this.graphicCard = other.graphicCard;
        this.OS = other.OS;
        this.maNhaSanXuat = other.maNhaSanXuat;
        this.tenNhaSanXuat = other.tenNhaSanXuat;
        this.namSanXuat = other.namSanXuat;
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setHD(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setGC(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setTNSX(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public void setTGSX(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMSP() {
        return maSanPham;
    }

    public String getRAM() {
        return RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public String getHD() {
        return hardDisk;
    }

    public String getGC() {
        return graphicCard;
    }

    public String getOS() {
        return OS;
    }

    public String getMNSX() {
        return maNhaSanXuat;
    }

    public String getTNSX() {
        return tenNhaSanXuat;
    }

    public String getTGSX() {
        return namSanXuat;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ma san pham: ");
        maSanPham = scanner.nextLine();

        System.out.println("RAM: ");
        RAM = scanner.nextLine();

        System.out.println("CPU: ");
        CPU = scanner.nextLine();

        System.out.println("hard disk: ");
        hardDisk = scanner.nextLine();

        System.out.println("graphic card");
        graphicCard = scanner.nextLine();

        System.out.println("OS: ");
        OS = scanner.nextLine();

        System.out.println("ma nha san xuat: ");
        maNhaSanXuat = scanner.nextLine();

        System.out.println("ten nha san xuat: ");
        tenNhaSanXuat = scanner.nextLine();

        System.out.println("thoi gian san xuat: ");
        namSanXuat = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("ma nha san xuat: " + maNhaSanXuat);
        System.out.println("RAM: " + RAM);
        System.out.println("CPU: " + CPU);
        System.out.println("hard disk: " + hardDisk);
        System.out.println("graphic card: " + graphicCard);
        System.out.println("OS: " + OS);
        System.out.println("ma nha san xuat: " + maNhaSanXuat);
        System.out.println("ten nha san xuat: " + tenNhaSanXuat);
        System.out.println("thoi gian san xuat: " + namSanXuat);
    }

    @Override
    public String toString() {
        return maSanPham + ", " + RAM + ", " + CPU + ", " + hardDisk + ", " + graphicCard + ", " + OS + ", " + maNhaSanXuat + ", " + tenNhaSanXuat + ", " + namSanXuat;
    }

}
