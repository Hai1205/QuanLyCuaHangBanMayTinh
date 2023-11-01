import java.util.Scanner;

public class DSKH {
    private KhachHang[] danhSach;

    public DSKH() {
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

    public KhachHang timkiem(String maKH) {
        for (KhachHang kh : danhSach) {
            if (kh.getMaKH().equals(maKH)) {
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
            if (danhSach[i].getMaKH().equals(kh.getMaKH())) {
                return i;
            }
        }
        return -1;
    }
}
