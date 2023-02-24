/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterFace;

import DAO.BacLuongDAO;
import DAO.LuongCoBanDAO;
import DAO.NhanVienDAO;
import DAO.PhuCapDAO;
import DAO.QuanLyLuongDAO;
import Helper.MsgBox;
import Model.BacLuong;
import Model.Luong;
import Model.LuongCoBan;
import Model.NhanVien;
import Model.PhuCap;
import java.text.ParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLyLuong extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLLuong
     */
    public QuanLyLuong() {
        initComponents();
        init();
    }

    void init() {
        this.fillComboBoxBacLuong();
        this.fillComboBoxLuongCoBan();
        this.fillComboBoxPhuCap();
        this.fillToTable();
        this.fillToTableNhanVien();
    }

    QuanLyLuongDAO dao = new QuanLyLuongDAO();
    PhuCapDAO pcdao = new PhuCapDAO();
    BacLuongDAO bldao = new BacLuongDAO();
    LuongCoBanDAO lcbdao = new LuongCoBanDAO();
    NhanVienDAO nvdao = new NhanVienDAO();
    Float thucLinh;
    String strFind = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        btnSeach = new javax.swing.JButton();
        txtTenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSoNgayLam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGioLamThem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboPhuCap = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTamUng = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTienThuong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtThucLinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboBacLuong = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboLuongCoBan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLuong = new javax.swing.JTable();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiemTheoTen = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QUẢN LÝ LƯƠNG NHÂN VIÊN");

        jLabel11.setText("Năm:");

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029" }));

        jLabel1.setText("Tháng lương:");

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel2.setText("Mã nhân viên:");

        btnSeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSeach.setText("Tìm kiếm");
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        txtTenNV.setEditable(false);

        jLabel3.setText("Tên nhân viên:");

        jLabel4.setText("Số ngày làm:");

        txtSoNgayLam.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoNgayLamCaretUpdate(evt);
            }
        });

        jLabel5.setText("Giờ làm thêm:");

        txtGioLamThem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGioLamThemCaretUpdate(evt);
            }
        });
        txtGioLamThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioLamThemActionPerformed(evt);
            }
        });

        jLabel7.setText("Phụ cấp:");

        cboPhuCap.setEditable(true);
        cboPhuCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhuCapActionPerformed(evt);
            }
        });

        jLabel8.setText("Tạm ứng:");

        txtTamUng.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTamUngCaretUpdate(evt);
            }
        });

        jLabel6.setText("Tiền thưởng:");

        txtTienThuong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThuongCaretUpdate(evt);
            }
        });

        jLabel12.setText("Thực lĩnh:");

        txtThucLinh.setEditable(false);
        txtThucLinh.setText("0.0");
        txtThucLinh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtThucLinhCaretUpdate(evt);
            }
        });

        jLabel9.setText("Bậc lương:");

        cboBacLuong.setEditable(true);
        cboBacLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBacLuongActionPerformed(evt);
            }
        });

        jLabel10.setText("Lương cơ bản:");

        cboLuongCoBan.setEditable(true);
        cboLuongCoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLuongCoBanActionPerformed(evt);
            }
        });

        tblLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Năm", "Tháng", "Mã NV", "Tên NV", "Số ngày làm", "Giờ làm thêm", "Phụ cấp", "Bậc lương", "Lương cơ bản", "Tạm ứng", "Tiền thưởng", "Thực lĩnh"
            }
        ));
        tblLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLuong);

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Document.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel11)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                    .addComponent(btnSeach))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel1)
                                    .addGap(34, 34, 34)
                                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(27, 27, 27)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addComponent(txtSoNgayLam)
                                .addComponent(txtGioLamThem))
                            .addGap(165, 165, 165)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTamUng, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(cboPhuCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienThuong)
                                    .addComponent(txtThucLinh)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cboBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cboLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeach)
                    .addComponent(jLabel7)
                    .addComponent(cboPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTamUng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNgayLam))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGioLamThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtThucLinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("QUẢN LÝ LƯƠNG", jPanel1);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Địa chỉ", "Trình độ", "Mã phòng", "Chức vụ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        jLabel13.setText("TÌM KIẾM THEO TÊN:");

        txtTimKiemTheoTen.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemTheoTenCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemTheoTen)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTimKiemTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("NHÂN VIÊN", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setModelNhanVien(NhanVien tk) {

        try {
            txtMaNV.setText(tk.getMaNV());
            txtTenNV.setText(tk.getTenNV());
            cboNam.setSelectedIndex(0);
            cboBacLuong.setSelectedIndex(0);
            cboLuongCoBan.setSelectedIndex(0);
            cboPhuCap.setSelectedIndex(0);
            cboThang.setSelectedIndex(0);
            txtGioLamThem.setText("");
            txtSoNgayLam.setText("");
            txtTamUng.setText("");
            txtThucLinh.setText("");
            txtTienThuong.setText("");
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void selectToTable() {
        DefaultTableModel tbModel = (DefaultTableModel) tblNhanVien.getModel();
        tbModel.setRowCount(0);//Xoa data trong table
        for (NhanVien nv : dao.findNhanVienByName(strFind)) {
            Object dataRow[] = new Object[8];
            dataRow[0] = nv.getMaNV();
            dataRow[1] = nv.getTenNV();
            dataRow[2] = nv.getNgaySinh();
            dataRow[3] = nv.getGioiTinh();
            dataRow[4] = nv.getDiaChi();
            dataRow[5] = nv.getTrinhDo();
            dataRow[6] = nv.getMaPhong();
            dataRow[7] = nv.getChucVu();

            tbModel.addRow(dataRow);
        }
    }

    public void fillToTableNhanVien() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);//clear table
        try {
            for (NhanVien nv : nvdao.getAllNhanVien()) {
                Object rowData[] = new Object[8];
                rowData[0] = nv.getMaNV();
                rowData[1] = nv.getTenNV();
                rowData[2] = nv.getNgaySinh();
                rowData[3] = nv.getGioiTinh();
                rowData[4] = nv.getDiaChi();
                rowData[5] = nv.getTrinhDo();
                rowData[6] = nv.getMaPhong();
                rowData[7] = nv.getChucVu();

                model.addRow(rowData);
            }
        } catch (Exception e) {
            //e.printStackTrace();

        }
    }

    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblLuong.getModel();
        model.setRowCount(0);//clear table
        try {
            for (Luong tk : dao.getAllLuong()) {
                Object rowData[] = new Object[12];
                rowData[0] = tk.getNam();
                rowData[1] = tk.getThang();
                rowData[2] = tk.getMaNV();
                rowData[3] = tk.getTenNV();
                rowData[4] = tk.getSoNgayLam();
                rowData[5] = tk.getGioLamThem();
                rowData[6] = tk.getPhuCap();
                rowData[7] = tk.getBacLuong();
                rowData[8] = tk.getLuongCoBan();
                rowData[9] = tk.getTamUng();
                rowData[10] = tk.getTienThuong();
                rowData[11] = tk.getThucLinh();
                model.addRow(rowData);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void fillComboBoxPhuCap() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhuCap.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<PhuCap> list = pcdao.getAllPhuCap();
            for (PhuCap cd : list) {
                model.addElement(cd);
            }
            cboPhuCap.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void chonPhuCap() {
        PhuCap pc = (PhuCap) cboPhuCap.getSelectedItem();
//        model.setMaCD(ChuyenDe.getMaCD());
    }

    void fillComboBoxBacLuong() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboBacLuong.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<BacLuong> list = bldao.getAllBacLuong();
            for (BacLuong cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void chonLuongCoBan() {
        LuongCoBan lcb = (LuongCoBan) cboLuongCoBan.getSelectedItem();
    }

    void fillComboBoxLuongCoBan() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLuongCoBan.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<LuongCoBan> list = lcbdao.getAllLuongCoBan();
            for (LuongCoBan cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void chonBacLuong() {
        BacLuong bl = (BacLuong) cboBacLuong.getSelectedItem();
    }

    public Luong getModel() throws ParseException {
        Luong tk = new Luong();
        tk.setNam(cboNam.getSelectedItem().toString());
        tk.setThang(cboThang.getSelectedItem().toString());
        tk.setMaNV(txtMaNV.getText());
        tk.setTenNV(txtTenNV.getText());
        tk.setSoNgayLam(txtSoNgayLam.getText());
        tk.setGioLamThem(txtGioLamThem.getText());
        PhuCap PhuCap = (PhuCap) cboPhuCap.getSelectedItem();
        tk.setPhuCap((String.valueOf(PhuCap.getPhuCap())));
        BacLuong BacLuong = (BacLuong) cboBacLuong.getSelectedItem();
        tk.setBacLuong((String.valueOf(BacLuong.getBacLuong())));
        LuongCoBan LuongCoBan = (LuongCoBan) cboLuongCoBan.getSelectedItem();
        tk.setLuongCoBan((String.valueOf(LuongCoBan.getLuongCoBan())));
        tk.setTamUng(txtTamUng.getText());
        tk.setTienThuong(txtTienThuong.getText());
        tk.setThucLinh(txtThucLinh.getText());

        return tk;
    }

    public void setModel(Luong tk) {

        try {
            cboNam.setSelectedItem(tk.getNam());
            cboThang.setSelectedItem(tk.getThang());
            txtGioLamThem.setText(tk.getGioLamThem());
            txtMaNV.setText(tk.getMaNV());
            txtSoNgayLam.setText(tk.getSoNgayLam());
            txtTamUng.setText(tk.getTamUng());
            txtTenNV.setText(tk.getTenNV());
            txtThucLinh.setText(tk.getThucLinh());
            txtTienThuong.setText(tk.getTienThuong());
            cboBacLuong.setSelectedItem(tk.getBacLuong());
            cboLuongCoBan.setSelectedItem(tk.getLuongCoBan());
            cboPhuCap.setSelectedItem(tk.getPhuCap());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public double tinhThucLinh() {
        LuongCoBan lcb = new LuongCoBan();
        lcb = (LuongCoBan) cboLuongCoBan.getSelectedItem();
        double luongCoBan = lcb.getLuongCoBan();

        BacLuong bl = new BacLuong();
        bl = (BacLuong) cboBacLuong.getSelectedItem();
        double bacLuong = bl.getBacLuong();

        PhuCap pc = new PhuCap();
        pc = (PhuCap) cboPhuCap.getSelectedItem();
        double phuCap = pc.getPhuCap();

        double tamUng = (Float.valueOf(txtTamUng.getText()));
        double tienThuong = (Float.valueOf(txtTienThuong.getText()));
        double soNgayLam = (Float.valueOf(txtSoNgayLam.getText()));
        double gioLamThem = (Float.valueOf(txtGioLamThem.getText()) * 100);
        double tienLamThem = (gioLamThem * 100);
//        double thucLinh = ((luongCoBan * bacLuong) * soNgayLam) + phuCap + tienThuong - tamUng + (gioLamThem * 100);
        double thucLinh = ((luongCoBan * bacLuong) * soNgayLam) + phuCap + tienThuong + tienLamThem - tamUng;
        txtThucLinh.setText((String.valueOf(thucLinh)));
        return thucLinh;
    }

    public boolean checkForm() {
        if (txtMaNV.getText().equals("")) {
            MsgBox.alert(this, "Mã nhân viên không được để trống");
            return false;
        }
//        if (txtTenNV.getText().equals("")) {
//            MsgBox.alert(this, "Tên nhân viên không được để trống");
//            return false;
//        }
        String pattenrn = "\\d{1,10}";
//        if (txtTenNV.getText().matches(pattenrn)) {
//            MsgBox.alert(this, "Tên NV không được chứa kí tự số!");
//            return false;
//        }
        if (txtSoNgayLam.getText().equals("")) {
            MsgBox.alert(this, "Số ngày làm không được để trống");
            return false;
        }
        String pattenrn1 = "\\d{1,100}";
        if (!txtSoNgayLam.getText().matches(pattenrn)) {
            MsgBox.alert(this, "Số ngày làm phải là số!");
            return false;
        }
        if ((Integer.valueOf(txtSoNgayLam.getText()))>31) {
            MsgBox.alert(this, "Số ngày làm tối đa là 31 ngày!");
            return false;
        }
        if (txtGioLamThem.getText().equals("")) {
            MsgBox.alert(this, "Giờ làm thêm không được để trống");
            return false;
        }
        if (!txtGioLamThem.getText().matches(pattenrn1)) {
            MsgBox.alert(this, "Giờ làm thêm phải là số!");
            return false;
        }
        if (txtTamUng.getText().equals("")) {
            MsgBox.alert(this, "Tạm ứng không được để trống");
            return false;
        }
        if (!txtTamUng.getText().matches(pattenrn1)) {
            MsgBox.alert(this, "Tạm ứng phải là số!!");
            return false;
        }
        if (txtTienThuong.getText().equals("")) {
            MsgBox.alert(this, "Tiền thưởng không được để trống");
            return false;
        }
        if (!txtTienThuong.getText().matches(pattenrn1)) {
            MsgBox.alert(this, "Tiền thưởng phải là số!!");
            return false;
        }

        return true;
    }

    public void Them() {
        if (MsgBox.confirm(this, "Bạn có muốn thêm lương mới không?")) {
            try {
                Luong ns = new Luong();
                ns.setNam((String) cboNam.getSelectedItem());
                ns.setThang((String) cboThang.getSelectedItem());
                ns.setMaNV(txtMaNV.getText());
                NhanVien nv = dao.getNhanVienByID(txtMaNV.getText());
                ns.setTenNV(nv.getTenNV());
                ns.setSoNgayLam(txtSoNgayLam.getText());
                ns.setGioLamThem(txtGioLamThem.getText());
                PhuCap PhuCap = (PhuCap) cboPhuCap.getSelectedItem();
                ns.setPhuCap((String.valueOf(PhuCap.getPhuCap())));
                BacLuong BacLuong = (BacLuong) cboBacLuong.getSelectedItem();
                ns.setBacLuong((String.valueOf(BacLuong.getBacLuong())));
                LuongCoBan LuongCoBan = (LuongCoBan) cboLuongCoBan.getSelectedItem();
                ns.setLuongCoBan((String.valueOf(LuongCoBan.getLuongCoBan())));
                ns.setTamUng(txtTamUng.getText());
                ns.setTienThuong(txtTienThuong.getText());
                ns.setThucLinh(txtThucLinh.getText());
                ns.setThucLinh((String.valueOf(tinhThucLinh())));

                dao.add(ns);
                MsgBox.alert(this, "Thêm thành công!");
                fillToTable();
                reset();
            } catch (Exception e) {
                //e.printStackTrace();
                MsgBox.alert(this, "Thêm thất bại, mã nhân viên đã tồn tại hoặc không tồn tại!");
            }
        }
    }

    void reset() {
        cboNam.setSelectedIndex(0);
        cboBacLuong.setSelectedIndex(0);
        cboLuongCoBan.setSelectedIndex(0);
        cboPhuCap.setSelectedIndex(0);
        cboThang.setSelectedIndex(0);
        txtGioLamThem.setText("");
        txtMaNV.setText("");
        txtSoNgayLam.setText("");
        txtTamUng.setText("");
        txtTenNV.setText("");
        txtThucLinh.setText("");
        txtTienThuong.setText("");
    }

    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        if (txtMaNV.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập mã nhân viên");
            return;
        }
        try {
            Luong ns = dao.getLuongByID(txtMaNV.getText());

            if (ns != null) {
                txtGioLamThem.setText(ns.getGioLamThem());
                txtSoNgayLam.setText(ns.getSoNgayLam());
                txtTamUng.setText(ns.getTamUng());
                txtTenNV.setText(ns.getTenNV());
                txtThucLinh.setText(ns.getThucLinh());
                txtTienThuong.setText(ns.getTienThuong());
                cboBacLuong.setSelectedItem(ns.getBacLuong());
                cboLuongCoBan.setSelectedItem(ns.getLuongCoBan());
                cboNam.setSelectedItem(ns.getNam());
                cboPhuCap.setSelectedItem(ns.getPhuCap());
                cboThang.setSelectedItem(ns.getThang());

            } else {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không đúng");
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_btnSeachActionPerformed

    private void txtSoNgayLamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoNgayLamCaretUpdate

    }//GEN-LAST:event_txtSoNgayLamCaretUpdate

    private void txtGioLamThemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGioLamThemCaretUpdate

    }//GEN-LAST:event_txtGioLamThemCaretUpdate

    private void txtGioLamThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioLamThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioLamThemActionPerformed

    private void cboPhuCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhuCapActionPerformed
        chonPhuCap();
    }//GEN-LAST:event_cboPhuCapActionPerformed

    private void txtTamUngCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTamUngCaretUpdate

    }//GEN-LAST:event_txtTamUngCaretUpdate

    private void txtTienThuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThuongCaretUpdate

    }//GEN-LAST:event_txtTienThuongCaretUpdate

    private void txtThucLinhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtThucLinhCaretUpdate

    }//GEN-LAST:event_txtThucLinhCaretUpdate

    private void cboBacLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBacLuongActionPerformed
        chonBacLuong();
    }//GEN-LAST:event_cboBacLuongActionPerformed

    private void cboLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLuongCoBanActionPerformed
        chonLuongCoBan();
    }//GEN-LAST:event_cboLuongCoBanActionPerformed

    private void tblLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLuongMouseClicked
        try {
            int id = tblLuong.rowAtPoint(evt.getPoint());
            String mabl = tblLuong.getValueAt(id, 2).toString();
            Luong tk = dao.getLuongByID(mabl);
            setModel(tk);
        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(this, "Error: MouseClick"+e.getMessage());
            //e.printStackTrace();
        }
    }//GEN-LAST:event_tblLuongMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        reset();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaNV.getText().equals("")) {
            sb.append("Mã nhân viên không được để trống!");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        } else {
            if (MsgBox.confirm(this, "Bạn chắc chắn muốn xóa!")) {
                if (dao.delLuongByID(txtMaNV.getText()) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    fillToTable();
                    reset();
                } else {
                    MsgBox.alert(this, "Sai mã nhân viên");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaNV.getText().equals("")) {
            sb.append("Mã nhân viên viên không được để trống!");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (MsgBox.confirm(this, "Bạn có muốn cập nhật lương mới không?")) {
            tinhThucLinh();
            try {
                Luong tk = getModel();
                if (dao.updateLuongByID(tk) > 0) {
                    MsgBox.alert(this, "Cập nhật thành công!");
                    fillToTable();
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Chưa nhập đầy đủ thông tin!");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkForm()) {
            tinhThucLinh();
            Them();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        try {
            int id = tblNhanVien.rowAtPoint(evt.getPoint());
            String mabl = tblNhanVien.getValueAt(id, 0).toString();
            NhanVien nv = dao.getNhanVienByID(mabl);
            setModelNhanVien(nv);
            jTabbedPane1.setSelectedIndex(0);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtTimKiemTheoTenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemTheoTenCaretUpdate
        strFind = txtTimKiemTheoTen.getText();
        selectToTable();
    }//GEN-LAST:event_txtTimKiemTheoTenCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSeach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboBacLuong;
    private javax.swing.JComboBox<String> cboLuongCoBan;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboPhuCap;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblLuong;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtGioLamThem;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSoNgayLam;
    private javax.swing.JTextField txtTamUng;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThucLinh;
    private javax.swing.JTextField txtTienThuong;
    private javax.swing.JTextField txtTimKiemTheoTen;
    // End of variables declaration//GEN-END:variables
}
