package model;

/**
 *
 * @author Toan
 */
public class ChiTieuPhieumodel {
    private String maPN;
    private String maSua;
    private int soLuong;
    private double donGia;

    public ChiTieuPhieumodel() {
    }

    public ChiTieuPhieumodel(String maPN, String maSua, int soLuong, double donGia) {
        this.maPN = maPN;
        this.maSua = maSua;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaSua() {
        return maSua;
    }

    public void setMaSua(String maSua) {
        this.maSua = maSua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "ChiTieuPhieumodel{" + "maPN=" + maPN + ", maSua=" + maSua + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
}
