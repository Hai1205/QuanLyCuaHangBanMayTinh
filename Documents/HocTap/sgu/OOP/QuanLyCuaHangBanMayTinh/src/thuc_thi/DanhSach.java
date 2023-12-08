package thuc_thi;

public interface DanhSach<T> {
    int n = 0;

    int getN();

    void setN(int n);

    void nhap();

    void xuat();

    void timKiem();

    void nhapFile(boolean x);

    void xuatFile();

    void them();

    void them(T x);

    void xoa();

    void xoa(int x);

    void sua();

    void sua(int x);
}