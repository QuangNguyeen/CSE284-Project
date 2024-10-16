package model;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HocSinh implements IHocSinh {
	private String maHS;
	private String tenHS;
	private String lop;
	private LocalDate ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private double diemTB;
	private String hanhKiem;
	private String truong;
	/**
	 * Default constructor
	 * */
	public HocSinh() {
		
	}
	/**
	 * Constructor a new HocSinh with initial values
	 * @param diemTB 
	 * @param gioiTinh 
	 * @param maHS: The identification
	 * @param tenHS: The name of HocSinh
	 * @param lop: The class in school
	 * @param ngaySinh: The date of birth
	 * @param gioiTinh: The gender of pupil
	 * @param diaChi: The home address
	 * @param diemTB: The grade point average
	 * @param hanhKiem: The behavior rating
	 * @param truong: The name of school
	 * */
	public HocSinh(String _maHS, String _tenHS, String _lop, LocalDate _ngaySinh, String _gioiTinh, String _diaChi, float _diemTB, String _hanhKiem, String _truong) {
		this.maHS = _maHS;
		this.tenHS = _tenHS;
		this.lop = _lop;
		this.ngaySinh = _ngaySinh;
		this.gioiTinh = _gioiTinh;
		this.diaChi = _diaChi;
		this.diemTB = _diemTB;
		this.hanhKiem = _hanhKiem;
		this.truong = _truong;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(double d) {
		this.diemTB = d;
	}
	public String getHanhKiem() {
		return hanhKiem;
	}
	public void setHanhKiem(String hanhKiem) {
		this.hanhKiem = hanhKiem;
	}
	public String getTruong() {
		return truong;
	}
	public void setTruong(String truong) {
		this.truong = truong;
	}
	@Override
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap Ma Hoc Sinh: ");
		setMaHS(sc.nextLine());
		System.out.println("Nhap Ten Hoc Sinh: ");
		setTenHS(sc.nextLine());
		System.out.println("Nhap Lop: ");
		setLop(sc.nextLine());
		while(true) {
			try {
				System.out.println("Nhap Ngay sinh(yyyy-mm-dd): ");
				setNgaySinh(LocalDate.parse(sc.nextLine()));
				break;
			}catch(Exception e) {
				System.out.println("Thong tin khong dung dinh dang");
			}
		}
		System.out.println("Nhap Gioi Tinh: ");
		setGioiTinh(sc.nextLine());
		System.out.println("Nhap Dia chi nha: ");
		setDiaChi(sc.nextLine());
		while(true) {
			try {
				System.out.println("Nhap Diem Trung Binh: ");
				double diemTB = sc.nextDouble();
				if(diemTB >= 0 && diemTB <= 10) {setDiemTB(diemTB); break;}
				else System.out.println("Diem Trung binh phai trong khoang 0 - 10");
			}catch(InputMismatchException e) {
				System.out.println("Diem trung binh phai la so");
				sc.nextLine();
			}
		}
		sc.nextLine();
		System.out.println("Nhap Hanh Kiem: ");
		setHanhKiem(sc.nextLine());
		System.out.println("Nhap Truong: ");
		setTruong(sc.nextLine());
	}
	@Override
	public void xuat() {
		System.out.println("Truong:    " + getTruong());
		System.out.println("Ma HS:     " + getMaHS());
		System.out.println("Ten:       " + getTenHS());
		System.out.println("Lop:       " + getLop());
		System.out.println("Ngay Sinh: " + getNgaySinh());
		System.out.println("Gioi Tinh: " + getGioiTinh());
		System.out.println("Dia Chi:   " + getDiaChi());
		System.out.println("Diem TB:   " + getDiemTB());
		System.out.println("Hanh Kiem: " + getHanhKiem());
	}
}
