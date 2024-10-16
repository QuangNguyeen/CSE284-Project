package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
public class HocSinhTHPT extends HocSinh implements IHocSinhTHPT, Serializable{
	private String toHop;
	private double diemToHop;
	private boolean isDangVien;
	private String nguyenVong;
	
	/**
	 * Default constructor
	 * */
	public HocSinhTHPT() {
		
	}
	/**
	 * Constructor a new HocSinhTHPT with initial values
	 * @param toHop: A00, B00, C, D etc ...
	 * @param diemToHop: Total score of 3 subjects in the group
	 * @param isDangVien: 18 Age can be DangVien
	 * @param nguyenVong: Pupil' wishes when graduating from high school
	 * */
	public HocSinhTHPT(String _maHS, String _tenHS, String _lop, LocalDate _ngaySinh, String _gioiTinh, String _diaChi, float _diemTB, String _hanhKiem, String _truong,  String _toHop, double _diemToHop, boolean _isDangVien, String _nguyenVong
			) {
		super(_maHS,  _tenHS,  _lop,  _ngaySinh,  _gioiTinh,  _diaChi,  _diemTB,  _hanhKiem,  _truong);
		this.toHop = _toHop;
		this.diemToHop = _diemToHop;
		this.isDangVien = _isDangVien;
		this.nguyenVong = _nguyenVong;
	}
	public String getToHop() {
		return toHop;
	}
	public void setToHop(String toHop) {
		this.toHop = toHop;
	}
	public double getDiemToHop() {
		return diemToHop;
	}
	public void setDiemToHop(double diemToHop) {
		this.diemToHop = diemToHop;
	}
	public boolean isDangVien() {
		return isDangVien;
	}
	public void setDangVien(boolean isDangVien) {
		this.isDangVien = isDangVien;
	}
	public String getNguyenVong() {
		return nguyenVong;
	}
	public void setNguyenVong(String nguyenVong) {
		this.nguyenVong = nguyenVong;
	}
	@Override
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			super.nhap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nhap To Hop: ");
		setToHop(sc.nextLine());
		while(true) {
			try {
				System.out.println("Nhap Diem To Hop: ");
				double diemToHop = sc.nextDouble();
				if(diemToHop >= 0 && diemToHop<= 30) {
					setDiemToHop(diemToHop);
				}else {
					System.out.println("Diem to hop phai trong khoang 0 - 30");
				}
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Co phai Dang Vien khong (true/false): ");
		sc.nextLine();
		setDangVien(sc.nextBoolean());
		sc.nextLine();
		System.out.println("Nhap Nguyen Vong: ");
		setNguyenVong(sc.nextLine());
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("To Hop:       " + getToHop());
		System.out.println("Diem Top Hop: " + getDiemToHop());
		System.out.println("Dang Vien:    " + isDangVien());
		System.out.println("Nguyen Vong:  " + getNguyenVong());
	}
	
}
