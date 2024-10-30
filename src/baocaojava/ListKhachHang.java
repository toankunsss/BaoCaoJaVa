package baocaojava;

import controller.KhachHangController;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.KhachHangmodel;
import javax.swing.JOptionPane;

/**
 *
 * @author Toan
 */
public class ListKhachHang extends javax.swing.JPanel {

    private KhachHangController khachHangController;
    private KhachHangmodel khachHangmodel;
    DefaultTableModel defaultTableModel;

    /**
     * Creates new form ListKhachHang
     */
    public ListKhachHang() {
        initComponents();
        maKhTextFiled.setText(creatId());
        khachHangController = new KhachHangController();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        khachHangTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã khách hàng");
        defaultTableModel.addColumn("Họ và Tên");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Quê quán");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Tổng chi tiêu");
        defaultTableModel.addColumn("Điểm");

        loadDataToTable();

        // Thiết lập sự kiện khi người dùng chọn hàng
        khachHangTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                updateFieldsFromSelectedRow();
            }
        });
    }

    private void loadDataToTable() {
        ArrayList<KhachHangmodel> khachHangmodels = khachHangController.selectAll();
        for (KhachHangmodel khachHangmodel : khachHangmodels) {
            defaultTableModel.addRow(new Object[]{
                khachHangmodel.getMaKh(),
                khachHangmodel.getTenKh(),
                khachHangmodel.getGioiTinh(),
                khachHangmodel.getDiaChi(),
                khachHangmodel.getSoDt(),
                khachHangmodel.getTongChiTieu(),
                khachHangmodel.getDiem()
            });
        }
    }

    private void updateFieldsFromSelectedRow() {
        int row = khachHangTable.getSelectedRow();

        // Kiểm tra nếu hàng được chọn hợp lệ
        if (row >= 0) {
            String khachang = String.valueOf(khachHangTable.getValueAt(row, 0));
            KhachHangmodel khachHangmodelUD = khachHangController.selectById(khachang);

            maKhTextFiled.setText(khachHangmodelUD.getMaKh());
            diaChiTextField.setText(khachHangmodelUD.getDiaChi());
            soDtTextField.setText(String.valueOf(khachHangmodelUD.getSoDt()));
            hotenTextField.setText(khachHangmodelUD.getTenKh());
            tongChiTieuTextField.setText(String.valueOf(khachHangmodelUD.getTongChiTieu()));
            diemTextField.setText(String.valueOf(khachHangmodelUD.getDiem()));

            // Cập nhật giới tính
            String gioiString = khachHangmodelUD.getGioiTinh();
            namRadioButton.setSelected("Nam".equals(gioiString));
            nuRadioButton.setSelected("Nữ".equals(gioiString));
//            set cho ma nhan vien khong duoc sua
            maKhTextFiled.setEditable(false);
        }
    }

    public String creatId() {
        KhachHangController khachHangController = new KhachHangController();
        ArrayList<KhachHangmodel> arr = khachHangController.selectAll();
        if (arr != null) {
            int id = arr.size() + 1;
            String check = "";
            for (KhachHangmodel khachHangmodel : arr) {
                if (khachHangmodel.getMaKh().equals("KH" + id)) {
                    check = khachHangmodel.getMaKh();
                    break;
                }
            }
            while (check.length() != 0) {
                id++;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getMaKh().equals("KH" + id)) {
                        check = arr.get(i).getMaKh();
                    }else{
                        check="";
                    }
                }
            }
            return "KH" + id;
        } else {
            return "KH" + 1;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        maKhTextFiled = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        hotenTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        khachHangTable = new javax.swing.JTable();
        diemTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        themBtn = new javax.swing.JButton();
        namRadioButton = new javax.swing.JRadioButton();
        capnhatJbtn = new javax.swing.JButton();
        nuRadioButton = new javax.swing.JRadioButton();
        deleteJbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        timKiemJFd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        timKiemBtn = new javax.swing.JButton();
        refreshjbtn = new javax.swing.JButton();
        tongChiTieuTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        diaChiTextField = new javax.swing.JTextField();
        soDtTextField = new javax.swing.JTextField();

        jLabel2.setText("Họ tên nhân viên:");

        maKhTextFiled.setEnabled(false);
        maKhTextFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhTextFiledActionPerformed(evt);
            }
        });

        jLabel9.setText("Giới tính");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel6.setText("Quê quán:");

        jLabel7.setText("Điểm:");

        jLabel3.setText("Tổng Chi tiêu:");

        khachHangTable.setModel(new javax.swing.table.DefaultTableModel(
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
        khachHangTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(khachHangTable);

        diemTextField.setEnabled(false);

        jLabel4.setText("Số điện thoại:");

        themBtn.setText("Thêm");
        themBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(namRadioButton);
        namRadioButton.setText("Nam");
        namRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namRadioButtonActionPerformed(evt);
            }
        });

        capnhatJbtn.setText("Cập nhật");
        capnhatJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatJbtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(nuRadioButton);
        nuRadioButton.setText("Nữ");

        deleteJbtn.setText("Xóa");
        deleteJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJbtnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel5.setText("Nhập từ khóa cần tìm:");

        timKiemBtn.setText("Tìm kiếm");
        timKiemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(timKiemJFd, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(timKiemJFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        refreshjbtn.setText("Làm mới");
        refreshjbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã khách hàng");

        soDtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soDtTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(themBtn)
                                .addGap(60, 60, 60)
                                .addComponent(capnhatJbtn)
                                .addGap(60, 60, 60)
                                .addComponent(deleteJbtn)
                                .addGap(60, 60, 60)
                                .addComponent(refreshjbtn)
                                .addGap(178, 178, 178))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(445, 445, 445)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(hotenTextField)
                                                        .addComponent(diaChiTextField)
                                                        .addComponent(maKhTextFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(namRadioButton)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(nuRadioButton))))
                                            .addComponent(jLabel9))
                                        .addGap(94, 94, 94)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(soDtTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                            .addComponent(tongChiTieuTextField)
                                            .addComponent(diemTextField))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(maKhTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hotenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongChiTieuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(namRadioButton)
                    .addComponent(nuRadioButton)
                    .addComponent(jLabel7)
                    .addComponent(diemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(diaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themBtn)
                    .addComponent(capnhatJbtn)
                    .addComponent(deleteJbtn)
                    .addComponent(refreshjbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void themBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBtnActionPerformed
        // TODO add your handling code here:
        // Check if any of the required fields are empty
        if (maKhTextFiled.getText().trim().isEmpty()
                || diaChiTextField.getText().trim().isEmpty()
                || soDtTextField.getText().trim().isEmpty()
                || hotenTextField.getText().trim().isEmpty()
                || tongChiTieuTextField.getText().trim().isEmpty()
                || (!namRadioButton.isSelected() && !nuRadioButton.isSelected())) {

            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing if any required field is empty
        }

        // Validate the phone number to ensure it has exactly 10 digits
        String soDt = soDtTextField.getText().trim();
        if (!soDt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 chữ số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing if the phone number is invalid
        }

//        truyen gia tri vao model
        khachHangmodel = new KhachHangmodel();
        khachHangmodel.setMaKh(maKhTextFiled.getText());
        khachHangmodel.setDiaChi(diaChiTextField.getText());
        khachHangmodel.setSoDt(Integer.parseInt(soDt));
        khachHangmodel.setTenKh(hotenTextField.getText());
        khachHangmodel.setTongChiTieu(Double.parseDouble(tongChiTieuTextField.getText()));
        String gioiTinh = "";
        if (namRadioButton.isSelected()) {
            gioiTinh += "Nam";
        }
        if (nuRadioButton.isSelected()) {
            gioiTinh += "Nữ";
        }
        khachHangmodel.setGioiTinh(gioiTinh);

        // Add the employee through the controller
        khachHangController.ThemNv(khachHangmodel);
    }//GEN-LAST:event_themBtnActionPerformed

    private void namRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namRadioButtonActionPerformed

    private void capnhatJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatJbtnActionPerformed
        // TODO add your handling code here:
        int row = khachHangTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListKhachHang.this, "Vui long chon doi tuong muon cap nhat", "loi", JOptionPane.ERROR_MESSAGE);
        } else {
            khachHangmodel = new KhachHangmodel();
            khachHangmodel.setMaKh(maKhTextFiled.getText());
            khachHangmodel.setDiaChi(diaChiTextField.getText());
            khachHangmodel.setSoDt(Integer.parseInt(soDtTextField.getText()));
            khachHangmodel.setTenKh(hotenTextField.getText());
            khachHangmodel.setTongChiTieu(Double.parseDouble(tongChiTieuTextField.getText()));
//            khachHangmodel.setDiem(Integer.parseInt(diemTextField.getText()));
            String gioiTinh = "";
            if (namRadioButton.isSelected()) {
                gioiTinh += "Nam";
            }
            if (nuRadioButton.isSelected()) {
                gioiTinh += "Nữ";
            }
            khachHangmodel.setGioiTinh(gioiTinh);

            khachHangController.UpdateNv(khachHangmodel);
            JOptionPane.showMessageDialog(ListKhachHang.this, "Cập nhật thông tin khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_capnhatJbtnActionPerformed

    private void deleteJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJbtnActionPerformed
        // TODO add your handling code here:
        int row = khachHangTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListKhachHang.this, "Vui long chon doi tuong muon xoa", "loi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListKhachHang.this, "ban chac chan muon xoa khong");
            if (confirm == JOptionPane.YES_OPTION) {
                String maNvString = String.valueOf(khachHangTable.getValueAt(row, 0));
                khachHangController.XoaNv(maNvString);
                defaultTableModel.setRowCount(0);
                ArrayList<KhachHangmodel> khachHangmodels = khachHangController.selectAll();
                for (KhachHangmodel Coutkhachang : khachHangmodels) {
                    defaultTableModel.addRow(new Object[]{Coutkhachang.getMaKh(), Coutkhachang.getTenKh(), Coutkhachang.getGioiTinh(), Coutkhachang.getDiaChi(), Coutkhachang.getSoDt(),
                        Coutkhachang.getTongChiTieu(), Coutkhachang.getDiem()});
                }

            }
        }
    }//GEN-LAST:event_deleteJbtnActionPerformed

    private void timKiemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKiemBtnActionPerformed

    private void refreshjbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjbtnActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        ArrayList<KhachHangmodel> khachHangmodels = khachHangController.selectAll();
        for (KhachHangmodel Coutkhachang : khachHangmodels) {
            defaultTableModel.addRow(new Object[]{Coutkhachang.getMaKh(), Coutkhachang.getTenKh(), Coutkhachang.getGioiTinh(), Coutkhachang.getDiaChi(), Coutkhachang.getSoDt(),
                Coutkhachang.getTongChiTieu(), Coutkhachang.getDiem()});
        }
        maKhTextFiled.setText(creatId());
        diaChiTextField.setText("");
        soDtTextField.setText("");
        hotenTextField.setText("");
        // Cập nhật giới tính
        buttonGroup1.clearSelection();
        tongChiTieuTextField.setText("");
        diemTextField.setText("");
    }//GEN-LAST:event_refreshjbtnActionPerformed

    private void soDtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soDtTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soDtTextFieldActionPerformed

    private void maKhTextFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKhTextFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKhTextFiledActionPerformed
    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("Danh sách nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600); // Kích thước cửa sổ

        // Thêm ListNhanVienJPanel vào JFrame
        ListKhachHang listPanel = new ListKhachHang();
        frame.add(listPanel);

        // Đặt cửa sổ hiển thị ở giữa màn hình
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Hiện cửa sổ
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton capnhatJbtn;
    private javax.swing.JButton deleteJbtn;
    private javax.swing.JTextField diaChiTextField;
    private javax.swing.JTextField diemTextField;
    private javax.swing.JTextField hotenTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable khachHangTable;
    private javax.swing.JTextField maKhTextFiled;
    private javax.swing.JRadioButton namRadioButton;
    private javax.swing.JRadioButton nuRadioButton;
    private javax.swing.JButton refreshjbtn;
    private javax.swing.JTextField soDtTextField;
    private javax.swing.JButton themBtn;
    private javax.swing.JButton timKiemBtn;
    private javax.swing.JTextField timKiemJFd;
    private javax.swing.JTextField tongChiTieuTextField;
    // End of variables declaration//GEN-END:variables
}
