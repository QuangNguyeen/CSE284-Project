package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
public class HocSinhTHCS extends HocSinh implements IHocSinhTHCS, Serializable {
	private String huongNghiep;
	private boolean isDoanVien;
	public String getHuongNghiep() {
		return huongNghiep;
	}
	public void setHuongNghiep(String _huongNghiep) {
		this.huongNghiep = _huongNghiep;
	}
	public boolean isDoanVien() {
		return isDoanVien;
	}
	public void setDoanVien(boolean _isDoanVien) {
		this.isDoanVien = _isDoanVien;
	}
	/**
	 * Default constructor
	 * */
	public HocSinhTHCS() {
		
	}
	/**
	 * Constructor a new HocSinhTHCS with initial values
	 * @param huongNghiep: Chuyen / Thuong / GDTX
	 * @param isDoanVien:  Tinh trang doan vien cua HocSinhTHCS: true / false
	 * 						16 Years can be Doan Vien
	 * */
	public HocSinhTHCS(String _maHS, String _tenHS, String _lop, LocalDate _ngaySinh, String _diaChi, float _diem, String _hanhKiem, float _diemTB, String _gioiTinh, String _truong, String _huongNghiep, boolean _isDoanVien) {
		super(_maHS,  _tenHS,  _lop,  _ngaySinh,  _gioiTinh,  _diaChi,  _diemTB,  _hanhKiem,  _truong);
		this.huongNghiep = _huongNghiep;
		this.isDoanVien = _isDoanVien;
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
		System.out.println("Huong Nghiep (Chuyen / Thuong / GDTX ): ");
		setHuongNghiep(sc.nextLine());
		System.out.println("Doan Vien (true/false): ");
		setDoanVien(sc.nextBoolean());
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Doan vien: " + isDoanVien());
		System.out.println("Huong nghiep sau THCS: " + getHuongNghiep());
	}
}
