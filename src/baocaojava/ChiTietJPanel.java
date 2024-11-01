package baocaojava;

import DAO.ChiTietPhieuNhapDAO;
import DAO.SanPhamDAO;
import controller.SanPhamController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.ChiTieuPhieumodel;
import model.phieuModel;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.List;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

// Thêm dòng sau để hỗ trợ tiếng Việt.
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;

/**
 *
 * @author Toan
 */
public class ChiTietJPanel extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    SanPhamDAO sanPhamDAO;
    SanPhamController sanPhamController;
    public static String maPhieuCT;

    /**
     * Creates new form ChiTietJPanel
     */
    public ChiTietJPanel() {
        initComponents();
        defaultTableModel = new DefaultTableModel();
        chitietTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Mã sữa");
        defaultTableModel.addColumn("Tên sữa");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Thành tiền");

    }

    void loadDataToTable() {
        defaultTableModel.setRowCount(0);
        sanPhamDAO = new SanPhamDAO();
        sanPhamController = new SanPhamController();
        String condition = maPhieuCT;
        ArrayList<ChiTieuPhieumodel> list = ChiTietPhieuNhapDAO.getInstance().selectByCondition(condition);
        int i = 0;

        for (ChiTieuPhieumodel sp : list) {
            i++;
            int soLuong = sp.getSoLuong(); // Lấy số lượng
            double donGia = sp.getDonGia(); // Lấy đơn giá
            double thanhTien = soLuong * donGia;
            String tenSua = sanPhamController.GetTenSuaById(sp.getMaSua());
            defaultTableModel.addRow(new Object[]{
                i,
                sp.getMaSua(),
                tenSua,
                soLuong,
                donGia,
                thanhTien});

        }
    }

    public void setMaPhieu(String maPhieu) {
        jLabel1.setText("Mã Phiếu: " + maPhieu);
        maPhieuCT = maPhieu;
    }

    public void setNguoiTao(String nguoiTao) {
        jLabel3.setText("Người tạo: " + nguoiTao);
    }

    public void setThoiGianTao(String thoiGian) {
        jLabel4.setText("Thời gian tạo: " + thoiGian);
    }

    public void setNhaCungCap(String thoiGian) {
        jLabel2.setText("Nhà Cung Cấp: " + thoiGian);
    }

    public void setTongTien(String thoiGian) {
        jLabel5.setText("Tổng tiền: " + thoiGian);
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
        chitietTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        chitietTable.setBackground(new java.awt.Color(255, 255, 255));
        chitietTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chitietTable.setModel(new javax.swing.table.DefaultTableModel(
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
        chitietTable.setAutoscrolls(false);
        jScrollPane1.setViewportView(chitietTable);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CHI TIẾT PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã Phiếu:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nhà cung cấp:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Người tạo:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Thời gian tạo:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng tiền: ");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Create.png"))); // NOI18N
        jButton1.setText("Xuất PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(310, 310, 310))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(350, 350, 350)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(52, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                PdfWriter writer = new PdfWriter(fileToSave.getAbsolutePath() + ".pdf");
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                // Sử dụng font hỗ trợ Unicode
                String fontPath = "C:\\Users\\Toan\\Downloads\\font-times-new-roman (2)\\font-times-new-roman\\SVN-Times New Roman 2.ttf"; // Đường dẫn font
                PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

                document.add(new Paragraph("CHI TIẾT PHIẾU NHẬP").setFont(font).setFontSize(20).setBold());
                document.add(new Paragraph(jLabel1.getText()).setFont(font));
                document.add(new Paragraph(jLabel2.getText()).setFont(font));
                document.add(new Paragraph(jLabel3.getText()).setFont(font));
                document.add(new Paragraph(jLabel4.getText()).setFont(font));
                document.add(new Paragraph(jLabel5.getText()).setFont(font));

                // Tạo bảng PDF
                int columnCount = chitietTable.getColumnCount();
                Table pdfTable = new Table(columnCount);

                // Thêm tiêu đề cột
                for (int i = 0; i < columnCount; i++) {
                    pdfTable.addCell(new Cell().add(new Paragraph(chitietTable.getColumnName(i)).setFont(font)));
                }

                // Thêm dữ liệu từ JTable
                int rowCount = chitietTable.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < columnCount; j++) {
                        pdfTable.addCell(new Cell().add(new Paragraph(chitietTable.getValueAt(i, j).toString()).setFont(font)));
                    }
                }

                document.add(pdfTable);
                document.close();
                javax.swing.JOptionPane.showMessageDialog(this, "Xuất PDF thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra khi xuất PDF.");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo một frame chứa JPanel của bạn
            JFrame frame = new JFrame("Chi Tiết Phiếu Nhập");
            ChiTietJPanel chiTietPanel = new ChiTietJPanel();

            // Thiết lập các thông tin mẫu cho JPanel
            chiTietPanel.setMaPhieu("PN001");
            chiTietPanel.setNguoiTao("Nguyễn Văn A");
            chiTietPanel.setThoiGianTao("2024-11-01 10:30");
            chiTietPanel.setNhaCungCap("Nhà cung cấp ABC");
            chiTietPanel.setTongTien("5,000,000 VND");

            chiTietPanel.defaultTableModel.addRow(new Object[]{
                1, 1, 1, 1, 1, 1
            });
            // Gọi hàm loadDataToTable để tải dữ liệu mẫu vào bảng

            // Thêm JPanel vào frame và thiết lập các thuộc tính cho frame
            frame.add(chiTietPanel);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable chitietTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
