package DAO;

import java.util.ArrayList;

/**
 *
 * @author Toan
 * @param <T>
 */
public interface DAOinterface<T> {
    public int them(T t);
    public int capnhat(T t);
    public int xoa(String t);
    public ArrayList<T> selectAll();
    public T selectById(String t);
    public ArrayList<T> selectByCondition(String condition);
}
