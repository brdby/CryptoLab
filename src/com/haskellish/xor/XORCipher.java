package com.haskellish.xor;

import javax.swing.*;
import java.awt.*;

public class XORCipher {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame Frame = new JXORFrame("XOR");
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