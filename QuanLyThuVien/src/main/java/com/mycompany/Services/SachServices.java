/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;
import com.mycompany.Pojo.Sach;
import com.mycompany.config.JDBC;
import java.sql.Connection;
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
}
