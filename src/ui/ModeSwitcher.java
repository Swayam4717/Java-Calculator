package ui;

import logic.StandardCalculatorLogic;
import logic.ScientificCalculatorLogic;

import javax.swing.*;
import java.awt.event.*;

public class ModeSwitcher extends JPanel {
    public ModeSwitcher(CalculatorUI ui) {
        JButton switchButton = new JButton("Switch Mode");
        switchButton.addActionListener(e -> {
            boolean isScientific = ui.isScientificMode();
            ui.setLogic(isScientific ? new StandardCalculatorLogic() : new ScientificCalculatorLogic());
            ui.refreshButtons();
        });
        add(switchButton);
    }
}
