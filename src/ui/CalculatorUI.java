package ui;

import logic.CalculatorLogic;
import logic.StandardCalculatorLogic;
import logic.ScientificCalculatorLogic;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    private final JTextField display;
    private CalculatorLogic logic;
    private JPanel buttonPanel;

    public CalculatorUI() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Set initial logic to Standard
        logic = new StandardCalculatorLogic();

        // Display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        // Top panel with ModeSwitcher on right
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(display, BorderLayout.CENTER);
        topPanel.add(new ModeSwitcher(this), BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Button panel area
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(new ButtonLayout(this, isScientificMode()), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void appendToDisplay(String text) {
        display.setText(display.getText() + text);
    }

    public void clearDisplay() {
        display.setText("");
    }

    public void calculateResult() {
        String expression = display.getText();
        String result = logic.evaluate(expression);
        display.setText(result);
    }

    public void setLogic(CalculatorLogic logic) {
        this.logic = logic;
    }

    public CalculatorLogic getCurrentLogic() {
        return logic;
    }

    public boolean isScientificMode() {
        return logic instanceof ScientificCalculatorLogic;
    }

    public void refreshButtons() {
        buttonPanel.removeAll();
        ButtonLayout layout = new ButtonLayout(this, isScientificMode());
        buttonPanel.add(layout, BorderLayout.CENTER);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
}
