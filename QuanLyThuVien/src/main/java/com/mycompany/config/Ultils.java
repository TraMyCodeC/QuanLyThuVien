package com.mycompany.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My
 */
public class Ultils {
    public static int ktraUserPass(String user,String pass)
    {
        int k=1;
        if("".equals(user)||"".equals(pass)) 
            k=0;
        return k;
    }
    public static String dateTimeFormatter(LocalDateTime ldt)
    {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String datetime=ldt.format(formatter);
          return datetime;
    }
    public static String inToString(int m)
    {
        String s=Integer.toString(m);
        return s;
    }
}
