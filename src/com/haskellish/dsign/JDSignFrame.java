package com.haskellish.dsign;

import com.haskellish.rsa.RSA;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.LinkedHashMap;

public class JDSignFrame extends JFrame {

    private final LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    private RSA rsa = new RSA();

    public JDSignFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //listing all components
        components.put("InputKeyLabel", new JLabel("Open key:", SwingConstants.RIGHT));
        components.put("InputKeyText", new JTextField());
        components.put("GenerateKeyButton", new JButton("Generate"));
        components.put("InputMessageLabel", new JLabel("Input message:", SwingConstants.CENTER));
        components.put("InputSignatureLabel", new JLabel("Signature:", SwingConstants.CENTER));
        components.put("Space1", new JLabel(""));
        components.put("InputMessageText", new JTextField());
        components.put("InputSignatureText", new JTextField());
        components.put("GenerateSignatureButton", new JButton("Sign"));
        components.put("OutputMessageLabel", new JLabel("Input message:", SwingConstants.CENTER));
        components.put("OutputSignatureLabel", new JLabel("Signature:", SwingConstants.CENTER));
        components.put("OutputKeyLabel", new JLabel("Key:", SwingConstants.CENTER));
        components.put("OutputMessageText", new JTextField());
        components.put("OutputSignatureText", new JTextField());
        components.put("OutputKeyText", new JTextField());
        components.put("CheckSignatureButton", new JButton("Check"));
        components.put("CheckSignatureText", new JLabel(""));
        components.put("Space2", new JLabel("", SwingConstants.CENTER));

        //setting fonts
        components.forEach((k, v) -> v.setFont(new Font("Verdana", Font.BOLD, 15)));

        // Creating panel
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(6, 3));
        components.forEach((k,v) -> contents.add(v));
        add(contents);

        //setting action listeners
        ((JButton) components.get("GenerateKeyButton")).addActionListener(e -> {
            rsa = new RSA();
            ((JTextField) components.get("InputKeyText")).setText(rsa.getD() + " " + rsa.getN());
        });

        ((JButton) components.get("GenerateSignatureButton")).addActionListener(e -> {
            String message = ((JTextField) components.get("InputMessageText")).getText();
            if (!message.equals("")){
                ((JTextField) components.get("InputSignatureText")).setText(
                        digitalSignature.getSignature(message, rsa.getE(), rsa.getN()).toString());
            }
        });

        ((JButton) components.get("CheckSignatureButton")).addActionListener(e -> {
            String message = ((JTextField) components.get("OutputMessageText")).getText();
            String[] keys = ((JTextField) components.get("OutputKeyText")).getText().split(" ");
            String signature = ((JTextField) components.get("OutputSignatureText")).getText();
            if (keys.length == 2 && keys[0].matches("[0-9]+") && keys[1].matches("[0-9]+")){
                BigInteger D = new BigInteger(keys[0]);
                BigInteger N = new BigInteger(keys[1]);
                if (!message.equals("") && signature.matches("[0-9]+")){
                    BigInteger signatureInt = new BigInteger(signature);
                    boolean check = digitalSignature.checkSignature(message, signatureInt, D, N);
                    ((JLabel) components.get("CheckSignatureText")).setText(String.valueOf(check));
                }
            }
        });

        setSize(1300, 300);
        setVisible(true);
    }
}
