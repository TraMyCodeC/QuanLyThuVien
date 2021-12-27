/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.mycompany.Pojo.DocGia;
import com.mycompany.config.JDBC;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
public class DocGiaSerVices {
    private static HashCode hs=new HashCode();
    public DocGia kTraNhanVienAccount(String name,String pass) throws SQLException, UnsupportedEncodingException
    {
         DocGia dg = null;
        Connection cnn=JDBC.getConn();
        PreparedStatement stm= cnn.prepareStatement("SELECT t.* FROM account a, thedocgia t WHERE a.MaDG=t.MaDG AND UserName=?"
                + " and Password=? AND t.DoiTuong=N'Nhân viên'" );
          stm.setString(1,name);
          stm.setString(2,hs.truyenPass(pass));
          ResultSet rs= stm.executeQuery();
          while(rs.next())
          {
              dg= new DocGia(rs.getInt("MaDG"),rs.getString("HoTen"),rs.getString("GioiTinh"),
              rs.getString("DoiTuong"),rs.getTimestamp("NgaySinh").toLocalDateTime(),rs.getTimestamp("HanThe").toLocalDateTime());
          }
          stm.close();
            return dg; 
    }
       public DocGia kTraDocGiaAccount(String name,String pass) throws SQLException, UnsupportedEncodingException
    {
         DocGia dg = null;
        Connection cnn=JDBC.getConn();
        PreparedStatement stm= cnn.prepareStatement("SELECT t.* FROM account a, thedocgia t WHERE a.MaDG=t.MaDG AND UserName=?"
                + " and Password=?" );
          stm.setString(1,name);
          stm.setString(2,hs.truyenPass(pass));
          ResultSet rs= stm.executeQuery();
          while(rs.next())
          {
              dg= new DocGia(rs.getInt("MaDG"),rs.getString("HoTen"),rs.getString("GioiTinh"),
              rs.getString("DoiTuong"),rs.getTimestamp("NgaySinh").toLocalDateTime(),rs.getTimestamp("HanThe").toLocalDateTime());
          }
          stm.close();
            return dg; 
    }
            
          public List<DocGia> getDSDocGia() throws SQLException
          {
            List<DocGia> ds= new ArrayList<>();  
            Connection conn=JDBC.getConn();
              Statement stm=conn.createStatement();
              ResultSet rs=stm.executeQuery("SELECT * FROM TheDocGia ");
                  while(rs.next())
                  {
                     DocGia dg= new DocGia(rs.getInt("MaDG"),rs.getString("HoTen"),rs.getString("GioiTinh"),rs.getString("DoiTuong"),
                  rs.getObject("NgaySinh", LocalDateTime.class),rs.getObject("HanThe",LocalDateTime.class));
                     ds.add(dg);
                  }
                  stm.close();
                  return ds;
          }
    }
