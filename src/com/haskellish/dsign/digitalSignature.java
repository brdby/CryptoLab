package com.haskellish.dsign;

import com.haskellish.luhn.JLuhnFrame;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class digitalSignature {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame Frame = new JDSignFrame("Luhn");
        });
    }

    public static BigInteger getSignature(String message, BigInteger key, BigInteger N){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(md.digest(message.getBytes()));
            return hash.modPow(key, N);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return BigInteger.ZERO;
    }

    public static boolean checkSignature(String message, BigInteger signature, BigInteger key, BigInteger N){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger localHash = new BigInteger(md.digest(message.getBytes()));
            BigInteger hash = signature.modPow(key, N);
            if (hash.equals(localHash)) return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}
