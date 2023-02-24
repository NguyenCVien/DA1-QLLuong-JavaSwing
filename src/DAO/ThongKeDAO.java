package DAO;

import Helper.ConnectDatabase;
import Model.Luong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    public List<Luong> getAllLuong() {
        List<Luong> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from Luongg";
            conn = ConnectDatabase.openConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Luong tk = new Luong();
                tk.setNam(rs.getString(1));
                tk.setThang(rs.getString(2));
                tk.setMaNV(rs.getString(3));
                tk.setTenNV(rs.getString(4));
                tk.setSoNgayLam(rs.getString(5));
                tk.setGioLamThem(rs.getString(6));
                tk.setBacLuong(rs.getString(7));
                tk.setTienThuong(rs.getString(8));
                tk.setPhuCap(rs.getString(9));
                tk.setTamUng(rs.getString(10));
                tk.setLuongCoBan(rs.getString(11));
                tk.setThucLinh(rs.getString(12));
                ls.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Error: getAll" + e.getMessage());
            //e.printStackTrace();
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }

    public List<Luong> findLuongByMaNV(String maNV) {
        List<Luong> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        Connection conn = null;
        try {
            String sSQL = "select * from Luongg where MaNV like '%" + maNV + "%'";
            conn = ConnectDatabase.openConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Luong tk = new Luong();
                tk.setNam(rs.getString(1));
                tk.setThang(rs.getString(2));
                tk.setMaNV(rs.getString(3));
                tk.setTenNV(rs.getString(4));
                tk.setSoNgayLam(rs.getString(5));
                tk.setGioLamThem(rs.getString(6));
                tk.setBacLuong(rs.getString(7));
                tk.setTienThuong(rs.getString(8));
                tk.setPhuCap(rs.getString(9));
                tk.setTamUng(rs.getString(10));
                tk.setLuongCoBan(rs.getString(11));
                tk.setThucLinh(rs.getString(12));
                ls.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            //e.printStackTrace();
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error: getall" + e.toString());
                //e.printStackTrace();
            }
        }
        return ls;
    }

    public List<Luong> findLuongByCboNam(String nam) {
        List<Luong> ls = new ArrayList<>();
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            String sSQL = "select * from Luongg where Nam = ?";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nam);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Luong tk = new Luong();
                tk.setNam(rs.getString(1));
                tk.setThang(rs.getString(2));
                tk.setMaNV(rs.getString(3));
                tk.setTenNV(rs.getString(4));
                tk.setSoNgayLam(rs.getString(5));
                tk.setGioLamThem(rs.getString(6));
                tk.setBacLuong(rs.getString(7));
                tk.setTienThuong(rs.getString(8));
                tk.setPhuCap(rs.getString(9));
                tk.setTamUng(rs.getString(10));
                tk.setLuongCoBan(rs.getString(11));
                tk.setThucLinh(rs.getString(12));
                ls.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            //e.printStackTrace();
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error: getall" + e.toString());
                //e.printStackTrace();
            }
        }
        return ls;
    }
    
    public List<Luong> findLuongByCboThang(String thang) {
        List<Luong> ls = new ArrayList<>();
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            String sSQL = "select * from Luongg where Thang = ?";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, thang);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Luong tk = new Luong();
                tk.setNam(rs.getString(1));
                tk.setThang(rs.getString(2));
                tk.setMaNV(rs.getString(3));
                tk.setTenNV(rs.getString(4));
                tk.setSoNgayLam(rs.getString(5));
                tk.setGioLamThem(rs.getString(6));
                tk.setBacLuong(rs.getString(7));
                tk.setTienThuong(rs.getString(8));
                tk.setPhuCap(rs.getString(9));
                tk.setTamUng(rs.getString(10));
                tk.setLuongCoBan(rs.getString(11));
                tk.setThucLinh(rs.getString(12));
                ls.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            //e.printStackTrace();
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error: getall" + e.toString());
                //e.printStackTrace();
            }
        }
        return ls;
    }
}
