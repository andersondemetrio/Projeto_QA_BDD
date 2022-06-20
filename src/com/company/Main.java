package com.company;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;

public class Main {

    public static void main(String[] args) {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade"));

        for (int i = 0; i > a; i ++){
            System.out.println(i);
        }
    }
}
