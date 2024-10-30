package model;

import java.sql.Timestamp;

/**
 *
 * @author Toan
 */
public class HoaDonmodel {
    private String maHD;
    private String maNV;
    private String maKh;
    private Timestamp ngayban;
    private double tongTien;

    public HoaDonmodel() {
    }

    public HoaDonmodel(String maHD, String maNV, String maKh, Timestamp ngayban, double tongTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKh = maKh;
        this.ngayban = ngayban;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public Timestamp getNgayban() {
        return ngayban;
    }

    public void setNgayban(Timestamp ngayban) {
        this.ngayban = ngayban;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
