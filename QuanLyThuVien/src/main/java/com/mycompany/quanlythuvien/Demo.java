/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Services.MuonSachServices;
import com.mycompany.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author My
 */
public class Demo {
     public static void main(String[] args) throws SQLException
     {
         int id=4;
         Connection conn=JDBC.getConn();
        String sql="Select COUNT(MaSach) as count from muonsach where MaDG=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setInt(1,id);
        ResultSet rs=stm.executeQuery();
        int dem = 0;
        while(rs.next())
        {
            dem=rs.getInt("count");
        }
        System.out.println(dem);
         if(MuonSachServices.ktSoSachNguoiMuon(4)==1)
             System.out.println("trả hết sách");
         else
             System.out.println("Chưa trả hết sách");
     }
}
