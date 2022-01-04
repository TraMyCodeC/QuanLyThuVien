/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TestCase;

import com.mycompany.Services.MuonSachServices;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author My
 */
public class MuonSachServicesTest {
    @Test
    public void testKTSoSachNguoiMuonTheoId()
    {
        try {
            int expected=5;
            Assertions.assertEquals(expected,MuonSachServices.ktSoSachNguoiMuon(4));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Test
    public void testKTSoSachDaTraTheoId()
    {
        try {
            int expected=3;
            Assertions.assertEquals(expected,MuonSachServices.ktSoSachDaTra(2));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testKTTheConHan()
    {
        try {
            int expected=1;
            Assertions.assertEquals(expected,MuonSachServices.kiemTraHanThe(2));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @Test
    public void testKTTheHetHan()
    {
        try {
            int expected=0;
            Assertions.assertEquals(expected,MuonSachServices.kiemTraHanThe(4));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @Test
    public void testKTMaDGKhongHopLe()
    {
        try {
            
            Assertions.assertEquals(0,MuonSachServices.ktMaDG(""));
            Assertions.assertEquals(0,MuonSachServices.ktMaDG("15"));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
     public void testKTMaDGHopLe()
    {
        try {
            
            Assertions.assertEquals(1,MuonSachServices.ktMaDG("3"));
            Assertions.assertEquals(1,MuonSachServices.ktMaDG("6"));
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
