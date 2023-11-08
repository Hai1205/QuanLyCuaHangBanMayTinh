import java.util.Scanner;

public class QLPNH {
    private DSPNH dspnh;

    public QLPNH(DSPNH dspnh)
    {
        this.dspnh = dspnh;
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        dspnh.xuatFile();
        do 
        {
            System.out.println("---- Menu ----");
            System.out.println("1. xem danh sach phieu nhap hang");
            System.out.println("2. them 1 phieu nhap hang");
            System.out.println("3. xoa 1 phieu nhap hang");
            System.out.println("4. sua thong tin 1 phieu nhap hang");
            System.out.println("5. tim kiem 1 phieu nhap hang");
            System.out.println("6. thong ke");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    dspnh.xuat();
                    break;
                case 2:
                    dspnh.them();
                    break;
                case 3:
                    dspnh.xoa();
                    break;
                case 4:
                    dspnh.sua();
                    break;
                case 5:
                    dspnh.timKiem();
                    break;
                case 6:
                    dspnh.thongKe();
                    break;
                case 7:
                    System.out.println("end!");
                    break;
                default:
                    System.out.println("invalid!");
            } 
            dspnh.nhapFile(false);
        } while (choice != 7);
    }
}
