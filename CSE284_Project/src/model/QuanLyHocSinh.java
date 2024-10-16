package model;
import java.io.*;
import java.util.ArrayList;

import controller.DBManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class QuanLyHocSinh implements IQuanLyHocSinh {
	private DBManager dBManager;
	private ArrayList<HocSinh> dsHocSinh;
    
	public QuanLyHocSinh() {
		dBManager = new DBManager();
		dsHocSinh = dBManager.getAllHocSinh();
	}
        // Getter
	public ArrayList<HocSinh> getDsHocSinh() {
		return dsHocSinh;
	}
	/**
	 * Cap nhat thong tin cua HocSinh trong danh sach
	 * @param maHS
	 * */
	public void updateHocSinh(String maHS) throws Exception {
	    if (!isExistHoc(maHS)) {
	        System.out.println("Hoc sinh khong ton tai trong danh sach.");
	        return;
	    }

	    System.out.println("Nhap lai thong tin hoc sinh.");
	    int capHoc = typeHocSinh(maHS);
	    
	    switch (capHoc) {
	        case 1:
	            HocSinhTieuHoc updateHS_TieuHoc = new HocSinhTieuHoc();
	            updateHS_TieuHoc.nhap();
	            dsHocSinh.set(getIndexOfHsTieuHoc(maHS), updateHS_TieuHoc);
	            break;

	        case 2:
	            HocSinhTHCS updateHS_THCS = new HocSinhTHCS();
	            updateHS_THCS.nhap();
	            dsHocSinh.set(getIndexOfHsTHCS(maHS), updateHS_THCS);
	            break;

	        case 3:
	            HocSinhTHPT updateHS_THPT = new HocSinhTHPT();
	            updateHS_THPT.nhap();
	            dsHocSinh.set(getIndexOfHsTHPT(maHS), updateHS_THPT);
	            break;

	        default:
	            throw new IllegalArgumentException("Cap hoc khong hop le.");
	    }
	}
	/**
	 * Hien thi thong tin hoc HocSinh neu tim thay
	 * @param maHS
	 * */
	public HocSinh searchHocSinh(String maHS) {
            if (!isExistHoc(maHS)) {
                System.out.println("Khong tim thay Hoc Sinh");
                return null; // Trả về null nếu không tìm thấy học sinh
            } else {
            int capHoc = typeHocSinh(maHS);
            switch (capHoc) {
                case 1:
                    return dsHocSinh.get(getIndexOfHsTieuHoc(maHS)); 
                case 2:
                    return dsHocSinh.get(getIndexOfHsTHCS(maHS)); 
                case 3:
                    return dsHocSinh.get(getIndexOfHsTHPT(maHS));
                default:
                    System.out.println("Loai hoc sinh khong hop le.");
                    return null; 
        }
    }
}
	/**
	 * Xoa hoc sinh khoi danh sach
	 * @param maHS
	 * */
	public void removeHocSinh(String maHS) {
	    if (!isExistHoc(maHS)) {
	        System.out.println("Hoc sinh khong ton tai");
	    } else {
	        dBManager.deleteHocSinh(maHS);
	       
	    }
	}
	/**
	 * Them HocSinhTieuHoc vao danh sach dsTieuHoc
	 * */
	public void addHocSinhTieuHoc(HocSinhTieuHoc hsTieuHoc){
	    if (isExistHoc(hsTieuHoc.getMaHS())) {
	        System.out.println("Hoc sinh da ton tai");
	    } else {
	        dsHocSinh.add(hsTieuHoc);
	    }
	}
	/**
	 * Them HocSinhTHCS vao danh sach dsTHCS
	 * */
	public void addHocSinhTHCS(HocSinhTHCS hsTHCS) {
	    if (isExistHoc(hsTHCS.getMaHS())) {
	        System.out.println("Hoc sinh da ton tai");
	    } else {
	        dsHocSinh.add(hsTHCS);
	    }
	}
	/**
	 * Them HocSinhTHPT vao danh sach dsTHPT
	 * */
	public void addHocSinhTHPT(HocSinhTHPT hsTHPT){
	    if (isExistHoc(hsTHPT.getMaHS())) {
	        System.out.println("Hoc sinh da ton tai");
	    } else {
	        dsHocSinh.add(hsTHPT);
	    }
	}
	public void addHocSinh(HocSinh hocSinh) {
	    if (isExistHoc(hocSinh.getMaHS())) {
	        System.out.println("Hoc sinh da ton tai");
	    } else {
	        dBManager.addHocSinh(hocSinh);
	    }
	}

	/**
	 * Kiem tra HocSinh co ton tai trong danh sach hay khong
	 * @param: maHS
	 * @return true neu ton tai; false neu khong ton tai
	 * */
	public boolean isExistHoc(String maHS) {
	    return typeHocSinh(maHS) != 0;
	}
	/**
	 * Lay ra kieu HocSinh
	 * @param maHS
	 * @return 1 - tieu hoc, 2 - THCS, 3 - THPT
	 * */
	public int typeHocSinh(String maHS) {
		if(getIndexOfHsTieuHoc(maHS) != -1) return 1;
		if(getIndexOfHsTHCS(maHS) != -1) 	return 2;
		if(getIndexOfHsTHPT(maHS) != -1)	return 3;
		return 0;
	}
	/**
	 * Lay dia chi cua HocSinhTieuHoc trong danh sach dsTieuHoc
	 * @param maHS
	 * @return index 
	 * */
	public int getIndexOfHsTieuHoc(String maHS) {
		for(int i = 0; i < dsHocSinh.size(); i++) {
			if(dsHocSinh.get(i).getMaHS().equals(maHS)) {
				return i;
			}
		}
		return -1;
	}
	public int getIndexOfHsTHCS(String maHS) {
		for(int i = 0; i < dsHocSinh.size(); i++) {
			if(dsHocSinh.get(i).getMaHS().equals(maHS)) {
				return i;
			}
		}
		return -1;
	}
	public int getIndexOfHsTHPT(String maHS) {
		for(int i = 0; i < dsHocSinh.size(); i++) {
			if(dsHocSinh.get(i).getMaHS().equals(maHS)) {
				return i;
			}
		}
		return -1;
	}
	public void xuat() {
		if (dsHocSinh.isEmpty()) {
	        System.out.println("Danh sach hoc sinh rong.");
	    } else {
	        System.out.println("Danh sach hoc sinh:");
	        for (HocSinh hocSinh : dsHocSinh) {
	            hocSinh.xuat(); 
	            System.out.println("-----------------------"); 
	        }
	    }
	}
	@Override
	public void loadFromFile(String filePath) throws IOException {
	    BufferedReader buffterReader = new BufferedReader(new FileReader(filePath));
	    String line;
	    while ((line = buffterReader.readLine()) != null) {
	        String[] parts = line.split("\\|"); 
	        
	        int typeHocSinh = Integer.parseInt(parts[0].trim());
	        String maHS = parts[1].trim();
	        String tenHS = parts[2].trim();
	        String lop = parts[3].trim();
	        
	        LocalDate ngaySinh = null;
	        try {
	            ngaySinh = LocalDate.parse(parts[4].trim());
	        } catch (DateTimeParseException e) {
	            e.printStackTrace();
	        }
	        
	        String gioiTinh = parts[5].trim();
	        String diaChi = parts[6].trim();
	        
	        float diemTB = Float.parseFloat(parts[7].trim().replace(",", "."));
	        String hanhKiem = parts[8].trim();
	        String truong = parts[9].trim();
	        
	        switch (typeHocSinh) {
	            case 1:
	                String hoatDongNgoaiKhoa = parts[10].trim();
	                HocSinhTieuHoc hocSinhTieuHoc = new HocSinhTieuHoc(maHS, tenHS, lop, ngaySinh, gioiTinh, diaChi, hanhKiem, diemTB, truong, hoatDongNgoaiKhoa);
	                dsHocSinh.add(hocSinhTieuHoc);
	                break;
	            case 2:
	                String huongNghiep = parts[10].trim();
	                boolean doanVien = Boolean.parseBoolean(parts[11].trim());
	                HocSinhTHCS hocSinhTHCS = new HocSinhTHCS(maHS, tenHS, lop, ngaySinh, diaChi, diemTB, hanhKiem, diemTB, gioiTinh, truong, huongNghiep, doanVien);
	                dsHocSinh.add(hocSinhTHCS);
	                break;
	            case 3:
	                String toHop = parts[10].trim();
	                float diemToHop = Float.parseFloat(parts[11].trim().replace(",", "."));
	                boolean dangVien = Boolean.parseBoolean(parts[12].trim());
	                String nguyenVong = parts[13].trim();
	                HocSinhTHPT hocSinhTHPT = new HocSinhTHPT(maHS, tenHS, lop, ngaySinh, gioiTinh, diaChi, diemTB, hanhKiem, truong, toHop, diemToHop, dangVien, nguyenVong);
	                dsHocSinh.add(hocSinhTHPT);
	                break;
	            default:
	                System.out.println("Invalid type HocSinh: " + typeHocSinh);
	                break;
	        }
	    }
	    buffterReader.close();
	}

	@Override
	public void saveFile(String filePath) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        for (HocSinh hocSinh : dsHocSinh) {
	            
	            int typeHocSinh = 0;

	            if (hocSinh instanceof HocSinhTieuHoc) {
	                typeHocSinh = 1;
	                HocSinhTieuHoc hsTieuHoc = (HocSinhTieuHoc) hocSinh;
	                writer.write(String.format("%d|%s|%s|%s|%s|%s|%s|%.2f|%s|%s|%s%n", 
	                        typeHocSinh, 
	                        hsTieuHoc.getMaHS(), 
	                        hsTieuHoc.getTenHS(), 
	                        hsTieuHoc.getLop(), 
	                        hsTieuHoc.getNgaySinh(), 
	                        hsTieuHoc.getGioiTinh(), 
	                        hsTieuHoc.getDiaChi(), 
	                        hsTieuHoc.getDiemTB(), 
	                        hsTieuHoc.getHanhKiem(), 
	                        hsTieuHoc.getTruong(), 
	                        hsTieuHoc.getHoatDongNgoaiKhoa()));

	            } else if (hocSinh instanceof HocSinhTHCS) {
	                typeHocSinh = 2;
	                HocSinhTHCS hsTHCS = (HocSinhTHCS) hocSinh;
	                writer.write(String.format("%d|%s|%s|%s|%s|%s|%s|%.2f|%s|%s|%s|%b%n", 
	                        typeHocSinh, 
	                        hsTHCS.getMaHS(), 
	                        hsTHCS.getTenHS(), 
	                        hsTHCS.getLop(), 
	                        hsTHCS.getNgaySinh(), 
	                        hsTHCS.getGioiTinh(), 
	                        hsTHCS.getDiaChi(), 
	                        hsTHCS.getDiemTB(), 
	                        hsTHCS.getHanhKiem(), 
	                        hsTHCS.getTruong(), 
	                        hsTHCS.getHuongNghiep(), 
	                        hsTHCS.isDoanVien()));

	            } else if (hocSinh instanceof HocSinhTHPT) {
	                typeHocSinh = 3;
	                HocSinhTHPT hsTHPT = (HocSinhTHPT) hocSinh;
	                writer.write(String.format("%d|%s|%s|%s|%s|%s|%s|%.2f|%s|%s|%s|%.2f|%b|%s%n", 
	                        typeHocSinh, 
	                        hsTHPT.getMaHS(), 
	                        hsTHPT.getTenHS(), 
	                        hsTHPT.getLop(), 
	                        hsTHPT.getNgaySinh(), 
	                        hsTHPT.getGioiTinh(), 
	                        hsTHPT.getDiaChi(), 
	                        hsTHPT.getDiemTB(), 
	                        hsTHPT.getHanhKiem(), 
	                        hsTHPT.getTruong(), 
	                        hsTHPT.getToHop(), 
	                        hsTHPT.getDiemToHop(), 
	                        hsTHPT.isDangVien(), 
	                        hsTHPT.getNguyenVong()));
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error save file: " + e.getMessage());
	    }
	}
}
