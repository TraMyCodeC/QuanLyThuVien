/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TestCase;

import com.mycompany.Services.DocGiaSerVices;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author My
 */
public class DocGiaServiceTest {
   private static DocGiaSerVices d= new DocGiaSerVices();
   @Test
    public void testKtraDocGiaAccountNhapSai()
    {
       try {
           Assertions.assertNull(d.kTraDocGiaAccount("",""));
       } catch (SQLException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Test
    public void testKtraDocGiaAccountNhapDung()
    {
       try {
           Assertions.assertNotNull(d.kTraDocGiaAccount("My1","1234"));
       } catch (SQLException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Test
    public void testKtraNVAccountNhapSai()//Kiem tra neu nhap tai khoan doc gia de dang nhap nhan vien se tra ra null
    {
       try {
           Assertions.assertNull(d.kTraNhanVienAccount("My1","1234"));
       } catch (SQLException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Test
    public void testKtraNVAccountNhapDung()
    {
       try {
           Assertions.assertNotNull(d.kTraNhanVienAccount("Duyen","123"));
       } catch (SQLException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(DocGiaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
