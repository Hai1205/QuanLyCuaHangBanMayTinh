import java.util.Scanner;

public class DanhSachNhanVien {
    
    public NhanVien[] danhSach;

    public DanhSachNhanVien() {
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

    public NhanVien timkiem(String maNhanVien) {
        for (NhanVien nv : danhSach) {
            if (nv.getMaNhanVien().equals(maNhanVien)) {
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
            if (danhSach[i].getMaNhanVien().equals(nv.getMaNhanVien())) {
                return i;
            }
        }
        return -1;
    }

    public void thuongLuong(NhanVien nv) {
        DSHoaDon DanhSachHoaDon = new DSHoaDon();
        int soHoaDon = DanhSachHoaDon.getSoHoaDon(); 
        if (soHoaDon >= 3 && soHoaDon < 5) {
            long thuong = (long) (nv.getLuong() * 0.1);
            nv.setLuong(nv.getLuong() + thuong);
        } else if (soHoaDon >= 5) {
            long thuong = (long) (nv.getLuong() * 0.1);
            nv.setLuong(nv.getLuong() + thuong);
        }
    }
    
    
}