package baocaojava;

import controller.MaHoa;
import controller.NhanVienController;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVienmodel;

/**
 *
 * @author Toan
 */
public class ListNhanVienJPanel extends javax.swing.JPanel {

    private NhanVienController nhanVienController;
    NhanVienmodel nhanVienmodel;
    DefaultTableModel defaultTableModel;
    String duongDanAnh = "D:\\hdt\\baocaojava\\src\\picture\\images.png";

    /**
     * Creates new form ListNhanVienJPanel
     */
    public ListNhanVienJPanel() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        nhanVienController = new NhanVienController();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        nhanVienTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nhân viên");
        defaultTableModel.addColumn("Họ và Tên");
        defaultTableModel.addColumn("Chức Vụ");
        defaultTableModel.addColumn("Quê quán");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Giới Tính");
        defaultTableModel.addColumn("Số điện Thoại");

        loadDataToTable();

        // Thiết lập sự kiện khi người dùng chọn hàng
        nhanVienTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                updateFieldsFromSelectedRow();
            }
        });
        maNvTextFiled.setText(CreatId());
    }

    private void loadDataToTable() {
        ArrayList<NhanVienmodel> nhanVienmodels = nhanVienController.selectAll();
        for (NhanVienmodel nhanVienmodel : nhanVienmodels) {
            defaultTableModel.addRow(new Object[]{
                nhanVienmodel.getMaNv(),
                nhanVienmodel.getTen(),
                nhanVienmodel.getChucVu(),
                nhanVienmodel.getDiaChi(),
                nhanVienmodel.getNgaysinh(),
                nhanVienmodel.getGioiTinh(),
                nhanVienmodel.getSoDt()
            });

        }
    }

    public void updateFieldsFromSelectedRow() {
        int row = nhanVienTable.getSelectedRow();

        // Kiểm tra nếu hàng được chọn hợp lệ
        if (row >= 0) {
            String nhanvien = String.valueOf(nhanVienTable.getValueAt(row, 0));
            NhanVienmodel nhanVienmodelUD = nhanVienController.selectById(nhanvien);

            maNvTextFiled.setText(nhanVienmodelUD.getMaNv());
            diaChiTextField.setText(nhanVienmodelUD.getDiaChi());
            soDtTextField.setText(String.valueOf(nhanVienmodelUD.getSoDt()));
            matKhauTextField.setText(nhanVienmodelUD.getMatKhau());
            hotenTextField.setText(nhanVienmodelUD.getTen());
            // Hiển thị ảnh
            lbAnh.setIcon(ResizeImage(nhanVienmodelUD.getDuongAnh()));
            // Cập nhật giới tính
            String gioiString = nhanVienmodelUD.getGioiTinh();
            namRadioButton.setSelected("Nam".equals(gioiString));
            nuRadioButton.setSelected("Nữ".equals(gioiString));

            // Cập nhật chức vụ
            String chucVusString = nhanVienmodelUD.getChucVu();
            quanLyRadioBtn.setSelected("Quản lý".equals(chucVusString));
            nhanVienRadioBtn.setSelected("Nhân viên".equals(chucVusString));
//            cap nhat duong dan anh
            if (nhanVienmodelUD.getDuongAnh() == null) {
                lbAnh.setIcon(ResizeImage(duongDanAnh));

            } else {
                lbAnh.setIcon(ResizeImage(nhanVienmodelUD.getDuongAnh()));

            }
            maNvTextFiled.setEditable(false);
            matKhauTextField.setEditable(false);
        }
    }

    public String CreatId() {
        nhanVienController = new NhanVienController();
        ArrayList<NhanVienmodel> arr = nhanVienController.selectAll();
        String check = "";
        int id = arr.size() + 1;
        if (arr != null) {
            for (NhanVienmodel nhanVienmodel : arr) {
                if (nhanVienmodel.getMaNv().equals("NV" + id)) {
                    check = nhanVienmodel.getMaNv();
                }
            }
            while (check.length() != 0) {
                id++;
                for (int i = 0; i <= arr.size(); i++) {
                    if (arr.get(i).getMaNv().equals("NV" + id)) {
                        check = arr.get(i).getMaNv();
                    } else {
                        check = "";
                    }
                }
            }
            return "NV" + id;
        } else {
            return "NV" + 1;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhanVienTable = new javax.swing.JTable();
        themBtn = new javax.swing.JButton();
        capnhatJbtn = new javax.swing.JButton();
        deleteJbtn = new javax.swing.JButton();
        refreshjbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namRadioButton = new javax.swing.JRadioButton();
        nuRadioButton = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        timKiemTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        timKiemBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maNvTextFiled = new javax.swing.JTextField();
        hotenTextField = new javax.swing.JTextField();
        diaChiTextField = new javax.swing.JTextField();
        soDtTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        matKhauTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        quanLyRadioBtn = new javax.swing.JRadioButton();
        nhanVienRadioBtn = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        huyChonBtn = new javax.swing.JButton();
        lbAnh = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));

        nhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
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
        nhanVienTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        nhanVienTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(nhanVienTable);

        themBtn.setText("Thêm");
        themBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBtnActionPerformed(evt);
            }
        });

        capnhatJbtn.setText("Cập nhật");
        capnhatJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatJbtnActionPerformed(evt);
            }
        });

        deleteJbtn.setText("Xóa");
        deleteJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJbtnActionPerformed(evt);
            }
        });

        refreshjbtn.setText("Làm mới");
        refreshjbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã nhân viên:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ngày sinh:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Số điện thoại:");

        namRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(namRadioButton);
        namRadioButton.setText("Nam");
        namRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namRadioButtonActionPerformed(evt);
            }
        });

        nuRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(nuRadioButton);
        nuRadioButton.setText("Nữ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nhập từ khóa cần tìm:");

        timKiemBtn.setText("Tìm kiếm");
        timKiemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quê quán:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Chức vụ:");

        maNvTextFiled.setEditable(false);

        soDtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soDtTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Mật khẩu:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Giới tính");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");

        quanLyRadioBtn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(quanLyRadioBtn);
        quanLyRadioBtn.setText("quản lý");
        quanLyRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyRadioBtnActionPerformed(evt);
            }
        });

        nhanVienRadioBtn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(nhanVienRadioBtn);
        nhanVienRadioBtn.setText("nhân viên");

        huyChonBtn.setText("Hủy chọn");
        huyChonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyChonBtnActionPerformed(evt);
            }
        });

        lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/images.png"))); // NOI18N

        jButton1.setText("Thêm ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(themBtn)
                        .addGap(60, 60, 60)
                        .addComponent(capnhatJbtn)
                        .addGap(60, 60, 60)
                        .addComponent(deleteJbtn)
                        .addGap(60, 60, 60)
                        .addComponent(refreshjbtn)
                        .addGap(56, 56, 56)
                        .addComponent(huyChonBtn)
                        .addGap(47, 47, 47))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(445, 445, 445)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quanLyRadioBtn)
                                        .addGap(10, 10, 10)
                                        .addComponent(nhanVienRadioBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addGap(122, 122, 122))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(namRadioButton)
                                                .addGap(10, 10, 10)
                                                .addComponent(nuRadioButton))
                                            .addComponent(matKhauTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                            .addComponent(hotenTextField)
                                            .addComponent(diaChiTextField)
                                            .addComponent(maNvTextFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                            .addComponent(soDtTextField)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 431, Short.MAX_VALUE)
                                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(219, 219, 219)))
                .addGap(63, 63, 63))
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
                    .addComponent(maNvTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(matKhauTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(hotenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namRadioButton)
                            .addComponent(nuRadioButton)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(diaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(soDtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(quanLyRadioBtn)
                    .addComponent(nhanVienRadioBtn)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themBtn)
                    .addComponent(capnhatJbtn)
                    .addComponent(deleteJbtn)
                    .addComponent(refreshjbtn)
                    .addComponent(huyChonBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void themBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBtnActionPerformed
        // Kiểm tra nếu bất kỳ trường nào bắt buộc đều trống
        if (maNvTextFiled.getText().trim().isEmpty()
                || diaChiTextField.getText().trim().isEmpty()
                || soDtTextField.getText().trim().isEmpty()
                || matKhauTextField.getText().trim().isEmpty()
                || hotenTextField.getText().trim().isEmpty()
                || (!namRadioButton.isSelected() && !nuRadioButton.isSelected())
                || (!quanLyRadioBtn.isSelected() && !nhanVienRadioBtn.isSelected())) { // Kiểm tra nếu giới tính và chức vụ được chọn

            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Dừng xử lý nếu bất kỳ trường nào bắt buộc đều trống
        }

        // Xác thực số điện thoại
        String soDt = soDtTextField.getText().trim();
        if (!soDt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 chữ số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Dừng xử lý nếu số điện thoại không hợp lệ
        }

// Xác thực và phân tích ngày sinh
        java.util.Date selectedDate = jDateChooser2.getDate();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Dừng xử lý nếu ngày sinh không hợp lệ
        }
        nhanVienmodel = new NhanVienmodel();
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        nhanVienmodel.setNgaysinh(sqlDate); // Set ngày sinh vào đối tượng nhanVienmodel

        String maNv = maNvTextFiled.getText().trim();
        if (nhanVienController.isMaNvExists(maNv)) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại, vui lòng nhập mã khác!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return; // Dừng xử lý nếu mã nhân viên đã được sử dụng
        }

        // Tạo đối tượng nhanVienmodel
        nhanVienmodel.setMaNv(maNv);

        String chucVu = "";
        if (quanLyRadioBtn.isSelected()) {
            chucVu = "Quản lý";
        }
        if (nhanVienRadioBtn.isSelected()) {
            chucVu = "Nhân viên";
        }
        nhanVienmodel.setChucVu(chucVu);
        nhanVienmodel.setDiaChi(diaChiTextField.getText());
        nhanVienmodel.setSoDt(Integer.parseInt(soDt));
        String passWord=matKhauTextField.getText();
        nhanVienmodel.setMatKhau(MaHoa.toSHAL(passWord));
        nhanVienmodel.setTen(hotenTextField.getText());

        // Đường dẫn hình ảnh
        // Thay bằng đường dẫn thực tế
        nhanVienmodel.setDuongAnh(duongDanAnh);

        String gioiTinh = namRadioButton.isSelected() ? "Nam" : "Nữ";
        nhanVienmodel.setGioiTinh(gioiTinh);

        // Thêm nhân viên qua controller
        nhanVienController.ThemNv(nhanVienmodel);

        // Thông báo thành công
        JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_themBtnActionPerformed

    private void capnhatJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatJbtnActionPerformed
        // TODO add your handling code here:
        int row = nhanVienTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListNhanVienJPanel.this, "Vui long chon doi tuong muon cap nhat", "loi", JOptionPane.ERROR_MESSAGE);
        } else {
            nhanVienmodel = new NhanVienmodel();
            nhanVienmodel.setMaNv(maNvTextFiled.getText());
            String chucVu = "";
            if (quanLyRadioBtn.isSelected()) {
                chucVu += "Quản lý";
            }
            if (nhanVienRadioBtn.isSelected()) {
                chucVu += "Nhân viên";
            }
            nhanVienmodel.setChucVu(chucVu);
            nhanVienmodel.setDiaChi(diaChiTextField.getText());
            nhanVienmodel.setSoDt(Integer.parseInt(soDtTextField.getText()));
            nhanVienmodel.setMatKhau(matKhauTextField.getText());
            nhanVienmodel.setTen(hotenTextField.getText());
            nhanVienmodel.setDuongAnh(duongDanAnh);
            String gioiTinh = "";
            if (namRadioButton.isSelected()) {
                gioiTinh += "Nam";
            }
            if (nuRadioButton.isSelected()) {
                gioiTinh += "Nữ";
            }
            nhanVienmodel.setGioiTinh(gioiTinh);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date uDate = null;

            nhanVienController.UpdateNv(nhanVienmodel);
            JOptionPane.showMessageDialog(ListNhanVienJPanel.this, "Cập nhật thông tin nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_capnhatJbtnActionPerformed

    private void refreshjbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjbtnActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        ArrayList<NhanVienmodel> nhanVienmodels = nhanVienController.selectAll();
        for (NhanVienmodel nhanVienmodel : nhanVienmodels) {
            defaultTableModel.addRow(new Object[]{nhanVienmodel.getMaNv(), nhanVienmodel.getMatKhau(), nhanVienmodel.getTen(), nhanVienmodel.getChucVu(), nhanVienmodel.getDiaChi(),
                nhanVienmodel.getNgaysinh(), nhanVienmodel.getGioiTinh(), nhanVienmodel.getSoDt(), nhanVienmodel.getLuong()});
        }

    }//GEN-LAST:event_refreshjbtnActionPerformed

    private void namRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namRadioButtonActionPerformed

    private void soDtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soDtTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soDtTextFieldActionPerformed

    private void quanLyRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quanLyRadioBtnActionPerformed

    private void deleteJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJbtnActionPerformed
        // TODO add your handling code here:
        int row = nhanVienTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListNhanVienJPanel.this, "Vui long chon doi tuong muon xoa", "loi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListNhanVienJPanel.this, "ban chac chan muon xoa khong");
            if (confirm == JOptionPane.YES_OPTION) {
                String maNvString = String.valueOf(nhanVienTable.getValueAt(row, 0));
                nhanVienController.XoaNv(maNvString);
                defaultTableModel.setRowCount(0);
                ArrayList<NhanVienmodel> nhanVienmodels = nhanVienController.selectAll();
                for (NhanVienmodel CoutNhanVienmodel : nhanVienmodels) {
                    defaultTableModel.addRow(new Object[]{CoutNhanVienmodel.getMaNv(), CoutNhanVienmodel.getMatKhau(), CoutNhanVienmodel.getTen(), CoutNhanVienmodel.getChucVu(), CoutNhanVienmodel.getDiaChi(),
                        CoutNhanVienmodel.getNgaysinh(), CoutNhanVienmodel.getGioiTinh(), CoutNhanVienmodel.getSoDt(), CoutNhanVienmodel.getLuong()});
                }

            }
        }
    }//GEN-LAST:event_deleteJbtnActionPerformed

    private void timKiemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemBtnActionPerformed
        // TODO add your handling code here:
        String name = timKiemTextField.getText(); // Giả sử name là "Toàn"
        String condition = "LOWER(Ten) LIKE LOWER('%" + name + "%')";

        ArrayList<NhanVienmodel> nhanVienmodels = null;
        if (name.trim().length() == 0) {
            nhanVienmodels = nhanVienController.selectAll();
        } else {
            nhanVienmodels = nhanVienController.selectByCondition(condition);
        }
        defaultTableModel.setRowCount(0);
        for (NhanVienmodel nhanVienmodel : nhanVienmodels) {
            defaultTableModel.addRow(new Object[]{nhanVienmodel.getMaNv(), nhanVienmodel.getMatKhau(), nhanVienmodel.getTen(), nhanVienmodel.getChucVu(), nhanVienmodel.getDiaChi(),
                nhanVienmodel.getNgaysinh(), nhanVienmodel.getGioiTinh(), nhanVienmodel.getSoDt(), nhanVienmodel.getLuong()});
        }


    }//GEN-LAST:event_timKiemBtnActionPerformed

    private void huyChonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyChonBtnActionPerformed
        // TODO add your handling code here:
        maNvTextFiled.setText(CreatId());
        diaChiTextField.setText("");
        soDtTextField.setText("");
        matKhauTextField.setText("");
        hotenTextField.setText("");

        // Cập nhật giới tính
        buttonGroup1.clearSelection();

        // Cập nhật chức vụ
        buttonGroup2.clearSelection();

        maNvTextFiled.setEditable(true);
        duongDanAnh = "D:\\hdt\\baocaojava\\src\\picture\\images.png";
        lbAnh.setIcon(ResizeImage(duongDanAnh));
        matKhauTextField.setEditable(true);

    }//GEN-LAST:event_huyChonBtnActionPerformed

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File ftenAnh = f.getSelectedFile();
            duongDanAnh = ftenAnh.getAbsolutePath();
            lbAnh.setIcon(ResizeImage(String.valueOf(duongDanAnh)));
            System.out.println(duongDanAnh);

        } catch (Exception ex) {
            System.out.print(" Chưa chọn ảnh");
            System.out.println(duongDanAnh);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("Danh sách nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600); // Kích thước cửa sổ

        // Thêm ListNhanVienJPanel vào JFrame
        ListNhanVienJPanel listPanel = new ListNhanVienJPanel();
        frame.add(listPanel);

        // Đặt cửa sổ hiển thị ở giữa màn hình
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Hiện cửa sổ
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton capnhatJbtn;
    private javax.swing.JButton deleteJbtn;
    private javax.swing.JTextField diaChiTextField;
    private javax.swing.JTextField hotenTextField;
    private javax.swing.JButton huyChonBtn;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JTextField maNvTextFiled;
    private javax.swing.JTextField matKhauTextField;
    private javax.swing.JRadioButton namRadioButton;
    private javax.swing.JRadioButton nhanVienRadioBtn;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JRadioButton nuRadioButton;
    private javax.swing.JRadioButton quanLyRadioBtn;
    private javax.swing.JButton refreshjbtn;
    private javax.swing.JTextField soDtTextField;
    private javax.swing.JButton themBtn;
    private javax.swing.JButton timKiemBtn;
    private javax.swing.JTextField timKiemTextField;
    // End of variables declaration//GEN-END:variables
}
