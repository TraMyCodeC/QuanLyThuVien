/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;
import com.mycompany.Pojo.Sach;
import com.mycompany.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author My
 */
public class SachServices {
    public List<Sach> getDSSach() throws SQLException
    {
        List<Sach> ds= new ArrayList<>();
        Connection cnn=JDBC.getConn();
        Statement stm=cnn.createStatement();
        ResultSet rs=stm.executeQuery("SELECT * FROM sach");
        while(rs.next())
        {
          Sach e= new Sach(rs.getInt("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MoTa"),
       rs.getString("NoiXB"),rs.getObject("NamXB",LocalDateTime.class),rs.getInt("MaDanhMuc"),
                  rs.getObject("NgayNhap",LocalDateTime.class),rs.getString("ViTri"));
          ds.add(e);
        }
        stm.close();
        return ds;
        
    }
        public List<Sach> getDSSachId(int id) throws SQLException
    {
        List<Sach> ds= new ArrayList<>();
        Connection cnn;
         cnn = JDBC.getConn();
            String sql="SELECT * FROM sach s,muonsach m where s.MaSach=m.MaSach and MaDG=? and NgayTra is null";
         PreparedStatement stm=cnn.prepareStatement(sql);
             stm.setInt(1, id);
        ResultSet rs=stm.executeQuery();
        while(rs.next())
        {
          Sach e= new Sach(rs.getInt("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MoTa"),
       rs.getString("NoiXB"),rs.getObject("NamXB",LocalDateTime.class),rs.getInt("MaDanhMuc"),
                  rs.getObject("NgayNhap",LocalDateTime.class),rs.getString("ViTri"));
          ds.add(e);
        }  
        return ds;
        
    }
}
