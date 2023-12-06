package thanh_phan;

import thuc_thi.Static;

public class KhachHang {
    private String maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai;

    public KhachHang() {}

    public KhachHang(String maKhachHang, String hoKhachHang, String tenKhachHang, String diaChi, String soDienThoai) {
        setMaKhachHang(maKhachHang);
        setHoKhachHang(hoKhachHang);
        setTenKhachHang(tenKhachHang);
        setDiaChi(diaChi);
        setSoDienThoai(soDienThoai);
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHoKhachHang(String hoKhachHang) {
        this.hoKhachHang = hoKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoKhachHang() {
        return hoKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void nhap() {
        if (maKhachHang == null || maKhachHang.isEmpty()) {
            System.out.print("Ma khach hang: ");
            setMaKhachHang(Static.scanner.nextLine());
        }

        System.out.print("Ho khach hang: ");
        setHoKhachHang(Static.scanner.nextLine());

        System.out.print("Ten khach hang: ");
        setTenKhachHang(Static.scanner.nextLine());

        System.out.print("Dia chi: ");
        setDiaChi(Static.scanner.nextLine());
        
        do {
            System.out.print("So dien thoai: ");
            setSoDienThoai(String.valueOf(Static.checkInputIsInt()));

            if (getSoDienThoai().length() != 10) {
                System.out.println("So dien thoai khong hop le!");
            }
        } while (getSoDienThoai().length() != 10);
    }

    public void xuat() {
        System.out.println("Ma khach hang: " + maKhachHang);
        System.out.println("Ho khach hang: " + hoKhachHang);
        System.out.println("Ten khach hang: " + tenKhachHang);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + soDienThoai);
    }

    @Override
    public String toString() {
        return maKhachHang + ", " + hoKhachHang + ", " + tenKhachHang + ", " + diaChi + ", " + soDienThoai;
    }
}
