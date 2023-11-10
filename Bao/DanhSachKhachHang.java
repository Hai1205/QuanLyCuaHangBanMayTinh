import java.util.Scanner;


public class DanhSachKhachHang {
    private KhachHang[] danhSach;

    public DanhSachKhachHang() {
        danhSach = new KhachHang[0];
    }

    public void them(KhachHang kh) {
        int size = danhSach.length;
        KhachHang[] temp = new KhachHang[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = danhSach[i];
        }
        temp[size] = kh;
        danhSach = temp;
    }

    public void xoa(KhachHang kh) {
        int index = timViTri(kh);
        if (index != -1) {
            int size = danhSach.length - 1;
            KhachHang[] temp = new KhachHang[size];
            for (int i = 0; i < index; i++) {
                temp[i] = danhSach[i];
            }
            for (int i = index + 1; i < size + 1; i++) {
                temp[i - 1] = danhSach[i];
            }
            danhSach = temp;
        }
    }

    public void sua(KhachHang kh, KhachHang khMoi) {
        int index = timViTri(kh);
        if (index != -1) {
            danhSach[index] = khMoi;
        }
    }

    public KhachHang timkiem(String maKhachHang) {
        for (KhachHang kh : danhSach) {
            if (kh.getMaKhachHang().equals(maKhachHang)) {
                return kh;
            }
        }
        return null;
    }

    public void xuatdanhsach() {
        for (KhachHang kh : danhSach) {
            kh.xuat();
        }
    }

    private int timViTri(KhachHang kh) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i].getMaKhachHang().equals(kh.getMaKhachHang())) {
                return i;
            }
        }
        return -1;
    }

    public void hangThanhVien(KhachHang kh) {
        DSHoaDon DanhSachHoaDon = new DSHoaDon();
        double tongTien =   DanhSachHoaDon.getTongTien();
        int soHoaDon = DanhSachHoaDon.getSoHoaDon(); 
        
        double voucher = 0; 

        if (soHoaDon >= 3 || tongTien >= 3000000) {
            if (soHoaDon >= 75 || tongTien >= 20000000) {
                voucher = 0.4; // Voucher giảm 40%
            } else if (soHoaDon >= 75 || tongTien >= 5000000) {
                voucher = 0.2; // Voucher giảm 20%
            } else if (soHoaDon >= 3 || tongTien >= 3000000) {
                voucher = 0.1; // Voucher giảm 10%
            }

            // Áp dụng voucher giảm giá
            double giamGia = tongTien * voucher;
            double tongTienSauGiamGia = tongTien - giamGia;

            System.out.println("Ưu đãi: được voucher giảm " + (voucher * 100) + "% giá trị đơn hàng");
            System.out.println("Tổng tiền sau giảm giá: " + tongTienSauGiamGia);
        } else {
            System.out.println("Không đạt được hạng thành viên");
        }
    }
}

