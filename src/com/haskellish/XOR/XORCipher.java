package com.haskellish.XOR;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.EventListener;

public class XORCipher {

    /**
     * @param args arg[0] - input text, other args - keys
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame Frame = new JXORFrame("Test");
        });
    }

    /**
     * Simple XOR cipher method
     * @param input input text
     * @param keys keys
     * @return XOR result
     */
    public static String crypt(String input, String... keys){
        int size = input.length();
        for (String s : keys){
            StringBuilder output = new StringBuilder(size);
            for(int i = 0; i < size; i++){
                output.append((char) (s.charAt(i%size%s.length()) ^ input.charAt(i)));
            }
            input = output.toString();
        }
        return input;
    }
}