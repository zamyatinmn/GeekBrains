package Lesson7a;

import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {
    JTextArea display = new JTextArea();
    JTextArea displayUp = new JTextArea();
    JPanel text = new JPanel(new GridLayout(2, 1));
    JPanel btnPanel = new JPanel(new GridLayout(4, 5));
    private double value = 0;
    private String lastCommand = "=";
    private String def = "0";

    public static void main(String[] args) {
        CalcFrame frame = new CalcFrame();
        frame.setTitle("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    CalcFrame() {
        setBounds(700, 300, 300, 300);
        setLayout(new BorderLayout());
        text.add(displayUp);
        text.add(display);
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn0 = new JButton("0");
        JButton btnDot = new JButton(".");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnMult = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton btnResult = new JButton("=");
        JButton btnReset = new JButton("C");
        JButton btnBack = new JButton("<");
        JButton btnSqrt = new JButton("√");
        JButton btnPow = new JButton("x²");

        add(text, BorderLayout.NORTH);
        btnPanel.add(btn7);
        btnPanel.add(btn8);
        btnPanel.add(btn9);
        btnPanel.add(btnReset);
        btnPanel.add(btnPow);
        btnPanel.add(btn4);
        btnPanel.add(btn5);
        btnPanel.add(btn6);
        btnPanel.add(btnSqrt);
        btnPanel.add(btnMult);
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.add(btnMinus);
        btnPanel.add(btnDiv);
        btnPanel.add(btn0);
        btnPanel.add(btnDot);
        btnPanel.add(btnBack);
        btnPanel.add(btnPlus);
        btnPanel.add(btnResult);

        add(btnPanel, BorderLayout.CENTER);

        display.setText(def);
        btn0.addActionListener(e -> {
            if (!display.getText().equals(def)) {
                display.append("0");
            }
        });
        btn1.addActionListener(e -> {
            isEmpty();
            display.append("1");
        });
        btn2.addActionListener(e -> {
            isEmpty();
            display.append("2");
        });
        btn3.addActionListener(e -> {
            isEmpty();
            display.append("3");
        });
        btn4.addActionListener(e -> {
            isEmpty();
            display.append("4");
        });
        btn5.addActionListener(e -> {
            isEmpty();
            display.append("5");
        });
        btn6.addActionListener(e -> {
            isEmpty();
            display.append("6");
        });
        btn7.addActionListener(e -> {
            isEmpty();
            display.append("7");
        });
        btn8.addActionListener(e -> {
            isEmpty();
            display.append("8");
        });
        btn9.addActionListener(e -> {
            isEmpty();
            display.append("9");
        });
        btnReset.addActionListener(e -> {
            display.setText(def);
            displayUp.setText("");
            value = 0;
            lastCommand = "=";
        });
        btnPlus.addActionListener(e -> {
            action();
            displayUp.append(" + ");
            lastCommand = "+";
        });
        btnMinus.addActionListener(e -> {
            action();
            displayUp.append(" - ");
            lastCommand = "-";
        });
        btnMult.addActionListener(e -> {
            action();
            displayUp.append(" * ");
            lastCommand = "*";
        });
        btnDiv.addActionListener(e -> {
            action();
            displayUp.append(" / ");
            lastCommand = "/";
        });
        btnDot.addActionListener(e -> {
            if (!display.getText().contains(".")) {
                display.append(".");
            }
        });
        btnResult.addActionListener(e -> {
            action();
            display.setText("" + value);
            displayUp.setText("");
            lastCommand = "=";
        });
        btnBack.addActionListener(e -> {
            if (display.getText().length() != 0) {
                display.setText(display.getText().substring(0, display.getText().length() - 1));
            }
        });
        btnSqrt.addActionListener(e -> {
            action();
            displayUp.setText("√" + displayUp.getText());
            lastCommand = "√";
        });
        btnPow.addActionListener(e -> {
            action();
            displayUp.append("² ");
            lastCommand = "x²";
        });

    }

    private void action() {
        if (lastCommand.equals("+")) {
            value += Double.parseDouble(display.getText());
        }
        if (lastCommand.equals("-")) {
            value -= Double.parseDouble(display.getText());
        }
        if (lastCommand.equals("*")) {
            value *= Double.parseDouble(display.getText());
        }
        if (lastCommand.equals("/")) {
            value /= Double.parseDouble(display.getText());
        }
        if (lastCommand.equals("=")) {
            value = Double.parseDouble(display.getText());
            displayUp.setText(display.getText());
        }
        if (lastCommand.equals("√")){
            value = Math.sqrt(value);
        }
        if (lastCommand.equals("x²")){
            value = Math.pow(value, 2);
        }
        displayUp.setText(value + "");
        display.setText(def);
    }

    private void isEmpty() {
        if (display.getText().equals("0")) {
            display.setText("");
        }
    }


}
