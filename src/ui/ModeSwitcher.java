package ui;

import logic.CalculatorLogic;
import logic.StandardCalculatorLogic;
import logic.ScientificCalculatorLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeSwitcher extends JPanel {
    private boolean isScientific = false;
    private final CalculatorUI ui;
    private final JToggleButton toggleButton;

    public ModeSwitcher(CalculatorUI ui) {
        this.ui = ui;
        this.toggleButton = new JToggleButton("Scientific Mode");

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isScientific = toggleButton.isSelected();
                toggleButton.setText(isScientific ? "Standard Mode" : "Scientific Mode");

                // Switch logic
                CalculatorLogic newLogic = isScientific
                        ? new ScientificCalculatorLogic()
                        : new StandardCalculatorLogic();
                ui.setLogic(newLogic);

                // Refresh UI with new buttons
                ui.refreshButtons();
            }
        });

        add(toggleButton);
    }
}
