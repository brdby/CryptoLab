package com.haskellish.luhn;

import com.haskellish.xor.JXORFrame;
import com.haskellish.xor.XORCipher;

import javax.swing.*;
import java.awt.*;

public class JLuhnFrame extends JFrame {

    public JLuhnFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //listing all components
        JTextField input = new JTextField();
        JLabel inputLabel = new JLabel("Input:", SwingConstants.CENTER);
        JButton crypt = new JButton("Check");
        JLabel output = new JLabel("", SwingConstants.CENTER);


        //setting fonts
        inputLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        crypt.setFont(new Font("Verdana", Font.BOLD, 15));
        output.setFont(new Font("Verdana", Font.BOLD, 15));


        // Creating panel
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(2, 2));
        contents.add(inputLabel);
        contents.add(input);
        contents.add(crypt);
        contents.add(output);

        //setting action listeners
        crypt.addActionListener(event -> {
            output.setText(Luhn.checkNum(input.getText()));
        });

        setContentPane(contents);
        setSize(500, 100);
        setVisible(true);
    }
}
