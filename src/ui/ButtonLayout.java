package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.CalculatorLogic;

public class ButtonLayout extends JPanel {
    private final CalculatorUI ui;

    public ButtonLayout(CalculatorUI ui, boolean isScientific) {
        this.ui = ui;
        setLayout(new GridLayout(5, isScientific ? 5 : 4, 5, 5));
        String[] buttons = isScientific ? getScientificButtons() : getStandardButtons();

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            add(button);
        }
    }

    private String[] getStandardButtons() {
        return new String[]{
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "DEL", "(", ")"
        };
    }

    private String[] getScientificButtons() {
        return new String[]{
            "sin", "cos", "tan", "sqrt", "log",
            "C", "DEL", "^", "(", ")",
            "7", "8", "9", "/", "*",
            "4", "5", "6", "-", "+",
            "1", "2", "3", "0", "="
        };
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();
            CalculatorLogic logic = ui.getCurrentLogic();

            switch (command) {
                case "=" -> ui.setDisplayText(logic.evaluate(ui.getDisplayText()));
                case "C" -> ui.setDisplayText("");
                case "DEL" -> {
                    String current = ui.getDisplayText();
                    if (!current.isEmpty()) {
                        ui.setDisplayText(current.substring(0, current.length() - 1));
                    }
                }
                default -> ui.setDisplayText(ui.getDisplayText() + command);
            }
        }
    }
}
