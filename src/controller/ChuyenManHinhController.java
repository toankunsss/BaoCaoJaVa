package controller;

import baocaojava.ListKhachHang;
import baocaojava.ListNhanVienJPanel;
import baocaojava.QuanLySanPhamJpanel;
import baocaojava.SanPhamJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.DanhMuc;

public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMuc> lisItem;
    private String kindHovered = "";

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangBanHang";
        jlbItem.setBackground(new Color(255, 102, 0));
        jpnItem.setBackground(new Color(255, 102, 0));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QuanLySanPhamJpanel(), BorderLayout.CENTER); // Đảm bảo rằng JPanel được thêm vào CENTER của BorderLayout
        root.revalidate(); // Sử dụng revalidate để cập nhật lại bố cục hoàn toàn
        root.repaint();

    }

    public void setEvent(List<DanhMuc> listItem) {
        this.lisItem = listItem;
        for (DanhMuc item : listItem) {
            item.getJlb().addMouseListener(new LaBelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LaBelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LaBelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "BanHang":
                    node = new QuanLySanPhamJpanel();
                    break;
                case "SanPham":
                    node = new SanPhamJPanel();
                    break;
                case "NhanVien":
                    node = new ListNhanVienJPanel();
                    break;
                case "KhachHang":
                    node=new ListKhachHang();
                    break;
                default:
                    node = new QuanLySanPhamJpanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node, BorderLayout.CENTER); // Đảm bảo rằng JPanel được thêm vào CENTER của BorderLayout
            root.revalidate(); // Đảm bảo bố cục được cập nhật lại hoàn toàn
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            setChangeBackground(kind);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            kindHovered = kind;
            setChangeBackground(kind);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            kindHovered = ""; // Reset the hovered item when the mouse exits
            setChangeBackground(kind);
        }
    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : lisItem) {
            if (item.getKind().equalsIgnoreCase(kindSelected)) {
                // Highlight the selected item
                item.getJlb().setBackground(new Color(255, 102, 0));
                item.getJpn().setBackground(new Color(255, 102, 0));
            } else if (item.getKind().equalsIgnoreCase(kindHovered)) {
                // Highlight the hovered item3

                item.getJlb().setBackground(new Color(255, 153, 51));
                item.getJpn().setBackground(new Color(255, 153, 51));
            } else {
                // Reset the color of other items
                item.getJlb().setBackground(new Color(255, 204, 51));
                item.getJpn().setBackground(new Color(255, 204, 51));
            }
        }
    }
}
