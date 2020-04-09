package com.haskellish.XOR;

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
        JLabel testLabel = new JLabel("TEST", SwingConstants.CENTER);


        //setting fontsg
        inputLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        keysLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        crypt.setFont(new Font("Verdana", Font.BOLD, 20));
        testLabel.setFont(new Font("Verdana", Font.BOLD, 20));


        // Creating panel
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(3, 2));
        contents.add(inputLabel);
        contents.add(input);
        contents.add(keysLabel);
        contents.add(keys);
        contents.add(crypt);
        contents.add(testLabel);

        setContentPane(contents);
        setSize(400, 600);
        setVisible(true);
    }
}
