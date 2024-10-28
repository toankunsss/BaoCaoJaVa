package controller;

import DAO.NhaCCDAO;
import java.util.ArrayList;
import model.NhaCungCap ;
  
        
        /**
         *
         * @author Toan
         */

public class SearchNhaCungCap {

    public static SearchNhaCungCap getInstance() {
        return new SearchNhaCungCap();
    }

    public ArrayList<NhaCungCap> searchTatCa(String text) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        ArrayList<NhaCungCap> armt = NhaCCDAO.getInstance().selectAll();
        for (var ncc : armt) {
            String sdtString = String.valueOf(ncc.getSoDt());
            if (ncc.getMaNhaCC().toLowerCase().contains(text.toLowerCase())
                    || ncc.getTenNCC().toLowerCase().contains(text.toLowerCase())
                    || ncc.getDiaChi().toLowerCase().contains(text.toLowerCase())
                    || sdtString.toLowerCase().contains(text)) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCap> searchMaNCC(String text) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        ArrayList<NhaCungCap> armt = NhaCCDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getMaNhaCC().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
    public ArrayList<NhaCungCap> searchTenNCC(String text) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        ArrayList<NhaCungCap> armt = NhaCCDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getTenNCC().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
    public ArrayList<NhaCungCap> searchDiaChi(String text) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        ArrayList<NhaCungCap> armt = NhaCCDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
    public ArrayList<NhaCungCap> searchSdt(String text) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        ArrayList<NhaCungCap> armt = NhaCCDAO.getInstance().selectAll();
        for (var ncc : armt) {
            String sdtString = String.valueOf(ncc.getSoDt());
            if (sdtString.contains(text)) {
                result.add(ncc);
            }
        }
        return result;
    }

}
