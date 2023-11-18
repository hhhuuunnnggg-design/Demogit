package doan;

import java.util.Scanner;

public class Chitietphieunhap {
	public static void main(String[] args) {
		DANHSACH2 ctpn = new DANHSACH2();
        ctpn.goi3();
	}
}

class chitiet2{
	private int machitietphieunhap;
	private int masanpham;
	private int soluong;
	private float dongia;
	private float thanhtien;

	public chitiet2() {}

	
	public chitiet2(int machitietphieunhap, int masanpham, int soluong, float dongia, float thanhtien) {
		super();
		this.machitietphieunhap = machitietphieunhap;
		this.masanpham = masanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhập mã chi tiết phiếu nhập: ");
		machitietphieunhap=sc.nextInt();
		System.out.println("Nhập mã sản phầm: ");
		masanpham=sc.nextInt();
		System.out.println("Nhập số lượng: ");
		soluong=sc.nextInt();
		System.out.println("Nhập Đơn giá: ");
		dongia=sc.nextFloat();
		//System.out.println("Nhập thành tiền");
		//thanhtien=sc.nextFloat();
	}
	public void xuat() {
		System.out.println("*******************************");
		System.out.println("Mã chi tiết phiếu nhập: "+machitietphieunhap);
		System.out.println("Mã sản phẩm :"+masanpham);
		System.out.println("Số lượng "+soluong);
		System.out.println("Đơn giá "+dongia);
		System.out.println("Thành tiền: "+soluong*dongia);
	}
	//System.out.println("Thành tiền: "+thanhtien);
	public void xuat1() {
		System.out.println("Mã chi tiết phiếu nhập: "+machitietphieunhap);
	}

	public int getMachitietphieunhap() {
		return machitietphieunhap;
	}


	public void setMachitietphieunhap(int machitietphieunhap) {
		this.machitietphieunhap = machitietphieunhap;
	}


	public int getMasanpham() {
		return masanpham;
	}


	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public float getDongia() {
		return dongia;
	}


	public void setDongia(float dongia) {
		this.dongia = dongia;
	}


	public float getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}	
	
}
class DANHSACH2{
	private int n;
	private chitiet2[] ct2;
	int max=50;
	
	public DANHSACH2() {
		this.n=0;
		ct2=new chitiet2[max];
	}
	public void nhapds() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhập số lượng: ");
		n=sc.nextInt();
		for(int i=0 ; i<n ; i++) {
			ct2[i]=new chitiet2();
			ct2[i].nhap();
		}
	}
	public void codecung2(chitiet2 ct2) {
    	if(n<max) {
    		this.ct2[n]= ct2;
    		n++;
    	}
    	else {
    		System.out.println("Danh sách đã đầy");
    	}
    }
	
	public void xuatds() {
        for (int i = 0; i < n; i++) {
            ct2[i].xuat();
        }
    }
	
	public void themds() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================");
		chitiet2 newct2=new chitiet2();
		newct2.nhap();
		boolean kt=false;
		
		for(int i=0 ; i<n ; i++) {
			
				if(ct2[i].getMachitietphieunhap() == newct2.getMachitietphieunhap() )
					kt=true;
					break;
		}
		if (kt==false) {
			ct2[n]=newct2;
			n++;
			System.out.println("Đã thêm thành công");
		}
		else {
			System.out.println("Mã phiếu nhập đã tồn tại");
		}
	}
	
	public void xoads() {
		Scanner sc=new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("Nhập mã cần xóa");
		int cc=sc.nextInt();
		boolean kt1=false;
		for(int i=0 ; i<n ; i++) {
			if(ct2[i].getMachitietphieunhap()==cc) {
				for(int j=i ; j<n ;j++) {
					ct2[j]=ct2[j+1];
				}
				n--;
				kt1=true;
				System.out.println("Mã chi tiết  phiếu nhập đã được xóa");
				break;
			}
		}
		if(kt1==false) {
			System.out.println("Không tìm thấy mã phiếu nhập");
		}
	}
	public void timkiemds() {
        System.out.println("==================================");
        System.out.print("Nhập mã phiếu nhập cần tiềm kiếm: ");
        Scanner sc = new Scanner(System.in);
        int ma = sc.nextInt();
        boolean thayma = false;
        for (int i = 0; i < n; i++) {
            if (ct2[i].getMachitietphieunhap() == ma) {
                System.out.println("Đã tìm thấy:");
                thayma = true;
                ct2[i].xuat();
                break;
            }
        }
        if (!thayma) {
            System.out.println("Không tìm thấy mã chi tiết phiếu nhập");
        }
    }
	
	public  void goi3() {
		DANHSACH2 ds = new DANHSACH2();
		ds.codecung2(new chitiet2 (2514,125,5,100,500));
		ds.codecung2(new chitiet2 (15421,415,3,125,375));
		ds.codecung2(new chitiet2 (9,102,5,50,250));
		ds.codecung2(new chitiet2 (20,145,7,200,1400));
		ds.codecung2(new chitiet2 (300,115,6,375,2250));
		while (true) {
	        System.out.println("====Menu====");
	        System.out.println("1. Thêm phiếu chi tiết ");
	        System.out.println("2. Xóa phiếu nhập chi tiết");
	        System.out.println("3. Tim kiem phiếu nhập chi tiết");
	        System.out.println("4. Xuất danh sách phiếu nhập chi tiết ");
	        System.out.println("5. Thống kê");
	        System.out.println("6. quay ve man hinh chinh ");
	        System.out.println("0. Thoat");
	        System.out.print("Chon thao tac: ");
	        Scanner sc = new Scanner(System.in);
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                ds.themds();
	                break;
	            case 2:
	                ds.xoads();
	                break;
	            case 3:
	                ds.timkiemds();
	                break;
	            case 4:
	                ds.xuatds();
	                break;
	            case 5:
	            	ds.demctpn();
	            	break;
	            case 6:
	            	//cocc cc;
                	cocc cc= new cocc();
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
	public void demctpn() {
		int dem=0;
		for(int i=0 ; i<n ; i++) {
			ct2[i].xuat1();
			dem++;
		}
		System.out.println("CÓ ("+ dem+") mã chi tiết phiếu nhập");
	}	
}




















