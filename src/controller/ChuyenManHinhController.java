package controller;

import baocaojava.ListKhachHang;
import baocaojava.ListNhanVienJPanel;
import baocaojava.QuanLyPhieu;
import baocaojava.QuanLySanPham;
import baocaojava.QuanLySanPhamJpanel;
import baocaojava.ThongKeJpane;
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
        kindSelected = "SanPham";
        jlbItem.setBackground(new Color(255, 102, 0));
        jpnItem.setBackground(new Color(255, 102, 0));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QuanLySanPhamJpanel(), BorderLayout.CENTER); // Đảm bảo rằng JPanel được thêm vào CENTER của BorderLayout
        root.revalidate(); // Sử dụng revalidate để cập nhật lại bố cục hoàn toàn
        root.repaint();

    }

    public void setViewMenu(String kind, JPanel jpnItem, JLabel jlbItem) {
        JPanel node;
        switch (kind) {
            case "BanHang":
                node = new QuanLySanPhamJpanel();
                break;
            case "SanPham":
                node = new QuanLySanPham();
                break;
            case "NhanVien":
                node = new ListNhanVienJPanel();
                break;
            case "KhachHang":
                node = new ListKhachHang();
                break;
            case "PhieuNhap":
                node = new QuanLyPhieu();
                break;
            case "ThongKe":
                node = new ThongKeJpane();
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
        setChangeBackground();

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
                    node = new QuanLySanPham();
                    break;
                case "NhanVien":
                    node = new ListNhanVienJPanel();
                    break;
                case "KhachHang":
                    node = new ListKhachHang();
                    break;
                case "PhieuNhap":
                    node = new QuanLyPhieu();
                    break;
                case "ThongKe":
                    node = new ThongKeJpane();
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
            setChangeBackground();
        }


        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            kindHovered = kind;
            System.out.println("Hovered: " + kindHovered);
            setChangeBackground();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            kindHovered = "";
            System.out.println("Exited: " + kindHovered);
            setChangeBackground();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            System.out.println("Selected: " + kindSelected);
            setChangeBackground();
        }
    }

    private void setChangeBackground() {
        for (DanhMuc item : lisItem) {
            if (item.getKind().equalsIgnoreCase(kindSelected)) {
                // Làm nổi bật mục đã chọn
                item.getJlb().setBackground(new Color(255, 102, 0));
                item.getJpn().setBackground(new Color(255, 102, 0));
            } else if (item.getKind().equalsIgnoreCase(kindHovered)) {
                // Làm nổi bật mục đang bị di chuột
                item.getJlb().setBackground(new Color(255, 153, 51));
                item.getJpn().setBackground(new Color(255, 153, 51));
            } else {
                // Đặt lại màu sắc cho các mục khác
                item.getJlb().setBackground(new Color(255, 204, 51));
                item.getJpn().setBackground(new Color(255, 204, 51));
            }
        }
    }

}
