/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TestCase;

import com.mycompany.Services.SachServices;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author My
 */
public class SachServicesTest {
    SachServices sv=new SachServices();
    @Test
    public void testGetDSSach()
    {
        try {
            Assertions.assertNotNull(sv.getDSSach());
        } catch (SQLException ex) {
            Logger.getLogger(SachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testGetDSSachTheoIdNotEmptyAndCorrect()
    {
        try {
            Assertions.assertNotEquals(0,sv.getDSSachId(4).size());
            Assertions.assertEquals(5,sv.getDSSachId(4).size());
        } catch (SQLException ex) {
            Logger.getLogger(SachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testGetDSSachTheoIdIsEmpty()
    {
        try {
            List<String> m= new ArrayList();
            Assertions.assertEquals(m.size(),sv.getDSSachId(3).size());
        } catch (SQLException ex) {
            Logger.getLogger(SachServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
