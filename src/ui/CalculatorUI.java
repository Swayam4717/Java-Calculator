package ui;

import logic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame {
    private JTextField display;
    private JButton switchModeButton;
    private boolean isScientific = false;
    private CalculatorLogic logic;
    private JPanel buttonPanel;

    public CalculatorUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        logic = new StandardCalculatorLogic();

        // Display setup
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Button layout panel (center)
        buttonPanel = new ButtonLayout(this, isScientific);
        add(buttonPanel, BorderLayout.CENTER);

        // Switch Mode Button
        switchModeButton = new JButton("Switch Mode");
        switchModeButton.setPreferredSize(new Dimension(100, 40)); // smaller
        switchModeButton.addActionListener(e -> toggleMode());
        add(switchModeButton, BorderLayout.SOUTH);

        setSize(400, 500);
        setVisible(true);
    }

    private void toggleMode() {
        isScientific = !isScientific;
        logic = isScientific ? new ScientificCalculatorLogic() : new StandardCalculatorLogic();

        // Refresh button layout
        remove(buttonPanel);
        buttonPanel = new ButtonLayout(this, isScientific);
        add(buttonPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    public CalculatorLogic getCurrentLogic() {
        return logic;
    }

    public boolean isScientificMode() {
        return isScientific;
    }
}
