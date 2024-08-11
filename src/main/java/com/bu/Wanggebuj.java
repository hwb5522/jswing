package com.bu;

import javax.swing.*;
import java.awt.*;

public class Wanggebuj extends JFrame {
    public Wanggebuj() {
        GridLayout gridLayout = new GridLayout(3,3);
        setSize(400,400);
        setLayout(gridLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        add(new JButton("ss"));
        add(new JButton("ss"));
        add(new JButton("ss"));
        add(new JButton("ss"));
        add(new JButton("ss"));
        add(new JButton("ss"));
        add(new JButton("ss"));


        setVisible(true);

    }

    public static void main(String[] args) {
        new Wanggebuj();
    }

}
