/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;
import com.mycompany.config.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author My
 */
public class MuonSachServices {
    public static int ktSoSachNguoiMuon(int id) throws SQLException//kiểm tra số sách độc giả mượn đã trả hết chưa,trả ra 1 nếu trả hết
    {
         int dem=0;
        Connection conn=JDBC.getConn();
        String sql="Select COUNT(MaSach) as count from muonsach where MaDG=? and NgayTra is null";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs=stm.executeQuery();
        while(rs.next())
        {
            dem=rs.getInt("count");
        }
        stm.close();
        return dem;
    }
    public static int ktSoSachDaTra(int id) throws SQLException
    {
        int dem=0;
        Connection conn=JDBC.getConn();
        String sql="Select COUNT(MaSach) as count from muonsach where MaDG=? and NgayTra is not NULL";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs=stm.executeQuery();
        
        while(rs.next())
        {  
            dem=rs.getInt("count");
        }
        stm.close();
        return dem;
    }
    public static int kiemTraHanThe(int id) throws SQLException//trả ra 1 nếu hạn thẻ còn,trả ra 0 nếu hạn thể hết
    {
          Connection conn=JDBC.getConn();
        String sql="Select HanThe from thedocgia where MaDG=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs=stm.executeQuery();
        LocalDateTime date=null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.parse("04/01/2022 15:53:46",fmt);
        while(rs.next())
        {
            date=rs.getTimestamp("HanThe").toLocalDateTime();
        }
        stm.close();
        boolean kq=now.isAfter(date);//kiểm tra hạn thẻ
        if(kq)
            return 0;
        else
            return 1;
    }
    public static int ktMaDG(String id) throws SQLException//mã để trống hoặc mã không tồn tại thì trả về 0,ngược lại trả về 1
    {
        
        if("".equals(id))
            return 0;
        int kt=0;
        int dem=0;
        int ma=Integer.parseInt(id);
         Connection conn=JDBC.getConn();
         PreparedStatement stm=conn.prepareStatement("SELECT count(*) FROM thedocgia where MaDG=?");
         stm.setInt(1,ma);
         ResultSet rs = stm.executeQuery();
          while(rs.next())
               dem=rs.getInt(1);
            if (dem > 0) {
                kt=1;
            }
            else
                kt=0;
            stm.close();
            return kt;
    }
}
