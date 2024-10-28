package baocaojava;

import controller.SanPhamController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Toan
 */
public class ItemSua extends javax.swing.JPanel {

    private QuanLySanPhamJpanel parentPanel;
    SanPhamController sanPhamController;

    /**
     * Creates new form ItemSua
     */


    public ItemSua(QuanLySanPhamJpanel parentPanel) {
        initComponents();
        this.parentPanel = parentPanel;
        // Thêm listener cho panel
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onItemClick();
            }
        });
    }

    private void onItemClick() {
        // Hiển thị JOptionPane để người dùng nhập số lượng
        String input = JOptionPane.showInputDialog(this, "Nhập số lượng sản phẩm:", "Số lượng", JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.trim().isEmpty()) {
            try {
                int quantity = Integer.parseInt(input); // Chuyển đổi số lượng từ chuỗi sang số nguyên

                // Lấy thông tin sản phẩm
                String productName = tenSuaJlabel.getText();
                double price = Double.parseDouble(donGiaJlable.getText().replace("Đơn giá:", "").trim());

                // Gọi phương thức để thêm sản phẩm vào giỏ hàng
                parentPanel.addProductToCart(productName, quantity, price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public JLabel getTenSuaJlabel() {
        return tenSuaJlabel;
    }

    public JLabel getSoLuongJlable() {
        return soLuongJlable;
    }

    public JLabel getDonGiaJlable() {
        return donGiaJlable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tenSuaJlabel = new javax.swing.JLabel();
        soLuongJlable = new javax.swing.JLabel();
        donGiaJlable = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Picture1.png"))); // NOI18N

        tenSuaJlabel.setForeground(new java.awt.Color(0, 0, 0));
        tenSuaJlabel.setText("Tên Sản phẩm");

        soLuongJlable.setForeground(new java.awt.Color(0, 0, 0));
        soLuongJlable.setText("Số lượng:");

        donGiaJlable.setForeground(new java.awt.Color(0, 0, 0));
        donGiaJlable.setText("Đơn giá:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(soLuongJlable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tenSuaJlabel, javax.swing.GroupLayout.Alignment.LEADING))
            .addComponent(donGiaJlable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenSuaJlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soLuongJlable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(donGiaJlable))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel donGiaJlable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel soLuongJlable;
    private javax.swing.JLabel tenSuaJlabel;
    // End of variables declaration//GEN-END:variables
}