public interface DanhSach<T> {
    int getN();
    void setN(int n);
    void Them(T obj);
    void Xoa(String id);
    void Sua(String id, T newObj);
    void TimKiem(String name);
    void ThongKe();
    void GhiDuLieuVaoFile(String fileName);
    void DocDuLieuTuFile(String fileName);
    void Nhap();
    void Xuat();
}
