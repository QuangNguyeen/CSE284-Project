package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.*;

import java.util.ArrayList;
public class MainFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> comboBoxCapHoc;
    private QuanLyHocSinh quanLyHocSinh;
    
    public MainFrame() {
    	quanLyHocSinh = new QuanLyHocSinh();
        setTitle("QUAN LY HOC SINH");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Display center 

        // Create component of GUI
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Chức năng");
        JMenuItem itemThem = new JMenuItem("THEM");
        JMenuItem itemXoa = new JMenuItem("XOA");
        JMenuItem itemTimKiem = new JMenuItem("TIM KIEM");
        JMenuItem itemLoadFromFile = new JMenuItem("Load From File");
        JMenuItem itemLuuFile = new JMenuItem("Save File");
        menu.add(itemThem);
        menu.add(itemXoa);
        menu.add(itemTimKiem);
        menu.add(itemLoadFromFile);
        menu.add(itemLuuFile);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // Combo box level
        String[] capHoc = {"1", "2", "3"};
        comboBoxCapHoc = new JComboBox<>(capHoc);
        JLabel labelCapHoc = new JLabel("Cap Hoc:");
        comboBoxCapHoc.setSelectedIndex(0);
        comboBoxCapHoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCapHoc = (String) comboBoxCapHoc.getSelectedItem();
                updateTableColumns(selectedCapHoc);
                updateTableData();
            }
        });
        panel.add(labelCapHoc);
        panel.add(comboBoxCapHoc);

        // Create 
        String[] columnNames = {"MaHS", "Ten", "Lop", "NgaySinh", "Gioi Tinh", "Dia Chi", "DiemTB", "Hanh Kiem", "Truong", "NgoaiKhoa"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        // Setup layout GUI
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        updateTableData();
        
       /**
        * Process Event
        */
        itemThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                InforFrame fr = new InforFrame(MainFrame.this);
                fr.setLocationRelativeTo(null);
                fr.setVisible(true);
                quanLyHocSinh = new QuanLyHocSinh();
            	updateTableData();
            }
        });
        itemXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(MainFrame.this,"Vui long chon Hoc Sinh", "Loi", JOptionPane.ERROR_MESSAGE);
                }else{
                    int comfirm = JOptionPane.showConfirmDialog(MainFrame.this, "Ban chac chan muon xoa khong ?");
                    if(comfirm == JOptionPane.YES_OPTION){
                        String maHS = String.valueOf(table.getValueAt(row, 0));
                        removeHocSinh(maHS);
                    }
                }
                quanLyHocSinh = new QuanLyHocSinh();
            	updateTableData();
            } 
        });
        itemTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SearchFrame fr = new SearchFrame(MainFrame.this);
            }
        });
        itemLoadFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(quanLyHocSinh.getDsHocSinh().isEmpty())
            	try {
                    quanLyHocSinh.loadFromFile("./res/data.txt");
		} catch (IOException e1) {
		// TODO Auto-generated catch block
                    e1.printStackTrace();
		}
            	updateTableData();
            }
        });
        itemLuuFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!quanLyHocSinh.getDsHocSinh().isEmpty()){
                    quanLyHocSinh.saveFile("./res/data.txt");
                }
            }
        });

    }
    // Update 
    private void updateTableColumns(String capHoc) {
        switch (capHoc) {
            case "1":
                String[] cap1Columns = {"MaHS", "Ten", "Lop", "NgaySinh", "Gioi Tinh", "Dia Chi", "DiemTB", "Hanh Kiem", "Truong", "HD Ngoai Khoa"};
                tableModel.setColumnIdentifiers(cap1Columns);
                break;
            case "2":
                String[] cap2Columns = {"MaHS", "Ten", "Lop", "NgaySinh", "Gioi Tinh", "Dia Chi", "DiemTB", "Hanh Kiem", "Truong", "Huong Nghiep", "Doan Vien"};
                tableModel.setColumnIdentifiers(cap2Columns);
                break;
            case "3":
                String[] cap3Columns = {"MaHS", "Ten", "Lop", "NgaySinh", "Gioi Tinh", "Dia Chi", "DiemTB", "Hanh Kiem", "Truong", "ToHop", "DiemToHop", "Dang Vien", "Nguyen Vong"};
                tableModel.setColumnIdentifiers(cap3Columns);
                break;
            default:
                String[] defaultColumns = {"MaHS", "Ten", "Lop", "NgaySinh", "Gioi Tinh", "Dia Chi", "DiemTB", "Hanh Kiem", "Truong"};
                tableModel.setColumnIdentifiers(defaultColumns);
        }
    }
    public void updateTableData() {
    	String capHoc = (String) comboBoxCapHoc.getSelectedItem();
        tableModel.setRowCount(0);
        for (HocSinh hs : quanLyHocSinh.getDsHocSinh()) {
            Object[] rowData;

            if (capHoc.equals("1") && hs instanceof HocSinhTieuHoc) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTieuHoc) hs).getHoatDongNgoaiKhoa()
                };
                tableModel.addRow(rowData);
            } else if (capHoc.equals("2") && hs instanceof HocSinhTHCS) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTHCS) hs).getHuongNghiep(),
                    ((HocSinhTHCS) hs).isDoanVien()
                };
                tableModel.addRow(rowData);
            } else if (capHoc.equals("3") && hs instanceof HocSinhTHPT) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTHPT) hs).getToHop(),
                    ((HocSinhTHPT) hs).getDiemToHop(),
                    ((HocSinhTHPT) hs).isDangVien(),
                    ((HocSinhTHPT) hs).getNguyenVong()
                };
                tableModel.addRow(rowData);
            }
        }
        
    }
    public void addHocSinh(HocSinh hocSinh){
        quanLyHocSinh.addHocSinh(hocSinh);
    }
    public void removeHocSinh(String maHS){
        quanLyHocSinh.removeHocSinh(maHS);
    }
    public void searchHocSinh(String maHS){
        HocSinh hs = quanLyHocSinh.searchHocSinh(maHS);
        tableModel.setRowCount(0);
        ArrayList<HocSinh> dsHocSinh = new ArrayList<HocSinh>();
        Object[] rowData;
        if(hs != null){
            dsHocSinh.add(hs);
        }
        String capHoc = "";
        if(hs instanceof HocSinhTieuHoc){
            capHoc = "1";
        }else if (hs instanceof HocSinhTHCS){
            capHoc = "2";
        }else{
            capHoc = "3";
        }
        if (capHoc.equals("1") && hs instanceof HocSinhTieuHoc) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTieuHoc) hs).getHoatDongNgoaiKhoa()
                };
                tableModel.addRow(rowData);
            } else if (capHoc.equals("2") && hs instanceof HocSinhTHCS) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTHCS) hs).getHuongNghiep(),
                    ((HocSinhTHCS) hs).isDoanVien()
                };
                tableModel.addRow(rowData);
            } else if (capHoc.equals("3") && hs instanceof HocSinhTHPT) {
                rowData = new Object[] {
                    hs.getMaHS(),
                    hs.getTenHS(),
                    hs.getLop(),
                    hs.getNgaySinh(),
                    hs.getGioiTinh(),
                    hs.getDiaChi(),
                    hs.getDiemTB(),
                    hs.getHanhKiem(),
                    hs.getTruong(),
                    ((HocSinhTHPT) hs).getToHop(),
                    ((HocSinhTHPT) hs).getDiemToHop(),
                    ((HocSinhTHPT) hs).isDangVien(),
                    ((HocSinhTHPT) hs).getNguyenVong()
                };
                tableModel.addRow(rowData);
            }
    }
    public void saveFile(){
        quanLyHocSinh.saveFile("./res/data.txt");
    }

}

