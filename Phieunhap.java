package doan;

//-------------------------

import java.util.Date;
import java.util.Scanner;

public class Phieunhap {
    public static void main(String[] args) {
        DANHSACH1.goi2();
    }
}

class chitiet1 {
    private int maphieunhap;
    private int manhanvien;
    private Date ngaynhap;
    private float tongtien;
    private int manhacungcap;

    public chitiet1() {
    }

    public chitiet1(int maphieunhap, int manhanvien, Date ngaynhap, float tongtien, int manhacungcap) {
        super();
        this.maphieunhap = maphieunhap;
        this.manhanvien = manhanvien;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
        this.manhacungcap = manhacungcap;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã phiếu nhập: ");
        maphieunhap = sc.nextInt();
        System.out.println("Nhập mã nhân viên: ");
        manhanvien = sc.nextInt();
        System.out.println("Nhập ngày nhập (định dạng dd/mm/yyyy): ");
        String ngayNhap = sc.next();
        try {
            ngaynhap = new Date(ngayNhap);
        } catch (Exception e) {
            System.out.println("Lỗi định dạng ngày. Vui lòng sử dụng định dạng dd/mm/yyyy.");
        }
        System.out.println("Tổng tiền: ");
        tongtien = sc.nextFloat();
        System.out.println("Nhập mã nhà cung cấp: ");
        manhacungcap = sc.nextInt();
    }

    public void xuat() {
        System.out.println("*********************");
        System.out.println("Mã phiếu nhập là: " + maphieunhap);
        System.out.println("Mã nhân viên là: " + manhanvien);
        System.out.println("Thời gian: " + ngaynhap);
        System.out.println("Tổng tiền: " + tongtien);
        System.out.println("Mã nhà cung cấp: " + manhacungcap);
    }

    public void xuat1() {
        System.out.println("Mã phiếu nhập là: " + maphieunhap);
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public int getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }
}

class DANHSACH1 {
    private static int n;
    private static chitiet1[] ct1;
    private static int max = 50;

    static  {
        n = 0;
        ct1 = new chitiet1[max];
    }

    public static void codecung1(chitiet1 ct1) {
        boolean ktma = false;

        for (int i = 0; i < n; i++) {
            if (DANHSACH1.ct1[i] != null && DANHSACH1.ct1[i].getMaphieunhap() == ct1.getMaphieunhap()) {
                ktma = true;
                break;
            }
        }

        if (!ktma) {
            if (n < max) {
                DANHSACH1.ct1[n] = ct1;
                n++;
                System.out.println("Đã thêm thành công");
            } else {
                System.out.println("Danh sách đã đầy");
            }
        } else {
            System.out.println("Mã phiếu nhập đã tồn tại");
        }
    }

    public static void xuatds() {
        for (int i = 0; i < n; i++) {
            ct1[i].xuat();
        }
    }


    public static void themds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        chitiet1 newct1 = new chitiet1();
        newct1.nhap();

        DANHSACH9.themds(newct1.getMaphieunhap());

        boolean kt = false;

        for (int i = 0; i < n; i++) {
            if (ct1[i].getMaphieunhap() == newct1.getMaphieunhap()) {
                kt = true;
                break;
            }
        }
        if (kt == false) {
            ct1[n] = newct1;
            n++;
            System.out.println("Đã thêm thành công");
        } else {
            System.out.println("Mã phiếu nhập đã tồn tại");
        }
    }

    public static void xoads() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Nhập mã cần xóa");
        int cc = sc.nextInt();
        boolean kt1 = false;
        for (int i = 0; i < n; i++) {
            if (ct1[i].getMaphieunhap() == cc) {
                for (int j = i; j < n; j++) {
                    ct1[j] = ct1[j + 1];
                }
                n--;
                kt1 = true;
                System.out.println("Mã phiếu nhập đã được xóa");
                break;
            }
        }
        if (kt1 == false) {
            System.out.println("Không tìm thấy mã phiếu nhập");
        }
    }

    public static void timkiemds() {
        System.out.println("==================================");
        System.out.print("Nhập mã phiếu nhập cần tìm kiếm: ");
        Scanner sc = new Scanner(System.in);
        int ma = sc.nextInt();
        boolean thayma = false;
        for (int i = 0; i < n; i++) {
            if (ct1[i].getMaphieunhap() == ma) {
                System.out.println("Đã tìm thấy:");
                thayma = true;
                ct1[i].xuat();
                break;
            }
        }
        if (!thayma) {
            System.out.println("Không tìm thấy mã nha cung cap");
        }
    }

    public static void goi2() {
        //DANHSACH1 DANHSACH1 = new DANHSACH1();
        Date ngayNhap = new Date();
        DANHSACH1.codecung1(new chitiet1(154, 214, ngayNhap, 1245, 1254));
        DANHSACH1.codecung1(new chitiet1(12, 451, ngayNhap, 148114, 4875));
        DANHSACH1.codecung1(new chitiet1(13, 136, ngayNhap, 481154, 487));
        DANHSACH1.codecung1(new chitiet1(14, 481, ngayNhap, 94148755, 482));
        DANHSACH1.codecung1(new chitiet1(15, 481, ngayNhap, 48761514, 4985));

        while (true) {
            System.out.println("====Menu====");
            System.out.println("1. Thêm phiếu nhập");
            System.out.println("2. Xóa phiếu nhập");
            System.out.println("3. Tìm kiếm phiếu nhập");
            System.out.println("4. Xuất danh sách phiếu nhập");
            System.out.println("5. Thống kê");
            System.out.println("6. Quay về màn hình chính");
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    DANHSACH1.themds();
                    break;
                case 2:
                    DANHSACH1.xoads();
                    break;
                case 3:
                    DANHSACH1.timkiemds();
                    break;
                case 4:
                    DANHSACH1.xuatds();
                    break;
                case 5:
                    DANHSACH1.dempn();
                    break;
                case 6:
                    cocc cc = new cocc();
                    cc.haha();
                    break;
                case 0:
                    System.exit(0); // Thoát khỏi chương trình
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static void dempn() {
        int dem = 0;
        for (int i = 0; i < n; i++) {
            ct1[i].xuat1();
            dem++;
        }
        System.out.println("Có (" + dem + ") Mã phiếu nhập");
    }
}
