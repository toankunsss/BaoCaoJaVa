package controller;

import DAO.KhachHangDAO;
import DAO.NhaCCDAO;
import java.util.ArrayList;
import model.NhaCungCap;

/**
 *
 * @author Toan
 */
public class NhaCungCapController {

    private NhaCCDAO nccdao;

    public NhaCungCapController() {
        nccdao = new NhaCCDAO();
    }

    public ArrayList<NhaCungCap> selectAll() {
        return nccdao.selectAll();
    }

    public int ThemNv(NhaCungCap nhaCungCap) {
       return nccdao.them(nhaCungCap);
    }

    public int XoaNv(String khachString) {
       return nccdao.xoa(khachString);
    }

    public NhaCungCap selectById(String t) {
        return nccdao.selectById(t);
    }

    public void UpdateNv(NhaCungCap ncc) {
        nccdao.capnhat(ncc);
    }
    public ArrayList<NhaCungCap> SelectByCondition(String t){
        return nccdao.selectByCondition(t);
    }

}
