package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame {
    private int sum = 0;
    public MyFrame() throws HeadlessException {
        createFrame();
    }

    public void createFrame() {
        setName("Counter");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.BLACK);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));

        JLabel label = new JLabel("リセット回数");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Century", Font.ITALIC, 20));

        JLabel label1 = new JLabel();
        label1.setFont(new Font("Century", Font.ITALIC, 20));
        label1.setText("" + 0);

        subPanel.add(label);
        subPanel.add(label1);

        JLabel jLabelCenter = new JLabel();
        jLabelCenter.setText("回数指定");
        jLabelCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabelCenter.setFont(new Font("Century", Font.ITALIC, 20));

        JTextField jTextField = new JTextField();
        jTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setColumns(5);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("call");
                try {
                    sum = Integer.parseInt(jTextField.getText());
                    label1.setText("" + sum);
                } catch (NumberFormatException ne) {
                    JLabel message = new JLabel("値が不正です。");
                    JOptionPane.showConfirmDialog(MyFrame.this, message);
                }
            }
        });

        subPanel.add(jLabelCenter);
        subPanel.add(jTextField);

        mainPanel.add(subPanel);

        JPanel panelButton = new JPanel();

        JButton button = new JButton();
        button.setText("Count++");
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sum++;
                        label1.setText("" + sum);
                    }
                });
                panelButton.add(button);

        JButton button1 = new JButton();
        button1.setText("Count--");
        button1.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sum <= 0) {
                    sum = 0;
                } else {
                    sum--;
                }
                label1.setText("" + sum);
            }
        });
        panelButton.add(button1);
        mainPanel.add(panelButton);

        Container container = getContentPane();
        container.add(mainPanel);

        setVisible(true);
    }
}
