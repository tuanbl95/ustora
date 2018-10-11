package com.mycompany.spring_project_final.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordUtil {

    public static String hashPassword(String password) {
        StringBuilder sb = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] mdArr = md.digest();
            sb = new StringBuilder(mdArr.length * 2);
            for (byte b : mdArr) {
                int v = b & 0xff;
                if (v < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(v));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public static String saltPassword(String password)
            throws NoSuchAlgorithmException {
        Random rd = new SecureRandom();
        byte[] saltBytes = new byte[32];
        rd.nextBytes(saltBytes);
        String salt = Base64.getEncoder().encodeToString(saltBytes);
        return hashPassword(salt + password);
    }

}
