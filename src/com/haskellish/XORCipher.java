package com.haskellish;

import java.util.Arrays;

public class XORCipher {

    /**
     * @param args arg[0] - input text, other args - keys
     */
    public static void main(String[] args) {
        if (args.length > 1) System.out.println(XORCipher.crypt(args[0], Arrays.copyOfRange(args, 1, args.length)));
        else System.out.println("Неправильные аргументы");
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