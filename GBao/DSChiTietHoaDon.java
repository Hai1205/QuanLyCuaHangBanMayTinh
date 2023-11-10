import java.util.Scanner;

public class DSChiTietHoaDon {
    private ChiTietHoaDon[] danhSach;

    public DSChiTietHoaDon() {
        danhSach = new ChiTietHoaDon[0];
    }

    public void them(ChiTietHoaDon cthd) {
        ChiTietHoaDon[] newDanhSach = new ChiTietHoaDon[danhSach.length + 1];
        for (int i = 0; i < danhSach.length; i++) {
            newDanhSach[i] = danhSach[i];
        }
        newDanhSach[danhSach.length] = cthd;
        danhSach = newDanhSach;
    }

    public void xoa(int viTri) {
        if (viTri >= 0 && viTri < danhSach.length) {
            ChiTietHoaDon[] newDanhSach = new ChiTietHoaDon[danhSach.length - 1];
            for (int i = 0; i < viTri; i++) {
                newDanhSach[i] = danhSach[i];
            }
            for (int i = viTri; i < danhSach.length - 1; i++) {
                newDanhSach[i] = danhSach[i + 1];
            }
            danhSach = newDanhSach;
        }
    }

    public void sua(int viTri, ChiTietHoaDon cthd) {
        if (viTri >= 0 && viTri < danhSach.length) {
            danhSach[viTri] = cthd;
        }
    }

    public ChiTietHoaDon timKiem(String maHoaDon) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(maHoaDon)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void xuatDanhSach() {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i] != null) {
                danhSach[i].xuat();
            }
        }
    }
    
    public double tinhTongThanhTien(){
        double tongThanhTien = 0;
        for (int i = 0; i < danhSach.length; i++) {
            if(danhSach[i] != null) {
                tongThanhTien += danhSach[i].getThanhTien();
            }
        }
            return tongThanhTien;
    }
}
