package com.haskellish;

/**
 * Represents simple Vigenere cipher coder/decoder
 * @author Valery Kucherov
 */

public class Vigenere {
    //unicode pointers for different languages
    public static final char RU = 1072;
    public static final char EN = 97;
    public static final int RU_LENGTH = 32;
    public static final int EN_LENGTH = 26;

    //cipher table
    private char[][] table;

    /**
     * Returns default Vigenere class with the generated cipher table
     * @param tableStart char from which cipher table will be generated
     * @param tableLength alphabet length that we want to use
     */
    Vigenere(char tableStart, int tableLength){
        table = new char[tableLength][tableLength];

        //filling cipher table
        for (int i = 0; i < tableLength; i++){
            for (int j = 0; j < tableLength; j++){
                //shifting each string to the left by it's number
                table[i][j] = (char) (tableStart + (j + i + tableLength)%tableLength);
            }
        }
    }


    /**
     * Encrypt text
     * @param input text that we want to encrypt
     * @param key key that we use to encrypt
     * @return cipher text
     */
    public String encrypt(String input, String key){
        char[] charInput = input.toCharArray();
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < charInput.length; i++){
            char keyChar =  key.charAt(i%key.length());
            for (int j = 0; j < table.length; j++){
                if (table[j][0] == keyChar) output.append(table[j][charInput[i] - table[0][0]]);
            }
        }
        return output.toString();
    }

    /**
     * Decrypt text
     * @param input text that we want to decrypt
     * @param key key that we use to decrypt
     * @return decrypted text
     */
    public String decrypt(String input, String key){
        char[] charInput = input.toCharArray();
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < charInput.length; i++){
            char keyChar =  key.charAt(i%key.length());
            for (int j = 0; j < table.length; j++){
                if (table[j][0] == keyChar) {
                    for (int k = 0; k < table.length; k++){
                        if (table[j][k] == charInput[i]) output.append(table[0][k]);
                    }
                }
            }
        }
        return output.toString();
    }

    /**
     * Printing cipher table to console
     */
    public void printTable(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
