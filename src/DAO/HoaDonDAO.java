package DAO;

import Database.JDBCconnect;
import java.util.ArrayList;
import model.HoaDonmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Toan
 */
public class HoaDonDAO implements DAOinterface<HoaDonmodel> {

    private static HoaDonDAO intance;

    public HoaDonDAO getIntance() {
        if (intance == null) {
            intance = new HoaDonDAO();
        }
        return intance;
    }

    @Override
    public int them(HoaDonmodel t) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO hoadon(MaHD,MaNV,MaKH,NgayBan,TongTien)" + "Value (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHD());
            pst.setString(2, t.getMaNV());
            pst.setString(3, t.getMaKh());
            pst.setTimestamp(4, t.getNgayban());
            pst.setDouble(5, t.getTongTien());
            ketqua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int capnhat(HoaDonmodel t) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE hoadon SET MaNV = ?, MaKH = ?, NgayBan = ?, TongTien = ? WHERE MaHD = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getMaKh());
            pst.setTimestamp(3, t.getNgayban());
            pst.setDouble(4, t.getTongTien());
            pst.setString(5, t.getMaHD());
            ketqua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int xoa(String maHD) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "DELETE FROM hoadon WHERE MaHD = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maHD);
            ketqua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<HoaDonmodel> selectAll() {
        ArrayList<HoaDonmodel> list = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM hoadon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDonmodel hd = new HoaDonmodel(
                        rs.getString("MaHD"),
                        rs.getString("MaNV"),
                        rs.getString("MaKH"),
                        rs.getTimestamp("NgayBan"),
                        rs.getDouble("TongTien")
                );
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public HoaDonmodel selectById(String maHD) {
        HoaDonmodel hd = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM hoadon WHERE MaHD = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                hd = new HoaDonmodel(
                        rs.getString("MaHD"),
                        rs.getString("MaNV"),
                        rs.getString("MaKH"),
                        rs.getTimestamp("NgayBan"),
                        rs.getDouble("TongTien")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    @Override
    public ArrayList<HoaDonmodel> selectByCondition(String condition) {
        ArrayList<HoaDonmodel> list = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM hoadon WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDonmodel hd = new HoaDonmodel(
                        rs.getString("MaHD"),
                        rs.getString("MaNV"),
                        rs.getString("MaKH"),
                        rs.getTimestamp("NgayBan"),
                        rs.getDouble("TongTien")
                );
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
