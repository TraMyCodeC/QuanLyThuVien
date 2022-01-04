/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TestCase;

import com.mycompany.Services.HashCode;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author My
 */
public class HashCodeTest {
    HashCode hs= new HashCode();
    @Test
    public void testTruyenPassIsCorrect()
    {
        try {
            String expected="202CB962AC59075B964B07152D234B70";
            Assertions.assertEquals(expected.toLowerCase(),hs.truyenPass("123").toLowerCase());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HashCodeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
