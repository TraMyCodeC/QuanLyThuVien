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
    public List<Sach> getDsSachTim(String ten,String tg,String nam,String danhmuc) throws SQLException
    {
        int m=0;
        List<Sach> ds= new ArrayList<>();
        Connection conn= JDBC.getConn();
        String sql="select * from sach";
        if(ten!=null&&!ten.isEmpty()&&!ten.isBlank())
        {     
            sql+="where TenSach like concat('%','"+ten+"','%')";
            m=1;
        }
        if(tg!=null&&!tg.isEmpty()&&!tg.isBlank())
        {    if(m==1)
            sql+="and TacGia like concat('%','"+tg+"','%')";
            else
            sql+="where TacGia like concat('%','"+tg+"','%')";
        }
        else
            m=0;
        if(nam!=null&&!nam.isEmpty()&&!nam.isBlank())
        {     if(m==1)
            sql+="and YEAR(NamXB)=concat('','"+nam+"','')";
              else
               sql+="where YEAR(NamXB)="+nam;
        }
        else
            m=0;
        if(danhmuc!=null&&!danhmuc.isEmpty()&&!danhmuc.isBlank())
        {   if(m==1)
            sql+="and danhmuc=(select MaDanhMuc from danhmucsach where TenDanhMuc like concat('%','"+danhmuc+"','%')";
            else
            sql+="where danhmuc=(select MaDanhMuc from danhmucsach where TenDanhMuc like concat('%','"+danhmuc+"','%')";
        }
        PreparedStatement stm=conn.prepareStatement(sql);
          ResultSet rs= stm.executeQuery();
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
