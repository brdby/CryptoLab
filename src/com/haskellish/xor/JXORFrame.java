package com.haskellish.xor;

import javax.swing.*;
import java.awt.*;

public class JXORFrame extends JFrame {

    public JXORFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //listing all components
        JTextField input = new JTextField();
        JTextField keys = new JTextField();
        JLabel inputLabel = new JLabel("Input:", SwingConstants.CENTER);
        JLabel keysLabel = new JLabel("Keys (divide with spaces):", SwingConstants.CENTER);
        JButton crypt = new JButton("Crypt");
        JLabel output = new JLabel("", SwingConstants.CENTER);


        //setting fonts
        inputLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        keysLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        crypt.setFont(new Font("Verdana", Font.BOLD, 15));
        output.setFont(new Font("Verdana", Font.BOLD, 15));


        // Creating panel
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(3, 2));
        contents.add(inputLabel);
        contents.add(input);
        contents.add(keysLabel);
        contents.add(keys);
        contents.add(crypt);
        contents.add(output);

        //setting action listeners
        crypt.addActionListener(event -> {
            String inputStr = input.getText();
            String[] keysArr = keys.getText().split(" ");
            output.setText(XORCipher.crypt(inputStr, keysArr));
        });

        setContentPane(contents);
        setSize(800, 150);
        setVisible(true);
    }
}
