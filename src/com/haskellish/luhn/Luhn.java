package com.haskellish.luhn;

import javax.swing.*;
import java.awt.*;

public class Luhn {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame Frame = new JLuhnFrame("Luhn");
        });
    }
    public static String checkNum(String CardNumber){
        String reversedCardNumber = new StringBuilder(CardNumber).reverse().toString();
        if (CardNumber.matches("[0-9]{13,19}")){
            int sum = 0;
            for (int i = 0; i < reversedCardNumber.length(); i++){
                int parseInt = Integer.parseInt(reversedCardNumber.charAt(i) + "");
                if (i%2 == 1) parseInt*=2;
                if (parseInt > 9) parseInt-=9;
                sum+=parseInt;
            }
            if (sum%10 == 0){
                switch (CardNumber.charAt(0)){
                    case '2': return "MIR";
                    case '3': return "American Express";
                    case '4': return "VISA";
                    case '5': return "MasterCard, Maestro";
                    case '6': return "Union Pay";
                    default: return "Other";
                }
            }
        }
        return "Wrong input";
    }

}
