package UserInterFace;

import DAO.NhanVienDAO;
import DAO.PhongBanDAO;
import Helper.MsgBox;
import Model.NhanVien;
import Model.PhongBan;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVienJInternal extends javax.swing.JInternalFrame {

    DefaultTableModel modelProducts;
    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");

    public QuanLyNhanVienJInternal() {

        initComponents();
        setMaximizable(true);
        fillToTable();
        fillComboBoxPhongBan();
    }

    PhongBanDAO pbdao = new PhongBanDAO();

    public void fillComboBoxPhongBan() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbomaPhong.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            List<PhongBan> list = pbdao.getAllPhongBan();
            for (PhongBan cd : list) {
                model.addElement(cd);
            }
            cbomaPhong.setSelectedIndex(0);
        } catch (Exception e) {
            //e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);//clear table
        try {
            for (NhanVien nv : dao.getAllNhanVien()) {
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
            // e.printStackTrace();

        }
    }

    public void reset() {
        txtMa.setText("");
        txtTen.setText("");
        txtNgaySinh.setText("");

        txtDiaChi.setText("");
        txtTrinhDo.setText("");

        cboChucVu.setSelectedIndex(0);
        cbomaPhong.setSelectedIndex(0);
    }

    public NhanVien getModel() throws ParseException {
        NhanVien ns = new NhanVien();
        ns.setMaNV(txtMa.getText());
        ns.setTenNV(txtTen.getText());
        ns.setNgaySinh(txtNgaySinh.getText());
        ns.setDiaChi(txtDiaChi.getText());
        ns.setTrinhDo(txtTrinhDo.getText());
        ns.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
        ns.setChucVu((String) cboChucVu.getSelectedItem());
        ns.setMaPhong((String) cbomaPhong.getSelectedItem());
        return ns;
    }

    public void setModel(NhanVien ns) {
        txtMa.setText(ns.getMaNV());
        txtTen.setText(ns.getTenNV());
        txtNgaySinh.setText(ns.getNgaySinh().toString());
        txtTrinhDo.setText(ns.getTrinhDo());

        cbomaPhong.setSelectedItem(ns.getMaPhong());
        cboChucVu.setSelectedItem(ns.getChucVu());
        rdoNam.setSelected(ns.getGioiTinh() == 1);
        rdoNu.setSelected(ns.getGioiTinh() == 0);
        txtDiaChi.setText(ns.getDiaChi());
    }

    public boolean checkForm() {
        if (txtMa.getText().equals("")) {
            MsgBox.alert(this, "Mã nhân viên không được để trống");
            return false;
        }
        if (txtTen.getText().equals("")) {
            MsgBox.alert(this, "Tên nhân viên không được để trống");
            return false;
        }
        String pattenrn1 = "\\d{1,100}";
        if (txtTen.getText().matches(pattenrn1)) {
            MsgBox.alert(this, "Tên nhân viên không được nhập kí tự số!");
            return false;
        }
        if (txtDiaChi.getText().equals("")) {
            MsgBox.alert(this, "Địa chỉ không được để trống");
            return false;
        }
        if (txtNgaySinh.getText().equals("")) {
            MsgBox.alert(this, "Ngày sinh không được để trống");
            return false;
        }
        String reDate = "\\d{2}+/\\d{2}+/\\d{4}";
        if (!txtNgaySinh.getText().matches(reDate)) {
            MsgBox.alert(this, "Ngày sinh phải đúng định dạng dd/MM/yyyy");
            return false;
        }
        if (txtTrinhDo.getText().equals("")) {
            MsgBox.alert(this, "Trình độ không được để trống");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        btnSeach = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbomaPhong = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        txtTrinhDo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        cboChucVu = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QUẢN LÝ NHÂN VIÊN");
        setToolTipText("");

        jLabel1.setText("Mã nhân viên:");

        btnSeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSeach.setText("Tìm kiếm");
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        jLabel3.setText("Họ và tên:");

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("Giới tính:");

        buttonGroup2.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam ");

        buttonGroup2.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Trình độ:");

        jLabel2.setText("Mã phòng:");

        cbomaPhong.setEditable(true);
        cbomaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomaPhongActionPerformed(evt);
            }
        });

        jLabel8.setText("Chức vụ:");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Document.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Trình độ", "Mã Phòng", "Chức Vụ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhanVien);

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Trưởng Phòng", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbomaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMa)
                                            .addComponent(txtNgaySinh)
                                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(38, 38, 38)
                                        .addComponent(btnSeach))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(232, 232, 232))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(81, 81, 81)
                                        .addComponent(rdoNam)
                                        .addGap(69, 69, 69)
                                        .addComponent(rdoNu)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 426, Short.MAX_VALUE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(txtTrinhDo)
                    .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbomaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeach)
                    .addComponent(jLabel8)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMoi)
                        .addComponent(btnXoa)
                        .addComponent(btnSua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        if (txtMa.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập mã nhân viên");
            return;
        }
        try {
            NhanVienDAO dao = new NhanVienDAO();
            NhanVien ns = dao.findById(txtMa.getText());

            if (ns != null) {
                txtMa.setText(ns.getMaNV());
                txtTen.setText(ns.getTenNV());
                txtNgaySinh.setText(ns.getNgaySinh().toString());
                txtTrinhDo.setText(ns.getTrinhDo());
                txtDiaChi.setText(ns.getDiaChi());
                cbomaPhong.setSelectedItem(ns.getMaPhong());
                cboChucVu.setSelectedItem(ns.getChucVu());
                rdoNam.setSelected(ns.getGioiTinh() == 1);
                rdoNu.setSelected(ns.getGioiTinh() == 0);

            } else {
                MsgBox.alert(this, "Nhân viên không tìm thấy");
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSeachActionPerformed

    void Them() {
        try {
            NhanVien ns = new NhanVien();
            ns.setMaNV(txtMa.getText());
            ns.setTenNV(txtTen.getText());
            ns.setNgaySinh(txtNgaySinh.getText());
            ns.setDiaChi(txtDiaChi.getText());
            ns.setTrinhDo(txtTrinhDo.getText());
            ns.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
            ns.setChucVu((String) cboChucVu.getSelectedItem());
//            ns.setMaPhong((String) cboMaPhong.getSelectedItem());
            PhongBan PhongBan = (PhongBan) cbomaPhong.getSelectedItem();
            ns.setMaPhong(PhongBan.getMaPhongBan());

            NhanVienDAO dao = new NhanVienDAO();
            dao.insert(ns);
            MsgBox.alert(this, "Thêm thành công!");
            fillToTable();

        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại, mã nhân viên đã tồn tại");
            //e.printStackTrace();
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (checkForm()) {
            Them();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (MsgBox.confirm(this, "Bạn có muốn cập nhật nhân viên không?")) {
            try {
                NhanVien ns = new NhanVien();
                ns.setMaNV(txtMa.getText());
                ns.setTenNV(txtTen.getText());
                ns.setDiaChi(txtDiaChi.getText());
                ns.setNgaySinh(txtNgaySinh.getText());
                ns.setMaPhong(cbomaPhong.getSelectedItem().toString());
                ns.setTrinhDo(txtTrinhDo.getText());
                ns.setChucVu((String) cboChucVu.getSelectedItem());
                ns.setGioiTinh(rdoNam.isSelected() ? 1 : 0);

                NhanVienDAO dao = new NhanVienDAO();
                dao.update(ns);
                MsgBox.alert(this, "Cập nhật thành công!");
                fillToTable();
                reset();
            } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//            e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMa.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập mã nhân viên");
            return;
        }
        if (MsgBox.confirm(this, "Bạn có muốn xóa nhân viên không?")) {
            try {
                NhanVienDAO dao = new NhanVienDAO();
                dao.delete(txtMa.getText());
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                fillToTable();
                reset();
            } catch (Exception e) {
                MsgBox.alert(this, "Sai mã nhân viên, xóa thất bại!");
//            e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed
    NhanVienDAO dao = new NhanVienDAO();

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.reset();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        try {
            int id = tblNhanVien.rowAtPoint(evt.getPoint());
            String manv = tblNhanVien.getValueAt(id, 0).toString();
            NhanVien nv = dao.findById(manv);
            setModel(nv);

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error: MouseClick" + e.getMessage());
//            e.printStackTrace();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void cbomaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomaPhongActionPerformed

    }//GEN-LAST:event_cbomaPhongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSeach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cbomaPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTrinhDo;
    // End of variables declaration//GEN-END:variables
}
