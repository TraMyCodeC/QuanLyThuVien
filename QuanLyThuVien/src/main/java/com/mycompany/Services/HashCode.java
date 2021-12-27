/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author My
 */
public class HashCode {
    
    public String truyenPass(String pass) throws UnsupportedEncodingException
    {
        String m="";
        try{
        byte[] byteMessage=pass.getBytes("UTF-8");
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] theMD5=md.digest(byteMessage);
        m=String.format("%032x", new BigInteger(1,theMD5));
        }
        catch(NoSuchAlgorithmException ex)
        {
            ex.printStackTrace();
        }
         return m;
    }
}
