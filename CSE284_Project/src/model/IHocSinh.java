package model;

import java.time.LocalDate;

public interface IHocSinh {
	public String getMaHS();
	public String getTenHS();
	public String getLop();
	public LocalDate getNgaySinh();
	public String getGioiTinh();
	public String getDiaChi();
	public double getDiemTB();
	public String getHanhKiem();
	public void nhap() throws Exception;
	public void xuat();
}
