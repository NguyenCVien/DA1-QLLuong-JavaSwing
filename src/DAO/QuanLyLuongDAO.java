package DAO;

import Helper.ConnectDatabase;
import Helper.MsgBox;
import Model.BacLuong;
import Model.Luong;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QuanLyLuongDAO {
    
    public static List<Luong> ls = new ArrayList<>();
    
    
        public NhanVien getNhanVienByID(String maNV) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        NhanVien nv = new NhanVien();
        try {
            String sSQL = "select * from NhanVien where MaNV = ?";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maNV);
            rs = sttm.executeQuery();
            while (rs.next()) {
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setNgaySinh(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setDiaChi(rs.getString(5));
                nv.setTrinhDo(rs.getString(6));
                nv.setMaPhong(rs.getString(7));
                nv.setChucVu(rs.getString(8));
                return nv;
            }
        } catch (Exception e) {
            System.out.println("Error: getTaiKhoanByID"+e.getMessage());
            //e.printStackTrace();
        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
    }
        return null;
    }
    
    public List<NhanVien> findNhanVienByName(String tenNV) {
        List<NhanVien> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        Connection conn = null;
        try {
            String sSQL = "select * from NhanVien where TenNV like '%" + tenNV + "%'";
            conn = ConnectDatabase.openConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setNgaySinh(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setDiaChi(rs.getString(5));
                nv.setTrinhDo(rs.getString(6));
                nv.setMaPhong(rs.getString(7));
                nv.setChucVu(rs.getString(8));
                ls.add(nv);
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


    public int add(Luong bl) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement sttm = null;
//        try {
            String sSQL = "insert into Luongg(Nam, Thang, MaNV, TenNV, SoNgayLam, GioLamThem, MaBacLuong, MaThuong, MaPhuCap, TamUng, LuongCoBan ,ThucLinh)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(1, bl.getNam());
            sttm.setString(2, bl.getThang());
            sttm.setString(3, bl.getMaNV());
            sttm.setString(4, bl.getTenNV());
            sttm.setString(5, bl.getSoNgayLam());
            sttm.setString(6, bl.getGioLamThem());
            sttm.setString(7, bl.getBacLuong());
            sttm.setString(8, bl.getTienThuong());
            sttm.setString(9, bl.getPhuCap());
            sttm.setString(10, bl.getTamUng());
            sttm.setString(11, bl.getLuongCoBan());
            sttm.setString(12, bl.getThucLinh());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Add Thanh Cong");
                return 1;
            }
//        } catch (Exception e) {
//            //e.printStackTrace();
//        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
//        }
        return -1;
    }
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
            System.out.println("Error: getAll"+e.getMessage());
            //e.printStackTrace();
        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {   
            }
            }
        return ls;
    }

    public Luong getLuongByID(String maLuong) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Luong tk = new Luong();
        try {
            String sSQL = "select * from Luongg where MaNV = ?";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maLuong);
            rs = sttm.executeQuery();
            while (rs.next()) {
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
                return tk;
            }
        } catch (Exception e) {
            System.out.println("Error: getTaiKhoanByID"+e.getMessage());
            //e.printStackTrace();
        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
    }
        return null;
    }

    public int updateLuongByID(Luong tk) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Luongg set Nam = ?, Thang = ?, TenNV = ?, SoNgayLam = ?,"
                    + " GioLamThem = ?, MaBacLuong = ?, MaThuong = ?, MaPhuCap = ?, TamUng = ?, LuongCoBan = ?, ThucLinh = ? where MaNV = ?";

            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(12, tk.getMaNV());
            sttm.setString(1, tk.getNam());
            sttm.setString(2, tk.getThang());
            sttm.setString(3, tk.getTenNV());
            sttm.setString(4, tk.getSoNgayLam());
            sttm.setString(5, tk.getGioLamThem());
            sttm.setString(6, tk.getBacLuong());
            sttm.setString(7, tk.getTienThuong());
            sttm.setString(8, tk.getPhuCap());
            sttm.setString(9, tk.getTamUng());
            sttm.setString(10, tk.getLuongCoBan());
            sttm.setString(11, tk.getThucLinh());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Update Thanh Cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Update"+e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
                
            }
            }
        return -1;
    }
    public int delLuongByID(String maBL) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete Luongg where MaNV = ?";
            conn = ConnectDatabase.openConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maBL);
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xoa Thanh Cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Delete"+e.getMessage());
            //e.printStackTrace();
        }finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
            }
        return -1;
    }

    
}
