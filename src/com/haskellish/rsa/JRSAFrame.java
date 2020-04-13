package com.haskellish.rsa;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class JRSAFrame extends JFrame {
    private final LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    private RSA rsa = new RSA();

    public JRSAFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //listing all components
        components.put("NLabel", new JLabel("N - " + rsa.getN(), SwingConstants.CENTER));
        components.put("ELabel", new JLabel("E - " + rsa.getE(), SwingConstants.CENTER));
        components.put("DLabel", new JLabel("D - " + rsa.getD(), SwingConstants.CENTER));
        components.put("inputLabel", new JLabel("Input:", SwingConstants.CENTER));
        components.put("cryptedLabel", new JLabel("Crypted:", SwingConstants.CENTER));
        components.put("decryptedLabel", new JLabel("Decrypted:", SwingConstants.CENTER));
        components.put("input", new JTextField("input"));
        components.put("crypted", new JTextField());
        components.put("decrypted", new JTextField());
        components.put("generateButton", new JButton("Generate"));
        components.put("space", new JLabel(""));
        components.put("encryptButton", new JButton("Encrypt"));

        //setting fonts
        components.forEach((k, v) -> v.setFont(new Font("Verdana", Font.BOLD, 15)));

        // Creating panel
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(4, 3));
        components.forEach((k,v) -> contents.add(v));
        add(contents);

        //setting action listeners
        ((JButton) components.get("generateButton")).addActionListener(e -> {
            rsa = new RSA();
            ((JLabel) components.get("NLabel")).setText("N - " + rsa.getN());
            ((JLabel) components.get("ELabel")).setText("E - " + rsa.getE());
            ((JLabel) components.get("DLabel")).setText("D - " + rsa.getD());
        });

        ((JButton) components.get("encryptButton")).addActionListener(e -> {
            String message = ((JTextField) components.get("input")).getText();
            if (!message.equals("")){
                byte[] crypted = rsa.encrypt(message.getBytes());
                ((JTextField) components.get("crypted")).setText(Arrays.toString(crypted));
                ((JTextField) components.get("decrypted")).setText(new String(rsa.decrypt(crypted)));
            }
        });

        setSize(1400, 300);
        setVisible(true);
    }
}
