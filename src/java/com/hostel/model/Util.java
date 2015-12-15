/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.net.URLEncoder;
import java.util.Base64;

/**
 *
 * @author shukor.saharuni
 */
public class Util {
//    public static String urlEncode(String value) throws UnsupportedEncodingException {
//        return URLEncoder.encode(value, "UTF-8");
//    }
    public static String Base64Encode(String value) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(value.getBytes("utf-8"));
    }
    
    public static byte[] Base64Decode(String value) throws UnsupportedEncodingException{
        return Base64.getDecoder().decode(value.getBytes("utf-8"));
    }
    
    public static String HashPassword(String value) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] hash = md.digest(value.getBytes());
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < hash.length; i++){
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
