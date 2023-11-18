package doan;
import java.util.Scanner;

public class Nhacungcap {
    public static void main(String[] args) {
        DANHSACH ncc ;
        DANHSACH.goi1();
    }
}

class chitiet {
    protected int manhacungcap;
    protected String tennhacungcap;
    protected String diachi;

    public chitiet() {
    }

    public chitiet(int manhacungcap, String tennhacungcap, String diachi) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachi = diachi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp: ");
        manhacungcap = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        tennhacungcap = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diachi = sc.nextLine();
    }

    public void xuat() {
        System.out.println("********************************");
        System.out.println("Mã nhà cung cấp: " + manhacungcap);
        System.out.println("Tên nhà cung cấp: " + tennhacungcap);
        System.out.println("Địa chỉ nhà cung cấp: " + diachi);
    }

    public void xuat1() {
        System.out.println("Tên nhà cung cấp: " + tennhacungcap);
    }

    public int getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}

class DANHSACH {
    protected static int n;
    protected static chitiet[] ct;
    protected static int max = 50;

    static {
        n = 0; // Khởi tạo số lượng nhà cung cấp là 0
        ct = new chitiet[max];
    }

    public static void nhapds() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nha cung cap: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            ct[i] = new chitiet();
            ct[i].nhap();
        }
    }

    public static void codecung(chitiet ct) {
        if (n < max) {
        	DANHSACH.ct[n] = ct;
            n++;
        } else {
            System.out.println("Danh sách đã đầy");
        }
    }

    public static void xuatds() {
        for (int i = 0; i < n; i++) {
            ct[i].xuat();
        }
    }

    public static void xuatds1() {
        for (int i = 0; i < n; i++) {
            ct[i].xuat1();
        }
    }

    public static void themds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Nhap thong tin nha cung cap: ");
        chitiet newct = new chitiet();
        newct.nhap();
        boolean kt = false;
        for (int i = 0; i < n; i++) {
            if (ct[i].getManhacungcap() == newct.getManhacungcap()) {
                kt = true;
                break;
            }
        }
        if (!kt) {
            ct[n] = newct;
            n++;
            System.out.println("Da them thanh cong!");
        } else {
            System.out.println("Ma nha cung cap da ton tai!");
        }
    }

    public static void xoads() {
        System.out.println("=================================");
        System.out.print("Nhap Ma so Nha cung cap can xoa: ");
        Scanner sc = new Scanner(System.in);
        int cc = sc.nextInt();
        boolean datimthay = false;
        for (int i = 0; i < n; i++) {
            if (ct[i].getManhacungcap() == cc) {
                for (int j = i; j < n; j++) {
                    ct[j] = ct[j + 1];
                }
                n--;
                datimthay = true;
                System.out.println("Ma nha cung cap da duoc xoa");
                break;
            }
        }
        if (!datimthay) {
            System.out.println("Khong tim thay ma nha cung cap");
        }
    }

    public static void timkiemds() {
        System.out.println("==================================");
        System.out.print("Nhap ma nha cung cap can tim kiem: ");
        Scanner sc = new Scanner(System.in);
        int ma = sc.nextInt();
        boolean thayma = false;
        for (int i = 0; i < n; i++) {
            if (ct[i].getManhacungcap() == ma) {
                System.out.println("Da tim thay:");
                thayma = true;
                ct[i].xuat();
                break;
            }
        }
        if (!thayma) {
            System.out.println("Khong tim thay ma nha cung cap");
        }
    }

    public static void timkiemds1() {
        boolean tiptuc = true;
        while (tiptuc) {
            System.out.println("**********************************");
            System.out.println("1. Tìm kiếm theo mã nhà cung cấp");
            System.out.println("2. Tìm kiếm theo tên nhà cung cấp");
            System.out.println("3. Quay về Menu");
            Scanner sc = new Scanner(System.in);
            int chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Nhập mã cần tìm!");
                    int ma = sc.nextInt();
                    boolean timma = false;
                    for (int i = 0; i < n; i++) {
                        if (ct[i].getManhacungcap() == ma) {
                            System.out.println("Đã tìm thấy");
                            timma = true;
                            ct[i].xuat();
                        }
                    }
                    if (!timma) {
                        System.out.println("Không tìm thấy mã nhà cung cấp");
                    }
                    break;
                case 2:
                    sc.nextLine(); // Loại bỏ ký tự xuống dòng còn sót lại sau khi đọc số.
                    System.out.println("Nhập tên cần tìm kiếm");
                    String ten = sc.nextLine();
                    boolean timten = false;
                    for (int i = 0; i < n; i++) {
                        if (ct[i].getTennhacungcap().equalsIgnoreCase(ten)) {
                            System.out.println("Đã tìm thấy");
                            timten = true;
                            ct[i].xuat();
                            //System.out.println("123");
                            break;
                        }
                    }
                    if (!timten) {
                        System.out.println("Không tìm thấy tên!");
                    }
                    break;
                case 3:
                    DANHSACH ds;
                    DANHSACH.goi1();
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }

    public static void goi1() {
        //DANHSACH DANHSACH = new DANHSACH();
        DANHSACH.codecung(new chitiet(123, "Phong Vũ", "Sài Gòn"));
        DANHSACH.codecung(new chitiet(456, "Minh Long", "Long An"));
        DANHSACH.codecung(new chitiet(789, "FPT", "Hà Nội"));
        DANHSACH.codecung(new chitiet(112, "Phương Hằng", "Công Viên Thủy Tinh"));
        DANHSACH.codecung(new chitiet(113, "Phan Anh", "Hải Phòng"));
        while (true) {
            System.out.println("====Menu====");
            System.out.println("1. Them nha cung cap");
            System.out.println("2. Xoa nha cung cap");
            System.out.println("3. Tim kiem nha cung cap");
            System.out.println("4. Xuat danh sach nha cung cap");
            System.out.println("5. Thống kê ");
            System.out.println("6. Quay ve man hinh chinh  ");
            System.out.println("0. Thoat");
            System.out.print("Chon thao tac: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    DANHSACH.themds();
                    break;
                case 2:
                    DANHSACH.xoads();
                    break;
                case 3:
                    DANHSACH.timkiemds1();
                    break;
                case 4:
                    DANHSACH.xuatds();
                    break;
                case 5:
                    DANHSACH.demnhacungcap();
                    break;
                case 6:
                    cocc cc = new cocc();
                    cc.haha();
                case 0:
                    System.exit(0); // Thoát khỏi chương trình
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }

    public static void demnhacungcap() {
        Scanner sc = new Scanner(System.in);
        int dem = 0;
        System.out.println("-----------------------");
        for (int i = 0; i < n; i++) {
            ct[i].xuat1();
            dem++;
        }
        System.out.println("có " + dem + " nhà cung cấp");
    }
}
