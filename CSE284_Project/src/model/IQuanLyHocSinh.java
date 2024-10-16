package model;

import java.io.IOException;

public interface IQuanLyHocSinh {
	public void updateHocSinh(String maHS) throws Exception;
	public HocSinh searchHocSinh(String maHS);
	public void removeHocSinh(String maHS);
	public void addHocSinhTieuHoc(HocSinhTieuHoc hs);
	public void addHocSinhTHCS(HocSinhTHCS hs);
	public void addHocSinhTHPT(HocSinhTHPT hs);
	public boolean isExistHoc(String maHS);
	public int typeHocSinh(String maHS);
	
	public void loadFromFile(String filePath) throws IOException;
	public void saveFile(String filePath);
}
