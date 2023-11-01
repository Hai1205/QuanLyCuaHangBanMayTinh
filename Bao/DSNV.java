import java.util.Scanner;

public class DSNV {
    private NhanVien[] danhSach;

    public DSNV() {
        danhSach = new NhanVien[0];
    }

    public void them(NhanVien nv) {
        int size = danhSach.length;
        NhanVien[] temp = new NhanVien[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = danhSach[i];
        }
        temp[size] = nv;
        danhSach = temp;
    }

    public void xoa(NhanVien nv) {
        int index = timViTri(nv);
        if (index != -1) {
            int size = danhSach.length - 1;
            NhanVien[] temp = new NhanVien[size];
            for (int i = 0; i < index; i++) {
                temp[i] = danhSach[i];
            }
            for (int i = index + 1; i < size + 1; i++) {
                temp[i - 1] = danhSach[i];
            }
            danhSach = temp;
        }
    }

    public void sua(NhanVien nv, NhanVien nvMoi) {
        int index = timViTri(nv);
        if (index != -1) {
            danhSach[index] = nvMoi;
        }
    }

    public NhanVien timkiem(String maNv) {
        for (NhanVien nv : danhSach) {
            if (nv.getMaNV().equals(maNv)) {
                return nv;
            }
        }
        return null;
    }

    public void xuatdanhsach() {
        for (NhanVien nv : danhSach) {
            nv.xuat();
        }
    }

    private int timViTri(NhanVien nv) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i].getMaNV().equals(nv.getMaNV())) {
                return i;
            }
        }
        return -1;
    }
}