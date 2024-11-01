package baocaojava;

import controller.NhaCungCapController;
import controller.SearchNhaCungCap;
import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.NhaCungCap;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Toan
 */
public class NhaCungCapJpane extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    NhaCungCapController nhaCungCapController;
    NhaCungCap nhaCungCap;

    /**
     * Creates new form NhaCungCapJpane
     */
    public NhaCungCapJpane() {
        initComponents();
//        Image icon = new ImageIcon(this.getClass().getResource("/picture/Picture1.png")).getImage();
//        this.setIconImage(icon);
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        nccTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nhà cung cấp");
        defaultTableModel.addColumn("Tên nhà cung cấp");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Địa chỉ nhà cung cấp");
        LoadDataTable();
        nccTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                UpDateFieldFromSelectRow();
            }
        });

    }

    public void LoadDatatoTable(ArrayList<NhaCungCap> ncc) {
        try {
            defaultTableModel.setRowCount(0);
            for (NhaCungCap i : ncc) {
                defaultTableModel.addRow(new Object[]{
                    i.getMaNhaCC(),
                    i.getTenNCC(),
                    i.getSoDt(),
                    i.getDiaChi()
                });
            }
        } catch (Exception e) {
        }
    }

    private void LoadDataTable() {
        nhaCungCapController = new NhaCungCapController();
        ArrayList<NhaCungCap> nhaCungCaps = nhaCungCapController.selectAll();
        defaultTableModel.setRowCount(0);
        for (NhaCungCap nhaCungCap : nhaCungCaps) {
            defaultTableModel.addRow(new Object[]{
                nhaCungCap.getMaNhaCC(),
                nhaCungCap.getTenNCC(),
                nhaCungCap.getSoDt(),
                nhaCungCap.getDiaChi()

            });
        }
    }

    public void UpDateFieldFromSelectRow() {
        int row = nccTable.getSelectedRow();
        if (row >= 0) {
            String nccString = String.valueOf(nccTable.getValueAt(row, 0));
            NhaCungCap nhaCungCapUD = nhaCungCapController.selectById(nccString);
            maNCCTextField.setText(nhaCungCapUD.getMaNhaCC());
            tenNccTextField.setText(nhaCungCapUD.getTenNCC());
            soDtNccTextField.setText(String.valueOf(nhaCungCapUD.getSoDt()));
            diaChiTextField.setText(nhaCungCapUD.getDiaChi());
            maNCCTextField.setEditable(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        nccTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        soDtNccTextField = new javax.swing.JTextField();
        maNCCTextField = new javax.swing.JTextField();
        tenNccTextField = new javax.swing.JTextField();
        diaChiTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        timKiemTextField = new javax.swing.JTextField();
        timKiemBtn = new javax.swing.JButton();
        cbxLuaChon = new javax.swing.JComboBox<>();
        boChonBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        themButton = new javax.swing.JButton();
        xoaButon = new javax.swing.JButton();
        suaButon = new javax.swing.JButton();
        xuatExcelButton = new javax.swing.JButton();
        nhapExcelbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        nccTable.setBackground(new java.awt.Color(255, 255, 255));
        nccTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(nccTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách nhà cung cấp");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã nhà cung cấp:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên nhà cung cấp:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Địa chỉ:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Số điện thoại:");

        soDtNccTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soDtNccTextFieldActionPerformed(evt);
            }
        });

        maNCCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNCCTextFieldActionPerformed(evt);
            }
        });

        diaChiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaChiTextFieldActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 102, 51))); // NOI18N

        timKiemTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemTextFieldActionPerformed(evt);
            }
        });

        timKiemBtn.setBackground(new java.awt.Color(255, 102, 51));
        timKiemBtn.setForeground(new java.awt.Color(0, 0, 0));
        timKiemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Refresh.png"))); // NOI18N
        timKiemBtn.setText("Làm mới");
        timKiemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemBtnActionPerformed(evt);
            }
        });

        cbxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", " " }));
        cbxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLuaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cbxLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(timKiemTextField)
                .addGap(18, 18, 18)
                .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        boChonBtn.setBackground(new java.awt.Color(255, 102, 51));
        boChonBtn.setForeground(new java.awt.Color(0, 0, 0));
        boChonBtn.setText("Bỏ chọn");
        boChonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boChonBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 102, 51))); // NOI18N

        themButton.setBackground(new java.awt.Color(255, 153, 51));
        themButton.setForeground(new java.awt.Color(0, 0, 0));
        themButton.setText("Thêm");
        themButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themButtonActionPerformed(evt);
            }
        });

        xoaButon.setBackground(new java.awt.Color(255, 102, 51));
        xoaButon.setForeground(new java.awt.Color(0, 0, 0));
        xoaButon.setText("Xóa");
        xoaButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaButonActionPerformed(evt);
            }
        });

        suaButon.setBackground(new java.awt.Color(255, 102, 51));
        suaButon.setForeground(new java.awt.Color(0, 0, 0));
        suaButon.setText("Sửa");
        suaButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaButonActionPerformed(evt);
            }
        });

        xuatExcelButton.setBackground(new java.awt.Color(255, 102, 51));
        xuatExcelButton.setForeground(new java.awt.Color(0, 0, 0));
        xuatExcelButton.setText("Xuất Excel");
        xuatExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatExcelButtonActionPerformed(evt);
            }
        });

        nhapExcelbtn.setBackground(new java.awt.Color(255, 102, 51));
        nhapExcelbtn.setForeground(new java.awt.Color(0, 0, 0));
        nhapExcelbtn.setText("Nhập Excel");
        nhapExcelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapExcelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xoaButon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suaButon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xuatExcelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhapExcelbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themButton)
                    .addComponent(xoaButon)
                    .addComponent(suaButon)
                    .addComponent(xuatExcelButton)
                    .addComponent(nhapExcelbtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tenNccTextField)
                                    .addComponent(soDtNccTextField)
                                    .addComponent(diaChiTextField)
                                    .addComponent(maNCCTextField)))
                            .addComponent(boChonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(maNCCTextField))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tenNccTextField))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(soDtNccTextField))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(diaChiTextField))
                        .addGap(48, 48, 48)
                        .addComponent(boChonBtn)
                        .addGap(93, 93, 93)))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void soDtNccTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soDtNccTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soDtNccTextFieldActionPerformed

    private void maNCCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNCCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNCCTextFieldActionPerformed

    private void diaChiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaChiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaChiTextFieldActionPerformed

    private void themButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themButtonActionPerformed
        // TODO add your handling code here:
