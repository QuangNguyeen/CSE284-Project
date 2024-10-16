package model;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Scanner;

public class HocSinhTieuHoc extends HocSinh implements Serializable {
	private String hoatDongNgoaiKhoa;
	/**
	 * Default constructor
	 * */
	public HocSinhTieuHoc() {
		
	}
	/**
	 * Constructor a new HocSinhTieuHoc with initial values
	 * @param hoatDongNgoaiKhoa: Pupil learn new knowledge outside
	 * */
	public HocSinhTieuHoc(String _maHS, String _tenHS, String _lop, LocalDate _ngaySinh, String _gioiTinh, String _diaChi, String _hanhKiem, float _diemTB,  String _truong, String _hoatDong) {
		super(_maHS,  _tenHS,  _lop,  _ngaySinh,  _gioiTinh,  _diaChi,  _diemTB,  _hanhKiem,  _truong);
		this.hoatDongNgoaiKhoa = _hoatDong;
	}
	public String getHoatDongNgoaiKhoa() {
		return hoatDongNgoaiKhoa;
	}
	Scanner sc = new Scanner(System.in);
	public void nhap() {
		try {
			super.nhap();
			System.out.println("Hoat dong ngoai khoa: ");
			setHoatDongNgoaiKhoa(sc.nextLine());
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	public void xuat() {
		try {
			super.xuat();
			System.out.println(getHoatDongNgoaiKhoa());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setHoatDongNgoaiKhoa(String hoatDongNgoaiKhoa) {
		this.hoatDongNgoaiKhoa = hoatDongNgoaiKhoa;
	}
}
