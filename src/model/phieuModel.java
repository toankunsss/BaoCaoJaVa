package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Toan
 */
public class phieuModel {
    private String maPN;
    private Timestamp thoiGianTao;
    private String nguoiTao;
    private ArrayList<ChiTieuPhieumodel> chiTieuPhieumodels;
    private double tongTien;
    private String maNCC;

    public phieuModel() {
    }

    public phieuModel(String maPN, Timestamp thoiGianTao, String nguoiTao, ArrayList<ChiTieuPhieumodel> chiTieuPhieumodels, double tongTien, String maNCC) {
        this.maPN = maPN;
        this.thoiGianTao = thoiGianTao;
        this.nguoiTao = nguoiTao;
        this.chiTieuPhieumodels = chiTieuPhieumodels;
        this.tongTien = tongTien;
        this.maNCC = maNCC;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public ArrayList<ChiTieuPhieumodel> getChiTieuPhieumodels() {
        return chiTieuPhieumodels;
    }

    public void setChiTieuPhieumodels(ArrayList<ChiTieuPhieumodel> chiTieuPhieumodels) {
        this.chiTieuPhieumodels = chiTieuPhieumodels;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    @Override
    public String toString() {
        return "phieuModel{" + "maPN=" + maPN + ", thoiGianTao=" + thoiGianTao + ", nguoiTao=" + nguoiTao + ", chiTieuPhieumodels=" + chiTieuPhieumodels + ", tongTien=" + tongTien + ", maNCC=" + maNCC + '}';
    }
    
    
}
