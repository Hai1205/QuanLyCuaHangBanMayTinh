public interface DanhSach<T> {

    void setN(int n);

    int getN();

    T getDanhSachSanPham(int i);

    void setDanhSachSanPham(int i, T value);

    void nhap();

    void xuat();

    void nhapFile(boolean x);

    void xuatFile();

    void them();

    void them(T x);

    void timKiem();

    void xoa();

    void xoa(int x);

    void sua();

    void sua(int x);

    void thongKe();
}
