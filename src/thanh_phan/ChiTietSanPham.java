package thanh_phan;

import thuc_thi.Static;

public class ChiTietSanPham {
    private String maSanPham, RAM, CPU, ROM, graphicCard, OS, maNhaSanXuat, namSanXuat;

    public ChiTietSanPham() {}

    public ChiTietSanPham(String maSanPham, String maNhaSanXuat, String RAM, String ROM, String CPU, String graphicCard, String OS, String namSanXuat) {
        setMSP(maSanPham);
        setRAM(RAM);
        setCPU(CPU);
        setROM(ROM);
        setGC(graphicCard);
        setOS(OS);
        setMNSX(maNhaSanXuat);
        setNamSanXuat(namSanXuat);
    }

    public ChiTietSanPham(ChiTietSanPham other) {
        this.maSanPham = other.maSanPham;
        this.RAM = other.RAM;
        this.CPU = other.CPU;
        this.ROM = other.ROM;
        this.graphicCard = other.graphicCard;
        this.OS = other.OS;
        this.maNhaSanXuat = other.maNhaSanXuat;
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

    public void setROM(String ROM) {
        this.ROM = ROM;
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

    public void setNamSanXuat(String namSanXuat) {
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

    public String getROM() {
        return ROM;
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

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void nhap() {
        if (maSanPham == null || maSanPham.isEmpty()) {
            System.out.print("Ma san pham: ");
            setMSP(Static.scanner.nextLine());
        }
    
        if (maNhaSanXuat == null || maNhaSanXuat.isEmpty()) {
            System.out.print("Ma nha san xuat: ");
            setMNSX(Static.scanner.nextLine());
        }
    
        System.out.print("RAM: ");
        setRAM(Static.scanner.nextLine());
    
        System.out.print("ROM: ");
        setROM(Static.scanner.nextLine());

        System.out.print("CPU: ");
        setCPU(Static.scanner.nextLine());
    
        System.out.print("Card do hoa: ");
        setGC(Static.scanner.nextLine());
    
        System.out.print("He dieu hanh: ");
        setOS(Static.scanner.nextLine());
    
        System.out.print("Nam san xuat: ");
        setNamSanXuat(Static.scanner.nextLine());
    }
    

    public void xuat() {
        System.out.println("Ma san pham: " + maSanPham);
        System.out.println("Ma nha san xuat: " + maNhaSanXuat);
        System.out.println("RAM: " + RAM);
        System.out.println("ROM: " + ROM);
        System.out.println("CPU: " + CPU);
        System.out.println("Card do hoa: " + graphicCard);
        System.out.println("He dieu hanh: " + OS);
        System.out.println("Nam san xuat: " + namSanXuat);
    }

    @Override
    public String toString() {
        return maSanPham + ", " + maNhaSanXuat + ", " + RAM + ", " + ROM + ", " + CPU + ", " + graphicCard + ", " + OS + ", " +  namSanXuat;
    }

}
