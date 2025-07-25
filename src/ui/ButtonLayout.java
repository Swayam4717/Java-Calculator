package ui;

import logic.CalculatorLogic;
import javax.swing.*;
import java.awt.*;

public class ButtonLayout extends JPanel {
    private final CalculatorUI ui;
    private final boolean isScientific;

    public ButtonLayout(CalculatorUI ui, boolean isScientific) {
        this.ui = ui;
        this.isScientific = isScientific;

        String[] buttons = ui.getCurrentLogic().getButtons();

        int columns = 4;
        int rows = (int) Math.ceil(buttons.length / (double) columns);
        setLayout(new GridLayout(rows, columns, 5, 5));

        initButtons(buttons);
    }

    private void initButtons(String[] buttons) {
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.addActionListener(e -> ui.appendToDisplay(label));
            add(button);
        }
    }
}