//        kiem tra xem truong bat buoc nào đều trông
        if (maNCCTextField.getText().trim().isEmpty()
                || tenNccTextField.getText().trim().isEmpty()
                || diaChiTextField.getText().trim().isEmpty()
                || soDtNccTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Lỗi không nhập", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String soDt = soDtNccTextField.getText().trim();
        if (!soDt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 chữ số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Dừng xử lý nếu số điện thoại không hợp lệ
        }
        try {
            nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNhaCC(maNCCTextField.getText());
            nhaCungCap.setTenNCC(tenNccTextField.getText());
            nhaCungCap.setDiaChi(diaChiTextField.getText());
            nhaCungCap.setSoDt(Integer.parseInt(soDtNccTextField.getText()));
//        if(nhaCungCapController.ThemNv(nhaCungCap)!=null){
//            JOptionPane.showConfirmDialog(this, "", soDt, WIDTH)
//        }
            nhaCungCapController = new NhaCungCapController();
            int result = nhaCungCapController.ThemNv(nhaCungCap);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
            } else {
                throw new Exception("Thêm thất bại vào cơ sở dữ liệu!");
//                JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_themButtonActionPerformed

    private void suaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaButonActionPerformed
        // TODO add your handling code here:
        int row = nccTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng muốn cập nhật", "Lỗi không chọn", JOptionPane.ERROR_MESSAGE);
        } else {
            nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNhaCC(maNCCTextField.getText());
            nhaCungCap.setTenNCC(tenNccTextField.getText());
            nhaCungCap.setDiaChi(diaChiTextField.getText());
            nhaCungCap.setSoDt(Integer.parseInt(soDtNccTextField.getText()));
            nhaCungCapController.UpdateNv(nhaCungCap);
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_suaButonActionPerformed

    private void xoaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaButonActionPerformed
        // TODO add your handling code here:
        int row = nccTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng muốn xóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(NhaCungCapJpane.this, "Bạn chắc chắn muốn xóa ?");
            if (confirm == JOptionPane.YES_OPTION) {
                String maNCCString = String.valueOf(nccTable.getValueAt(row, 0));
                nhaCungCapController.XoaNv(maNCCString);
                LoadDataTable();
            }
        }
    }//GEN-LAST:event_xoaButonActionPerformed

    private void timKiemTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKiemTextFieldActionPerformed

    private void timKiemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemBtnActionPerformed
        // TODO add your handling code here:
        String luachon = (String) cbxLuaChon.getSelectedItem();
        String name = timKiemTextField.getText();
        ArrayList<NhaCungCap> nhaCungCapl = new ArrayList<>();
        switch (luachon) {
            case "Tất cả":
                nhaCungCapl = SearchNhaCungCap.getInstance().searchTatCa(name);
                break;
            case "Mã nhà cung cấp":
                nhaCungCapl = SearchNhaCungCap.getInstance().searchMaNCC(name);
                break;
            case "Tên nhà cung cấp":
                nhaCungCapl = SearchNhaCungCap.getInstance().searchTenNCC(name);
                break;
            case "Địa chỉ":
                nhaCungCapl = SearchNhaCungCap.getInstance().searchDiaChi(name);
                break;
            case "Số điện thoại":
                nhaCungCapl = SearchNhaCungCap.getInstance().searchSdt(name);
                break;
        }
        LoadDatatoTable(nhaCungCapl);
    }//GEN-LAST:event_timKiemBtnActionPerformed

    private void boChonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boChonBtnActionPerformed
        // TODO add your handling code here:
        maNCCTextField.setText("");
        tenNccTextField.setText("");
        soDtNccTextField.setText("");
        diaChiTextField.setText("");
        maNCCTextField.setEditable(true);
    }//GEN-LAST:event_boChonBtnActionPerformed

    private void cbxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLuaChonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLuaChonActionPerformed

    private void xuatExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelButtonActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("NhaCungCap");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < nccTable.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(nccTable.getColumnName(i));
                }
                for (int j = 0; j < nccTable.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < nccTable.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (nccTable.getValueAt(j, k) != null) {
                            cell.setCellValue(nccTable.getValueAt(j, k).toString());
                        }
                    }
                }

                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_xuatExcelButtonActionPerformed

    private void nhapExcelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelbtnActionPerformed
        // TODO add your handling code here:
        File excelFile;
        FileInputStream exCelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJtableImport = null;
        ArrayList<NhaCungCap> listAccExcel = new ArrayList<>();
        JFileChooser jf = new JFileChooser();
        int result = jf.showOpenDialog(null);
        jf.setDialogTitle("Open file");

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = jf.getSelectedFile();
                exCelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(exCelFIS);
                excelJtableImport = new XSSFWorkbook(excelBIS);

                XSSFSheet excelFSheet = excelJtableImport.getSheetAt(0);
                for (int row = 1; row <= excelFSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelFSheet.getRow(row);

                    String maNhaCungCap = getCellStringValue(excelRow.getCell(0));
                    String tenNhaCungCap = getCellStringValue(excelRow.getCell(1));
                    String sdt = getCellStringValue(excelRow.getCell(2));
                    String diachi = getCellStringValue(excelRow.getCell(3));

                    int soDt = Integer.parseInt(sdt); // Parse phone number to integer
                    NhaCungCap acc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, soDt, diachi);
                    listAccExcel.add(acc);
                }

                DefaultTableModel tableModel = (DefaultTableModel) nccTable.getModel();
                tableModel.setRowCount(0);
                LoadDatatoTable(listAccExcel);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Không tìm thấy file!", "Lỗi", JOptionPane.ERROR_MESSAGE);

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi trong quá trình đọc file.", "Lỗi", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi định dạng số trong file Excel.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (exCelFIS != null) {
                        exCelFIS.close();
                    }
                    if (excelJtableImport != null) {
                        excelJtableImport.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            int k = 0;
            for (NhaCungCap nhaCungCap : listAccExcel) {
                nhaCungCapController = new NhaCungCapController();
                k = nhaCungCapController.ThemNv(nhaCungCap);
            }
            if (k != 0) {
                JOptionPane.showMessageDialog(this, "Nhập thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Nhập thất bại!");
        }
    }//GEN-LAST:event_nhapExcelbtnActionPerformed
    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("Danh sách nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600); // Kích thước cửa sổ

        // Thêm ListNhanVienJPanel vào JFrame
        NhaCungCapJpane listPanel = new NhaCungCapJpane();
        frame.add(listPanel);

        // Đặt cửa sổ hiển thị ở giữa màn hình
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Hiện cửa sổ
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boChonBtn;
    private javax.swing.JComboBox<String> cbxLuaChon;
    private javax.swing.JTextField diaChiTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maNCCTextField;
    private javax.swing.JTable nccTable;
    private javax.swing.JButton nhapExcelbtn;
    private javax.swing.JTextField soDtNccTextField;
    private javax.swing.JButton suaButon;
    private javax.swing.JTextField tenNccTextField;
    private javax.swing.JButton themButton;
    private javax.swing.JButton timKiemBtn;
    private javax.swing.JTextField timKiemTextField;
    private javax.swing.JButton xoaButon;
    private javax.swing.JButton xuatExcelButton;
    // End of variables declaration//GEN-END:variables

    private void setIconImage(Image icon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String getCellStringValue(XSSFCell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()); // Convert numeric to string, handling integers
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

}
